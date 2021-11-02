package ebucelik.lobbi_backend.repository;

import ebucelik.lobbi_backend.entity.Lobbi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LobbiRepository extends JpaRepository<Lobbi, UUID> {
}
