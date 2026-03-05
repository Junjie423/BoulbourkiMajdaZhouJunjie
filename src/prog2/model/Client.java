package prog2.model;

public class Client implements InClient {
    // Atributs de Client
    private String nom;
    private String dni;

    // Constructor
    public Client(String nom, String dni){
        this.nom = nom;
        this.dni = dni;
    }

    // Mètodes de Client
    /**
     * Obté el nom del client.
     *
     * @return nom del client.
     */
    @Override
    public String getNom() {
        return this.nom;
    }

    /**
     * Obté el DNI del client.
     *
     * @return DNI del client.
     */
    @Override
    public String getDni() {
        return this.dni;
    }

    /**
     * Estableix el nom del client
     * @param nom del client.
     *
     */
    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Estableix el DNI del client
     * @param dni del client.
     *
     */
    @Override
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Dona la informació del nom i dni del client
     *
     * @return nom i dni del client
     */
    @Override
    public String toString(){
        String info = "";
        info = this.nom + " amb DNI: "+ this.dni + ". ";
        return info;
    }
}
