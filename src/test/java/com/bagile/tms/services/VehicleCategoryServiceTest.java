package com.bagile.tms.services;

import com.bagile.tms.dto.VehicleCategory;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.IdNotFound;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VehicleCategoryServiceTest {

    @Autowired
    private VehicleCategoryService vehicleCategoryService;


    @Test
    void save() {
        VehicleCategory vehicleCategory = new VehicleCategory();
        assertEquals(0,vehicleCategory.getId());
        VehicleCategory save = vehicleCategoryService.save(vehicleCategory);
        assertNotNull(save);
    }

    @Test
    void update() throws IdNotFound {

        VehicleCategory vehicleCategoryFindByid=vehicleCategoryService.findById(1L);
        assertNotNull(vehicleCategoryFindByid);
        vehicleCategoryFindByid.setCode("vv");
        VehicleCategory save = vehicleCategoryService.save(vehicleCategoryFindByid);
        assertNotNull(save);
        assertEquals("vv",save.getCode());

    }

    @Test
    void size_Db_vide_return_zero() {

        assertEquals(0, vehicleCategoryService.size());

    }

    @Test
    void isExist_Id_not_In_Db_return_False() {
        boolean d = vehicleCategoryService.isExist(4587L);
        assertFalse(d);

    }

    @Test
    void findById_Id_not_in_db_return_Exeption_IdNotFound() {

        assertThrows(IdNotFound.class,
                () -> vehicleCategoryService.findById(54181L));
    }

    @Test
    void find_search_not_in_db_return_Exeption_AttributesNotFound() {

        assertThrows(AttributesNotFound.class,
                () -> vehicleCategoryService.find("klm:pmlk"));
    }

    @Test
    void find1_searchPageSize_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(AttributesNotFound.class,
                () ->
                        vehicleCategoryService.find("pmlj:hjkd", 13, 44));
    }

    @Test
    void size1_Search_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(AttributesNotFound.class,
                () ->

                        vehicleCategoryService.size("azsfsdg"));
    }

    @Test
    void delete_Byid_not_inDb_return_exeptionEmptyResultDataAccessException() {
        assertThrows(EmptyResultDataAccessException.class,
        ()->
        vehicleCategoryService.delete(9512L));
    }

    @Test
    void delete1_byVehicleCategory_notinDb_return_exeption_NotNull_EmptyResultDataAccessException() {
    VehicleCategory z = new VehicleCategory();
    assertNotNull(z.getId());
    assertEquals(0,z.getId());
        assertThrows(EmptyResultDataAccessException.class,
                ()->
        vehicleCategoryService.delete(z.getId()));
    }

    @Test
    void findAll_empty_return_zero() {
        assertEquals(0, vehicleCategoryService.findAll().size());

    }

    @Test
    void findAll1_searchPageSize_empty_return_zero() {
        assertEquals(0, vehicleCategoryService.findAll(125,3).size());

    }
}