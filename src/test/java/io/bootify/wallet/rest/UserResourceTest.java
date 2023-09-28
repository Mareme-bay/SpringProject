package io.bootify.wallet.rest;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.bootify.wallet.model.UserDTO;
import io.bootify.wallet.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class UserResourceTest {
    private MockMvc mockMvc;
    private UserService userService;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        userService = Mockito.mock(UserService.class);
        UserResource userResource = new UserResource(userService);
        mockMvc = MockMvcBuilders.standaloneSetup(userResource).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void GetAllUsers() throws Exception {
        List<UserDTO> userList = new ArrayList<>();
        // Ajoutez des utilisateurs fictifs à la liste userList

        when(userService.findAll()).thenReturn(userList);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/users")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(userService).findAll();
    }

    @Test
    public void GetUser() throws Exception {
        Long userId = 1L;
        UserDTO user = new UserDTO();
        // Configurez l'utilisateur fictif avec l'ID userId

        when(userService.get(userId)).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/users/{id}", userId)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(userService).get(userId);
    }
    @Test
    public void testDeleteUser() throws Exception {
        Long userId = 1L;

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/users/{id}", userId)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(userService).delete(userId);
    }

}