package controller;

import io.bootify.wallet.controller.UserController;
import io.bootify.wallet.model.UserDTO;
import io.bootify.wallet.repos.AccountRepository;
import io.bootify.wallet.service.UserService;
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

public class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private Model model;

    @Mock
    private BindingResult bindingResult;

    @Mock
    private RedirectAttributes redirectAttributes;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setup() {
        // Initialisation des mocks si nécessaire
    }

    @Test
    public void testList() {
        List<UserDTO> fakeUsers = new ArrayList<>();
        when(userService.findAll()).thenReturn(fakeUsers);

        String viewName = userController.list(model);

        assertEquals("user/list", viewName);
        verify(model, times(1)).addAttribute("users", fakeUsers);
    }

    @Test
    public void testAddForm() {
        UserDTO userDTO = new UserDTO();

        String viewName = userController.add(userDTO);

        assertEquals("user/add", viewName);
    }

    @Test
    public void testAddSuccess() {
        UserDTO userDTO = new UserDTO();

        String viewName = userController.add(userDTO, bindingResult, redirectAttributes);

        assertEquals("redirect:/users", viewName);
        verify(userService, times(1)).create(userDTO);
        verify(redirectAttributes, times(1)).addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("user.create.success"));
    }

    @Test
    public void testEdit() {
        Long userId = 1L;
        UserDTO userDTO = new UserDTO();

        when(userService.get(userId)).thenReturn(userDTO);

        String viewName = userController.edit(userId, model);

        assertEquals("user/edit", viewName);
        verify(model, times(1)).addAttribute("user", userDTO);
    }

    @Test
    public void testEditFormSuccess() {
        Long userId = 1L;
        UserDTO userDTO = new UserDTO();

        when(bindingResult.hasErrors()).thenReturn(false);

        String viewName = userController.edit(userId, userDTO, bindingResult, redirectAttributes);

        assertEquals("redirect:/users", viewName);
        verify(userService, times(1)).update(userId, userDTO);
        verify(redirectAttributes, times(1)).addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("user.update.success"));
    }

    @Test
    public void testEditFormFailure() {
        Long userId = 1L;
        UserDTO userDTO = new UserDTO();

        when(bindingResult.hasErrors()).thenReturn(true);

        String viewName = userController.edit(userId, userDTO, bindingResult, redirectAttributes);

        assertEquals("user/edit", viewName);
    }

    @Test
    public void testDelete() {
        Long userId = 1L;

        String viewName = userController.delete(userId, redirectAttributes);

        assertEquals("redirect:/users", viewName);
        verify(userService, times(1)).delete(userId);
        verify(redirectAttributes, times(1)).addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("user.delete.success"));
    }
}
