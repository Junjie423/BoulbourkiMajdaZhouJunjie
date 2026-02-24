package prog2.model;

public class Client implements InClient {
    private String nom;
    private String dni;
    public Client(String nom, String dni){
        this.nom = nom;
        this.dni = dni;
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public String getDni() {
        return this.dni;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public void setDni(String dni) {
        this.dni = dni;
    }
}
