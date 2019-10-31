package com.bagile.tms.services;

import com.bagile.tms.dto.Driver;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.IdNotFound;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DriverServiceTest {
    @Autowired
    private DriverService driverService;

    @Test
    void saveEmptyDriverShouldThrowError() {
    }

    @Test
    void saveValidDriverShouldReturnTrue() {
    }

    @Test
    void sizeOFEmptyDB_ShouldReturn_Zero() {
        assertEquals(0, driverService.size());
    }

    @Test
    void sizeSearchOfNotFoundAttributeResultShould() {
        assertThrows(AttributesNotFound.class, () -> driverService.size("code:north"));
    }

    @Test
    void isExistOfNonExistingIdShouldReturnFalse() {
        assertFalse(driverService.isExist(100L));
    }

    @Test
    void findByIdOfNonExistingRecordShouldThrowIdNotFoundException() {
        assertThrows(IdNotFound.class, () -> {
            driverService.findById(100L);
        });
    }

    @Test
    void findNonExistingAttributeShouldThrowAttributeNotFoundException() {
        assertThrows(AttributesNotFound.class, () -> driverService.find("XXX:123"));
    }

    @Test
    void findExistingAttributeInEmptyTableShouldReturnEmptyList() {
        assertThrows(AttributesNotFound.class, () -> driverService.find("XXX:123"));
    }

    @Test
    void testFindOfNonExistingAttributeShouldThrowAttributesNotFoundException() {
        assertThrows(AttributesNotFound.class, () -> driverService.find("XXX:123"));
    }

    @Test
    void testSizeOfNonExistingAttributeShouldThrowAttributesNotFoundException() {
        assertThrows(AttributesNotFound.class, () -> driverService.size("XXX:123"));
    }

    @Test
    void deleteNonExistingIdThrowsEmptyResultDataAccessException() {
        assertThrows(EmptyResultDataAccessException.class, () -> driverService.delete(24235252L));
    }

    @Test
    void testDeleteOfNewDriverWithIDZeroShouldEmptyResultDataAccessException() {
        Driver driver = new Driver();
        assertNotNull(driver);
        assertEquals(0, driver.getId());
        assertThrows(EmptyResultDataAccessException.class, () -> driverService.delete(driver.getId()));
    }

    @Test
    void findAllWhenDbEmptyShouldReturnEmptyList() {
        List<Driver> all = driverService.findAll();
        assertEquals(0, all.size());
    }

    @Test
    void testFindAllOfEmptyTableShouldReturnEmptyList() {
        List<Driver> all = driverService.findAll();
        assertNotNull(all);
        assertEquals(0, all.size());
    }
}