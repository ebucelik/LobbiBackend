package ebucelik.lobbi_backend.controller;

import ebucelik.lobbi_backend.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ebucelik.lobbi_backend.repository.AccountRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/account")
    public List<Account> getAllEmployees() {
        return accountRepository.findAll();
    }

    @PostMapping("/account")
    public Account createAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    @PutMapping("/account")
    public Account updateAccount(@RequestBody Account account) {
        Account storedAccount = accountRepository.findById(account.getId())
                .orElseThrow();

        storedAccount.setUsername(account.getUsername());
        storedAccount.setPassword(account.getPassword());
        storedAccount.setName(account.getName());
        storedAccount.setLastname(account.getLastname());
        storedAccount.setAge(account.getAge());
        storedAccount.setImage(account.getImage());
        storedAccount.setBio(account.getBio());

        return accountRepository.save(storedAccount);
    }

    @GetMapping("/login")
    public Account login(@RequestParam String username, @RequestParam String password) {
        return accountRepository.findAll()
                .stream()
                .filter(acc -> acc.getUsername().equals(username) && acc.getPassword().equals(password))
                .findFirst()
                .get();
    }
}
