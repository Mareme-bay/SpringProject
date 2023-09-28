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
    public void testId() {
        // Créez un objet Transaction
        Transaction transaction = new Transaction();

        // Définissez l'ID
        transaction.setId(1L);

        // Vérifiez que la méthode getId() renvoie la valeur définie
        assertEquals(1L, transaction.getId());

        // Définissez un nouvel ID
        transaction.setId(2L);

        // Vérifiez que la méthode getId() renvoie la nouvelle valeur définie
        assertEquals(2L, transaction.getId());
    }

    @Test
    public void testHeuretrans() {
        // Créez un objet Transaction
        Transaction transaction = new Transaction();

        // Définissez l'heure de la transaction
        OffsetDateTime heuretrans = OffsetDateTime.now();
        transaction.setHeuretrans(heuretrans);

        // Vérifiez que la méthode getHeuretrans() renvoie la valeur définie
        assertEquals(heuretrans, transaction.getHeuretrans());

        // Définissez une nouvelle heure de transaction
        OffsetDateTime newHeuretrans = heuretrans.plusDays(1);
        transaction.setHeuretrans(newHeuretrans);

        // Vérifiez que la méthode getHeuretrans() renvoie la nouvelle valeur définie
        assertEquals(newHeuretrans, transaction.getHeuretrans());
    }

    @Test
    public void testAccount() {
        // Créez un objet Transaction
        Transaction transaction = new Transaction();

        // Créez un objet Account
        Account account = new Account();
        account.setSolde("1000.00");

        // Définissez le compte associé à la transaction
        transaction.setAccount(account);

        // Vérifiez que la méthode getAccount() renvoie le compte défini
        assertEquals(account, transaction.getAccount());

        // Créez un nouvel objet Account
        Account newAccount = new Account();
        newAccount.setSolde("2000.00");

        // Définissez un nouveau compte associé à la transaction
        transaction.setAccount(newAccount);

        // Vérifiez que la méthode getAccount() renvoie le nouveau compte défini
        assertEquals(newAccount, transaction.getAccount());
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