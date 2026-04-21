package prog2.model;

import java.util.Date;

/**
 * Autor: Junjie Zhou, Majda Boulbourki
 *
 * (Descripcio)
 */
public class Prestec implements InPrestec{

    /**
     * @param exemplar
     */
    @Override
    public void setExemplar(Exemplar exemplar) {

    }

    /**
     * @return
     */
    @Override
    public Exemplar getExemplar() {
        return null;
    }

    /**
     * @param usuari
     */
    @Override
    public void setUsuari(Usuari usuari) {

    }

    /**
     * @return
     */
    @Override
    public Usuari getUsuari() {
        return null;
    }

    /**
     * @param data
     */
    @Override
    public void setDataCreacio(Date data) {

    }

    /**
     * @return
     */
    @Override
    public Date getDataCreacio() {
        return null;
    }

    /**
     * @param data
     */
    @Override
    public void setDataLimitRetorn(Date data) {

    }

    /**
     * @return
     */
    @Override
    public Date getDataLimitRetorn() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public String tipusPrestec() {
        return "";
    }

    /**
     * @param retornat
     */
    @Override
    public void setRetornat(boolean retornat) {

    }

    /**
     * @return
     */
    @Override
    public boolean getRetornat() {
        return false;
    }

    /**
     * Retornar prestec. Llança excepció si el prestec ja es vaig retornar
     */
    @Override
    public void retorna() {

    }

    /**
     * Retornar durada prestec. La durada del prestec depen del tipus de prestec
     */
    @Override
    public long duradaPrestec() {
        return 0;
    }

    /**
     * Retornar true si el prestec està endarrerit per a la data actual
     */
    @Override
    public boolean prestecEndarrerit() {
        return false;
    }
}
