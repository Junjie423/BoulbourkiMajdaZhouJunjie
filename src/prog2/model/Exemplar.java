package prog2.model;

/**
 * Autor: Junjie Zhou, Majda Boulbourki
 *
 * (Descripcio)
 */
public class Exemplar implements InExemplar{
    // Atributs
    private String id;
    private String titol;
    private String autor;
    private boolean admetPrestecLlarg;
    private boolean disponible;

    // Constructor
    public Exemplar(String id_, String titol_, String autor_, boolean admetPrestecLlarg_) {
        this.id = id_;
        this.titol = titol_;
        this.autor = autor_;
        this.admetPrestecLlarg = admetPrestecLlarg_;
        this.disponible = true;
    }

    // Mètodes
    /**
     * Estableix l'id de l'exemplar
     * @param id
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retorna l'id de l'exemplar
     *
     * @return l'atribut d'id
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * Estableix el titol de l'exemplar
     * @param titol
     */
    @Override
    public void setTitol(String titol) {
        this.titol = titol;
    }

    /**
     * Retorna el titol de l'exemplar
     *
     * @return l'atribut de titol
     */
    @Override
    public String getTitol() {
        return this.titol;
    }

    /**
     * Estableix l'autor de l'exemplar
     * @param autor
     */
    @Override
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Retorna l'autor de l'exemplar
     *
     * @return l'atribut d'autor
     */
    @Override
    public String getAutor() {
        return this.autor;
    }

    /**
     * Estableix si l'exemplar admet prestec de llarga duració
     * @param admetPrestecLlarg
     */
    @Override
    public void setAdmetPrestecLlarg(boolean admetPrestecLlarg) {
        this.admetPrestecLlarg = admetPrestecLlarg;
    }

    /**
     * Retorna si admet o no prestec de llarga duració
     *
     * @return boolean admetPrestecLlarg
     */
    @Override
    public boolean getAdmetPrestecLlarg() {
        return this.admetPrestecLlarg;
    }

    /**
     * Estableix si està disponible l'exemplar
     * @param disponible
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Retorna si està o no disponible l'exemplar
     *
     * @return boolean disponibilitat
     */
    public boolean isDisponible() {
        return this.disponible;
    }

    /**
     * Mètode toString sobreescrit per mostrar la informació
     *
     * @return Un string amb la informació de l'exemplar
     */
    @Override
    public String toString() {
        String info = "Id=" + this.id + ", Titol=" + this.titol
                + ", Autor=" + this.autor + "Admet Prestec Llarg="
                +  this.admetPrestecLlarg + "Disponible=" +  this.disponible;
        return info;
    }
}
