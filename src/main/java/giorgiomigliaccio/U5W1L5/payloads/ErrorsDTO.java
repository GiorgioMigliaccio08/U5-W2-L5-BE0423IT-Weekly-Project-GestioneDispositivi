package giorgiomigliaccio.U5W1L5.payloads;

import java.time.LocalDateTime;

public record ErrorsDTO(String message, LocalDateTime timestamp) {
}