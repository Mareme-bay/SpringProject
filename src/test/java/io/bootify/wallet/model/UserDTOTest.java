package io.bootify.wallet.model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserDTOTest {
    private UserDTO userDTO;

    @BeforeEach
    public void setUp() {
        userDTO = new UserDTO();
    }

    @Test
    void testGetId() {
        assertNull(userDTO.getId()); // L'ID devrait être null initialement

        Long id = 1L;
        userDTO.setId(id);

        assertEquals(id, userDTO.getId()); // Vérifiez que getId() renvoie la valeur définie
    }

    @Test
    void testGetNom() {
        assertNull(userDTO.getNom()); // Le nom devrait être null initialement

        String nom = "John";
        userDTO.setNom(nom);

        assertEquals(nom, userDTO.getNom()); // Vérifiez que getNom() renvoie la valeur définie
    }

    @Test
    void testGetPrenom() {
        assertNull(userDTO.getPrenom()); // Le prénom devrait être null initialement

        String prenom = "Doe";
        userDTO.setPrenom(prenom);

        assertEquals(prenom, userDTO.getPrenom()); // Vérifiez que getPrenom() renvoie la valeur définie
    }

    @Test
    void testGetPassword() {
        assertNull(userDTO.getPassword()); // Le mot de passe devrait être null initialement

        String password = "secret123";
        userDTO.setPassword(password);

        assertEquals(password, userDTO.getPassword()); // Vérifiez que getPassword() renvoie la valeur définie
    }

    @Test
    void testGetMail() {
        assertNull(userDTO.getMail()); // L'adresse e-mail devrait être null initialement

        String mail = "john.doe@example.com";
        userDTO.setMail(mail);

        assertEquals(mail, userDTO.getMail()); // Vérifiez que getMail() renvoie la valeur définie
    }

    @Test
    void testGetAccount() {
        assertNull(userDTO.getAccount()); // L'ID de compte devrait être null initialement

        Long accountId = 1001L;
        userDTO.setAccount(accountId);

        assertEquals(accountId, userDTO.getAccount()); // Vérifiez que getAccount() renvoie la valeur définie
    }

}