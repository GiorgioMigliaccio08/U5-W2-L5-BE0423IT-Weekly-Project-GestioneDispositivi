package giorgiomigliaccio.U5W1L5.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandler {
    // RISPOSTA 400
    @org.springframework.web.bind.annotation.ExceptionHandler(org.apache.coyote.BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BadRequestException handleBadRequest(org.apache.coyote.BadRequestException ex) {
        return new BadRequestException(ex.getMessage(), LocalDateTime.now());
    }
    // RISPOSTA 404
    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BadRequestException handleNotFound(NotFoundException ex) {
        return new BadRequestException(ex.getMessage(), LocalDateTime.now());
    }
// RISPOSTA 500
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BadRequestException handleGenericError(Exception ex) {
        ex.printStackTrace();
        return new BadRequestException("Problema lato server! Stiamo risolvendo il problema!", LocalDateTime.now());
    }
}
