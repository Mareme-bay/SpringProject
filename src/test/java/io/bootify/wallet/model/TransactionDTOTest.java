package io.bootify.wallet.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
class TransactionDTOTest {
    private TransactionDTO transactionDTO;

    @BeforeEach
    public void setUp() {
        transactionDTO = new TransactionDTO();
    }

    @Test
    void testGetId() {
        assertNull(transactionDTO.getId()); // L'ID devrait être null initialement

        Long id = 1L;
        transactionDTO.setId(id);

        assertEquals(id, transactionDTO.getId()); // Vérifiez que getId() renvoie la valeur définie
    }

    @Test
    void testGetHeuretrans() {
        assertNull(transactionDTO.getHeuretrans()); // L'heure de la transaction devrait être null initialement

        OffsetDateTime heuretrans = OffsetDateTime.now();
        transactionDTO.setHeuretrans(heuretrans);

        assertEquals(heuretrans, transactionDTO.getHeuretrans()); // Vérifiez que getHeuretrans() renvoie la valeur définie
    }

    @Test
    void testGetMontant() {
        assertNull(transactionDTO.getMontant()); // Le montant devrait être null initialement

        Double montant = 50.0;
        transactionDTO.setMontant(montant);

        assertEquals(montant, transactionDTO.getMontant()); // Vérifiez que getMontant() renvoie la valeur définie
    }

    @Test
    void testGetCptSource() {
        assertNull(transactionDTO.getCptSource()); // Le compte source devrait être null initialement

        Long cptSource = 1001L;
        transactionDTO.setCptSource(cptSource);

        assertEquals(cptSource, transactionDTO.getCptSource()); // Vérifiez que getCptSource() renvoie la valeur définie
    }

    @Test
    void testGetCptDest() {
        assertNull(transactionDTO.getCptDest()); // Le compte destinataire devrait être null initialement

        Long cptDest = 2002L;
        transactionDTO.setCptDest(cptDest);

        assertEquals(cptDest, transactionDTO.getCptDest()); // Vérifiez que getCptDest() renvoie la valeur définie
    }

    @Test
    void testGetType() {
        assertNull(transactionDTO.getType()); // Le type devrait être null initialement

        String type = "Transfert";
        transactionDTO.setType(type);

        assertEquals(type, transactionDTO.getType()); // Vérifiez que getType() renvoie la valeur définie
    }

    @Test
    void testGetAccount() {
        assertNull(transactionDTO.getAccount()); // L'ID de compte devrait être null initialement

        Long accountId = 3003L;
        transactionDTO.setAccount(accountId);

        assertEquals(accountId, transactionDTO.getAccount()); // Vérifiez que getAccount() renvoie la valeur définie
    }

}