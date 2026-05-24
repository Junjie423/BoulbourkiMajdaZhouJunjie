package prog2.vista;

import prog2.adaptador.Adaptador;
import prog2.model.Exemplar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Autors: Junjie Zhou, Majda Boulbourki
 *
 * Aquesta classe hereta de JDialog i té botons per mostar la llista d'exemplars (mostrar el panel amb la JList),
 * afegir exemplars, i tornar a la finestra principal (tancar).
 */
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

    /**
     * Constructor que inicialitza la finestra de gestió Exemplars.
     * @param adp
     * @param pare
     */
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
        decorar();
        btnAfegir.addActionListener(new ActionListener() {
            /**
             * Crea un FrmAfegirExemplar i quan aquest es tanca, actualitza la llista.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAfegirExemplar frmAfegirExemplar = new FrmAfegirExemplar(adaptador, w);
                actualitzaLlista();
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            /**
             * Mostra el panel amb la Llista quan el botó és Mostrar Exemplar i ho amaga quan el text del botó
             * és Amagar Exemplar
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrarà la llista amb els exemplars (actualitza la llista abans de mostrarla
                if (btnMostrar.getText().equals("Mostrar Exemplar")) {
                    actualitzaLlista();
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
             * Tanca la finestra.
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

    /**
     * Mètode que actualitza la llista
     */
    private void actualitzaLlista(){
        if (adaptador.recuperaExemplars().isEmpty()) {
            // Si està buida la llista, llavors apareix el missatge de defecte
            llisExem.setListData(defecte);
        }else{
            llisExem.setListData(adaptador.recuperaExemplars().toArray());
        }
    }

    /**
     * Mètode que assigna la font als botons i crea espai entre cel·les de la llista
     */
    private void decorar(){
        btnAfegir.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnMostrar.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnSortir.setFont(new Font("Times New Roman", Font.BOLD, 20));
        llisExem.setFixedCellHeight(25);
    }
}
