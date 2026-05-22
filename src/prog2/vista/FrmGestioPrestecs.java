package prog2.vista;

import prog2.adaptador.Adaptador;
import prog2.model.Prestec;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmGestioPrestecs extends JFrame {

    private JButton btnMostrar;
    private Adaptador adaptador;
    private JPanel panelGestioPrestecs;
    private JCheckBox checkMostrarNoRetornats;
    private JButton btnRetornar;
    private JButton btnAfegir;
    private JList  llistaPrestecs;
    private JList llistaNoRetornats;

    public FrmGestioPrestecs(Adaptador adp) {
        add(panelGestioPrestecs);
        adaptador = adp;
        setTitle("Gestió prèstecs");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        llistaPrestecs.setVisible(false);
        llistaNoRetornats.setVisible(false);

        btnMostrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Si s'ha pres el checkbox:,
                if(checkMostrarNoRetornats.isSelected()){
                    if(btnMostrar.getText().equals("Visualitzar préstecs")){
                        llistaNoRetornats.setListData(adaptador.recuperaPrestecsNoRetornats().toArray());
                        llistaNoRetornats.setVisible(true);
                        btnMostrar.setText("Amagar préstecs");
                        pack();
                    }
                    else{
                        llistaNoRetornats.setVisible(false);
                        btnMostrar.setText("Visualitzar préstecs");
                    }
                }
                else{
                    if(btnMostrar.getText().equals("Visualitzar préstecs")){
                        llistaPrestecs.setListData((adaptador.recuperaPrestecs().toArray()));
                        llistaPrestecs.setVisible(true);
                        btnMostrar.setText("Amagar préstecs");
                    }
                    else{
                        llistaPrestecs.setVisible(false);
                        btnMostrar.setText("Amagar préstecs");
                    }
                }
            }
        });


        btnAfegir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }

}
