package io.bootify.wallet.service;

import io.bootify.wallet.domain.User;
import io.bootify.wallet.model.UserDTO;
import io.bootify.wallet.repos.AccountRepository;
import io.bootify.wallet.repos.UserRepository;
import io.bootify.wallet.util.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void testFindAllUsers() {
        // Créez une liste factice d'utilisateurs
        List<User> userList = new ArrayList<>();
        userList.add(new User());
        userList.add(new User());

        // Configurez le comportement de mock pour la méthode findAll
        when(userRepository.findAll(Sort.by("id"))).thenReturn(userList);

        // Appelez la méthode findAll de UserService
        List<UserDTO> userDTOList = userService.findAll();

        // Vérifiez que la liste retournée n'est pas vide
        assertFalse(userDTOList.isEmpty());
        // Vérifiez que la taille de la liste retournée correspond à celle de la liste factice
        assertEquals(userList.size(), userDTOList.size());
    }
@Test
    void testGetUserById() {
        // Créez un utilisateur factice
        User user = new User();
        user.setId(1L);
        user.setNom("ppp");
        user.setPrenom("tttt");

        // Configurez le comportement de mock pour la méthode findById
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        // Appelez la méthode get de UserService
        UserDTO userDTO = userService.get(1L);

        // Vérifiez que l'objet UserDTO retourné correspond à l'utilisateur factice
        assertEquals(user.getId(), userDTO.getId());
        assertEquals(user.getNom(), userDTO.getNom());
        assertEquals(user.getPrenom(), userDTO.getPrenom());
    }

    @Test
    void testGetUserByIdNotFound() {
        // Configurez le comportement de mock pour la méthode findById
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        // Appelez la méthode get de UserService et vérifiez qu'elle lance NotFoundException
        assertThrows(NotFoundException.class, () -> userService.get(1L));
    }


}










