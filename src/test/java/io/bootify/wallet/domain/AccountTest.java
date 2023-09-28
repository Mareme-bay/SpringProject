package io.bootify.wallet.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Mock
    private Account account;

    @BeforeEach
    void setUp() {
        // Initialiser un nouvel objet Account avant chaque test
        account = new Account();
    }
    @Test
    void getId() {
        // Définir l'ID de l'Account
        account.setId(1L);

        // Vérifier que getId retourne la valeur attendue
        assertEquals(1L, account.getId());

    }

    @Test
    void setId() {
        // Définir l'ID de l'Account
        account.setId(1L);

        // Vérifier que getId retourne la valeur attendue
        assertEquals(1L, account.getId());


    }

    @Test
    void getSolde() {
        // Créez une instance d'Account
        Account account = new Account();
        // Définir le solde de l'Account
        account.setSolde("100.0");

        // Vérifier que getSolde retourne la valeur attendue
        assertEquals("100.0", account.getSolde());

    }

    @Test
    void setSolde() {
        // Créez une instance d'Account
        Account account = new Account();
        // Définir le solde de l'Account en utilisant la méthode setSolde
        account.setSolde("200.0");

        // Vérifier que la valeur a été correctement définie
        assertEquals("200.0", account.getSolde());
    }

    @Test
    void getTransaction() {
        // Créez une nouvelle transaction
        Transaction transaction = new Transaction();
        transaction.setId(1L);

        // Créez un ensemble et ajoutez la nouvelle transaction
        Set<Transaction> transactionSet = new HashSet<>();
        transactionSet.add(transaction);

        // Utilisez la méthode setTransaction pour définir l'ensemble de transactions de l'Account
        account.setTransaction(transactionSet);

        // Utilisez la méthode getTransaction pour obtenir l'ensemble de transactions de l'Account
        Set<Transaction> result = account.getTransaction();

        // Vérifier que l'ensemble retourné est égal à l'ensemble attendu
        assertEquals(transactionSet, result);

    }

    @Test
    void getDemandeAnnulation() {
        // Créez une demande d'annulation factice
        DemandeAnnulation demandeAnnulation = new DemandeAnnulation();
        demandeAnnulation.setId(1L);

        //Créez un ensemble et ajoutez la nouvelle demande d'annulation
        Set<DemandeAnnulation> demandeAnnulationSet = new HashSet<>();
        demandeAnnulationSet.add(demandeAnnulation);

        // Utilisez la méthode setDemandeAnnulation pour définir l'ensemble de demandes d'annulation de l'Account
        account.setDemandeAnnulation(demandeAnnulationSet);

        // Utilisez la méthode getDemandeAnnulation pour obtenir l'ensemble de demandes d'annulation de l'Account
        Set<DemandeAnnulation> result = account.getDemandeAnnulation();

        // Vérifier que l'ensemble retourné est égal à l'ensemble attendu
        assertEquals(demandeAnnulationSet, result);
    }

    @Test
    void setDemandeAnnulation() {
        // Créez une nouvelle demande d'annulation
        DemandeAnnulation newDemandeAnnulation = new DemandeAnnulation();
        newDemandeAnnulation.setId(2L);

        // Créez un ensemble et ajoutez la nouvelle demande d'annulation
        Set<DemandeAnnulation> demandeAnnulationSet = new HashSet<>();
        demandeAnnulationSet.add(newDemandeAnnulation);

        // Utilisez la méthode setDemandeAnnulation pour définir le nouvel ensemble de demandes d'annulation de l'Account
        account.setDemandeAnnulation(demandeAnnulationSet);

        // Vérifier que la méthode getDemandeAnnulation retourne le nouvel ensemble de demandes d'annulation
        assertEquals(demandeAnnulationSet, account.getDemandeAnnulation());

    }

    @Test
    void getUser() {
        // Créez un objet User factice
        User user = new User();
        user.setId(1L);

        // Définir l'utilisateur de l'Account
        account.setUser(user);

        // Vérifier que getUser retourne l'utilisateur attendu
        assertEquals(user, account.getUser());
    }
    @Test
    void setUser() {
        // Créez un nouvel utilisateur
        User newUser = new User();
        newUser.setId(2L);

        // Utilisez la méthode setUser pour définir l'utilisateur de l'Account
        account.setUser(newUser);

        // Vérifier que la méthode getUser retourne le nouvel utilisateur
        assertEquals(newUser, account.getUser());
    }

    @Test
    public void testDateCreation() {
        // Créez un objet Account
        Account account = new Account();

        // Définissez la date de création
        OffsetDateTime dateCreation = OffsetDateTime.now();
        account.setDateCreation(dateCreation);

        // Vérifiez que la méthode getDateCreation() renvoie la valeur définie
        assertEquals(dateCreation, account.getDateCreation());

        // Définissez une nouvelle date de création
        OffsetDateTime newDateCreation = dateCreation.plusDays(1);
        account.setDateCreation(newDateCreation);

        // Vérifiez que la méthode getDateCreation() renvoie la nouvelle valeur définie
        assertEquals(newDateCreation, account.getDateCreation());
    }
    @Test
    public void testIdAccessors() {
        // Créez un objet Account
        Account account = new Account();

        // Définissez l'ID
        account.setId(1L);

        // Vérifiez que la méthode getId() renvoie la valeur définie
        assertEquals(1L, account.getId());

        // Définissez un nouvel ID
        account.setId(2L);

        // Vérifiez que la méthode getId() renvoie la nouvelle valeur définie
        assertEquals(2L, account.getId());
    }

    @Test
    public void testSolde() {
        // Créez un objet Account
        Account account = new Account();

        // Définissez le solde
        account.setSolde("1000.00");

        // Vérifiez que la méthode getSolde() renvoie la valeur définie
        assertEquals("1000.00", account.getSolde());

        // Définissez un nouveau solde
        account.setSolde("1500.00");

        // Vérifiez que la méthode getSolde() renvoie la nouvelle valeur définie
        assertEquals("1500.00", account.getSolde());
    }


@Test
    public void testUser() {
        // Créez un objet Account
        Account account = new Account();

        // Créez un objet User
        User user = new User();
        user.setNom("maya");
        user.setPrenom("sss");

        // Définissez l'utilisateur
        account.setUser(user);

        // Vérifiez que la méthode getUser() renvoie l'utilisateur défini
        assertEquals(user, account.getUser());

        // Définissez un nouvel utilisateur
        User newUser = new User();
        newUser.setNom("amsa");
        newUser.setPrenom("ttt");
        account.setUser(newUser);

        // Vérifiez que la méthode getUser() renvoie le nouvel utilisateur défini
        assertEquals(newUser, account.getUser());
    }
}