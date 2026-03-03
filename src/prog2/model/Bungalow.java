package prog2.model;

public class Bungalow extends Allotjament{
    // Atributs del Bungalow
    private String mida;
    private int habitacions, placesPersones, placesParquing;
    private boolean terrassa, tv, aireFred;

    // Constructor
    public Bungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred){
        super(nom_,idAllotjament_);
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
    }

    // Mètodes de Bungalow
    /**
     * Comprova que el Bungalow tingui un funcionament correcte.
     *
     * @return funcionament del Bungalow.
     */
    @Override
    public boolean correcteFuncionament() {

        return false;
    }

    /**
     * Imprimeix tota la informació de l'allotjament
     *
     * @return info
     */
    public String toString(){
        String info = "";

        return info;
    }
}
