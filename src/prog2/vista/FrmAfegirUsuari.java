package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Autors: Junjie Zhou, Majda Boulbourki
 *
 * Aquesta classe hereta de JDialog i demana a l'usuari introduir en els JTextField les dades de l'usuari a afegir,
 * té un JCombobox per assignar si és estudiant o no (professor) i crida el mètode afegirUsuari de l'adaptador.
 */
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

    /**
     * Constructor que inicialitza la finestra per afegir Usuaris
     * @param adp
     * @param pare
     */
    public FrmAfegirUsuari(Adaptador adp, Window pare) {
        super(pare, ModalityType.APPLICATION_MODAL); // Congela la finestra que l'ha creat fins que aquest estigui tancat
        adaptador = adp;
        setContentPane(contentPane);
        setModal(true);
        setSize(500, 300);
        btnOk.setEnabled(false);
        setTitle("Afegir Usuari");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        getRootPane().setDefaultButton(btnOk);
        decorar();

        // KeyListener pels JTextField per tal que quan estiguin omplerts habiliti el botó acceptar
        KeyListener checkBuits = new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                btnOk.setEnabled((!tNom.getText().isEmpty() && !tEmail.getText().isEmpty() && !tAdreca.getText().isEmpty()));
            }
        };

        // Afegir el KeyListener als JTExtFields
        tNom.addKeyListener(checkBuits);
        tEmail.addKeyListener(checkBuits);
        tAdreca.addKeyListener(checkBuits);

        btnOk.addActionListener(new ActionListener() {
            /**
             * Mètode que crida al mètode onOK()
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            /**
             * Mètode que crida al mètode onCancel()
             * @param e the event to be processed
             */
            @Override
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

    /**
     * Mètode que comprova que els JTextField no estiguin en blanc i que hi hagui '@' en l'email.
     * Un cop correctes, crida el mètode afegirUsuari de l'adaptador amb les dades introduïdes.
     */
    private void onOK() {
        try {
            if (tNom.getText().isBlank() || tEmail.getText().isBlank() || tAdreca.getText().isBlank()) {
                throw new BiblioException("Hi ha camps per omplir encara");
            }
            if(!tEmail.getText().contains("@")){
                throw new BiblioException("El format del correu està incorrecte (cal @)");
            }
            adaptador.afegirUsuari(tEmail.getText(), tNom.getText(), tAdreca.getText(), checkStudent.isSelected());
            dispose();
        }catch (BiblioException e) {
            // Llença un JOptionPane amb el missatge d'error
            JOptionPane.showMessageDialog(this, e.getMessage(), "Afegir Usuari", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onCancel() {
        dispose();
    }

    private void decorar(){
        btnOk.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnCancelar.setFont(new Font("Times New Roman", Font.BOLD, 16));
        nom.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        email.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        adreca.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        checkStudent.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        tNom.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        tEmail.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        tAdreca.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        tNom.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5,5,5,5), new MatteBorder(0, 0, 2, 0, Color.LIGHT_GRAY)));
        tEmail.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5,5,5,5), new MatteBorder(0, 0, 2, 0, Color.LIGHT_GRAY)));
        tAdreca.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5,5,5,5), new MatteBorder(0, 0, 2, 0, Color.LIGHT_GRAY)));
    }
}
