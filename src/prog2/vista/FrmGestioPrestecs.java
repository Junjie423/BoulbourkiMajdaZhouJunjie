package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Autors: Junjie Zhou, Majda Boulbourki
 *
 * Aquesta classe hereta de JDialog i té botons per mostar la llista de préstecs (mostrar el panel amb la JList),
 * afegir préstecs, retornar préstec i tornar a la finestra principal (tancar).
 */
public class FrmGestioPrestecs extends JDialog {

    private JButton btnMostrar;
    private JPanel panelGestioPrestecs;
    private JCheckBox checkMostrarNoRetornats;
    private JButton btnRetornar;
    private JButton btnAfegir;
    private JList llistaPrestecs;
    private JScrollPane panelLlista;
    private JButton btnTornar;
    private JPanel panelMostrar;
    private Adaptador adaptador;

    private Window w = this;
    private static final String[] defecte = {"No hi ha cap prestec a la llista"};

    /**
     * Constructor que inicialitza la finestra per gestió Prestecs
     * @param adp
     * @param pare
     */
    public FrmGestioPrestecs(Adaptador adp, Window pare) {
        super(pare, ModalityType.APPLICATION_MODAL);
        add(panelGestioPrestecs);
        adaptador = adp;
        setTitle("Gestió prèstecs");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        panelMostrar.setVisible(false);
        decorar();
        btnMostrar.addActionListener(new ActionListener() {
            /**
             * Mètode que crida a actualitzaLlista i mostra o amaga el panel amb la llista
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                actualitzaLlista();
                if (btnMostrar.getText().equals("Visualitzar préstecs")) {
                    panelMostrar.setVisible(true);
                    btnMostrar.setText("Amagar préstecs");
                } else {
                    panelMostrar.setVisible(false);
                    btnMostrar.setText("Visualitzar préstecs");
                }
            }
        });
        btnAfegir.addActionListener(new ActionListener() {
            /**
             * Mètode que crea un FrmAfegirPrestec i després actualitza la llista
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAfegirPrestec frmAfegirPrestec = new FrmAfegirPrestec(adaptador, w);
                actualitzaLlista();
            }
        });

        checkMostrarNoRetornats.addActionListener(new ActionListener() {
            /**
             * Mètode crida a actualitzaLlista()
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                actualitzaLlista();
            }
        });
        btnRetornar.addActionListener(new ActionListener() {
            /**
             * Mètode que crida retornarPrestes de l'adaptador amb l'índex del préstec escollit de la llista
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    // Si no s'escull cap llista, llença excepció
                    if (llistaPrestecs.getSelectedIndex() == -1){
                        throw new BiblioException("No hi ha cap prestec seleccionat");
                    }
                    adaptador.retornarPrestec(llistaPrestecs.getSelectedIndex());
                    JOptionPane.showMessageDialog(null, "S'ha retornat correctament el préstec", "Retornar Prestec", JOptionPane.INFORMATION_MESSAGE);
                } catch (BiblioException ex){
                    // Crea un JOpinionPane amb l'error.
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Retornar Prestec", JOptionPane.ERROR_MESSAGE);
                }
                // Actualitza la llista
                actualitzaLlista();
            }
        });
        btnTornar.addActionListener(new ActionListener() {
            /**
             * Mètode que tanca la finestra
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
     * Mètode que actualitza la llista segons si el CheckBox estè pres o no
     */
    private void actualitzaLlista(){
        if(checkMostrarNoRetornats.isSelected()){
            if (adaptador.recuperaPrestecsNoRetornats().isEmpty()){
                llistaPrestecs.setListData(defecte);
            }else {
                llistaPrestecs.setListData(adaptador.recuperaPrestecsNoRetornats().toArray());
            }
        } else{
            if (adaptador.recuperaPrestecs().isEmpty()){
                llistaPrestecs.setListData(defecte);
            }else{
                llistaPrestecs.setListData((adaptador.recuperaPrestecs().toArray()));
            }
        }
    }

    /**
     * Mètode que assigna la font dels botons i fixa el marge entre les cel·les de la llista
     */
    private void decorar(){
        btnMostrar.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnAfegir.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnRetornar.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnTornar.setFont(new Font("Times New Roman", Font.BOLD, 20));
        checkMostrarNoRetornats.setFont(new Font("Times New Roman", Font.BOLD, 14));
        llistaPrestecs.setFixedCellHeight(25);
    }
}
