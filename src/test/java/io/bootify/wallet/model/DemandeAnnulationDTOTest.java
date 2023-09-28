package io.bootify.wallet.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

class DemandeAnnulationDTOTest {
    private DemandeAnnulationDTO demandeAnnulationDTO;

    @BeforeEach
    public void setUp() {
        demandeAnnulationDTO = new DemandeAnnulationDTO();
    }

    @Test
    void testGetId() {
        assertNull(demandeAnnulationDTO.getId()); // L'ID devrait être null initialement

        Long id = 1L;
        demandeAnnulationDTO.setId(id);

        assertEquals(id, demandeAnnulationDTO.getId()); // Vérifiez que getId() renvoie la valeur définie
    }

    @Test
    void testGetIdEmet() {
        assertNull(demandeAnnulationDTO.getIdEmet()); // L'ID émetteur devrait être null initialement

        Long idEmet = 1001L;
        demandeAnnulationDTO.setIdEmet(idEmet);

        assertEquals(idEmet, demandeAnnulationDTO.getIdEmet()); // Vérifiez que getIdEmet() renvoie la valeur définie
    }

    @Test
    void testGetIdRecept() {
        assertNull(demandeAnnulationDTO.getIdRecept()); // L'ID destinataire devrait être null initialement

        Long idRecept = 2002L;
        demandeAnnulationDTO.setIdRecept(idRecept);

        assertEquals(idRecept, demandeAnnulationDTO.getIdRecept()); // Vérifiez que getIdRecept() renvoie la valeur définie
    }

    @Test
    void testGetMontant() {
        assertNull(demandeAnnulationDTO.getMontant()); // Le montant devrait être null initialement

        Double montant = 50.0;
        demandeAnnulationDTO.setMontant(montant);

        assertEquals(montant, demandeAnnulationDTO.getMontant()); // Vérifiez que getMontant() renvoie la valeur définie
    }

    @Test
    void testGetEtatDemande() {
        assertNull(demandeAnnulationDTO.getEtatDemande()); // L'état de la demande devrait être null initialement

        String etatDemande = "En attente";
        demandeAnnulationDTO.setEtatDemande(etatDemande);

        assertEquals(etatDemande, demandeAnnulationDTO.getEtatDemande()); // Vérifiez que getEtatDemande() renvoie la valeur définie
    }

    @Test
    void testGetHeureDemande() {
        assertNull(demandeAnnulationDTO.getHeureDemande()); // L'heure de la demande devrait être null initialement

        OffsetDateTime heureDemande = OffsetDateTime.now();
        demandeAnnulationDTO.setHeureDemande(heureDemande);

        assertEquals(heureDemande, demandeAnnulationDTO.getHeureDemande()); // Vérifiez que getHeureDemande() renvoie la valeur définie
    }

    @Test
    void testGetAccount() {
        assertNull(demandeAnnulationDTO.getAccount()); // L'ID de compte devrait être null initialement

        Long accountId = 3003L;
        demandeAnnulationDTO.setAccount(accountId);

        assertEquals(accountId, demandeAnnulationDTO.getAccount()); // Vérifiez que getAccount() renvoie la valeur définie
    }

}