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
    private JButton btnSortir;

    private Adaptador adaptador;
    private Window w = this;
    public AppBiblioUB() {
        adaptador = new Adaptador();
        //try {for(int i = 0; i< 10; i++){adaptador.afegirExemplar("Id"+i,"Tit"+i,"Aut"+i,i%2 == 0);adaptador.afegirUsuari("Mail"+i,"Nom"+i,"Adr"+i,i%2 ==0);}adaptador.afegirPrestec(1,1,false);} catch (Exception e){System.err.println("Error inesperat:" + e.getMessage());}
        add(panelPrincipal);
        setTitle("Biblio");
        setSize(550, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
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
                int resposta = chooser.showSaveDialog(w); // Donara 0 si funciona, 1 si no funciona i -1 si hi ha error
                if (resposta == JFileChooser.APPROVE_OPTION) { // Cas 0
                    try {
                        adaptador.guardaDades(chooser.getSelectedFile().getAbsolutePath());
                        JOptionPane.showMessageDialog(btnGuardar, "Dades guardades correctament", "Guardar Dades", JOptionPane.INFORMATION_MESSAGE);
                    } catch (BiblioException ex) {
                        JOptionPane.showMessageDialog(btnGuardar, ex.getMessage(), "Guardar dades", JOptionPane.ERROR_MESSAGE);
                    }
                }
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
                JFileChooser chooser = new JFileChooser();
                int resposta = chooser.showOpenDialog(w);
                if (resposta == JFileChooser.APPROVE_OPTION) {
                    try {
                        adaptador.carregaDades(chooser.getSelectedFile().getAbsolutePath());
                        JOptionPane.showMessageDialog(btnCarregar,"Dades carregades correctament", "Carregar Dades", JOptionPane.INFORMATION_MESSAGE);
                    } catch (BiblioException ex) {
                        JOptionPane.showMessageDialog(btnCarregar, ex.getMessage(), "Carregar dades", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        btnSortir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }


}
