package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.*;
import com.bagile.gmo.entities.TmsOrderTransport;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.OrderTransportMapper;
import com.bagile.gmo.repositories.OrderTransportRepository;
import com.bagile.gmo.services.*;
import com.bagile.gmo.util.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderTransportServiceImpl implements OrderTransportService {
    
    private final OrderTransportRepository orderTransportRepository;

    @Autowired
    private OrderTransportInfoService orderTransportInfoService;
    @Autowired
    private OrderTransportInfoLineService orderTransportInfoLineService;
    @Autowired
    private OrderTransportInfoLineDocumentService orderTransportInfoLineDocumentService;
    @Autowired
    private OrderTransportDocumentService orderTransportDocumentService;
    public OrderTransportServiceImpl(OrderTransportRepository orderTransportRepository) {
        this.orderTransportRepository = orderTransportRepository;
    }

    @Override
    public OrderTransport save(OrderTransport orderTransport) {
        return OrderTransportMapper.toDto(orderTransportRepository.saveAndFlush(OrderTransportMapper.toEntity(orderTransport, false)), false);
    }

    @Override
    public Long size() {
        return orderTransportRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return orderTransportRepository.existsById(id);
    }

    @Override
    public OrderTransport findById(Long id) throws IdNotFound {
        return OrderTransportMapper.toDto(orderTransportRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<OrderTransport> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return OrderTransportMapper.toDtos(orderTransportRepository.findAll(Search.expression(search, TmsOrderTransport.class)), false);
    }

    @Override
    public OrderTransport getOrderTransport(String search) throws AttributesNotFound, ErrorType {
      List<OrderTransport> orderTransports =  OrderTransportMapper.toDtos(orderTransportRepository.findAll(Search.expression(search, TmsOrderTransport.class)), false);
      OrderTransport orderTransport = orderTransports.get(0);
        List<OrderTransportInfo> orderTransportInfos=orderTransportInfoService.find("orderTransport.id:"+orderTransport.getId());


             if(orderTransportInfos.size()>0)   {

                 orderTransport.setOrderTransportInfos(orderTransportInfos);

                 orderTransport.getOrderTransportInfos().forEach(info->{
                     try {
                          List<OrderTransportInfoLine> orderTransportInfoLines=orderTransportInfoLineService.find("orderTransportInfo.id:"+info.getId());
                         orderTransportInfoLines.forEach(line->{
                             try {
                                 List<OrderTransportInfoLineDocument> orderTransportInfoLineDocuments=orderTransportInfoLineDocumentService.find("orderTransportInfoLine.id:"+line.getId());


                                 orderTransportInfoLineDocuments.forEach(document-> {

                                     try {
                                         List<OrderTransportDocument> orderTransportDocuments=orderTransportDocumentService.find("orderTransportInfoLineDocument.id:"+document.getId());

                                         document.setOrderTransportDocumentList(orderTransportDocuments);

                                     } catch (AttributesNotFound e) {
                                         throw new RuntimeException(e);
                                     } catch (ErrorType e) {
                                         throw new RuntimeException(e);
                                     }


                                 });

                                 line.setOrderTransportInfoLineDocuments(orderTransportInfoLineDocuments);

                                 } catch (AttributesNotFound e) {
                                 throw new RuntimeException(e);
                             } catch (ErrorType e) {
                                 throw new RuntimeException(e);
                             }


                         });


                         info.setOrderTransportInfoLines(orderTransportInfoLines);


                     } catch (AttributesNotFound e) {
                         throw new RuntimeException(e);
                     } catch (ErrorType e) {
                         throw new RuntimeException(e);
                     }

                 });

             }



             if(orderTransport.getLoadingType().getId()==1){
                 if(orderTransport.getTurnType().getId()==1 || orderTransport.getTurnType().getId()==3) {
                     orderTransport.setOrderTransportInfoAller(orderTransportInfos.stream().filter(f -> f.getType() == 1).collect(Collectors.toList()).stream().findFirst().get());
                 }if(orderTransport.getTurnType().getId()==2 || orderTransport.getTurnType().getId()==3) {

                     orderTransport.setOrderTransportInfoRetour(orderTransportInfos.stream().filter(f -> f.getType() == 2).collect(Collectors.toList()).stream().findFirst().get());
                 }
             }else if (orderTransport.getLoadingType().getId()==2){

                 orderTransport.setOrderTransportInfoAller(orderTransportInfos.get(0));

             }

        return orderTransport;
    }


    @Override
    public List<OrderTransport> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportMapper.toDtos(orderTransportRepository.findAll(Search.expression(search, TmsOrderTransport.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return orderTransportRepository.count(Search.expression(search, TmsOrderTransport.class));
    }

    @Override
    public void delete(Long id) {
        try {
           List<Long> orderTransportInfos =orderTransportInfoService.find("orderTransport.id:"+id).stream().map(m-> m.getId()).collect(Collectors.toList());

           if(orderTransportInfos.size()>0){

               orderTransportInfos.forEach(orderTI->{
                   try {
                       List<Long> orderTransportInfoLines =orderTransportInfoLineService.find("orderTransportInfo.id:"+orderTI).stream().map(m-> m.getId()).collect(Collectors.toList());

                       if(orderTransportInfoLines.size()>0){
                       orderTransportInfoLines.forEach(orderTIL-> {
                           try {
                               List<Long> orderTransportInfoLineDocuments =orderTransportInfoLineDocumentService.find("orderTransportInfoLine.id:"+orderTIL).stream().map(m-> m.getId()).collect(Collectors.toList());
                               if(orderTransportInfoLineDocuments.size()>0){
                               orderTransportInfoLineDocuments.forEach(orderTILD->{

                                   try {
                                       List<Long> orderTransportDocuments =orderTransportDocumentService.find("orderTransportInfoLineDocument.id:"+orderTILD).stream().map(m-> m.getId()).collect(Collectors.toList());
                                       if(orderTransportDocuments.size()>0) {
                                           orderTransportDocumentService.deleteAll(orderTransportDocuments);
                                       }


                                   } catch (AttributesNotFound e) {
                                       throw new RuntimeException(e);
                                   } catch (ErrorType e) {
                                       throw new RuntimeException(e);
                                   }


                               });
                            orderTransportInfoLineDocumentService.deleteAll(orderTransportInfoLineDocuments);
                           }

                           } catch (AttributesNotFound e) {
                               throw new RuntimeException(e);
                           } catch (ErrorType e) {
                               throw new RuntimeException(e);
                           }


                       });
                       orderTransportInfoLineService.deleteAll(orderTransportInfoLines);
                   }
                   } catch (AttributesNotFound e) {
                       throw new RuntimeException(e);
                   } catch (ErrorType e) {
                       throw new RuntimeException(e);
                   }

               });

           }
        //   List<Long> orderTransportInfoLine =orderTransportInfoLineService.find("orderTransportInfo.id:"+id).stream().map(m-> m.getId()).collect(Collectors.toList());
            orderTransportInfoService.deleteAll(orderTransportInfos);
            orderTransportRepository.deleteById(id);

        } catch (AttributesNotFound e) {
            throw new RuntimeException(e);
        } catch (ErrorType e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(OrderTransport orderTransport) {
        orderTransportRepository.delete(OrderTransportMapper.toEntity(orderTransport, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            delete(id);        }
    }


    @Override
    public List<OrderTransport> findAll() {
        return OrderTransportMapper.toDtos(orderTransportRepository.findAll(), false);
    }

    @Override
    public List<OrderTransport> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OrderTransportMapper.toDtos(orderTransportRepository.findAll(pageable), false);
    }

    @Override
    public OrderTransport findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

    @Override
    public String getNextVal() {
        String value="OT" + orderTransportRepository.getNextVal().get(0);
        return value;


    }

}

