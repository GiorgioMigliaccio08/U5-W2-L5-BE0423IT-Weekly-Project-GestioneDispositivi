package giorgiomigliaccio.U5W1L5.exceptions;

import java.time.LocalDateTime;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, LocalDateTime now) {
    }
}

