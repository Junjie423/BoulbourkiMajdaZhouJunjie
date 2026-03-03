package prog2.model;

public class Allotjament implements InAllotjament{
    // Atributs de la classe Allotjament
    private String nom_;
    private String id_;
    private long estadaMinimaAlta;
    private long estadaMinimaBaixa;
    private Temp temporada;

    // Constructor
    public Allotjament(String nom, String id){
        this.nom_ = nom;
        this.id_ = id;
    }

    // Mètodes de la classe Allotjament
    /**
     * Obté el nom de l'allotjament.
     *
     * @return el nom de l'allotjament.
     */
    @Override
    public String getNom() {
        return this.nom_;
    }

    /**
     * Estableix el nom de l'allotjament.
     *
     * @param nom el nom a assignar.
     */
    @Override
    public void setNom(String nom) {
        this.nom_ = nom;
    }

    /**
     * Obté l'identificador únic de l'allotjament.
     *
     * @return l'identificador únic de l'allotjament.
     */
    @Override
    public String getId() {
        return this.id_;
    }

    /**
     * Estableix l'identificador únic de l'allotjament.
     *
     * @param id l'identificador a assignar.
     */
    @Override
    public void setId(String id) {
        this.id_ = id;
    }

    /**
     * Obté l'estada mínima segons la temporada.
     *
     * @param temp la temporada (ALTA o BAIXA).
     * @return el valor de l'estada mínima per a la temporada indicada.
     */
    @Override
    public long getEstadaMinima(Temp temp) {
        long tmp = 0;
        switch(temp){
            case ALTA:
                tmp = this.estadaMinimaAlta;
                break;
            case BAIXA:
                tmp = this.estadaMinimaBaixa;
                break;
        }
        return tmp;
    }

    /**
     * Estableix l'estada mínima per a cada temporada.
     *
     * @param estadaMinimaALTA_  l'estada mínima en temporada alta.
     * @param estadaMinimaBAIXA_ l'estada mínima en temporada baixa.
     */
    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estadaMinimaAlta = estadaMinimaALTA_;
        this.estadaMinimaBaixa = estadaMinimaBAIXA_;
    }

    /**
     * Comprova si l'allotjament funciona correctament.
     * La implementació dependrà dels criteris específics de cada tipus d'allotjament.
     *
     * @return true si l'allotjament funciona correctament, false altrament.
     */
    @Override
    public boolean correcteFuncionament() {
        return false;
    }
}
