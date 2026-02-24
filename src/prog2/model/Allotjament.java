package prog2.model;

public class Allotjament implements InAllotjament{

    /**
     * Obté el nom de l'allotjament.
     *
     * @return el nom de l'allotjament.
     */
    @Override
    public String getNom() {
        return "";
    }

    /**
     * Estableix el nom de l'allotjament.
     *
     * @param nom el nom a assignar.
     */
    @Override
    public void setNom(String nom) {

    }

    /**
     * Obté l'identificador únic de l'allotjament.
     *
     * @return l'identificador únic de l'allotjament.
     */
    @Override
    public String getId() {
        return "";
    }

    /**
     * Estableix l'identificador únic de l'allotjament.
     *
     * @param id l'identificador a assignar.
     */
    @Override
    public void setId(String id) {

    }

    /**
     * Obté l'estada mínima segons la temporada.
     *
     * @param temp la temporada (ALTA o BAIXA).
     * @return el valor de l'estada mínima per a la temporada indicada.
     */
    @Override
    public long getEstadaMinima(Temp temp) {
        return 0;
    }

    /**
     * Estableix l'estada mínima per a cada temporada.
     *
     * @param estadaMinimaALTA_  l'estada mínima en temporada alta.
     * @param estadaMinimaBAIXA_ l'estada mínima en temporada baixa.
     */
    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {

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
