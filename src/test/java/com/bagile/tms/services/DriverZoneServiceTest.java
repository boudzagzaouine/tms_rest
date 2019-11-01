package com.bagile.tms.services;

import com.bagile.tms.dto.Driver;
import com.bagile.tms.dto.DriverZone;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.IdNotFound;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DriverZoneServiceTest {
    @Autowired
    private DriverZoneService driverZoneService;

    @Test
    void saveEmptyDriverZoneShouldThrowError() {
    }

    @Test
    @Disabled
    @DirtiesContext
    void saveValidDriverZoneShouldReturnTrue() {
        DriverZone driverZone = new DriverZone();
        assertEquals(0,driverZone.getId());
        DriverZone save = driverZoneService.save(driverZone);
        assertNotNull(save);
    }




    @Test
    void sizeOFEmptyDB_ShouldReturn_Zero() {
        assertEquals(0, driverZoneService.size());
    }

    @Test
    void sizeSearchOfNotFoundAttributeResultShould() {
        assertThrows(AttributesNotFound.class, () -> driverZoneService.size("code:north"));
    }

    @Test
    void isExistOfNonExistingIdShouldReturnFalse() {
        assertFalse(driverZoneService.isExist(100L));
    }

    @Test
    void findByIdOfNonExistingRecordShouldThrowIdNotFoundException() {
        assertThrows(IdNotFound.class, () -> {
            driverZoneService.findById(100L);
        });
    }

    @Test
    void findNonExistingAttributeShouldThrowAttributeNotFoundException() {
        assertThrows(AttributesNotFound.class, () -> driverZoneService.find("XXX:123"));
    }

    @Test
    void findExistingAttributeInEmptyTableShouldReturnEmptyList() {
        assertThrows(AttributesNotFound.class, () -> driverZoneService.find("XXX:123"));
    }

    @Test
    void testFindOfNonExistingAttributeShouldThrowAttributesNotFoundException() {
        assertThrows(AttributesNotFound.class, () -> driverZoneService.find("XXX:123"));
    }

    @Test
    void testSizeOfNonExistingAttributeShouldThrowAttributesNotFoundException() {
        assertThrows(AttributesNotFound.class, () -> driverZoneService.size("XXX:123"));
    }

    @Test
    void deleteNonExistingIdThrowsEmptyResultDataAccessException() {
        assertThrows(EmptyResultDataAccessException.class, () -> driverZoneService.delete(24235252L));
    }

    @Test
    void testDeleteOfNewDriverZoneWithIDZeroShouldEmptyResultDataAccessException() {
        DriverZone driverZone = new DriverZone();
        assertNotNull(driverZone);
        assertEquals(0, driverZone.getId());
        assertThrows(EmptyResultDataAccessException.class, () -> driverZoneService.delete(driverZone.getId()));
    }

    @Test
    void findAllWhenDbEmptyShouldReturnEmptyList() {
        List<DriverZone> all = driverZoneService.findAll();
        assertEquals(0, all.size());
    }

    @Test
    void testFindAllOfEmptyTableShouldReturnEmptyList() {
        List<DriverZone> all = driverZoneService.findAll();
        assertNotNull(all);
        assertEquals(0, all.size());
    }
}