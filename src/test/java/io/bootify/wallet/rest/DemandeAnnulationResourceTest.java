package io.bootify.wallet.rest;
import io.bootify.wallet.model.DemandeAnnulationDTO;
import io.bootify.wallet.service.DemandeAnnulationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")

class DemandeAnnulationResourceTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DemandeAnnulationService demandeAnnulationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllDemandeAnnulations() throws Exception {
        // Créez des objets de test
        DemandeAnnulationDTO demandeAnnulation1 = new DemandeAnnulationDTO();
        demandeAnnulation1.setId(1L);
        DemandeAnnulationDTO demandeAnnulation2 = new DemandeAnnulationDTO();
        demandeAnnulation2.setId(2L);

        List<DemandeAnnulationDTO> demandeAnnulations = new ArrayList<>();
        demandeAnnulations.add(demandeAnnulation1);
        demandeAnnulations.add(demandeAnnulation2);

        // Configurez le comportement du mock du service
        when(demandeAnnulationService.findAll()).thenReturn(demandeAnnulations);

        // Effectuez la requête MockMvc
        mockMvc.perform(MockMvcRequestBuilders.get("/api/demandeAnnulations")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2));
    }

    @Test
    public void testDeleteDemandeAnnulation() throws Exception {
        // Id de la demande d'annulation à supprimer
        Long demandeAnnulationId = 1L;

        // Configurez le comportement du mock du service pour une méthode void avec doNothing
        doNothing().when(demandeAnnulationService).delete(demandeAnnulationId);

        // Effectuez la requête MockMvc pour supprimer la demande d'annulation
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/demandeAnnulations/{id}", demandeAnnulationId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        // Vérifiez que la méthode delete du service a été appelée avec le bon ID
        verify(demandeAnnulationService).delete(demandeAnnulationId);
    }

}