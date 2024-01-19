package giorgiomigliaccio.U5W1L5.repositories;

import giorgiomigliaccio.U5W1L5.entities.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DispositivoDAO extends JpaRepository<Dispositivo, UUID> {
    Optional<Dispositivo> findByTipoDispositivo(String tipoDispositivo);

    boolean existsByTipoDispositivo(String TipoDispositivo);
}