package io.bootify.wallet.controller;

import static io.cucumber.messages.internal.com.google.common.base.Verify.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import io.bootify.wallet.controller.UserController;
import io.bootify.wallet.model.UserDTO;
import io.bootify.wallet.repos.UserRepository;
import io.bootify.wallet.service.UserService;
import io.bootify.wallet.util.WebUtils;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@RunWith(MockitoJUnitRunner.class)

@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserService userService;

    @Mock
    private Model model;
    @Mock
    private BindingResult bindingResult;
    @Mock
    private RedirectAttributes redirectAttributes;
    @InjectMocks
    private UserController userController;

    public UserControllerTest() {
    }

    @BeforeEach
    public void setup() {
        userService = mock(UserService.class);
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testList() {
        List<UserDTO> fakeUsers = new ArrayList();
        when(this.userService.findAll()).thenReturn(fakeUsers);
        String viewName = this.userController.list(this.model);
        Assertions.assertEquals("user/list", viewName);
        ((Model)Mockito.verify(this.model, times(1))).addAttribute("users", fakeUsers);
    }
    @Test
    public void testAddForm() {
        UserDTO userDTO = new UserDTO();
        String viewName = this.userController.add(userDTO);
        Assertions.assertEquals("user/add", viewName);
    }
    @Test
    public void testEditFormFailure() {
        Long userId = 1L;
        UserDTO userDTO = new UserDTO();
        when(this.bindingResult.hasErrors()).thenReturn(true);
        String viewName = this.userController.edit(userId, userDTO, this.bindingResult, this.redirectAttributes);
        Assertions.assertEquals("user/edit", viewName);
    }















}