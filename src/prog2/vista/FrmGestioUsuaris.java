package prog2.vista;



import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Autors: Junjie Zhou, Majda Boulbourki
 *
 * Aquesta classe hereta de JDialog i té botons per mostar la llista d'usuaris (mostrar el panel amb la JList),
 * afegir usuaris, i tornar a la finestra principal (tancar).
 *
 */
public class FrmGestioUsuaris extends JDialog {
    private JButton btnvisualitzarUsuaris;
    private JPanel panelGestioUsuaris;
    private JButton btnafegirUsuaris;
    private JList llistaUsuaris;
    private JScrollPane panelLlista;
    private JButton btnRetorn;
    private Adaptador adaptdor;

    private Window w = this;
    private static final String[] defecte = {"No hi ha cap usuari a la llista"};

    /**
     * Constructor que inicilitza la finestra per gestió Usuaris
     * @param adp
     * @param pare
     */
    public FrmGestioUsuaris(Adaptador adp, Window pare){
        super(pare, ModalityType.APPLICATION_MODAL); // Congela la finestra pare mentre aquest està obert
        add(panelGestioUsuaris);
        adaptdor = adp;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setTitle("Gestio Usuaris");
        panelLlista.setVisible(false);
        decorar();
        btnafegirUsuaris.addActionListener(new ActionListener() {
            /**
             * Mètode que crea un FrmAfegirUsuari, i després actualitza la llista
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAfegirUsuari afegirUsuari = new FrmAfegirUsuari(adaptdor, w);
                actualizaLlista();
            }
        });
        btnvisualitzarUsuaris.addActionListener(new ActionListener() {
            /**
             * Mètode que mostra o amaga el panel amb la llista segons el text del botó
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(btnvisualitzarUsuaris.getText().equals("Visualitzar usuaris")){
                    panelLlista.setVisible(true);
                    actualizaLlista();
                    btnvisualitzarUsuaris.setText("Amagar usuaris");
                } else{
                    panelLlista.setVisible(false);
                    btnvisualitzarUsuaris.setText("Visualitzar usuaris");
                }
            }
        });
        btnRetorn.addActionListener(new ActionListener() {
            /**
             * Mètode que tanca la finestra
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }

    /**
     * Mètode que actualitza la llista
     */
    private void actualizaLlista() {
        if (adaptdor.recuperaUsuaris().isEmpty()) {
            // En cas de llista buida, assigna el missatge defecte
            llistaUsuaris.setListData(defecte);
        }else{
            llistaUsuaris.setListData(adaptdor.recuperaUsuaris().toArray());
        }
    }

    /**
     * Mètode que assigna la font als botons i fixa el marge entre les cel·les de la llista
     */
    private void decorar() {
        btnvisualitzarUsuaris.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnafegirUsuaris.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnRetorn.setFont(new Font("Times New Roman", Font.BOLD, 20));
        llistaUsuaris.setFixedCellHeight(25);
    }
}
