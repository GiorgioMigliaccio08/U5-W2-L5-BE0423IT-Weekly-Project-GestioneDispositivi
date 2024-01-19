package giorgiomigliaccio.U5W1L5.exceptions;


import java.util.UUID;
public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("Utente con id " + id + " non trovato!");
    }
}
