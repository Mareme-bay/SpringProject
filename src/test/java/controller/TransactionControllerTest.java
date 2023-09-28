package controller;

import io.bootify.wallet.controller.TransactionController;
import io.bootify.wallet.model.TransactionDTO;
import io.bootify.wallet.repos.AccountRepository;
import io.bootify.wallet.service.TransactionService;
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

public class TransactionControllerTest {

    @Mock
    private TransactionService transactionService;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private Model model;

    @Mock
    private BindingResult bindingResult;

    @Mock
    private RedirectAttributes redirectAttributes;

    @InjectMocks
    private TransactionController transactionController;

    @BeforeEach
    public void setup() {
        // Initialisation des mocks si nécessaire
    }

    @Test
    public void testList() {
        List<TransactionDTO> fakeTransactions = new ArrayList<>();
        when(transactionService.findAll()).thenReturn(fakeTransactions);

        String viewName = transactionController.list(model);

        assertEquals("transaction/list", viewName);
        verify(model, times(1)).addAttribute("transactions", fakeTransactions);
    }

    @Test
    public void testAddForm() {
        TransactionDTO transactionDTO = new TransactionDTO();

        String viewName = transactionController.add(transactionDTO);

        assertEquals("transaction/add", viewName);
    }

    @Test
    public void testAddSuccess() {
        TransactionDTO transactionDTO = new TransactionDTO();

        String viewName = transactionController.add(transactionDTO, bindingResult, redirectAttributes);

        assertEquals("redirect:/transactions", viewName);
        verify(transactionService, times(1)).create(transactionDTO);
        verify(redirectAttributes, times(1)).addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("transaction.create.success"));
    }

    @Test
    public void testEdit() {
        Long transactionId = 1L;
        TransactionDTO transactionDTO = new TransactionDTO();

        when(transactionService.get(transactionId)).thenReturn(transactionDTO);

        String viewName = transactionController.edit(transactionId, model);

        assertEquals("transaction/edit", viewName);
        verify(model, times(1)).addAttribute("transaction", transactionDTO);
    }

    @Test
    public void testEditFormSuccess() {
        Long transactionId = 1L;
        TransactionDTO transactionDTO = new TransactionDTO();

        when(bindingResult.hasErrors()).thenReturn(false);

        String viewName = transactionController.edit(transactionId, transactionDTO, bindingResult, redirectAttributes);

        assertEquals("redirect:/transactions", viewName);
        verify(transactionService, times(1)).update(transactionId, transactionDTO);
        verify(redirectAttributes, times(1)).addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("transaction.update.success"));
    }

    @Test
    public void testEditFormFailure() {
        Long transactionId = 1L;
        TransactionDTO transactionDTO = new TransactionDTO();

        when(bindingResult.hasErrors()).thenReturn(true);

        String viewName = transactionController.edit(transactionId, transactionDTO, bindingResult, redirectAttributes);

        assertEquals("transaction/edit", viewName);
    }

    @Test
    public void testDelete() {
        Long transactionId = 1L;

        String viewName = transactionController.delete(transactionId, redirectAttributes);

        assertEquals("redirect:/transactions", viewName);
        verify(transactionService, times(1)).delete(transactionId);
        verify(redirectAttributes, times(1)).addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("transaction.delete.success"));
    }

    @Test
    public void testTransfertMoney() {
        Long id1 = 1L;
        Long id2 = 2L;
        double amount = 100.0;

        String viewName = transactionController.transfertMoney(id1, id2, amount, redirectAttributes);

        assertEquals("redirect:/transactions", viewName);
        verify(transactionService, times(1)).transferMoney(id1, id2, amount);
        verify(redirectAttributes, times(1)).addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("transaction.transfertMoney.success"));
    }
}
