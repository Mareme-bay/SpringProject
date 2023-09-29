package io.bootify.wallet.controller;

import static org.junit.jupiter.api.Assertions.*;
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
class DemandeAnnulationControllerTest {
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



}