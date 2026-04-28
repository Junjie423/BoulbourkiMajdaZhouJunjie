package prog2.model;

import java.util.Date;

public class PrestecLlarg extends Prestec {
    // Atributs

    // Constructor
    public PrestecLlarg(Exemplar exemplar, Usuari usuari, Date dataCre) {
        super(exemplar, usuari, dataCre);
    }
    // Mètodes
    /**
     * Mètode sobreescrit que retorna el tipus de préstec com a LLarg
     *
     * @return "Llarg"
     */
    @Override
    public String tipusPrestec() {
        return "Llarg";
    }

    /**
     * Retornar durada d'un préstec llarg
     *
     */
    @Override
    public long duradaPrestec() {
        return 140000;
    }
}
