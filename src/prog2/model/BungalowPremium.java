package prog2.model;

public class BungalowPremium extends Bungalow{
    // Atributs de BungalowPremium
    private String codiWifi;
    private boolean serveiExtra;

    // Constructor
    public BungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi){
        super(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        this.serveiExtra = serveisExtra;
        this.codiWifi = codiWifi;
    }

    // Mètodes de BungalowPremium
    /**
     * Comprova que el BungalowPremium tingui un funcionament correcte.
     *
     * @return funcionament del BungalowPremium.
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
