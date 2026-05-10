package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.Date;

/**
 * Autor: Junjie Zhou, Majda Boulbourki
 *
 * La classe Prestec és una classe abstracta que guarda un tipus de prestec
 * que pot ser llarg o normal. Els objectes de tipus prestec tenen guardat un objecte
 * exemplar i un objecte usuari.
 */
public abstract class Prestec implements InPrestec, Serializable {
    // Atributs
    private Usuari usuari;
    private Exemplar exemplar;
    private Date dataCre;
    private Date dataLim;
    private boolean retornat;

    // Constructor
    public Prestec(Exemplar exemplar, Usuari usuari, Date dataCre) {
        this.exemplar = exemplar;
        this.usuari = usuari;
        this.dataCre = dataCre;
        this.dataLim = new Date(dataCre.getTime()+duradaPrestec());
        this.retornat = false;
    }

    // Mètodes
    /**
     * Estableix l'exemplar del préstec
     * @param exemplar
     */
    @Override
    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    /**
     * Retorna l'exemplar del préstec
     *
     * @return Exemplar
     */
    @Override
    public Exemplar getExemplar() {
        return this.exemplar;
    }

    /**
     * Estableix l'usuari del préstec
     * @param usuari
     */
    @Override
    public void setUsuari(Usuari usuari) {
    this.usuari = usuari;
    }

    /**
     * Retorna l'usuari del préstec
     *
     * @return Usuari
     */
    @Override
    public Usuari getUsuari() {
        return this.usuari;
    }

    /**
     * Estableix la data de creació del préstec
     * @param data
     */
    @Override
    public void setDataCreacio(Date data) {
        this.dataCre = data;
    }

    /**
     * Retorna la data de creació del préstec
     *
     * @return Date de creació
     */
    @Override
    public Date getDataCreacio() {
        return this.dataCre;
    }

    /**
     * Estableix la data de límit de retorn del préstec
     * @param data
     */
    @Override
    public void setDataLimitRetorn(Date data) {
        this.dataLim = data;
    }

    /**
     * Retorna la data de límit de retorn
     *
     * @return Date límit per retornar el préstec
     */
    @Override
    public Date getDataLimitRetorn() {
        return this.dataLim;
    }

    /**
     * Mètode abstracte que retorna el tipus de préstec
     *
     * @return "Llarg" o "Normal"
     */
    @Override
    public abstract String tipusPrestec();

    /**
     * Estableix si està o no l'exemplar retornat
     * @param retornat
     */
    @Override
    public void setRetornat(boolean retornat) {
        this.retornat = retornat;
    }

    /**
     * Retorna si l'exemplar està o no retornat
     *
     * @return boolean retornat
     */
    @Override
    public boolean getRetornat() {
        return this.retornat;
    }

    /**
     * Retornar prestec. Llança excepció si el prestec ja es va retornar
     */
    @Override
    public void retorna() {
        if (this.retornat) {
            throw new BiblioException("El préstec ja es va retornar");
        }
        if(tipusPrestec().equals("Llarg"))
            usuari.setNumPrestecsLlargs(usuari.getNumPrestecsLlargs()-1);
        else
            usuari.setNumPrestecsNormals(usuari.getNumPrestecsNormals()-1);
        this.retornat = true;
        exemplar.setDisponible(true);
    }

    /**
     * Retornar durada prestec. La durada del prestec depen del tipus de prestec
     */
    @Override
    public abstract long duradaPrestec();

    /**
     * Retornar true si el prestec està endarrerit per a la data actual
     */
    @Override
    public boolean prestecEndarrerit() {
        if ((!this.retornat) && this.dataLim.before(new Date())){
            return true;
        }
        return false;
    }

    /**
     * Mètode sobreescrit per mostrar informació del préstec
     *
     * @return String amb la informació del préstec
     */
    @Override
    public String toString(){
        return ("Tipus=" + this.tipusPrestec() + ", Exemplar=" + this.exemplar.getTitol()
                + ", Usuari=" + this.usuari.getNom() + ", Data de creació=" + this.dataCre
                + ", Data límit retorn=" + this.dataLim + ", Retornat=" + this.retornat);
    }
}
