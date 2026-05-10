package prog2.model;

/**
 * Autor: Junjie Zhou, Majda Boulbourki
 *
 * La classe Estudiant és una subclasse d'Usuari (tipus d'usuari)
 * que permet fer 2 reserves normals i 2 reserves llargues.
 */
public class Professor extends Usuari {
    // Constructor
    public Professor(String email, String nom, String adreca){
        super(email, nom, adreca);
    }

    // Mètodes
    /**
     * Mètode sobreescrit que retorna Professor com a tipus
     *
     * @return Tipus d'usuari
     */
    @Override
    public String tipusUsuari(){
        return "Professor";
    }

    /**
     * Mètode sobreescrit que retorna el maxim de préstecs normals d'un professor
     *
     * @return 2
     */
    @Override
    public int getMaxPrestecsNormals(){
        return 2;
    }

    /**
     * Mètode que retorna el max de préstecs llargs d'un professor
     *
     * @return 1
     */
    @Override
    public int getMaxPrestecsLlargs(){
        return 2;
    }

}
