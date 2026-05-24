package prog2.vista;

import prog2.adaptador.Adaptador;
import prog2.model.Exemplar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrmAfegirPrestec extends JDialog {
    private JPanel contentPane;
    private JButton btnOK;
    private JButton btnCancelar;
    private JLabel LUsuaris;
    private JLabel LExemplars;
    private JComboBox lUsuaris;
    private JComboBox lExemplars;
    private JCheckBox checkPrestecLlarg;
    private Adaptador adaptador;

    public FrmAfegirPrestec(Adaptador adp, Window pare) {
        super(pare, ModalityType.APPLICATION_MODAL);
        adaptador = adp;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnOK);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 500);
        btnOK.setEnabled(false);
        lUsuaris.addItem("");
        lExemplars.addItem("");
        for (Object u: adaptador.recuperaUsuaris()){
            lUsuaris.addItem(u);
        }
        for (Object u: adaptador.recuperaExemplars()){
            lExemplars.addItem(u);
        }
        pack();
        lUsuaris.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(lUsuaris.getSelectedIndex() != 0 && lExemplars.getSelectedIndex()!= 0){
                    btnOK.setEnabled(true);
                } else{
                    btnOK.setEnabled(false);
                }
            }
        });
        lExemplars.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(lExemplars.getSelectedIndex()!=0 && lUsuaris.getSelectedIndex()!=0){
                    btnOK.setEnabled(true);
                } else{
                    btnOK.setEnabled(false);
                }
            }
        });
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
        setVisible(true);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        try{
            adaptador.afegirPrestec(lExemplars.getSelectedIndex()-1,lUsuaris.getSelectedIndex()-1,checkPrestecLlarg.isSelected());
            dispose();
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Afegir Prestec", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onCancel() {
        dispose();
    }
}
