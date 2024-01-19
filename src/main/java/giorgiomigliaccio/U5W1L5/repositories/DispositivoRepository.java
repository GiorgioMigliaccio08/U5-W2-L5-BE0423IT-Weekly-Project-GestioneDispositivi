package giorgiomigliaccio.U5W1L5.repositories;

import giorgiomigliaccio.U5W1L5.entities.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
    List<Dispositivo> findByTipo(String tipo);
    List<Dispositivo> findByStato(String stato)

}