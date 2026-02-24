package prog2.model;

import java.util.ArrayList;

public class Camping implements InCamping {
    private String nom;
    private ArrayList<Allotjament> allojament;
    private ArrayList<Client> clients;
    private ArrayList<Reserva> reserves;
    public Camping(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }
    public LlistaReserves getLlistaReserves() {
        return reserves;
    }
}

