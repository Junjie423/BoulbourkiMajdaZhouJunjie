package prog2.vista;

import javax.swing.*;
import java.awt.*;

public class AppBiblioUB extends JFrame{
    // Atributs
    private JButton btnGestioUsuaris;
    private JButton btnGestioExemplars;
    private JButton btnGestioPrestecs;
    private JButton btnGuardarDades;
    private JButton btnCarregarDades;

    // Constructor
    public AppBiblioUB(){
        setTitle("Benvinguts a la BibliotecaUB");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
