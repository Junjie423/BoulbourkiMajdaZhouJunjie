package prog2.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrmAfegirExemplar extends JDialog {
    private JPanel panelAfegir;
    private JButton btnAcceptar;
    private JButton btnCancel;

    public FrmAfegirExemplar() {
        setContentPane(panelAfegir);
        setModal(true);
        getRootPane().setDefaultButton(btnAcceptar);
        setVisible(true);
        setTitle("Afegir Exemplar");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        btnAcceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        panelAfegir.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        FrmAfegirExemplar dialog = new FrmAfegirExemplar();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
