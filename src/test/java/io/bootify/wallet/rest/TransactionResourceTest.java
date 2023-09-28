package io.bootify.wallet.rest;
import io.bootify.wallet.domain.Transaction;
import io.bootify.wallet.model.TransactionDTO;
import io.bootify.wallet.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import io.bootify.wallet.model.TransactionDTO;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")


class TransactionResourceTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TransactionResource transactionResource;
    @MockBean
    private TransactionService transactionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllTransactions() throws Exception {
        // Créez une liste de transactions fictives pour simuler la réponse du service
        List<TransactionDTO> transactions = new ArrayList<>();
        // Ajoutez des transactions fictives à la liste

        // Configurez le comportement du mock du service pour renvoyer la liste fictive
        when(transactionService.findAll()).thenReturn(transactions);

        // Effectuez la requête MockMvc pour obtenir toutes les transactions
        mockMvc.perform(MockMvcRequestBuilders.get("/api/transactions")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

        // Vérifiez que la méthode findAll du service a été appelée
        verify(transactionService).findAll();
    }

    @Test
    public void testGetTransaction() throws Exception {
        // Id de la transaction fictive à récupérer
        Long transactionId = 1L;
        // Créez une transaction fictive pour simuler la réponse du service
        TransactionDTO transaction = new TransactionDTO();
        // Configurez le comportement du mock du service pour renvoyer la transaction fictive
        when(transactionService.get(transactionId)).thenReturn(transaction);

        // Effectuez la requête MockMvc pour obtenir une transaction par son ID
        mockMvc.perform(MockMvcRequestBuilders.get("/api/transactions/{id}", transactionId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

        // Vérifiez que la méthode get du service a été appelée avec le bon ID
        verify(transactionService).get(transactionId);
    }


    @Test
    public void testDeleteTransaction() throws Exception {
        // Configurez le comportement du mock du service pour la suppression
        doNothing().when(transactionService).delete(1L);

        // Effectuez la requête DELETE pour supprimer la transaction
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/transactions/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent()); // Attend une réponse 204 No Content

        // Vérifiez que la méthode de service a été appelée avec le bon ID
        verify(transactionService).delete(1L);
    }


}