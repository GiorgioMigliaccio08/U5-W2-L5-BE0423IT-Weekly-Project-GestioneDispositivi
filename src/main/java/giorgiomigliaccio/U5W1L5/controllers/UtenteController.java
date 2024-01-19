package giorgiomigliaccio.U5W1L5.controllers;

import giorgiomigliaccio.U5W1L5.entities.Utente;
import giorgiomigliaccio.U5W1L5.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/utenti")
public class UtenteController {
    @Autowired
    private UtenteService utenteService;
    private Object usersService;

    @GetMapping
    public Page<Utente> getUsers(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 @RequestParam(defaultValue = "id") String orderBy) {
        return utenteService.getUtenti(page, size, orderBy);
    }

    @GetMapping("/{utenteId}")
    public Utente getUserById(@PathVariable UUID utenteId) {
        return utenteService.findById(utenteId);
    }

    @PutMapping("/{utenteId}")
    public Utente updateUserById(@PathVariable UUID utenteId, @RequestBody Utente modifiedUtentePayload) {
        return utenteService.updateById(utenteId, modifiedUtentePayload);
    }

    @DeleteMapping("/{utenteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable UUID utenteId) {
        utenteService.deleteById(utenteId);
    }

    //UPLOAD DELL'IMMAGINE
   // @PostMapping("/{userId}/upload")
  //  public String uploadAvatar(@RequestParam("ImgUtente") MultipartFile file, @PathVariable UUID userId) throws IOException, InterruptedException {

 //return UtenteService.uploadPicture(file);
   // }
}