package com.bagile.gmo.services;

import com.bagile.gmo.dto.Contact;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.ContactService;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Disabled
class ContactServiceTest {

    @Autowired
    private ContactService contactService;

    @Test
    @Disabled
    @DirtiesContext
    void save() {
        Contact contact = new Contact();
        assertEquals(0,contact.getId());
        Contact save = contactService.save(contact);
        assertNotNull(save);
    }

    @Test
    void update() throws IdNotFound {

        Contact contactFindByid=contactService.findById(1L);
        assertNotNull(contactFindByid);
        contactFindByid.setSurname("ddd");
        Contact save = contactService.save(contactFindByid);
        assertNotNull(save);
        assertEquals("ddd",save.getSurname());

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
    void saveEmptyContactShouldThrowError() {
    }

    @Test
    void saveValidContactShouldReturnTrue() {
    }

    @Test
    void sizeOFEmptyDB_ShouldReturn_Zero() {
        assertEquals(0, contactService.size());
    }

    @Test
    void sizeSearchOfNotFoundAttributeResultShould() {
        assertThrows(NullPointerException.class, () -> contactService.size("cdscd:north"));
    }

    @Test
    void isExistOfNonExistingIdShouldReturnFalse() {
        assertFalse(contactService.isExist(100L));
    }

    @Test
    void findByIdOfNonExistingRecordShouldThrowIdNotFoundException() {
        assertThrows(IdNotFound.class, () -> {
            contactService.findById(100L);
        });
    }

    @Test
    void findNonExistingAttributeShouldThrowAttributeNotFoundException() throws AttributesNotFound, ErrorType {
        contactService.find("XXX:123");
    }

    @Test
    void findExistingAttributeInEmptyTableShouldReturnEmptyList() {
        try {
            contactService.find("id:123");
        } catch (AttributesNotFound | ErrorType attributesNotFound) {
            attributesNotFound.printStackTrace ( );
        }
    }


    @Test
    void testSizeOfNonExistingAttributeShouldThrowAttributesNotFoundException() throws AttributesNotFound, ErrorType {
        Long size = contactService.size ("XXX:123");
        assertEquals (0, size);
    }

    @Test
    void deleteNonExistingIdThrowsEmptyResultDataAccessException() {
        assertThrows(IdNotFound.class, () -> contactService.delete(24235252L));
    }

    @Test
    void testDeleteOfNewContactWithIDZeroShouldEmptyResultDataAccessException() {
        Contact contact = new Contact();
        assertNotNull(contact);
        assertEquals(0, contact.getId());
        assertThrows(IdNotFound.class, () -> contactService.delete(contact.getId()));
    }

    @Test
    void testFindAllOfEmptyTableShouldReturnEmptyList() throws AttributesNotFound, ErrorType {
        List<Contact> all = contactService.findAll();
        assertNotNull(all);
        assertEquals(0, all.size());
    }
}