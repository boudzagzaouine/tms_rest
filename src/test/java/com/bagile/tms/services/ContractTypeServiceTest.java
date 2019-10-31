package com.bagile.tms.services;

import com.bagile.tms.dto.ContractType;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.DirtiesContext;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContractTypeServiceTest {

    @Autowired
    private ContractTypeService contractTypeService;


    @Test
    @Disabled
    @DirtiesContext
    void save() {
        ContractType contractTypeact = new ContractType();
        assertEquals(0,contractTypeact.getId());
        ContractType save = contractTypeService.save(contractTypeact);
        assertNotNull(save);

    }

    @Test
    void update() throws IdNotFound {

        ContractType contracttypeFindByid=contractTypeService.findById(1L);
        assertNotNull(contracttypeFindByid);
        contracttypeFindByid.setCode("ddd");
        ContractType save = contractTypeService.save(contracttypeFindByid);
        assertNotNull(save);
        assertEquals("ddd",save.getCode());

    }

    @Test
    void size_Db_vide_return_zero() {

        assertEquals(0, contractTypeService.size());

    }

    @Test
    void isExist_Id_not_In_Db_return_False() {
        boolean d = contractTypeService.isExist(4587L);
        assertFalse(d);

    }

    @Test
    void findById_Id_not_in_db_return_Exeption_IdNotFound() {

        assertThrows(NoSuchElementException.class,
                () -> contractTypeService.findById(54181L));
    }

    @Test
    void find_search_not_in_db_return_Exeption_AttributesNotFound() {

        assertThrows(AttributesNotFound.class,
                () -> contractTypeService.find("klm:pmlk"));
    }

    @Test
    void find1_searchPageSize_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(AttributesNotFound.class,
                () ->
                        contractTypeService.find("pmlj:hjkd", 13, 44));
    }

    @Test
    void size1_Search_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(AttributesNotFound.class,
                () ->

                        contractTypeService.size("azsfsdg"));
    }

    @Test
    void delete_Byid_not_inDb_return_exeptionEmptyResultDataAccessException() {
        assertThrows(EmptyResultDataAccessException.class,
        ()->
        contractTypeService.delete(9512L));
    }

    @Test
    void delete1_byContractType_notinDb_return_exeption_NotNull_EmptyResultDataAccessException() {
    ContractType z = new ContractType();
    assertNotNull(z.getId());
    assertEquals(0,z.getId());
        assertThrows(EmptyResultDataAccessException.class,
                ()->
        contractTypeService.delete(z.getId()));
    }

    @Test
    void findAll_empty_return_zero() throws AttributesNotFound, ErrorType {
        assertEquals(0, contractTypeService.findAll().size());

    }

    @Test
    void findAll1_searchPageSize_empty_return_zero() throws AttributesNotFound, ErrorType {
        assertEquals(0, contractTypeService.findAll(125,3).size());

    }
}