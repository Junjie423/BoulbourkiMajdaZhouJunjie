package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrmAfegirUsuari extends JDialog {
    private JPanel contentPane;
    private JButton btnOk;
    private JButton btnCancelar;
    private JTextField tNom;
    private JTextField tEmail;
    private JTextField tAdreca;
    private JLabel email;
    private JLabel nom;
    private JLabel adreca;
    private JCheckBox checkStudent;

    private Adaptador adaptador;
    public FrmAfegirUsuari(Adaptador adp, Window pare) {
        super(pare, ModalityType.APPLICATION_MODAL);
        adaptador = adp;
        setContentPane(contentPane);
        setModal(true);
        setSize(500, 500);
        btnOk.setEnabled(false);
        setTitle("Afegir Usuari");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        getRootPane().setDefaultButton(btnOk);
        setLocationRelativeTo(null);

        KeyListener checkBuits = new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                btnOk.setEnabled((!tNom.getText().isEmpty() && !tEmail.getText().isEmpty() && !tAdreca.getText().isEmpty()));
            }
        };

        tNom.addKeyListener(checkBuits);
        tEmail.addKeyListener(checkBuits);
        tAdreca.addKeyListener(checkBuits);

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

        // Escoltador pels JTextField per tal que quan estiguin omplerts habiliti el botó acceptar



        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        try {
            if (tNom.getText().isBlank() || tEmail.getText().isBlank() || tAdreca.getText().isBlank()) {
                throw new BiblioException("Hi ha camps per omplir encara");
            }
            adaptador.afegirUsuari(tEmail.getText(), tNom.getText(), tAdreca.getText(), checkStudent.isSelected());
            dispose();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Afegir Usuari", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onCancel() {
        dispose();
    }

}
