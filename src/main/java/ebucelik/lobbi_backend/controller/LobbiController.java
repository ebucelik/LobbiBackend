package ebucelik.lobbi_backend.controller;

import ebucelik.lobbi_backend.entity.Account;
import ebucelik.lobbi_backend.entity.Lobbi;
import ebucelik.lobbi_backend.repository.LobbiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class LobbiController {

    @Autowired
    private LobbiRepository lobbiRepository;

    @GetMapping("/lobbi")
    public List<Lobbi> getAllLobbis() {
        return lobbiRepository.findAll();
    }

    @PostMapping("/lobbi")
    public Lobbi joinLobbi(@RequestParam String username) {
        Random random = new Random();
        return lobbiRepository.save(new Lobbi(UUID.randomUUID(), username+"Lobbi", lobbiStatus(random.nextInt(3))));
    }

    private Lobbi.LobbiStatus lobbiStatus(int randomNum) {
        switch (randomNum) {
            case 0:
                return Lobbi.LobbiStatus.created;

            case 2:
                return Lobbi.LobbiStatus.aborted;

            default:
                return Lobbi.LobbiStatus.searching;
        }
    }
}
