package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;

public class LlistaReserves implements InLlistaReserves{
    // Atributs de LlistaReserves
    private ArrayList<Reserva> reserves_;

    // Constructor
    public LlistaReserves(){
        this.reserves_ = new ArrayList<>();
    }

    // Mètodes de LlistaReserves
    /**
     * Comprova que l'estada que es demani sigui més llarga o igual que l'estada mínima.
     * Comprova que l'allotjament estigui disponible pels dies indicats.
     * En cas afirmatiu, crea la reserva i l’afegeix a la llista de reserves del camping.
     * En cas negatiu, llança una excepció de tipus ExceptionReserva amb el missatge d'error.
     *
     * @param allotjament
     * @param client
     * @param dataEntrada
     * @param dataSortida
     * @throws ExcepcioReserva
     */
    @Override
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        Reserva nouReserva = new Reserva(allotjament, client, dataEntrada, dataSortida);

    }

    /**
     * Retorna el número de reserves de la llista.
     *
     * @return el número de reserves.
     */
    @Override
    public int getNumReserves() {
        return this.reserves_.size();
    }
}
