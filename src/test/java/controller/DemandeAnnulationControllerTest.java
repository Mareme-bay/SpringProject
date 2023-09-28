package controller;

import io.bootify.wallet.controller.DemandeAnnulationController;
import io.bootify.wallet.model.DemandeAnnulationDTO;
import io.bootify.wallet.repos.AccountRepository;
import io.bootify.wallet.service.DemandeAnnulationService;
import io.bootify.wallet.util.CustomCollectors;
import io.bootify.wallet.util.WebUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DemandeAnnulationControllerTest {

    @Mock
    private DemandeAnnulationService demandeAnnulationService;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private Model model;

    @Mock
    private BindingResult bindingResult;

    @Mock
    private RedirectAttributes redirectAttributes;

    @InjectMocks
    private DemandeAnnulationController demandeAnnulationController;

    @BeforeEach
    public void setup() {
        // Initialisation des mocks si nécessaire
    }

    @Test
    public void testList() {
        List<DemandeAnnulationDTO> fakeDemandes = new ArrayList<>();
        when(demandeAnnulationService.findAll()).thenReturn(fakeDemandes);

        String viewName = demandeAnnulationController.list(model);

        assertEquals("demandeAnnulation/list", viewName);
        verify(model, times(1)).addAttribute("demandeAnnulations", fakeDemandes);
    }

    @Test
    public void testAddForm() {
        DemandeAnnulationDTO demandeAnnulationDTO = new DemandeAnnulationDTO();

        String viewName = demandeAnnulationController.add(demandeAnnulationDTO);

        assertEquals("demandeAnnulation/add", viewName);
    }

    @Test
    public void testAddSuccess() {
        DemandeAnnulationDTO demandeAnnulationDTO = new DemandeAnnulationDTO();

        String viewName = demandeAnnulationController.add(demandeAnnulationDTO, bindingResult, redirectAttributes);

        assertEquals("redirect:/demandeAnnulations", viewName);
        verify(demandeAnnulationService, times(1)).create(demandeAnnulationDTO);
        verify(redirectAttributes, times(1)).addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("demandeAnnulation.create.success"));
    }

    @Test
    public void testEdit() {
        Long demandeId = 1L;
        DemandeAnnulationDTO demandeAnnulationDTO = new DemandeAnnulationDTO();

        when(demandeAnnulationService.get(demandeId)).thenReturn(demandeAnnulationDTO);

        String viewName = demandeAnnulationController.edit(demandeId, model);

        assertEquals("demandeAnnulation/edit", viewName);
        verify(model, times(1)).addAttribute("demandeAnnulation", demandeAnnulationDTO);
    }

    @Test
    public void testEditFormSuccess() {
        Long demandeId = 1L;
        DemandeAnnulationDTO demandeAnnulationDTO = new DemandeAnnulationDTO();

        when(bindingResult.hasErrors()).thenReturn(false);

        String viewName = demandeAnnulationController.edit(demandeId, demandeAnnulationDTO, bindingResult, redirectAttributes);

        assertEquals("redirect:/demandeAnnulations", viewName);
        verify(demandeAnnulationService, times(1)).update(demandeId, demandeAnnulationDTO);
        verify(redirectAttributes, times(1)).addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("demandeAnnulation.update.success"));
    }

    @Test
    public void testEditFormFailure() {
        Long demandeId = 1L;
        DemandeAnnulationDTO demandeAnnulationDTO = new DemandeAnnulationDTO();

        when(bindingResult.hasErrors()).thenReturn(true);

        String viewName = demandeAnnulationController.edit(demandeId, demandeAnnulationDTO, bindingResult, redirectAttributes);

        assertEquals("demandeAnnulation/edit", viewName);
    }

    @Test
    public void testDelete() {
        Long demandeId = 1L;

        String viewName = demandeAnnulationController.delete(demandeId, redirectAttributes);

        assertEquals("redirect:/demandeAnnulations", viewName);
        verify(demandeAnnulationService, times(1)).delete(demandeId);
        verify(redirectAttributes, times(1)).addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("demandeAnnulation.delete.success"));
    }
}
