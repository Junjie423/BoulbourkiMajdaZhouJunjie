package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Autors: Junjie Zhou, Majda Boulbourki
 *
 *
 */
public class FrmAfegirPrestec extends JDialog {
    private JPanel contentPane;
    private JButton btnOK;
    private JButton btnCancelar;
    private JLabel LUsuaris;
    private JLabel LExemplars;
    private JComboBox cUsuaris;
    private JComboBox cExemplars;
    private JCheckBox checkPrestecLlarg;
    private Adaptador adaptador;

    public FrmAfegirPrestec(Adaptador adp, Window pare) {
        super(pare, ModalityType.APPLICATION_MODAL);
        adaptador = adp;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnOK);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnOK.setEnabled(false);
        cUsuaris.addItem("");
        cExemplars.addItem("");
        for (Object u: adaptador.recuperaUsuaris()){
            cUsuaris.addItem(u);
        }
        for (Object u: adaptador.recuperaExemplars()){
            cExemplars.addItem(u);
        }
        setSize(500, 300);
        decorar();
        cUsuaris.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(cUsuaris.getSelectedIndex() != 0 && cExemplars.getSelectedIndex()!= 0){
                    btnOK.setEnabled(true);
                } else{
                    btnOK.setEnabled(false);
                }
            }
        });
        cExemplars.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(cExemplars.getSelectedIndex()!=0 && cUsuaris.getSelectedIndex()!=0){
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
        setLocationRelativeTo(null);
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
            adaptador.afegirPrestec(cExemplars.getSelectedIndex()-1, cUsuaris.getSelectedIndex()-1,checkPrestecLlarg.isSelected());
            dispose();
        } catch(BiblioException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Afegir Prestec", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onCancel() {
        dispose();
    }

    private void decorar(){
        btnOK.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnCancelar.setFont(new Font("Times New Roman", Font.BOLD, 16));
        cUsuaris.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        cExemplars.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        checkPrestecLlarg.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        LUsuaris.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        LExemplars.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    }
}
