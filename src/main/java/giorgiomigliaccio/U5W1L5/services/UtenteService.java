package giorgiomigliaccio.U5W1L5.services;


import giorgiomigliaccio.U5W1L5.entities.Utente;
import giorgiomigliaccio.U5W1L5.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    private final UtenteRepository utenteRepository;

    @Autowired
    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public int getUtente(int page, int size, String orderBy) {
        return page;
    }


    public List<Utente> getAllUtenti() {
        return utenteRepository.findAll();
    }

    public Optional<Utente> getUtenteById(Long id) {
        return utenteRepository.findById(id);
    }

    public Utente saveUtente(Utente utente) {
        return Utente.save(utente);
    }

    public Optional<Utente> updateUtente(Long id, Utente updatedUtente) {
        Optional<Utente> existingUtente = utenteRepository.findById(id);
        if (existingUtente.isPresent()) {
            Utente utente = existingUtente.get();
            utente.setUsername(updatedUtente.getUsername());
            utente.setNome(updatedUtente.getNome());
            utente.setCognome(updatedUtente.getCognome());
            utente.setEmail(updatedUtente.getEmail());
            return Optional.of(utenteRepository.save(utente));
        } else {
            return Optional.empty();
        }
    }

    public void deleteUtente(Long id) {
        utenteRepository.deleteById(id);
    }
}