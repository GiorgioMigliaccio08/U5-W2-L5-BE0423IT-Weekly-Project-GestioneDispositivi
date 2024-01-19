package giorgiomigliaccio.U5W1L5.repositories;


import giorgiomigliaccio.U5W1L5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UtenteDAO extends JpaRepository<Utente, UUID> {
    Optional<Utente> findByEmail(String email);

    boolean existsByEmail(String email);
}
