package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmGestioExemplars extends JDialog {
    private JPanel panelGestioExemplars;
    private JButton btnAfegir;
    private JButton btnMostrar;
    private JButton btnSortir;
    private Adaptador adaptador;

    Window w = this;
    public FrmGestioExemplars(Adaptador adp, Window pare){
        super(pare, Dialog.ModalityType.APPLICATION_MODAL); // Bloquejar l'anterior (la pestanya pare)
        add(panelGestioExemplars);
        adaptador = adp;
        setTitle("Gestio Exemplars");
        setMinimumSize(new Dimension(500,500));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        btnAfegir.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAfegirExemplar frmAfegirExemplar = new FrmAfegirExemplar(adaptador);
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrarà la llista amb els exemplars
            }
        });
        btnSortir.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }


}
