package io.bootify.wallet.repos;

import static org.junit.jupiter.api.Assertions.*;
import io.bootify.wallet.domain.Account;
import io.bootify.wallet.repos.AccountRepository;
import io.bootify.wallet.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class AccountRepositoryTest {
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() {
        // Créez un exemple d'objet Account
        Account sampleAccount = new Account();
        sampleAccount.setId(1L);
        sampleAccount.setSolde("1000.00");

        // Définissez le comportement attendu lorsque findById est appelé
        when(accountRepository.findById(1L)).thenReturn(Optional.of(sampleAccount));

        // Appelez la méthode à tester
        Optional<Account> result = accountRepository.findById(1L);

        // Vérifiez que le résultat est conforme aux attentes
        assertEquals(sampleAccount, result.orElse(null));
    }

}