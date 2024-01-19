package giorgiomigliaccio.U5W1L5.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Table(name = "dispositivi")
@NoArgsConstructor
public class Dispositivo {
    @Id
    @GeneratedValue
    private UUID id;
    private String marca;
    @Enumerated(EnumType.STRING)
    private Tipo tipoDispositivo;
    @Enumerated(EnumType.STRING)
    private Stato statoDispositivo;

    //CREO LA RELAZIONE CON LE ALTRE CLASSI:
    @ManyToOne
    private Utente utente;
    private Tipo tipo;
    private Stato stato;

    //GETTER AND SETTER
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Tipo getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(Tipo tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    public Stato getStatoDispositivo() {
        return statoDispositivo;
    }

    public void setStatoDispositivo(Stato statoDispositivo) {
        this.statoDispositivo = statoDispositivo;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
//CONSTRUCTOR
    public Dispositivo(String marca, Tipo tipoDispositivo, Stato statoDispositivo, Utente utente) {
        this.marca = marca;
        this.tipoDispositivo = tipoDispositivo;
        this.statoDispositivo = statoDispositivo;
        this.utente = utente;
    }
//TOSTRING
    @Override
    public String toString() {
        return "Dispositivo{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", tipoDispositivo=" + tipoDispositivo +
                ", statoDispositivo=" + statoDispositivo +
                ", utente=" + utente +
                '}';
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }
}