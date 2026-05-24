package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Autors: Junjie Zhou, Majda Boulbourki
 *
 * La classe AppBiblioUB, hereta de JFrame i serà la finestra principal, que tindrà
 * botons per obrir altres finestres per gestionar Usuaris, exemplars, Préstecs i
 * per Guardar i Carregar dades de fitxers.
 *
 */
public class AppBiblioUB extends JFrame {
    private JPanel panelPrincipal;
    private JButton btnGestioUsuaris;
    private JButton btnGestioExemplars;
    private JButton btnGestioPrestecs;
    private JButton btnGuardar;
    private JButton btnCarregar;
    private JButton btnSortir;

    // Es crea un objecte adaptador que es passa per paràmetre a les altres finestres
    private Adaptador adaptador;
    // Es guarda la finestra per poder congelar-la mentre està obert una "sub-finestra" que aquest crea.
    private Window w = this;
    public AppBiblioUB() {
        adaptador = new Adaptador();
        add(panelPrincipal);
        setTitle("Biblioteca UB");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        decorarBoton();
        btnGestioUsuaris.addActionListener(new ActionListener() {
            /**
             * Crea una finestra de tipus FrmGestioUsuaris quan es prem el botó
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
             * Crea una finestra de tipus FrmGestioExemplars quan es prem el botó
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
             * Crea una finestra de tipus FrmGestioPrestecs quan es prem el botó
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
             * Crea un JFileChooser per guardar el fitxer escollit i cridar la funció de guardarDades
             * d'adaptador amb el path guardat.
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
             * Crea un JFileChooser per guardar el fitxer escollit i cridar la funció de carregaDades
             * d'adaptador amb el path guardat.
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
            /**
             * Surt del programa quan es prem el botó
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * Mètode que canvia la dont de lletra dels botons
     */
    private void decorarBoton() {
        btnGestioUsuaris.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnGestioExemplars.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnGestioPrestecs.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnGuardar.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnCarregar.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnSortir.setFont(new Font("Times New Roman", Font.BOLD, 20));
    }


}
