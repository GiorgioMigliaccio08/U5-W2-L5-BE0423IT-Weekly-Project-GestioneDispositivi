package giorgiomigliaccio.U5W1L5.services;

import giorgiomigliaccio.U5W1L5.entities.Dispositivo;
import giorgiomigliaccio.U5W1L5.repositories.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DispositivoService {

    private final DispositivoRepository dispositivoRepository;

    @Autowired
    public DispositivoService(DispositivoRepository dispositivoRepository) {
        this.dispositivoRepository = dispositivoRepository;
    }

    public List<Dispositivo> getAllDispositivi() {
        return dispositivoRepository.findAll();
    }

    public Optional<Dispositivo> getDispositivoById(Long id) {
        return dispositivoRepository.findById(id);
    }

    public Dispositivo saveDispositivo(Dispositivo dispositivo) {
        return dispositivoRepository.save(dispositivo);
    }

    public Optional<Dispositivo> updateDispositivo(Long id, Dispositivo updatedDispositivo) {
        Optional<Dispositivo> existingDispositivo = dispositivoRepository.findById(id);
        if (existingDispositivo.isPresent()) {
            Dispositivo dispositivo = existingDispositivo.get();
            dispositivo.setTipoDispositivo(updatedDispositivo.getTipo());
            dispositivo.setStatoDispositivo(updatedDispositivo.getStato());
            return Optional.of(dispositivoRepository.save(dispositivo));
        } else {
            return Optional.empty();
        }
    }

    public void deleteDispositivo(Long id) {
        dispositivoRepository.deleteById(id);
    }
}