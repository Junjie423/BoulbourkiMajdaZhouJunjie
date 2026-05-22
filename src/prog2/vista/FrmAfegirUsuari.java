package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.*;

public class FrmAfegirUsuari extends JDialog {
    private JPanel contentPane;
    private JButton btnOk;
    private JButton btnCancelar;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel email;
    private JLabel nom;
    private JLabel adreca;
    private JCheckBox checkStudent;

    private Adaptador adaptador;
    public FrmAfegirUsuari(Adaptador adp) {
        adaptador = adp;
        setContentPane(contentPane);
        setModal(true);
        setSize(500, 500);
        setTitle("Afegir Usuari");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        getRootPane().setDefaultButton(btnOk);
        setLocationRelativeTo(null);

        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
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
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        try {
            if (textField1.getText().equals("") || textField2.getText().equals("") || textField3.getText().equals("")) {
                throw new RuntimeException("Camps buits");
            }
            adaptador.afegirUsuari(textField1.getText(), textField2.getText(), textField3.getText(), checkStudent.isSelected());
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Afegir Usuari", JOptionPane.ERROR_MESSAGE);
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
