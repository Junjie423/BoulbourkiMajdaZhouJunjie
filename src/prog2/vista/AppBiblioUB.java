package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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

    /**
     * Constructor que inicialitza l'AppBiblioUB
     */
    public AppBiblioUB() {
        adaptador = new Adaptador();
        add(panelPrincipal);
        setTitle("Biblioteca UB");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        decorarBoton();
        benvinguda();
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
                        // Llença un JOptionPane amb el missatge d'error
                        JOptionPane.showMessageDialog(w, ex.getMessage(), "Guardar dades", JOptionPane.ERROR_MESSAGE);
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
                        // Llença un JOptionPane amb el missatge d'error
                        JOptionPane.showMessageDialog(w, ex.getMessage(), "Carregar dades", JOptionPane.ERROR_MESSAGE);
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

    /**
     *
     * JDialog Mètode que dona la benvinguda després de 1,5s en iniciar AppBiblioUB i
     * tanca la finestra amb el missatge després de 3 segons.
     */
    private void benvinguda() {
        new Thread(()->{try{
            JDialog benvinguda = new JDialog();
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            JButton tancarBtn = new JButton("Som-hi!");

            //Finestra
            benvinguda.setVisible(false);
            benvinguda.setTitle("Benvinguda");
            benvinguda.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            benvinguda.setResizable(false);
            benvinguda.setLayout(new BorderLayout());
            benvinguda.setSize(new Dimension(500, 200));

            //Label
            JLabel hola = new JLabel("Benvingut/da a l'App de la Biblioteca UB", SwingConstants.CENTER);
            hola.setFont(new Font("Times New Roman", Font.BOLD, 20));

            //Bottom
            tancarBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
            tancarBtn.addActionListener(e-> benvinguda.dispose());
            tancarBtn.setIcon(new ImageIcon(getClass().getResource("/prog2/vista/Iconos/go.png")));

            //Panel
            panel.add(hola,BorderLayout.CENTER);
            benvinguda.add(panel);
            panel.add(tancarBtn,BorderLayout.SOUTH);

            //Saludar
            Thread.sleep(2000);// Espera dos segon
            benvinguda.setLocationRelativeTo(null);
            benvinguda.setVisible(true);
            while(true){
                hola.setIcon(new ImageIcon(getClass().getResource("/prog2/vista/Iconos/mano2.png")));
                Thread.sleep(500);
                hola.setIcon(new ImageIcon(getClass().getResource("/prog2/vista/Iconos/mano.png")));
                Thread.sleep(500);
            }

        } catch (Exception ex) {
            // Mai passarà
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Benvinguda", JOptionPane.ERROR_MESSAGE);
        }
        }).start();

    }


}
