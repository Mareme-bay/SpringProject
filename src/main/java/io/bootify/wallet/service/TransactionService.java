package io.bootify.wallet.service;

import io.bootify.wallet.domain.Account;
import io.bootify.wallet.domain.Transaction;
import io.bootify.wallet.model.TransactionDTO;
import io.bootify.wallet.repos.AccountRepository;
import io.bootify.wallet.repos.TransactionRepository;
import io.bootify.wallet.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionService(final TransactionRepository transactionRepository,
            final AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    public List<TransactionDTO> findAll() {
        final List<Transaction> transactions = transactionRepository.findAll(Sort.by("id"));
        return transactions.stream()
                .map(transaction -> mapToDTO(transaction, new TransactionDTO()))
                .toList();
    }

    public TransactionDTO get(final Long id) {
        return transactionRepository.findById(id)
                .map(transaction -> mapToDTO(transaction, new TransactionDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final TransactionDTO transactionDTO) {
        final Transaction transaction = new Transaction();
        mapToEntity(transactionDTO, transaction);
        return transactionRepository.save(transaction).getId();
    }

    public void update(final Long id, final TransactionDTO transactionDTO) {
        final Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(transactionDTO, transaction);
        transactionRepository.save(transaction);
    }

    public void delete(final Long id) {
        transactionRepository.deleteById(id);
    }

    private TransactionDTO mapToDTO(final Transaction transaction,
            final TransactionDTO transactionDTO) {
        transactionDTO.setId(transaction.getId());
        transactionDTO.setHeuretrans(transaction.getHeuretrans());
        transactionDTO.setMontant(transaction.getMontant());
        transactionDTO.setCptSource(transaction.getCptSource());
        transactionDTO.setCptDest(transaction.getCptDest());
        transactionDTO.setType(transaction.getType());
        transactionDTO.setAccount(transaction.getAccount() == null ? null : transaction.getAccount().getId());
        return transactionDTO;
    }

    private Transaction mapToEntity(final TransactionDTO transactionDTO,
            final Transaction transaction) {
        transaction.setHeuretrans(transactionDTO.getHeuretrans());
        transaction.setMontant(transactionDTO.getMontant());
        transaction.setCptSource(transactionDTO.getCptSource());
        transaction.setCptDest(transactionDTO.getCptDest());
        transaction.setType(transactionDTO.getType());
        final Account account = transactionDTO.getAccount() == null ? null : accountRepository.findById(transactionDTO.getAccount())
                .orElseThrow(() -> new NotFoundException("account not found"));
        transaction.setAccount(account);
        return transaction;
    }

}
