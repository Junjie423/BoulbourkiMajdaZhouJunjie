package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Autors: Junjie Zhou, Majda Boulbourki
 *
 * Aquesta classe hereta de JDialog i té dues JComboBox per escollir l'usuari que vol fer prestec
 * i l'exemplar que es vol prestar. També té un JCheckBox per assignar si és un préstec llarg o no.
 * Amb les dades, crida el mètode afegirPrestec, amb els índexs dels JComboBox i si és un prestec llarg.
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

    /**
     * Constructor que inicialitza la finestra per afegir Prestecs
     * @param adp
     * @param pare
     */
    public FrmAfegirPrestec(Adaptador adp, Window pare) {
        super(pare, ModalityType.APPLICATION_MODAL); // Fa que es bloquegi la finestra que el crea fins que aquest estigui tancat
        adaptador = adp;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnOK);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnOK.setEnabled(false);
        // Podem afegir un espai blanc en els JComboBox que seran l'opció per defecte (per bloquejar el botó Afegir)
        cUsuaris.addItem("");
        cExemplars.addItem("");
        // Per cada Objecte "String" de l'arrayList que recupera adaptador, l'afegim al JComboBox corresponent
        for (Object u: adaptador.recuperaUsuaris()){
            cUsuaris.addItem(u);
        }
        for (Object u: adaptador.recuperaExemplars()){
            cExemplars.addItem(u);
        }
        setSize(500, 300);
        decorar();
        cUsuaris.addActionListener(new ActionListener() {
            /**
             * Mètode que comprova que l'opció dels dos JComboBox no siguin el que hem creat per defecte (buit),
             * llavors activa el botó Afegir.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cUsuaris.getSelectedIndex() != 0 && cExemplars.getSelectedIndex()!= 0){
                    btnOK.setEnabled(true);
                } else{
                    btnOK.setEnabled(false);
                }
            }
        });
        cExemplars.addActionListener(new ActionListener() {
            /**
             * Mètode que comprova que l'opció dels dos JComboBox no siguin el que hem creat per defecte (buit),
             * llavors activa el botó Afegir.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cExemplars.getSelectedIndex()!=0 && cUsuaris.getSelectedIndex()!=0){
                    btnOK.setEnabled(true);
                } else{
                    btnOK.setEnabled(false);
                }
            }
        });
        btnOK.addActionListener(new ActionListener() {
            /**
             * Crida el mètode onOK()
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            /**
             * Crida el mètode onCancel()
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
     * Mètode que a partir dels índexs seleccionats dels JComboBox i el JCheckBox, crida el mètode afegirPrestec de l'adaptador.
     */
    private void onOK() {
        try{
            // Agafem els índexs -1, perquè hem afegit una opció en blanc al principi (que en la llista que recupera adaptador no està)
            adaptador.afegirPrestec(cExemplars.getSelectedIndex()-1, cUsuaris.getSelectedIndex()-1,checkPrestecLlarg.isSelected());
            dispose();
        } catch(BiblioException e){
            // Llença un JOptionPane amb el missatge d'error
            JOptionPane.showMessageDialog(this, e.getMessage(), "Afegir Prestec", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Mètode que tanca la finestra
     */
    private void onCancel() {
        dispose();
    }

    /**
     * Mètode que assigna la font dels botons, els JLabel i els JComboBox
     */
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
