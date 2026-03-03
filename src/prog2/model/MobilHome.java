package prog2.model;

public class MobilHome extends Allotjament{
    // Atributs de MobilHome
    private String mida;
    private int habitacions, placesPersones;
    private boolean terrassaBarbacoa;

    // Constructor
    public MobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa){
        super(nom_, idAllotjament_);
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    // Mètodes de MobilHome
    /**
     * Comprova que el MobilHome tingui un funcionament correcte.
     *
     * @return funcionament del MobilHome.
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
