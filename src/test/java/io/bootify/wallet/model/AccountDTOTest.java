package io.bootify.wallet.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

class AccountDTOTest {

    private AccountDTO accountDTO;

    @BeforeEach
    public void setUp() {
        accountDTO = new AccountDTO();
    }

    @Test
    void testGetId() {
        assertNull(accountDTO.getId()); // L'ID devrait être null initialement

        Long id = 1L;
        accountDTO.setId(id);

        assertEquals(id, accountDTO.getId()); // Vérifiez que getId() renvoie la valeur définie
    }

    @Test
    void testGetSolde() {
        assertNull(accountDTO.getSolde()); // Le solde devrait être null initialement

        String solde = "100.0";
        accountDTO.setSolde(solde);

        assertEquals(solde, accountDTO.getSolde()); // Vérifiez que getSolde() renvoie la valeur définie
    }

    @Test
    void testGetDateCreation() {
        assertNull(accountDTO.getDateCreation()); // La date de création devrait être null initialement

        OffsetDateTime dateCreation = OffsetDateTime.now();
        accountDTO.setDateCreation(dateCreation);

        assertEquals(dateCreation, accountDTO.getDateCreation()); // Vérifiez que getDateCreation() renvoie la valeur définie
    }







        }