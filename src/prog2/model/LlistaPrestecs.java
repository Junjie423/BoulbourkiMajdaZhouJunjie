package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.Iterator;

public class LlistaPrestecs extends Llista<Prestec> implements Serializable {
    // Atributs

    // Constructor
    public LlistaPrestecs(){
        super();
    }
    // Mètodes

    /**
     * Afegir element a la llista. Afegeix l'element e a la llista
     *
     * @param p
     */
    @Override
    public void afegir(Prestec p) throws BiblioException {
        Iterator<Prestec> it = llista.iterator();
        Prestec prest = it.
    }

    /**
     * Esborrar element de la llista. Esborra l'element e a la llista
     *
     * @param p
     */
    @Override
    public void esborrar(Prestec p) {

    }
}
