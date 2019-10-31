package com.bagile.tms.services;

import com.bagile.tms.dto.MaintenancePlan;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.junit.jupiter.api.Test;
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