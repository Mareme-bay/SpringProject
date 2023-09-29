package io.bootify.wallet.controller;

import static org.junit.jupiter.api.Assertions.*;
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
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
@ExtendWith(MockitoExtension.class)
@WebMvcTest(TransactionController.class)
class TransactionControllerTest {
    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private TransactionController transactionController;
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private Model model;

    @Mock
    private BindingResult bindingResult;

    @Mock
    private RedirectAttributes redirectAttributes;

    @BeforeEach
    public void setup() {

        MockitoAnnotations.openMocks(this);

    }



}