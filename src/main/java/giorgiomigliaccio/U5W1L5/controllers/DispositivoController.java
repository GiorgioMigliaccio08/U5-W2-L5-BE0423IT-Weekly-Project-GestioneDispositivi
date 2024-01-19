package giorgiomigliaccio.U5W1L5.controllers;

import giorgiomigliaccio.U5W1L5.entities.Dispositivo;
import giorgiomigliaccio.U5W1L5.services.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dispositivi")
public class DispositivoController {

    private final DispositivoService dispositivoService;

    @Autowired
    public DispositivoController(DispositivoService dispositivoService) {
        this.dispositivoService = dispositivoService;
    }

    @GetMapping
    public List<Dispositivo> getDispositivi() {
        return dispositivoService.getAllDispositivi();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dispositivo> getDispositivoById(@PathVariable Long id) {
        Optional<Dispositivo> dispositivo = dispositivoService.getDispositivoById(id);
        return dispositivo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Dispositivo> createDispositivo(@RequestBody Dispositivo dispositivo) {
        Dispositivo savedDispositivo = dispositivoService.saveDispositivo(dispositivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDispositivo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dispositivo> updateDispositivo(@PathVariable Long id, @RequestBody Dispositivo updatedDispositivo) {
        Optional<Dispositivo> dispositivo = dispositivoService.updateDispositivo(id, updatedDispositivo);
        return dispositivo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDispositivo(@PathVariable Long id) {
        dispositivoService.deleteDispositivo(id);
        return ResponseEntity.noContent().build();
    }
}
