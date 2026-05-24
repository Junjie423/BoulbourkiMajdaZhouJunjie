package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Autors: Junjie Zhou, Majda Boulbourki
 *
 *
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

            @Override
            public void actionPerformed(ActionEvent e) {
                //Si s'ha pres el checkbox:
                actualizaLlista();
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

            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAfegirPrestec frmAfegirPrestec = new FrmAfegirPrestec(adaptador, w);
                actualizaLlista();
            }
        });

        checkMostrarNoRetornats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizaLlista();
            }
        });
        btnRetornar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if (llistaPrestecs.getSelectedIndex() == -1){
                        throw new BiblioException("No hi ha cap prestec seleccionat");
                    }
                    adaptador.retornarPrestec(llistaPrestecs.getSelectedIndex());
                    JOptionPane.showMessageDialog(null, "S'ha retornat correctament el préstec", "Retornar Prestec", JOptionPane.INFORMATION_MESSAGE);
                } catch (BiblioException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Retornar Prestec", JOptionPane.ERROR_MESSAGE);
                }
                actualizaLlista();
            }
        });
        btnTornar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }

    private void actualizaLlista(){
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

    private void decorar(){
        btnMostrar.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnAfegir.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnRetornar.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnTornar.setFont(new Font("Times New Roman", Font.BOLD, 20));
        checkMostrarNoRetornats.setFont(new Font("Times New Roman", Font.BOLD, 14));
        llistaPrestecs.setFixedCellHeight(25);
    }
}
