package controller;

import io.bootify.wallet.controller.AccountController;
import io.bootify.wallet.model.AccountDTO;
import io.bootify.wallet.service.AccountService;
import io.bootify.wallet.util.WebUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AccountControllerTest {

    @Mock
    private AccountService accountService;

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
    public void testList() {
        List<AccountDTO> fakeAccounts = Arrays.asList(
                new AccountDTO(/* données du compte 1 */),
                new AccountDTO(/* données du compte 2 */)
        );

        when(accountService.findAll()).thenReturn(fakeAccounts);

        String viewName = accountController.list(model);

        assertEquals("account/list", viewName);
        verify(model, times(1)).addAttribute("accounts", fakeAccounts);
    }


    @Test
    public void testAddForm() {
        AccountDTO accountDTO = new AccountDTO();

        String viewName = accountController.add(accountDTO);

        assertEquals("account/add", viewName);
    }

    @Test
    public void testAddSuccess() {
        AccountDTO accountDTO = new AccountDTO();

        String viewName = accountController.add(accountDTO, bindingResult, redirectAttributes);

        assertEquals("redirect:/accounts", viewName);
        verify(accountService, times(1)).create(accountDTO);
        verify(redirectAttributes, times(1)).addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("account.create.success"));
    }

    @Test
    public void testEdit() {
        Long accountId = 1L;
        AccountDTO accountDTO = new AccountDTO(/* données du compte */);

        when(accountService.get(accountId)).thenReturn(accountDTO);

        String viewName = accountController.edit(accountId, model);

        assertEquals("account/edit", viewName);
        verify(model, times(1)).addAttribute("account", accountDTO);
    }
    @Test
    public void testEditFormSuccess() {
        Long accountId = 1L;
        AccountDTO accountDTO = new AccountDTO(/* données du compte */);

        when(bindingResult.hasErrors()).thenReturn(false);

        String viewName = accountController.edit(accountId, accountDTO, bindingResult, redirectAttributes);

        assertEquals("redirect:/accounts", viewName);
        verify(accountService, times(1)).update(accountId, accountDTO);
        verify(redirectAttributes, times(1)).addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("account.update.success"));
    }

    @Test
    public void testEditFormFailure() {
        Long accountId = 1L;
        AccountDTO accountDTO = new AccountDTO(/* données du compte */);

        when(bindingResult.hasErrors()).thenReturn(true);

        String viewName = accountController.edit(accountId, accountDTO, bindingResult, redirectAttributes);

        assertEquals("account/edit", viewName);
    }
    @Test
    public void testDelete() {
        Long accountId = 1L;
        String referencedWarning = null;

        when(accountService.getReferencedWarning(accountId)).thenReturn(null);

        String viewName = accountController.delete(accountId, redirectAttributes);

        assertEquals("redirect:/accounts", viewName);
        verify(accountService, times(1)).delete(accountId);
        verify(redirectAttributes, times(1)).addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("account.delete.success"));
    }

    @Test
    public void testDeleteWithReferencedWarning() {
        Long accountId = 1L;
        String referencedWarning = "Référence détectée";

        when(accountService.getReferencedWarning(accountId)).thenReturn(referencedWarning);

        String viewName = accountController.delete(accountId, redirectAttributes);

        assertEquals("redirect:/accounts", viewName);
        verify(redirectAttributes, times(1)).addFlashAttribute(WebUtils.MSG_ERROR, referencedWarning);
    }


}

