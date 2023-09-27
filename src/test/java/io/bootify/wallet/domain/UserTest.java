package io.bootify.wallet.domain;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void CreateUser() {
        User user = new User();
        assertNotNull(user);
    }


    @Test
    void testGettersAndSetters() {
        User user = new User();
        user.setId(1L);
        user.setNom("fafa");
        user.setPrenom("ppp");
        user.setPassword("password123");
        user.setMail("fafa.ppp@example.com");

        assertEquals(1L, user.getId());
        assertEquals("fafa", user.getNom());
        assertEquals("ppp", user.getPrenom());
        assertEquals("password123", user.getPassword());
        assertEquals("fafa.ppp@example.com", user.getMail());
    }

    @Test
    void testAccountAssociation() {
        User user = new User();
        Account account = new Account();
        user.setAccount(account);

        assertEquals(account, user.getAccount());
    }

    @Test
    void testDates() {
        User user = new User();
        OffsetDateTime now = OffsetDateTime.now();
        user.setDateCreated(now);
        user.setLastUpdated(now);

        assertEquals(now, user.getDateCreated());
        assertEquals(now, user.getLastUpdated());


    }
}