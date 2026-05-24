package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Autors: Junjie Zhou, Majda Boulbourki
 *
 *
 */
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
        setSize(500, 300);
        setTitle("Afegir Exemplar");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getRootPane().setDefaultButton(btnOk);
        setLocationRelativeTo(null);
        btnOk.setEnabled(false);
        decorar();
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
        }catch (BiblioException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Afegir Exemplar", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onCancel() {
        dispose();
    }

    private void decorar(){
        btnOk.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        liD.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lAutor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lTitol.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        tID.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        tTitol.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        tAutor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        tID.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5,5,5,5), new MatteBorder(0, 0, 2, 0, Color.LIGHT_GRAY)));
        tAutor.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5,5,5,5), new MatteBorder(0, 0, 2, 0, Color.LIGHT_GRAY)));
        tTitol.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5,5,5,5), new MatteBorder(0, 0, 2, 0, Color.LIGHT_GRAY)));
        pLlarg.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    }

}
