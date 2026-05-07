package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.Iterator;

public class LlistaUsuaris extends Llista<Usuari> implements Serializable {
    // Mètodes

    /**
     * Afegir element a la llista. Afegeix l'element u a la llista
     *
     * @param u
     */
    @Override
    public void afegir(Usuari u) throws BiblioException {
        Iterator<Usuari> it = llista.iterator();
        Usuari usuari;
        while(it.hasNext()){
            usuari = it.next();
            if(usuari.getAdreca().equals(u.getAdreca())){
                throw new BiblioException("L'adreça de l'usuari a afegir ja existeix.");
            }
        }
        llista.add(u);
    }

    /**
     * Esborrar element de la llista. Esborra l'element u a la llista
     *
     * @param u
     */
    @Override
    public void esborrar(Usuari u) throws BiblioException{
        Iterator<Usuari> it = llista.iterator();
        Usuari usuari;
        boolean trobat = false;
        while(it.hasNext() && !trobat){
            usuari = it.next();
            if(usuari.getAdreca().equals(u.getAdreca())){
                trobat = true;
            }
        }
        if(trobat == false){
            throw new BiblioException("L'adreça de l'usuari a esborrar no s'ha trobat.");
        }
        llista.remove(u);
    }
}
