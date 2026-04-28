package prog2.model;

public class Estudiant extends Usuari{
    // Atributs

    // Constructor
    public Estudiant(String email, String nom, String adreca){
        super(email, nom, adreca);
    }
    // Mètodes
    /**
     * Mètode sobreescrit que retorna Estudiant com a tipus
     *
     * @return Tipus d'usuari
     */
    @Override
    public String tipusUsuari(){
        return "Estudiant";
    }

    /**
     * Mètode sobreescrit que retorna el maxim de préstecs normals d'un estudiant
     *
     * @return 2
     */
    @Override
    public int getMaxPrestecsNormals(){
        return 2;
    }

    /**
     * Mètode que retorna el max de préstecs llargs d'un estudiant
     *
     * @return 1
     */
    @Override
    public int getMaxPrestecsLlargs(){
        return 1;
    }
}
