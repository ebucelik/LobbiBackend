package ebucelik.lobbi_backend.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "lobbi")
public class Lobbi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    public enum LobbiStatus {
        created, searching, aborted
    }

    public Lobbi() { }

    public Lobbi(UUID id, String name, LobbiStatus status) {
        this.id = id;
        this.name = name;
        this.status = status.name();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
