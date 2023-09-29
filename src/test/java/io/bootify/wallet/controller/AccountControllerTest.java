package io.bootify.wallet.controller;

import static org.junit.jupiter.api.Assertions.*;
import io.bootify.wallet.controller.AccountController;
import io.bootify.wallet.domain.Account;
import io.bootify.wallet.model.AccountDTO;
import io.bootify.wallet.service.AccountService;
import io.bootify.wallet.util.WebUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest

class AccountControllerTest {
    @Mock
    private AccountService accountService;
    private MockMvc mockMvc;
    @Mock
    private Model model;

    @Mock
    private BindingResult bindingResult;

    @Mock
    private RedirectAttributes redirectAttributes;

    @InjectMocks
    private AccountController accountController;

    @BeforeEach
    public void setup() {
    }

    @Test
    public void testAddForm() {
        AccountDTO accountDTO = new AccountDTO();

        String viewName = accountController.add(accountDTO);

        assertEquals("account/add", viewName);
    }



    @Test
    public void testEdit() {
        // Créer un compte fictif pour les besoins du test
        Long accountId = 1L;
        Account account = new Account();
      account.setId(accountId);
        account.setSolde("1000");
        account.setDateCreation(OffsetDateTime.now());

        // Appeler la méthode edit du contrôleur
        String viewName = accountController.edit(accountId, model);

        // Vérifier que la vue retournée est correcte
        assertEquals("account/edit", viewName);

        // Vérifier que le modèle a été correctement mis à jour avec le compte
        //verify(model, times(1)).addAttribute("account", account);
    }


    @Test
    public void testEditFormFailure() {
        Long accountId = 1L;
        AccountDTO accountDTO = new AccountDTO(/* données du compte */);

        when(bindingResult.hasErrors()).thenReturn(true);

        String viewName = accountController.edit(accountId, accountDTO, bindingResult, redirectAttributes);

        assertEquals("account/edit", viewName);
    }



}