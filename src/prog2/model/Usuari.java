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
    private int numPrestecsNormals;
    private int numPrestecsLlargs;

    // Constructor
    public Usuari(String email_, String nom_, String adreca_) {
        this.email = email_;
        this.nom = nom_;
        this.adreca = adreca_;
        this.numPrestecsNormals = 0;
        this.numPrestecsLlargs = 0;
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
     * Retorna l'adreça de l'usuari
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
     * Estableix el nombre de préstecs normals
     * @param numPrestecsNormals
     */
    @Override
    public void setNumPrestecsNormals(int numPrestecsNormals) {
        this.numPrestecsNormals = numPrestecsNormals;
    }

    /**
     * Retorna el nombre de préstecs normals
     *
     * @return nombre de préstecs normals
     */
    @Override
    public int getNumPrestecsNormals() {
        return this.numPrestecsNormals;
    }

    /**
     * Estableix el nombre de préstecs llargs
     * @param numPrestecstLlargs
     */
    @Override
    public void setNumPrestecsLlargs(int numPrestecstLlargs) {
        this.numPrestecsLlargs = numPrestecstLlargs;
    }

    /**
     * Retorna el nombre de préstecs llargs
     *
     * @return nombre de préstecs llargs
     */
    @Override
    public int getNumPrestecsLlargs() {
        return this.numPrestecsLlargs;
    }

    /**
     * @return
     */
    @Override
    public abstract int getMaxPrestecsNormals();

    /**
     * @return
     */
    @Override
    public abstract int getMaxPrestecsLlargs();

    /**
     * Mètode que sobreescriu toString per mostrar informació de l'usuari
     *
     * @return String amb la informació de l'usuari
     */
    @Override
    public String toString(){
        return ("Tipus=" + this.tipusUsuari() + ", Email=" + this.email
                + ", Nom=" + this.nom + ", Adreca=" + this.adreca + ", Num. prestecs normals="
                + this.numPrestecsNormals + ", Num. prestecs llargs=" + this.numPrestecsLlargs);
    }
}
