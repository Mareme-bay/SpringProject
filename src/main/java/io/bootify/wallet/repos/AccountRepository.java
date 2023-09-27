package io.bootify.wallet.repos;

import io.bootify.wallet.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findById(long id);
}
