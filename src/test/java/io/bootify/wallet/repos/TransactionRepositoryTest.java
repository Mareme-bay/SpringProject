package io.bootify.wallet.repos;

import static org.junit.jupiter.api.Assertions.*;
import io.bootify.wallet.domain.Account;
import io.bootify.wallet.domain.Transaction;
import io.bootify.wallet.repos.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.OffsetDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
class TransactionRepositoryTest {
    @Autowired
    private TransactionRepository transactionRepository;

    @MockBean
    private TransactionRepository mockTransactionRepository;





    @Test
    void findFirstByAccount() {

    }

}