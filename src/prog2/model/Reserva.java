package prog2.model;

import java.time.LocalDate;

public class Reserva implements InReserva {
    //Atributs de reserva
    private String id, dni;
    private LocalDate dataEntrada, dataSortida;

    // Constructor
    public Reserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida){
        this.id = id_;
        this.dni = dni_;
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
