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
public abstract class Llista<T> implements InLlista<T>, Serializable {
    // Atributs
    protected ArrayList<T> llista;
    private Exemplar exemplar;
    private Usuari usuari;
    private Prestec prestec;

    // constructor
    public Llista() {
        llista = new ArrayList<>();
    }

    // Mètodes

    /**
     * Retornar nombre d'elements continguts a la llista
     */
    @Override
    public int getSize() {
          return this.llista.size();
    }

    /**
     * Afegir element a la llista. Afegeix l'element t a la llista
     *
     * @param t
     */
    @Override
    public void afegir(T t) throws BiblioException {
        this.llista.add(t);
    }

    /**
     * Esborrar element de la llista. Esborra l'element t a la llista
     *
     * @param t
     */
    @Override
    public void esborrar(T t) {
        this.llista.remove(t);
    }

    /**
     * Retornar element de la llista a la posició position
     */
    @Override
    public T getAt(int position) {
          return this.llista.get(position);
    }

    /**
     * Buidar tots el elements de la llista
     */
    @Override
    public void clear() {
          this.llista.clear();
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
