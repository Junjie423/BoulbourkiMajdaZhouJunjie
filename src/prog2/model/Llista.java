/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;
import prog2.vista.BiblioException;

/**
 * Autor: Junjie Zhou, Majda Boulbourki
 *
 * (Descripcio)
 */
public abstract class Llista<T> implements InLlista, Serializable {
   protected ArrayList<T> llista;
   private Exemplar exemplar;
   private Usuari usuari;
   private Prestec prestec;

   public Llista() {
       llista = new ArrayList<>();
    }

    /**
     * Retornar nombre d'elements continguts a la llista
     */
    @Override
    public int getSize() {
          return this.llista.size();
    }

    /**
     * Afegir element a la llista. Afegeix l'element t a la llista
     */
    public void afegir(T t) throws BiblioException {
          // TO-BE-DONE
    }

    /**
     * Esborrar element de la llista. Esborra l'element t a la llista
     */
    public void esborrar(T t) {
          // TO-BE-DONE
    }

    /**
     * Retornar element de la llista a la posició position
     */
    @Override
    public T getAt(int position) {
          // TO-BE-DONE
    }

    /**
     * Buidar tots el elements de la llista
     */
    @Override
    public void clear() {
          // TO-BE-DONE
    }

    /**
     * Retornar true si la llista és buida
     */
    @Override
    public boolean isEmpty() {
        return this.getSize() == 0;
    }

    /**
     * Retornar l'ArrayList que es fa servir dins de la classe
     */
    @Override
    public ArrayList<T> getArrayList() {
        ArrayList<T> arrlist = new ArrayList<>(llista);
        return arrlist;
    }

}
