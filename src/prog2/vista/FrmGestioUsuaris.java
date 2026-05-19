package prog2.vista;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmGestioUsuaris extends JFrame{
    private JButton btnvisualitzarUsuaris;
    private JPanel panelGestioUsuaris;
    private JButton btnafegirUsuaris;

    public FrmGestioUsuaris(){
        add(panelGestioUsuaris);
        setVisible(true);

        btnafegirUsuaris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAfegirUsuari afegirUsuari =  new FrmAfegirUsuari();
            }
        });

        btnvisualitzarUsuaris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
