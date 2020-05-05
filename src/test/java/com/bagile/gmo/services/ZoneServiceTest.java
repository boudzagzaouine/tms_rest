package com.bagile.gmo.services;

import com.bagile.gmo.dto.Zone;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.ZoneService;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ZoneServiceTest {

    @Autowired
    private ZoneService zoneService;


    @Test
    void update() throws IdNotFound {

        Zone zoneFindByid=zoneService.findById(1L);
        assertNotNull(zoneFindByid);
        zoneFindByid.setName("ddd");
        Zone save = zoneService.save(zoneFindByid);
        assertNotNull(save);
        assertEquals("ddd",save.getName());

    }

    @Test
    void save() {
        Zone zone = new Zone();
        assertEquals(0,zone.getId());
        Zone save = zoneService.save(zone);
        assertNotNull(save);
    }

    @Test
    void size_Db_vide_return_zero() {

        assertEquals(0, zoneService.size());

    }

    @Test
    void isExist_Id_not_In_Db_return_False() {
        boolean d = zoneService.isExist(4587L);
        assertFalse(d);

    }

    @Test
    void findById_Id_not_in_db_return_Exeption_IdNotFound() {

        assertThrows(IdNotFound.class,
                () -> zoneService.findById(54181L));
    }

    @Test
    void find_search_not_in_db_return_Exeption_AttributesNotFound() {

        assertThrows(AttributesNotFound.class,
                () -> zoneService.find("klm:pmlk"));
    }

    @Test
    void find1_searchPageSize_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(AttributesNotFound.class,
                () ->
                        zoneService.find("pmlj:hjkd", 13, 44));
    }

    @Test
    void size1_Search_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(AttributesNotFound.class,
                () ->

                        zoneService.size("azsfsdg"));
    }

    @Test
    void delete_Byid_not_inDb_return_exeptionEmptyResultDataAccessException() {
        assertThrows(EmptyResultDataAccessException.class,
        ()->
        zoneService.delete(9512L));
    }

    @Test
    void delete1_byZone_notinDb_return_exeption_NotNull_EmptyResultDataAccessException() {
    Zone z = new Zone();
    assertNotNull(z.getId());
    assertEquals(0,z.getId());
        assertThrows(EmptyResultDataAccessException.class,
                ()->
        zoneService.delete(z.getId()));
    }

    @Test
    void findAll_empty_return_zero() {
        assertEquals(0, zoneService.findAll().size());

    }

    @Test
    void findAll1_searchPageSize_empty_return_zero() {
        assertEquals(0, zoneService.findAll(125,3).size());

    }
}