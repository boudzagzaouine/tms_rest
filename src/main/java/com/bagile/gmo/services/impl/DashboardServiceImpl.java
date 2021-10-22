package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Dashboard;
import com.bagile.gmo.dto.DieselDeclaration;
import com.bagile.gmo.dto.Maintenance;
import com.bagile.gmo.dto.Vehicle;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.repositories.DashboardRepository;
import com.bagile.gmo.services.DashboardService;
import com.bagile.gmo.services.DieselDeclarationService;
import com.bagile.gmo.services.MaintenanceService;
import com.bagile.gmo.services.VehicleService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Service
public class DashboardServiceImpl implements DashboardService {

    private final DashboardRepository dashboardRepository;

    private final MaintenanceService maintenanceService;

    private final DieselDeclarationService dieselDeclarationService;

    private final VehicleService vehicleService;


    public DashboardServiceImpl(DashboardRepository dashboardRepository,
                                MaintenanceService maintenanceService,
                                DieselDeclarationService dieselDeclarationService,
                                VehicleService vehicleService) {
        this.dashboardRepository = dashboardRepository;
        this.maintenanceService= maintenanceService;
        this.dieselDeclarationService=dieselDeclarationService;
        this.vehicleService=vehicleService;
    }


    @Override
    public BigDecimal getAverageconsumptionvehicle(long vehicleId, long CategoryId, Date dateDepart, Date dateFin) {
        return dashboardRepository.averageconsumptionvehicle( vehicleId,  CategoryId,  dateDepart,  dateFin);
    }

    @Override
    public BigDecimal getCorrectivemaintenancecostsbyvehicle(long vehicleId, long CategoryId, Date dateDepart, Date dateFin) {
        return dashboardRepository.correctivemaintenancecostsbyvehicle(vehicleId,  CategoryId,  dateDepart,  dateFin);
    }

    @Override
    public BigDecimal getPreventivemaintenancecostsbyvehicle(long vehicleId, long CategoryId, Date dateDepart, Date dateFin) {
        return dashboardRepository.preventivemaintenancecostsbyvehicle(vehicleId,  CategoryId,  dateDepart,  dateFin);
    }

    @Override
    public BigDecimal getTraveledmileagebyvechile(long vehicleId, long CategoryId, Date dateDepart, Date dateFin) {
        return dashboardRepository.traveledmileagebyvechile(vehicleId,  CategoryId,  dateDepart,  dateFin);
    }

    @Override
    public BigDecimal getTotalnumberofproblemsbyvehicle(long vehicleId, long CategoryId, Date dateDepart, Date dateFin) {
        return dashboardRepository.totalnumberofproblemsbyvehicle(vehicleId,  CategoryId,  dateDepart,  dateFin);
    }

    @Override
    public List<Dashboard> getLineChartMaintenanceCorrectiveByVehicle(long vehicleId, long CategoryId, Date dateDepart, Date dateFin) throws AttributesNotFound, ErrorType {
        List<Dashboard> dashboards = new ArrayList<>();

       // corrective
        List<Maintenance> maintenanceList = maintenanceService.find("patrimony.id:"+vehicleId+", maintenanceDate >"+new SimpleDateFormat("yyyy-MM-dd").format( dateDepart)+", maintenanceDate <"+new SimpleDateFormat("yyyy-MM-dd").format( dateFin)+",maintenanceType.id:"+2L);

        for (int i = 0; i <=11 ; i++) {
            long month =i;
            List<Maintenance> maintenanceList1 = maintenanceList;
            Dashboard dashboard = new Dashboard();

            dashboard.setMonth(month+1);
          BigDecimal total = maintenanceList1.stream().filter(f-> f.getMaintenanceDate().getMonth() == month).
                    map(mp-> mp.getTotalPrice()).reduce(BigDecimal.ZERO,BigDecimal::add);

         dashboard.setValue(total);
         dashboards.add(dashboard);

        }

        return dashboards;
    }

    @Override
    public List<Dashboard> getLineChartMaintenancePreventiveByVehicle(long vehicleId, long CategoryId, Date dateDepart, Date dateFin) throws AttributesNotFound, ErrorType {
        List<Dashboard> dashboards = new ArrayList<>();

        // Preventive
        List<Maintenance> maintenanceList = maintenanceService.find("patrimony.id:"+vehicleId+", maintenanceDate >"+new SimpleDateFormat("yyyy-MM-dd").format( dateDepart)+", maintenanceDate <"+new SimpleDateFormat("yyyy-MM-dd").format( dateFin)+",maintenanceType.id:"+1L);

        for (int i = 0; i <=11 ; i++) {
            long month =i;
            List<Maintenance> maintenanceList1 = maintenanceList;
            Dashboard dashboard = new Dashboard();

            dashboard.setMonth(month+1);
            BigDecimal total = maintenanceList1.stream().filter(f-> f.getMaintenanceDate().getMonth() == month).
                    map(mp-> mp.getTotalPrice()).reduce(BigDecimal.ZERO,BigDecimal::add);

            dashboard.setValue(total);
            dashboards.add(dashboard);

        }

        return dashboards;
    }


    @Override
    public List<Dashboard> getBarChartGasoilByVehicle(String vehicleId, long CategoryId, Date dateDepart, Date dateFin) throws AttributesNotFound, ErrorType {
        List<Dashboard> dashboards = new ArrayList<>();


        List<DieselDeclaration> dieselDeclarationList = dieselDeclarationService.find("vehicle.registrationNumber~"+vehicleId+", dieselDeclarationDate >"+new SimpleDateFormat("yyyy-MM-dd").format( dateDepart)+", dieselDeclarationDate <"+new SimpleDateFormat("yyyy-MM-dd").format( dateFin));

        for (int i = 0; i <=11 ; i++) {
            long month =i;
            List<DieselDeclaration> dieselDeclarationList1 = dieselDeclarationList;
            Dashboard dashboard = new Dashboard();

            dashboard.setMonth(month+1);
            BigDecimal total = dieselDeclarationList1.stream().filter(f-> f.getDieselDeclarationDate().getMonth() == month).
                    map(mp-> mp.getAmount()).reduce(BigDecimal.ZERO,BigDecimal::add);

            dashboard.setValue(total);
            dashboards.add(dashboard);

        }

        return dashboards;
    }

    @Override
    public int getaverageAgeByVehicle() throws AttributesNotFound, ErrorType {
        int averageAge =0;
        int sumAge =0;
        int sumVehicle=0;
        List<Vehicle> vehicleList = vehicleService.findAll();
         sumVehicle=vehicleList.size();

        for (Vehicle v:vehicleList) {
               if(v.getRelease()!=null){
            long diff = new Date().getTime() - v.getRelease().getTime();
            TimeUnit time = TimeUnit.DAYS;
            long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
            sumAge +=diffrence;
               }

        }

        averageAge= sumAge/sumVehicle;
        return averageAge;
    }


    @Override
    public BigDecimal getAverageconsumptiondriver(long driverId, Date dateDepart, Date dateFin) {
        return dashboardRepository.averageconsumptiondriver( driverId,  dateDepart,  dateFin);
    }

    @Override
    public BigDecimal getCorrectivemaintenancecostsbydriver(long driverId, Date dateDepart, Date dateFin) {
        return dashboardRepository.correctivemaintenancecostsbydriver( driverId,  dateDepart,  dateFin);
    }

    @Override
    public BigDecimal getPreventivemaintenancecostsbydriver(long driverId, Date dateDepart, Date dateFin) {
        return dashboardRepository.preventivemaintenancecostsbydriver( driverId,  dateDepart,  dateFin);
    }

    @Override
    public BigDecimal getTraveledmileagebydriver(long driverId, Date dateDepart, Date dateFin) {
        return dashboardRepository.traveledmileagebydriver( driverId,  dateDepart,  dateFin);
    }

    @Override
    public BigDecimal getTotalnumberofproblemsbydriver(long driverId, Date dateDepart, Date dateFin) {
        return dashboardRepository.totalnumberofproblemsbydriver( driverId,  dateDepart,  dateFin);
    }

    @Override
    public BigDecimal getAverageconsumptionseniorityvehicle(long categoryid, long slice1, long slice2, long senioritymode) {
        return dashboardRepository.averageconsumptionvehicleseniorityvehicle( categoryid,  slice1,  slice2,  senioritymode);
    }

    @Override
    public BigDecimal getCorrectivemaintenancecostsbyseniorityvehicle(long categoryid, long slice1, long slice2, long senioritymode) {
        return dashboardRepository.correctivemaintenancecostsbyseniorityvehicle(categoryid,  slice1,  slice2,  senioritymode);
    }

    @Override
    public BigDecimal getPreventivemaintenancecostsbyseniorityvehicle(long categoryid, long slice1, long slice2, long senioritymode) {
        return dashboardRepository.preventivemaintenancecostsbyseniorityvehicle(categoryid,  slice1,  slice2,  senioritymode);
    }

    @Override
    public BigDecimal getTraveledmileagebyseniorityvehicle(long categoryid, long slice1, long slice2, long senioritymode) {
        return dashboardRepository.traveledmileagebyvechileseniorityvehicle(categoryid,  slice1,  slice2,  senioritymode);
    }

    @Override
    public BigDecimal getTotalnumberofproblemsbyseniorityvehicle(long categoryid, long slice1, long slice2, long senioritymode) {
        return dashboardRepository.totalnumberofproblemsbyseniorityvehicle(categoryid,  slice1,  slice2,  senioritymode);
    }


    @Override
    public List<Dashboard> getBarChartGasoilByDriver(long driverId,Date dateDepart, Date dateFin) throws AttributesNotFound, ErrorType {
        List<Dashboard> dashboards = new ArrayList<>();


        List<DieselDeclaration> dieselDeclarationList = dieselDeclarationService.find("driver.id:"+driverId+", dieselDeclarationDate >"+new SimpleDateFormat("yyyy-MM-dd").format( dateDepart)+", dieselDeclarationDate <"+new SimpleDateFormat("yyyy-MM-dd").format( dateFin));

        for (int i = 0; i <=11 ; i++) {
            long month =i;
            List<DieselDeclaration> dieselDeclarationList1 = dieselDeclarationList;
            Dashboard dashboard = new Dashboard();

            dashboard.setMonth(month+1);
            BigDecimal total = dieselDeclarationList1.stream().filter(f-> f.getDieselDeclarationDate().getMonth() == month).
                    map(mp-> mp.getAmount()).reduce(BigDecimal.ZERO,BigDecimal::add);

            dashboard.setValue(total);
            dashboards.add(dashboard);

        }

        return dashboards;
    }



    @Override
    public List<Object> getPercentGasoilByDriver()  {
       /* List<Dashboard> dashboards = new ArrayList<>();


        List<DieselDeclaration> dieselDeclarationList = dieselDeclarationService.findAll();
        List<DieselDeclaration> dieselDeclarationDistinctList = new ArrayList<>();

        dieselDeclarationDistinctList= dieselDeclarationList.stream().collect(Collectors.groupingBy());

*/



        return dashboardRepository.getPercentGasoilByDriver();
    }




}

