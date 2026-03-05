package prog2.model;

import java.time.LocalDate;

public class Reserva implements InReserva {
    // Atributs de reserva
    private Allotjament allotjament;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;
    // Constructor
    public Reserva(Allotjament allotjament_, Client client_, LocalDate dataEntrada, LocalDate dataSortida){
        this.allotjament = allotjament_;
        this.client = client_;
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;
    }

    @Override
    public Allotjament getAllotjament_() {
        return null;
    }

    @Override
    public Client getClient() {
        return null;
    }

    @Override
    public LocalDate getDataEntrada() {
        return null;
    }

    @Override
    public LocalDate getDataSortida() {
        return null;
    }

    @Override
    public void setAllotjament_(Allotjament allotjament_) {

    }

    @Override
    public void setClient(Client client_) {

    }

    @Override
    public void setDataEntrada(LocalDate dataEntrada_) {

    }

    @Override
    public void setDataSortida(LocalDate dataSortida_) {

    }
}
