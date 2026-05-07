package prog2.model;

import prog2.vista.BiblioException;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * Autor: Junjie Zhou, Majda Boulbourki
 *
 * (Descripcio)
 */
public class Dades implements InDades{
    // Atributs
    private LlistaExemplars exemplars;
    private LlistaUsuaris usuaris;
    private LlistaPrestecs prestecs;

    // Constructor
    public Dades(){
        this.exemplars = new LlistaExemplars();
        this.usuaris = new LlistaUsuaris();
        this.prestecs = new LlistaPrestecs();
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
    @Override
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {
        this.exemplars.afegir(new Exemplar(id, titol, autor, admetPrestecLlarg));   //ja llença una exepció si l'id existeix al mètode afegir
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb tots els exemplars
     */
    @Override
    public ArrayList<Exemplar> recuperaExemplars() {
        return this.exemplars.getArrayList();
    }

    /**
     * Afegeix usuari. Llança excepció si l'email ja existeix
     *
     * @param email
     * @param nom
     * @param adreca
     * @param esEstudiant
     */
    @Override
    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {
        if(esEstudiant){
            this.usuaris.afegir(new Estudiant(email, nom, adreca));
        } else{
            this.usuaris.afegir(new Professor(email, nom, adreca));
        }
    }

    /**
     * Recuperar usuaris. Retorna un ArrayList amb tots els usuaris
     */
    @Override
    public ArrayList<Usuari> recuperaUsuaris() {
        return usuaris.getArrayList();
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
    @Override
    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {
        // Cas de out_of_range en les llistes
        if((exemplarPos < 0) || (exemplarPos > exemplars.getSize())){
            throw new BiblioException("No hi ha cap exemplar en la posició introduïda");
        }
        if((usuariPos < 0) || (usuariPos > usuaris.getSize())){
            throw new BiblioException("No hi ha cap usauri a la posició introduïda");
        }

        Exemplar e = exemplars.getAt(exemplarPos);
        Usuari u = usuaris.getAt(usuariPos);

        // Cas prestec llarg a un exemplar que no admet tipus llarg
        if(esLlarg && !e.getAdmetPrestecLlarg()){
            throw new BiblioException("No es pot afegir un prestec llarg a aquest exemplar");
        }

        // Cas de fer un prestec d'un exemplar no diponible
        if(!e.isDisponible()){
            throw new BiblioException("L'exemplar no està disponible per fer prestecs");
        }

        // Cas de fer un prestec a un usuari amb prestecs endarrerits
        if (u.getNumPrestecsLlargs() > u.getMaxPrestecsLlargs()) {
            throw new BiblioException("Aquest usuari ja no permet fer prestecs llargs");
        }
        if (u.getNumPrestecsNormals() > u.getMaxPrestecsNormals()) {
                throw new BiblioException("Aquest usuari ja no permet fer prestecs normals");
        }

        if(esLlarg){
            prestecs.afegir(new PrestecLlarg(e, u, new Date()));

        }
        else{
            prestecs.afegir(new PrestecNormal(e, u, new Date()));
        }
    }

    /**
     * Retornar préstec. Llança excepció si el prestec ja es va retornar.
     * El préstec s'identifica amb la seva posició dins de l'ArrayList
     *
     * @param position
     */
    @Override
    public void retornarPrestec(int position) throws BiblioException {
        Prestec p = prestecs.getAt(position);
        if (p.getRetornat()){
            throw new BiblioException("El prestec ja s'havia retornat");
        } else{
            p.setRetornat(true);
        }
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb tots els préstecs
     */
    @Override
    public ArrayList<Prestec> recuperaPrestecs() {
        return prestecs.getArrayList();
    }

    /**
     * Recuperar préstecs. Retorna un ArrayList amb els préstecs no retornats
     */
    @Override
    public ArrayList<Prestec> recuperaPrestecsNoRetornats() {
        ArrayList<Prestec> prestecsNoRetornats = new ArrayList<>();
        Iterator<Prestec> itr = prestecs.getArrayList().iterator();
        while(itr.hasNext()){
            Prestec p = itr.next();
            if(!p.getRetornat()){
                prestecsNoRetornats.add(p);
            }
        }
        return prestecsNoRetornats;
    }
}
