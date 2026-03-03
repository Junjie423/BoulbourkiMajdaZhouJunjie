package prog2.model;

public class Parcela extends Allotjament{
    // Atributs de Parcela
    private float metres;
    private boolean connexioElectrica;

    // Constructor
    public Parcela(String nom, String id, float metres, boolean connexioElectrica) {
        super(nom, id);
        this.metres = metres;
        this.connexioElectrica = connexioElectrica;
    }

    // Mètodes de Parcela
    /**
     * Comprova que la Parcela tingui un funcionament correcte.
     *
     * @return funcionament de la Parcela.
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
