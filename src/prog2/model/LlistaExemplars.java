package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaExemplars extends Llista<Exemplar> implements Serializable {
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
        Exemplar exe = null;
        while(it.hasNext()){
            Exemplar ex_aux = it.next();
            if (ex_aux.getId().equals(e.getId())){
                this.llista.remove(e);
                exe = ex_aux;
            }
        }
        if (exe == null){
            throw new BiblioException("No s'ha trobat l'exemplar en la llista");
        }
    }
}
