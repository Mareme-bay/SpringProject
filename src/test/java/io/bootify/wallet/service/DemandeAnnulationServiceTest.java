package io.bootify.wallet.service;

import io.bootify.wallet.domain.DemandeAnnulation;
import io.bootify.wallet.model.DemandeAnnulationDTO;
import io.bootify.wallet.repos.DemandeAnnulationRepository;
import io.bootify.wallet.util.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DemandeAnnulationServiceTest {
    @Mock
    private DemandeAnnulationRepository demandeAnnulationRepository;

    @InjectMocks
    private DemandeAnnulationService demandeAnnulationService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);


    }
    @Test
    void create() {
        // Créez un objet DemandeAnnulationDTO fictif pour le test
        DemandeAnnulationDTO demandeAnnulationDTO = new DemandeAnnulationDTO();
        // Initialisez les propriétés de la demandeAnnulationDTO si nécessaire

        // Créez un objet DemandeAnnulation factice pour le test
        DemandeAnnulation demandeAnnulationFictive = new DemandeAnnulation();
        demandeAnnulationFictive.setId(1L); // Par exemple, un ID factice

        // Configurez le comportement de mock pour save dans le repository
        when(demandeAnnulationRepository.save(any(DemandeAnnulation.class)))
                .thenReturn(demandeAnnulationFictive);

        // Appelez la méthode create avec la demandeAnnulationDTO
        Long createdDemandeAnnulationId = demandeAnnulationService.create(demandeAnnulationDTO);

        // Vérifiez que la méthode save a été appelée avec la demandeAnnulation
        verify(demandeAnnulationRepository, times(1)).save(any(DemandeAnnulation.class));

        // Vérifiez que l'ID retourné n'est pas nul
    }

    @Test
    void update() {
        Long demandeAnnulationId = 1L;
        DemandeAnnulationDTO updatedDemandeAnnulationDTO = new DemandeAnnulationDTO();

        when(demandeAnnulationRepository.findById(demandeAnnulationId)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> {
            demandeAnnulationService.update(demandeAnnulationId, updatedDemandeAnnulationDTO);
        });
    }

    @Test
    void delete() {
        Long demandeAnnulationId = 1L;

        demandeAnnulationService.delete(demandeAnnulationId);

        verify(demandeAnnulationRepository, times(1)).deleteById(demandeAnnulationId);
    }
}