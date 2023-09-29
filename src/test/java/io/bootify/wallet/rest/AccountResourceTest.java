package io.bootify.wallet.rest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.bootify.wallet.domain.Account;
import io.bootify.wallet.model.AccountDTO;
import io.bootify.wallet.service.AccountService;
import io.bootify.wallet.util.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class AccountResourceTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AccountResource accountResource;

    @Mock
    private AccountService accountService;



    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    public void testGetAllAccounts() throws Exception {
        // Simuler le service pour renvoyer une liste vide d'AccountDTO
        when(accountService.findAll()).thenReturn(Collections.emptyList());

        // Effectuer une requête GET sur /api/accounts
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/accounts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Vérifier que la réponse est vide
        String content = result.getResponse().getContentAsString();
        assert content.equals("[]");
    }






}