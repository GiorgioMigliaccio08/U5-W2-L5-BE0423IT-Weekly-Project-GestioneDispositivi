package giorgiomigliaccio.U5W1L5.controllers;


import giorgiomigliaccio.U5W1L5.entities.Utente;
import giorgiomigliaccio.U5W1L5.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/utenti")
public class UtenteController {
    @Autowired
    private UtenteService usersService;
    private Object utenteService;


    @GetMapping
    public Page<Utente> getUsers(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 @RequestParam(defaultValue = "id") String orderBy) {
        return UtenteService.getUtente(page, size, orderBy);
    }

    @GetMapping("/{userId}")
    public Utente getUserById(@PathVariable UUID userId) {
        return usersService.findById(utenteId);
    }

    @PutMapping("/{utenteId}")
    public Utente getUserByIdAndUpdate(@PathVariable UUID utenteId, @RequestBody Utente modifiedUserPayload) {
        return utenteService.findByIdAndUpdate(utenteId, modifiedUtentePayload);
    }

    @DeleteMapping("/{utenteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getUtenteByIdAndDelete(@PathVariable UUID utenteId) {
        utenteService.findByIdAndDelete(utenteId);
    }


}
