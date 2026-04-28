package prog2.model;

import java.util.Date;

public class PrestecNormal extends Prestec {
    // Atributs

    // Constructor
    public PrestecNormal(Exemplar exemplar, Usuari usuari, Date dataCre) {
        super(exemplar, usuari, dataCre);
    }
    // Mètodes
    /**
     * Mètode sobreescrit que retorna el tipus de préstec com a Normal
     *
     * @return "Normal"
     */
    @Override
    public String tipusPrestec() {
        return "Normal";
    }

    /**
     * Retornar durada d'un préstec llarg
     *
     */
    @Override
    public long duradaPrestec() {
        return 70000;
    }
}
