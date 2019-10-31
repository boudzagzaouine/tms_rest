package com.bagile.tms.services;

import com.bagile.tms.dto.Contact;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContactServiceTest {

    @Autowired
    private ContactService contactService;


    @Test
    void save() {

    }

    @Test
    void size_Db_vide_return_zero() {

        assertEquals(0, contactService.size());

    }

    @Test
    void isExist_Id_not_In_Db_return_False() {
        boolean d = contactService.isExist(4587L);
        assertFalse(d);

    }

    @Test
    void findById_Id_not_in_db_return_Exeption_IdNotFound() {

        assertThrows(IdNotFound.class,
                () -> contactService.findById(54181L));
    }

    @Test
    void find_search_not_in_db_return_Exeption_AttributesNotFound() {

        assertThrows(NullPointerException.class,
                () -> contactService.find("klm:pmlk"));
    }

    @Test
    void find1_searchPageSize_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(NullPointerException.class,
                () ->
                        contactService.find("pmlj:hjkd", 13, 44));
    }

    @Test
    void size1_Search_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(NumberFormatException.class,
                () ->

                        contactService.size("id:azsfsdg"));
    }

    @Test
    void delete_Byid_not_inDb_return_exeptionEmptyResultDataAccessException() {
        assertThrows(IdNotFound.class,
        ()->
        contactService.delete(9512L));
    }

    @Test
    void delete1_byContact_notinDb_return_exeption_NotNull_EmptyResultDataAccessException() {
    Contact z = new Contact();
    assertNotNull(z.getId());
    assertEquals(0,z.getId());
        assertThrows(IdNotFound.class,
                ()->
        contactService.delete(z.getId()));
    }

    @Test
    void findAll_empty_return_zero() throws AttributesNotFound, ErrorType {
        assertEquals(0, contactService.findAll().size());

    }

    @Test
    void findAll1_searchPageSize_empty_return_zero() throws AttributesNotFound, ErrorType {
        assertEquals(0, contactService.findAll(125,3).size());

    }
}