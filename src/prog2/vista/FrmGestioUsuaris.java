package prog2.vista;



import prog2.adaptador.Adaptador;
import prog2.model.Exemplar;
import prog2.model.Usuari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class FrmGestioUsuaris extends JDialog {
    private JButton btnvisualitzarUsuaris;
    private JPanel panelGestioUsuaris;
    private JButton btnafegirUsuaris;
    private JList llistaUsuaris;
    private Adaptador adaptdor;

    public FrmGestioUsuaris(Adaptador adp, Window pare){
        super(pare, Dialog.ModalityType.APPLICATION_MODAL);
        add(panelGestioUsuaris);
        adaptdor = adp;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        llistaUsuaris.setVisible(false);
        btnafegirUsuaris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAfegirUsuari afegirUsuari =  new FrmAfegirUsuari(adaptdor);
                afegirUsuari.setVisible(true);
                afegirUsuari.setLocationRelativeTo(null);
                llistaUsuaris.setListData(adaptdor.recuperaUsuaris().toArray());
            }
        });
        btnvisualitzarUsuaris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(btnvisualitzarUsuaris.getText().equals("Visualitzar usuaris")){
                    llistaUsuaris.setListData(adaptdor.recuperaUsuaris().toArray());
                    llistaUsuaris.setVisible(true);
                    btnvisualitzarUsuaris.setText("Amaga usuaris");
                    pack();
                } else{
                    llistaUsuaris.setVisible(false);
                    btnvisualitzarUsuaris.setText("Visualitzar usuaris");
                }
            }
        });

        setVisible(true);
    }
}
