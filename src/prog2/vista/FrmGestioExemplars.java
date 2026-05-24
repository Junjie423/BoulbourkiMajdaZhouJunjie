package prog2.vista;

import prog2.adaptador.Adaptador;
import prog2.model.Exemplar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmGestioExemplars extends JDialog {
    private JPanel panelGestioExemplars;
    private JButton btnAfegir;
    private JButton btnMostrar;
    private JButton btnSortir;
    private JList llisExem;
    private JScrollPane panelLlista;
    private Adaptador adaptador;

    private Window w = this;
    private static final String[] defecte = {"No hi ha cap exemplar a la llista"};
    public FrmGestioExemplars(Adaptador adp, Window pare){
        super(pare, ModalityType.APPLICATION_MODAL); // Bloqueja l'anterior (la finestra pare) mentre està obert
        add(panelGestioExemplars);
        adaptador = adp;
        setTitle("Gestio Exemplars");
        setMinimumSize(new Dimension(500,500));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500,500);
        panelLlista.setVisible(false);

        btnAfegir.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAfegirExemplar frmAfegirExemplar = new FrmAfegirExemplar(adaptador, w);
                actualizaLlista();
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
                if (btnMostrar.getText().equals("Mostrar Exemplar")) {
                    actualizaLlista();
                    panelLlista.setVisible(true);
                    btnMostrar.setText("Amagar Exemplar");
                }else{
                    panelLlista.setVisible(false);
                    btnMostrar.setText("Mostrar Exemplar");
                }

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

    private void actualizaLlista(){
        if (adaptador.recuperaExemplars().isEmpty()) {
            llisExem.setListData(defecte);
        }else{
            llisExem.setListData(adaptador.recuperaExemplars().toArray());
        }
    }
}
