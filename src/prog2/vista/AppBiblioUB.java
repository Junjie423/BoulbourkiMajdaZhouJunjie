package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppBiblioUB extends JFrame {
    private JPanel panelPrincipal;
    private JButton btnGestioUsuaris;
    private JButton btnGestioExemplars;
    private JButton btnGestioPrestecs;
    private JButton btnGuardar;
    private JButton btnCarregar;

    private Adaptador adaptador;

    public AppBiblioUB() {
        adaptador = new Adaptador();
        try {for(int i = 0; i< 10; i++){adaptador.afegirExemplar("Id"+i,"Tit"+i,"Aut"+i,i%2 == 0);adaptador.afegirUsuari("Mail"+i,"Nom"+i,"Adr"+i,i%2 ==0);}adaptador.afegirPrestec(1,1,false);} catch (Exception e){System.err.println("Error inesperat:" + e.getMessage());}
        add(panelPrincipal);
        setTitle("Biblio");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Window w = this;
        btnGestioUsuaris.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestioUsuaris formUsuari =  new FrmGestioUsuaris(adaptador, w);
            }
        });
        btnGestioExemplars.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestioExemplars formExemplar =  new FrmGestioExemplars(adaptador, w);
            }
        });
        btnGestioPrestecs.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestioPrestecs formPrestecs =  new FrmGestioPrestecs(adaptador, w);
            }
        });
        btnGuardar.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(btnGuardar);
            }
        });
        btnCarregar.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


}
