package com.bagile.gmo.services;

import com.bagile.gmo.dto.MaintenancePlan;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.MaintenancePlanService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MaintenancePlanServiceTest {
    @Autowired
    private MaintenancePlanService maintenancePlanService;

    @Test
    void saveEmptyMaintenancePlanShouldThrowError() {
    }

    @Test
    void saveValidMaintenancePlanShouldReturnTrue() {
        MaintenancePlan maintenancePlan = new MaintenancePlan();
        assertEquals(0,maintenancePlan.getId());
        MaintenancePlan save = maintenancePlanService.save(maintenancePlan);
        assertNotNull(save);
    }

  /*  @Test
    void update() throws IdNotFound {

        MaintenancePlan maintenancePlanFindByid=maintenancePlanService.findById(1L);
        assertNotNull(maintenancePlanFindByid);
        maintenancePlanFindByid.setCode("ddd");
        MaintenancePlan save = maintenancePlanService.save(maintenancePlanFindByid);
        assertNotNull(save);
        assertEquals("DDD",save.getCode());

    }*/


    @ParameterizedTest
    @ValueSource(strings = {"qs123", "ze5478"})
    void saveNewValid(String code) {

        MaintenancePlan maintenancePlan = new MaintenancePlan();
        maintenancePlan.setCode(code);
        assertEquals(0,maintenancePlan.getId());

        MaintenancePlan save = maintenancePlanService.save(maintenancePlan);
        assertEquals(code.toUpperCase(), save.getCode().toUpperCase());
        assertNotNull(save);

    }

    @Test
    void size_Db_return_count() {

        assertEquals(2, maintenancePlanService.size());

    }
    @ParameterizedTest
    @ValueSource(longs = {1L,2L})
    void isExist_Id_exist_In_Db_return_true(long id) {
        boolean d = maintenancePlanService.isExist(id);
        assertTrue(d);

    }
    @Test
    void findById_Id_exist_in_db_return_Object() throws IdNotFound {
        MaintenancePlan maintenancePlan = maintenancePlanService.findById(1L);
        assertNotNull(maintenancePlan);
        assertEquals(1,maintenancePlan.getId());
    }





    @Test
    void sizeOFEmptyDB_ShouldReturn_Zero() {
        assertEquals(0, maintenancePlanService.size());
    }

    @Test
    void sizeSearchOfNotFoundAttributeResultShould() throws AttributesNotFound, ErrorType {
        Long size = maintenancePlanService.size ("code:north");
        assertEquals (0, size);
    }

    @Test
    void isExistOfNonExistingIdShouldReturnFalse() {
        assertFalse(maintenancePlanService.isExist(100L));
    }

    @Test
    void findByIdOfNonExistingRecordShouldThrowIdNotFoundException() {
        assertThrows(IdNotFound.class, () -> {
            maintenancePlanService.findById(100L);
        });
    }

    @Test
    void findNonExistingAttributeShouldThrowAttributeNotFoundException() {
        assertThrows(AttributesNotFound.class, () -> maintenancePlanService.find("XXX:123"));
    }

    @Test
    void findExistingAttributeInEmptyTableShouldReturnEmptyList() {
        assertThrows(AttributesNotFound.class, () -> maintenancePlanService.find("XXX:123"));
    }

    @Test
    void testFindOfNonExistingAttributeShouldThrowAttributesNotFoundException() {
        assertThrows(AttributesNotFound.class, () -> maintenancePlanService.find("XXX:123"));
    }

    @Test
    void testSizeOfNonExistingAttributeShouldThrowAttributesNotFoundException() {
        assertThrows(AttributesNotFound.class, () -> maintenancePlanService.size("XXX:123"));
    }

    @Test
    void deleteNonExistingIdThrowsEmptyResultDataAccessException() {
        assertThrows(EmptyResultDataAccessException.class, () -> maintenancePlanService.delete(24235252L));
    }

    @Test
    void testDeleteOfNewMaintenancePlanWithIDZeroShouldEmptyResultDataAccessException() {
        MaintenancePlan maintenancePlan = new MaintenancePlan();
        assertNotNull(maintenancePlan);
        assertEquals(0, maintenancePlan.getId());
        assertThrows(EmptyResultDataAccessException.class, () -> maintenancePlanService.delete(maintenancePlan.getId()));
    }

    @Test
    void findAllWhenDbEmptyShouldReturnEmptyList() {
        List<MaintenancePlan> all = maintenancePlanService.findAll();
        assertEquals(0, all.size());
    }

    @Test
    void testFindAllOfEmptyTableShouldReturnEmptyList() {
        List<MaintenancePlan> all = maintenancePlanService.findAll();
        assertNotNull(all);
        assertEquals(0, all.size());
    }
}