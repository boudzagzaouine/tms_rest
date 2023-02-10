package com.bagile.gmo.services;

import com.bagile.gmo.dto.Trajet;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.importModels.CatalogTransportPricingImport;
import com.bagile.gmo.importModels.TrajetImport;

import java.util.List;

public interface TrajetService {
    Trajet save(Trajet trajet);
    List<Trajet> saveAll(List<Trajet> trajets) throws AttributesNotFound, ErrorType;

    Long size();

    Boolean isExist(Long id);

    Trajet findById(Long id) throws IdNotFound;

    List<Trajet> find(String search) throws AttributesNotFound, ErrorType;

    List<Trajet> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Trajet trajetService);
    void deleteAll (List<Long> ids);

    List<Trajet> findAll();

    List<Trajet> findAll(int page, int size);

	Trajet findOne(String search) throws AttributesNotFound, ErrorType;
    List<TrajetImport> loadingDataImport(List<TrajetImport>  trajetImports) throws ErrorType, AttributesNotFound, IdNotFound;


}
