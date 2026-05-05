package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.Iterator;

public class LlistaPrestecs extends Llista<Prestec> implements Serializable {

    // Mètodes

    /**
     * Afegir element a la llista. Afegeix l'element e a la llista
     *
     * @param p
     */
    @Override
    public void afegir(Prestec p) throws BiblioException {
        this.llista.add(p);
    }

    /**
     * Esborrar element de la llista. Esborra l'element e a la llista
     *
     * @param p
     */
    @Override
    public void esborrar(Prestec p) throws BiblioException{
        this.llista.remove(p);
    }
}
