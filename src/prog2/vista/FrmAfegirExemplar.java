package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrmAfegirExemplar extends JDialog {
    private JPanel panelAfegir;
    private JButton btnOk;
    private JButton btnCancel;
    private JTextField tID;
    private JTextField tTitol;
    private JTextField tAutor;
    private JCheckBox pLlarg;
    private JLabel liD;
    private JLabel lTitol;
    private JLabel lAutor;

    private Adaptador adaptador;
    public FrmAfegirExemplar(Adaptador adp, Window pare) {
        super(pare, ModalityType.APPLICATION_MODAL);
        adaptador = adp;
        setContentPane(panelAfegir);
        setModal(true);
        setSize(500, 500);
        setTitle("Afegir Exemplar");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getRootPane().setDefaultButton(btnOk);
        setLocationRelativeTo(null);
        btnOk.setEnabled(false);
        KeyListener checkBuits = new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                    btnOk.setEnabled((!tID.getText().isEmpty() && !tTitol.getText().isEmpty() && !tAutor.getText().isEmpty()));
            }
        };

        tID.addKeyListener(checkBuits);
        tTitol.addKeyListener(checkBuits);
        tAutor.addKeyListener(checkBuits);


        btnOk.addActionListener(new ActionListener() {
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

        setVisible(true);
    }

    private void onOK() {
        try {
            if (tID.getText().isBlank() || tTitol.getText().isBlank() || tAutor.getText().isBlank()) {
                throw new BiblioException("Hi ha camps per omplir encara");
            }
            adaptador.afegirExemplar(tID.getText(), tTitol.getText(), tAutor.getText(), pLlarg.isSelected());
            dispose();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Afegir Exemplar", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onCancel() {
        dispose();
    }

}
