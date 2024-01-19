package giorgiomigliaccio.U5W1L5.repositories;

import giorgiomigliaccio.U5W1L5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {



    Optional<Utente> findByUsername(String username);
        List<Utente> findByNomeAndCognome(String nome, String cognome);

    }

