package prog2.model;

public class Glamping extends Allotjament{
    // Atributs de Glamping
    private String mida, material;
    private int habitacions, placesPersones;
    private boolean casaMascota;

    // Constructor
    public Glamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota){
        super(nom_, idAllotjament_);
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
        this.material = material;
        this.casaMascota = casaMascota;
    }

    // Mètodes de Glamping
    /**
     * Comprova que el Glamping tingui un funcionament correcte.
     *
     * @return funcionament del Glamping.
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
