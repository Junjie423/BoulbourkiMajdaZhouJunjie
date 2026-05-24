package prog2.vista;



import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Autors: Junjie Zhou, Majda Boulbourki
 *
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
    public FrmGestioUsuaris(Adaptador adp, Window pare){
        super(pare, ModalityType.APPLICATION_MODAL); // Congela la finestra pare mentre aquest està obert
        add(panelGestioUsuaris);
        adaptdor = adp;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        panelLlista.setVisible(false);
        decorar();
        btnafegirUsuaris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAfegirUsuari afegirUsuari = new FrmAfegirUsuari(adaptdor, w);
                afegirUsuari.setVisible(true);
                afegirUsuari.setLocationRelativeTo(null);
                actualizaLlista();
            }
        });
        btnvisualitzarUsuaris.addActionListener(new ActionListener() {
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
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }

    private void actualizaLlista() {
        if (adaptdor.recuperaUsuaris().isEmpty()) {
            llistaUsuaris.setListData(defecte);
        }else{
            llistaUsuaris.setListData(adaptdor.recuperaUsuaris().toArray());
        }
    }

    private void decorar() {
        btnvisualitzarUsuaris.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnafegirUsuaris.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnRetorn.setFont(new Font("Times New Roman", Font.BOLD, 20));
        llistaUsuaris.setFixedCellHeight(25);
    }
}
