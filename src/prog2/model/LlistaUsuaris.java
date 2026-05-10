package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Autor: Junjie Zhou, Majda Boulbourki
 *
 * Subclasse de llista que guarda objectes de tipus Usuari.
 * Permet afegir i esborrar elements a la llista.
 */
public class LlistaUsuaris extends Llista<Usuari> implements Serializable {
    // Constructor
    public LlistaUsuaris() {
        super();
    }

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
            if(usuari.getEmail().equals(u.getEmail())){
                throw new BiblioException("L'usuari amb l'email " + u.getEmail() + " ja existeix.");
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
            if(usuari.getEmail().equals(u.getEmail())){
                trobat = true;
            }
        }
        if(!trobat){
            throw new BiblioException("L'email de l'usuari a esborrar no s'ha trobat.");
        }
        llista.remove(u);
    }

    /**
     * Mètode que comprova que estigui un usuari en la llista donant el seu email
     * @param email
     * @return
     */
    public boolean contains(String email) {
        Iterator<Usuari> it = llista.iterator();
        boolean contains = false;
        while (it.hasNext() && !contains) {
            Usuari u = it.next();
            if (u.getEmail().equals(email)) {
                contains = true;
            }
        }
        return contains;
    }
}

