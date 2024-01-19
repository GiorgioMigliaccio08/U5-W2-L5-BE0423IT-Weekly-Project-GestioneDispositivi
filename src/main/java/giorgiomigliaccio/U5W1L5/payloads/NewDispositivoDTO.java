package giorgiomigliaccio.U5W1L5.payloads;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewDispositivoDTO(
        @NotEmpty(message = "La marca del dispositivo è un campo obbligatorio!")
        @Size(min = 3, max = 30, message = "La marca deve essere compreso tra 3 e 30 caratteri!")
        String marca,
        @NotEmpty(message = "Il Tipo dispositivo è un campo obbligatorio!")
        @Size(min = 3, max = 30, message = "Il Tipo dispositivo deve essere compreso tra 3 e 30 caratteri!")
        String Tipodispositivo,

        @NotEmpty(message = "Lo Stato dispositivo è un campo obbligatorio!")
        @Size(min = 4, message = "Lo Stato dispositivo deve avere minimo 4 caratteri!")
        String Statodispositivo) {
}