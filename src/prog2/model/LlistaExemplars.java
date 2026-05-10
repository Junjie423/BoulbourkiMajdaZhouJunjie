package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Autor: Junjie Zhou, Majda Boulbourki
 *
 * Subclasse de llista que guarda objectes de tipus Exemplar.
 * Permet afegir i esborrar elements a la llista.
 */
public class LlistaExemplars extends Llista<Exemplar> implements Serializable {
    // Constructor
    public LlistaExemplars() {
        super();
    }

    // Mètodes
    /**
     * Afegir element a la llista. Afegeix l'element e a la llista
     *
     * @param e
     */
    @Override
    public void afegir(Exemplar e) throws BiblioException {
        Iterator<Exemplar> it = llista.iterator();
        Exemplar exe;
        while (it.hasNext()) {
            exe = it.next();
            if (exe.getId().equals(e.getId())) {
                throw new BiblioException("L'exemplar amb Id: " +e.getId() +" ja existeix");
            }
        }
        this.llista.add(e);
    }

    /**
     * Esborrar element de la llista. Esborra l'element e a la llista
     *
     * @param e
     */
    @Override
    public void esborrar(Exemplar e) throws BiblioException{
        Iterator<Exemplar> it = llista.iterator();
        boolean trobat = false;
        while(it.hasNext() && !trobat){
            Exemplar ex_aux = it.next();
            if (ex_aux.getId().equals(e.getId())){
                this.llista.remove(e);
                trobat = true;
            }
        }
        if (!trobat){
            throw new BiblioException("No s'ha trobat l'exemplar en la llista");
        }
    }

    /**
     * Mètode que comprova que estigui un exemplar en la llista donant el seu id
     * @param id
     * @return
     */
    public boolean contains(String id) {
        Iterator<Exemplar> it = llista.iterator();
        boolean contains = false;
        while (it.hasNext() && !contains) {
            Exemplar e = it.next();
            if (e.getId().equals(id)) {
                contains = true;
            }
        }
        return contains;
    }
}
