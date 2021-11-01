package ebucelik.lobbi_backend.repository;

import ebucelik.lobbi_backend.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

}
