package prog2.adaptador;

import prog2.model.*;
import prog2.vista.BiblioException;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * Autor: Junjie Zhou, Majda Boulbourki
 *
 * La classe Adaptador, és una classe que conté un Objecte de tipus Dades
 * i permet intervenir entre vista i les dades del model.
 *
 */
public class Adaptador implements Serializable {
    // Atributs
    private Dades dades;

    // Constructor
    public Adaptador() {
        this.dades = new Dades();
    }

    // Mètodes
    /**
     * Afegeix exemplar. Llança excepció si l'id ja existeix
     *
     * @param id
     * @param titol
     * @param autor
     * @param admetPrestecLlarg
     */
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {
        this.dades.afegirExemplar(id, titol, autor, admetPrestecLlarg);
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb tots els exemplars
     *
     * @return ArrayList<Exemplar> llista d'exemplars
     */
    public ArrayList<Exemplar> recuperaExemplars() {
        return this.dades.recuperaExemplars();
    }

    /**
     * Afegeix usuari. Llança excepció si l'email ja existeix
     *
     * @param email
     * @param nom
     * @param adreca
     * @param esEstudiant
     */
    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {
        this.dades.afegirUsuari(email, nom, adreca, esEstudiant);
    }

    /**
     * Recuperar usuaris. Retorna un ArrayList amb tots els usuaris
     *
     * @return ArrayList<Usuari> llista d'usuaris
     */
    public ArrayList<Usuari> recuperaUsuaris() {
        return this.dades.recuperaUsuaris();
    }

    /**
     * Afegeix préstec. Ha de fer diferents comprovacions que poden llançar excepcions.
     * Quan s'afegeix el préstec, s'han de tenir en compte les posicions d'exemplar
     * i usuari dins dels seus ArrayLists
     *
     * @param exemplarPos
     * @param usuariPos
     * @param esLlarg
     */
    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {
        this.dades.afegirPrestec(exemplarPos, usuariPos, esLlarg);
    }

    /**
     * Retornar préstec. Llança excepció si el prestec ja es va retornar.
     * El préstec s'identifica amb la seva posició dins de l'ArrayList
     *
     * @param position
     */
    public void retornarPrestec(int position) throws BiblioException {
        this.dades.retornarPrestec(position);
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb tots els préstecs
     *
     * @return ArrayList<Prestec> llista de prestecs
     */
    public ArrayList<Prestec> recuperaPrestecs() {
        return this.dades.recuperaPrestecs();
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb els préstecs no retornats
     *
     * @return ArrayList<Prestec> llista de prestecs no retornats
     */
    public ArrayList<Prestec> recuperaPrestecsNoRetornats() {
        return this.dades.recuperaPrestecsNoRetornats();
    }

    public void guardaDades(String camiDesti) throws BiblioException {
        File file = null;
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try{
            file = new File(camiDesti);
            fout = new FileOutputStream(file);
            oos = new ObjectOutputStream(fout);

            oos.writeObject(this.dades);

        } catch (IOException e){
            if (e instanceof FileNotFoundException) {
                throw new BiblioException("No s'ha pogut obrir el fitxer");
            }else {
                throw new BiblioException("No s'ha pogut guardar les dades");
            }
        }
        if (oos != null) {
            try {
                oos.close();
            } catch (IOException e) {
                throw new BiblioException("L'ObjectOutputStream no s'ha pogut tancar");
            }
        }
        if (fout != null) {
            try {
                fout.close();
            } catch (IOException e) {
                throw new BiblioException("El FileOutputStream no s'ha pogut tancar");
            }
        }
    }
    public void carregaDades(String camiOrigen) throws BiblioException{
        File file = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            file = new File(camiOrigen);
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            this.dades = (Dades) ois.readObject();
        } catch (IOException | ClassNotFoundException e){
            if (e instanceof FileNotFoundException) {
                throw new BiblioException("No s'ha pogut obrir el fitxer");
            } else if (e instanceof IOException) {
                throw new BiblioException("No s'ha pogut llegir el fitxer");
            } else {
                throw new BiblioException(e.getMessage());
            }
        }
        if (ois != null) {
            try {
                ois.close();
            } catch (IOException e) {
                throw new BiblioException("L'ObjectInputStream no s'ha pogut tancar");
            }
        }
        if (fis != null) {
            try {
                fis.close();
            } catch (IOException e) {
                throw new BiblioException("El FileInputStream no s'ha pogut tancar");
            }
        }
    }

}
