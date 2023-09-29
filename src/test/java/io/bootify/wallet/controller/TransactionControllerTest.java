package io.bootify.wallet.controller;
import io.bootify.wallet.WalletApplication;
import io.bootify.wallet.controller.TransactionController;
import io.bootify.wallet.model.TransactionDTO;
import io.bootify.wallet.service.TransactionService;
import io.bootify.wallet.util.WebUtils;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static io.cucumber.messages.internal.com.google.gson.reflect.TypeToken.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransactionController.class)
@ExtendWith(MockitoExtension.class)

public class TransactionControllerTest {
    @Mock
    private TransactionService transactionService;
    @Mock
    private Model model;
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private BindingResult bindingResult;
    @Mock
    private RedirectAttributes redirectAttributes;
    @InjectMocks
    private TransactionController transactionController;

    public TransactionControllerTest() {
    }

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


}

