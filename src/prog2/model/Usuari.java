package prog2.model;

/**
 * Autor: Junjie Zhou, Majda Boulbourki
 *
 * (Descripcio)
 */
public abstract class Usuari implements InUsuari {
    // Atributs
    private String email;
    private String nom;
    private String adreca;

    // Constructor
    public Usuari(String email_, String nom_, String adreca_) {
        this.email = email_;
        this.nom = nom_;
        this.adreca = adreca_;
    }

    // Mètodes
    /**
     * Configura el correu de l'usuari
     * @param email
     */
    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna el correu de l'usuari
     *
     * @return String email
     */
    @Override
    public String getEmail() {
        return this.email;
    }

    /**
     * Configura el nom de l'usuari
     * @param nom
     */
    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retorna el nom de l'usuari
     *
     * @return String nom
     */
    @Override
    public String getNom() {
        return this.nom;
    }

    /**
     * Configura l'adreça de l'usuari
     * @param adreca
     */
    @Override
    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    /**
     * Retorna l'adreça de l'usari
     *
     * @return String adreça
     */
    @Override
    public String getAdreca() {
        return this.adreca;
    }

    /**
     * Mètode abstracte que retorna el tipus d'usuari
     *
     * @return String tipus usuari (cada fill retorna el seu tipus)
     */
    @Override
    public abstract String tipusUsuari();

    /**
     * @param numPrestecsNormals
     */
    @Override
    public void setNumPrestecsNormals(int numPrestecsNormals) {

    }

    /**
     * @return
     */
    @Override
    public int getNumPrestecsNormals() {
        return 0;
    }

    /**
     * @param numPrestecstLlargs
     */
    @Override
    public void setNumPrestecsLlargs(int numPrestecstLlargs) {

    }

    /**
     * @return
     */
    @Override
    public int getNumPrestecsLlargs() {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public int getMaxPrestecsNormals() {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public int getMaxPrestecsLlargs() {
        return 0;
    }
}
