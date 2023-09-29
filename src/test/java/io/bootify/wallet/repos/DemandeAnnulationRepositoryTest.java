package io.bootify.wallet.repos;

import io.bootify.wallet.service.DemandeAnnulationService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import io.bootify.wallet.domain.Account;
import io.bootify.wallet.domain.DemandeAnnulation;
import io.bootify.wallet.repos.DemandeAnnulationRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@SpringBootTest
class DemandeAnnulationRepositoryTest {
    @Mock
    private DemandeAnnulationRepository demandeAnnulationRepository;

    @InjectMocks
    private DemandeAnnulationService demandeAnnulationService;

    @Test
    void findFirstByAccount() {

    }
}