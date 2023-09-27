package io.bootify.wallet.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
    private Transaction transaction;

    @BeforeEach
    void setUp() {
        transaction = new Transaction();
    }


    @Test
    public void SetId() {
        Transaction transaction = new Transaction();
        transaction.setId(1L);
        assertEquals(1L, transaction.getId());
    }
    @Test
    public void SetMontant() {
        Transaction transaction = new Transaction();
        transaction.setMontant(100.0);
        assertEquals(100.0, transaction.getMontant(), 0.01); // Utilisation de delta pour les valeurs en virgule flottante
    }

    @Test
    public void testSetHeureTrans() {
        Transaction transaction = new Transaction();
        OffsetDateTime heureTrans = OffsetDateTime.now();
        transaction.setHeuretrans(heureTrans);
        assertEquals(heureTrans, transaction.getHeuretrans());
    }
    @Test
    void setCptSource() {
        Transaction transaction = new Transaction();
        transaction.setCptSource(123L);
        assertEquals(123L, transaction.getCptSource());
    }

    @Test
    void setCptDest() {
        Transaction transaction = new Transaction();
        transaction.setCptDest(456L);
        assertEquals(456L, transaction.getCptDest());
    }


}