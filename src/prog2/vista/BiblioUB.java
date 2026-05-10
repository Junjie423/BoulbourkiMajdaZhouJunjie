/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.vista;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import prog2.adaptador.Adaptador;
import prog2.model.Exemplar;

/**
 * Autor: Junjie Zhou, Majda Boulbourki
 *
 * Aquesta classe és la classe principal on a partir d'un objecte de tipus
 * Adaptador pot utilitzar tots els mètodes de Dades, convertint les dades retornades
 * de Dades com a strings. En aquesta classe estan els menus i és la que interactua l'usuari.
 */
public class BiblioUB {
    
    // Declarem les constants del menu principal
    static private enum OpcionsMenuPrincipal {
        MENU_PRINCIPAL_EXEMPLARS,
        MENU_PRINCIPAL_USUARIS,
        MENU_PRINCIPAL_PRESTECS,
        MENU_PRINCIPAL_SAVE,
        MENU_PRINCIPAL_LOAD,
        MENU_PRINCIPAL_EXIT
    };
    
    // Declarem descripcions personalitzades per a les opcions del menú principal
    static private String[] descMenuPrincipal={"Gestió Exemplars",
                                               "Gestió Usuaris",
                                               "Gestió Prestecs",
                                               "Guardar Dades",
                                               "Recuperar Dades",
                                               "Sortir"};

    static private enum OpcionsMenuGestioExemplars {
        MENU_GESTIO_EXEMPLARS_ADD,
        MENU_GESTIO_EXEMPLARS_VIEW,
        MENU_GESTIO_EXEMPLARS_EXIT
    };
    
    // Declarem descripcions personalitzades per a les opcions del menú principal
    static private String[] descMenuGestioExemplars ={"Afegir Exemplar",
                                                      "Visualitzar Exemplars",
                                                      "Sortir"};

    static private enum OpcionsMenuGestioClients {
        MENU_GESTIO_USUARIS_ADD,
        MENU_GESTIO_USUARIS_VIEW,
        MENU_GESTIO_USUARIS_EXIT
    };
    
    // Declarem descripcions personalitzades per a les opcions del menú principal
    static private String[] descMenuGestioUsuaris ={"Afegir Usuari",
                                                    "Visualitzar Usuaris",
                                                    "Sortir"};

    static private enum OpcionsMenuGestioPrestecs {
        MENU_GESTIO_PRESTECS_ADD,
        MENU_GESTIO_PRESTECS_REMOVE,
        MENU_GESTIO_PRESTECS_VIEW,
        MENU_GESTIO_PRESTECS_VIEW_URG,
        MENU_GESTIO_PRESTECS_EXIT
    };
    
    // Declarem descripcions personalitzades per a les opcions del menú principal
    static private String[] descMenuGestioPrestecs ={"Afegir Prestec",
                                                     "Retornar Prestec",
                                                     "Visualitzar Prestecs",
                                                     "Visualitzar Prestecs no Retornats",
                                                     "Sortir"};


    /** Adaptador de l'aplicació */
    private Adaptador adaptador;
    
    /* Constructor*/
    public BiblioUB() {
        adaptador = new Adaptador();
    }
    public BiblioUB(Adaptador adaptador_) {
        adaptador = adaptador_;
    }
     
    public void gestioBiblioUB() {
        // Creem un objecte per llegir des del teclat
        Scanner sc = new Scanner(System.in);
        
        // Creem l'objecte per al menú. Li passem com a primer paràmetre el nom del menú
        Menu<OpcionsMenuPrincipal> menu = new Menu<>("Menu principal", OpcionsMenuPrincipal.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenuPrincipal);
        
        OpcionsMenuPrincipal opcio= null;
        do {
            try{

                // Mostrem les opcions del menú i demanem una opció
                menu.mostrarMenu();
                opcio = menu.getOpcio(sc);

                // Fem les accions necessàries per a la opció triada
                switch(opcio) {
                    case MENU_PRINCIPAL_EXEMPLARS:
                        // Mostra el menú per a la gestió d'exemplars
                        menuGestioExemplars(sc);
                        break;

                    case MENU_PRINCIPAL_USUARIS:
                        // Mostra el menú per a la gestió d'usuaris
                        menuGestioUsuaris(sc);
                        break;

                    case MENU_PRINCIPAL_PRESTECS:
                        // Mostra el menú per a la gestió de prestecs
                        menuGestioPrestecs(sc);
                        break;

                    case MENU_PRINCIPAL_SAVE:
                        // Guardar dades
                        String dstFile = getFilePath(sc,false); // Obtenir el fitxer de sortida
                        if(dstFile != null) {
                        // Guardar les dades al fitxer triat
                            try {
                                this.adaptador.guardaDades(dstFile);
                                System.err.println("Dades guardades");
                            } catch (BiblioException ex) {
                                System.out.println("Error guardant les dades: " + ex.getMessage());
                            }
                        }
                        break;
                    case MENU_PRINCIPAL_LOAD:
                        // Carregar dades
                        String srcFile = getFilePath(sc,false); // Obtenir el fitxer d'entrada
                        if(srcFile != null) {
                            // Carregar les dades del fitxer triat
                            try {
                                this.adaptador.carregaDades(srcFile);
                                System.err.println("Dades carregades");
                            } catch(BiblioException ex) {
                                System.out.println("Error carregant les dades." + ex.getMessage());
                            }
                        }
                        break;
                    case MENU_PRINCIPAL_EXIT:
                        // Sortir      1
                        System.err.println("Sortint de l'aplicació...");
                        break;
                }

            }catch (InputMismatchException e){
                opcio=null;
                sc.nextLine();
                System.err.println("Error: Només numeros" );
            }
            catch(Exception e) {
                opcio=null;
                System.err.println("Error:" + e.getMessage());
            }
        }while(opcio != OpcionsMenuPrincipal.MENU_PRINCIPAL_EXIT);

    }

    /**
     * Mètode amb el menú per gestionar els exemplars
     * @param sc
     */
    private void menuGestioExemplars(Scanner sc) {
        // Creem el menú per gestionar els exemplars
        Menu<OpcionsMenuGestioExemplars> menu = new Menu<>("Menú gestió Exemplars", OpcionsMenuGestioExemplars.values());

        // Li assignem les descripcions
        menu.setDescripcions(descMenuGestioExemplars);

        // Creem un objecte per guardar l'opció
        OpcionsMenuGestioExemplars opcio;

        // Fem el bucle principal que demana l'usuari el que vol fer
        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);

            // Creem el switch per a cada cas
            switch(opcio) {
                case MENU_GESTIO_EXEMPLARS_ADD:
                    // Cas afegir exemplar
                    afegirExemplar(sc);
                    break;

                case MENU_GESTIO_EXEMPLARS_VIEW:
                    // Cas per mostrar els exemplars
                    if (this.adaptador.recuperaExemplars().isEmpty()) {
                        System.err.println("La llista d'exemplars està buida");
                    } else{
                        showList("Llista Exemplars", ListToStringList(this.adaptador.recuperaExemplars()));
                    }
                    break;

                case MENU_GESTIO_EXEMPLARS_EXIT:
                    // Cas per sortir d'aquest menú
                    System.err.println("Has sortit del gestor d'exemplars...");
                    break;

            }
        } while(opcio != OpcionsMenuGestioExemplars.MENU_GESTIO_EXEMPLARS_EXIT);
    }
    
    /**
     * Afegir un nou article (exemplar)
     * @param sc
     */
    private void afegirExemplar(Scanner sc){
        String _id,_titol,_autor,_isllarg;

        // Demanem les dades
        System.out.println("Id de l'exemplar: ");
        _id = sc.nextLine();
        System.out.println("Títol de l'exemplar: ");
        _titol = sc.nextLine();
        System.out.println("Autor de l'exemplar: ");
        _autor = sc.nextLine();
        do{
            System.out.println("Permet préstecs llargs:(S/N) ");
            _isllarg=sc.nextLine();
            if(!_isllarg.equalsIgnoreCase("s") && !_isllarg.equalsIgnoreCase("n")){
                throw new BiblioException("Ha de ser 'S' 's' o 'N' 'n'");
            }
        } while(!_isllarg.equalsIgnoreCase("s") && !_isllarg.equalsIgnoreCase("n"));

        // fem un try catch
        try{
            if (_isllarg.equalsIgnoreCase("s")) {
                this.adaptador.afegirExemplar(_id, _titol, _autor, true);
            } else {
                this.adaptador.afegirExemplar(_id, _titol, _autor, false);
            }
        } catch (BiblioException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    private void menuGestioUsuaris(Scanner sc) {
        // Creem el menú per gestionar els usuaris
        Menu<OpcionsMenuGestioClients> menu = new Menu<>("Menú gestió Usuaris", OpcionsMenuGestioClients.values());

        // Li assignem les descripcions
        menu.setDescripcions(descMenuGestioUsuaris);

        // Creem un objecte per guardar l'opció
        OpcionsMenuGestioClients opcio;

        // Fem el bucle principal que demana l'usuari el que vol fer
        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);

            // Creem el switch per a cada cas
            switch(opcio) {
                case MENU_GESTIO_USUARIS_ADD:
                    // Cas afegir usuari
                    afegirUsuari(sc);
                    break;

                case MENU_GESTIO_USUARIS_VIEW:
                    // Cas per mostrar els usuaris
                    if (this.adaptador.recuperaUsuaris().isEmpty()) {
                        System.err.println("La llista d'usuaris està buida");
                    } else{
                        showList("Llista Usuaris", ListToStringList(this.adaptador.recuperaUsuaris()));
                    }
                    break;

                case MENU_GESTIO_USUARIS_EXIT:
                    // Cas per sortir d'aquest menú
                    System.err.println("Has sortir del gestor d'usuaris...");
                    break;

            }
        } while(opcio != OpcionsMenuGestioClients.MENU_GESTIO_USUARIS_EXIT);
    }
    
    /**
     * Afegir un nou usuari
     * @param sc
     */
    
    private void afegirUsuari(Scanner sc){
        String email, nom, adreca, isEstudiant;

        // Demanem les dades
        System.out.print("Email de l'usuari?: ");
        email = sc.nextLine();
        System.out.print("Nom de l'usuari?: ");
        nom = sc.nextLine();
        System.out.print("Adres de l'usuari?: ");
        adreca = sc.nextLine();

        do{
            System.out.println("És un estudiant:(S/N) ");
            isEstudiant=sc.nextLine();
            if(!isEstudiant.equalsIgnoreCase("s") && !isEstudiant.equalsIgnoreCase("n")){
                throw new BiblioException("Ha de ser 'S' 's' o 'N' 'n'");
            }
        } while(!isEstudiant.equalsIgnoreCase("s") && !isEstudiant.equalsIgnoreCase("n"));

        // fem un try catch
        try{
            if (isEstudiant.equalsIgnoreCase("s")) {
                this.adaptador.afegirUsuari(email, nom, adreca, true);
            } else {
                this.adaptador.afegirUsuari(email, nom, adreca, false);
            }
        } catch (BiblioException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    private void menuGestioPrestecs(Scanner sc) {
        // Creem el menú per gestionar els prestecs
        Menu<OpcionsMenuGestioPrestecs> menu = new Menu<>("Menú gestió Prestecs", OpcionsMenuGestioPrestecs.values());

        // Li assignem les descripcions
        menu.setDescripcions(descMenuGestioPrestecs);

        // Creem un objecte per guardar l'opció
        OpcionsMenuGestioPrestecs opcio;

        // Fem el bucle principal que demana l'usuari el que vol fer
        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);

            // Creem el switch per a cada cas
            switch(opcio) {
                case MENU_GESTIO_PRESTECS_ADD:
                    // Cas afegir préstec
                    afegirPrestec(sc);
                    break;

                case MENU_GESTIO_PRESTECS_REMOVE:
                    // Cas per retornar un prestec (remove)
                    cancelarPrestec(sc);
                case MENU_GESTIO_PRESTECS_VIEW:
                    // Cas per mostrar els préstecs
                    if (this.adaptador.recuperaPrestecs().isEmpty()) {
                        System.err.println("La llista de préstecs està buida");
                    } else{
                        showList("Llista Préstecs", ListToStringList(this.adaptador.recuperaPrestecs()));
                    }
                    break;

                case MENU_GESTIO_PRESTECS_VIEW_URG:
                    // Cas per mostrar els préstecs no retornats
                    if (this.adaptador.recuperaPrestecsNoRetornats().isEmpty()) {
                        System.err.println("La llista de préstecs no retornats està buida");
                    } else{
                        showList("llista Préstecs No Retornats", ListToStringList(this.adaptador.recuperaPrestecsNoRetornats()));
                    }
                    break;

                case MENU_GESTIO_PRESTECS_EXIT:
                    // Cas per sortir d'aquest menú
                    System.err.println("Has sortit del gestor de préstecs...");
                    break;

            }
        } while(opcio != OpcionsMenuGestioPrestecs.MENU_GESTIO_PRESTECS_EXIT);
    }
    
    /**
     * Afegir un nou prestec
     * @param sc
     */
    
    private void afegirPrestec(Scanner sc){
        int numUsuari, numExemplar;
        String isLlarg;
        try{
            // Demanar índex de l'exemplar
            if (this.adaptador.recuperaExemplars().isEmpty()){
                throw new BiblioException("Llista d'exemplars buida");
            }
            showList("Índex d'exemplars", ListToStringList(this.adaptador.recuperaExemplars()));
            System.out.println("Introdueix l'índex de l'exemplar a prestar: ");
            numExemplar = sc.nextInt();
            sc.nextLine(); //Buida el Scanner

            // Demanar líndex de l'usuari
            if (this.adaptador.recuperaUsuaris().isEmpty()){
                throw new BiblioException("Llista d'usuaris buida");
            }
            showList("Índex d'usuaris", ListToStringList(this.adaptador.recuperaUsuaris()));
            numUsuari = sc.nextInt();
            sc.nextLine();

            // Demanem si és un préstec Llarg
            do{
                System.out.println("Serà un prestec llarg: (S/N): ");
                isLlarg = sc.nextLine();
                if(!isLlarg.equalsIgnoreCase("s") && !isLlarg.equalsIgnoreCase("n")){
                    System.err.println("Ha de ser 'S' 's' o 'N' 'n'");
                }
            } while (isLlarg.equalsIgnoreCase("s") && isLlarg.equalsIgnoreCase("n"));

            // Afegim el préstec
            if (isLlarg.equalsIgnoreCase("s")) {
                this.adaptador.afegirPrestec(numExemplar, numUsuari, true);
            } else{
                this.adaptador.afegirPrestec(numExemplar, numUsuari, false);
            }

        }catch (BiblioException ex) {
                System.err.println("Error: " + ex.getMessage());
        }catch(Exception ex) {
            System.err.println("Error: cal ser un valor vàlid");
        }
    }

    private void cancelarPrestec(Scanner sc){
        int numPrestec;
        try{
            if (this.adaptador.recuperaPrestecs().isEmpty()){
                throw new BiblioException("Llista de préstecs buida");
            }
            showList("Índex de Préstecs",  ListToStringList(this.adaptador.recuperaPrestecs()));
            numPrestec = sc.nextInt();
            sc.nextLine();

            // Retornem si es pot el prestec
            this.adaptador.retornarPrestec(numPrestec);
        } catch(BiblioException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

     /**
     * Mostra una llista d'objectes
     * @param title Títol a posar com a capçalera
     * @param lines Llista d'objectes per mostrar
     */
    private void showList(String title, List<String> lines) {
        System.out.println("============================================");
        System.out.println(title);
        System.out.println("============================================");
        int i = 0;
        for(String l : lines) {
            System.out.println("\t[" + (i++) + "] " + l);
        }
        System.out.println("============================================");
    }


    /**
     * Demana el camí d'un fitxer
     * @param sc Objecte per a la lectura de dades de teclat
     * @param mustExist Exigeix que el fitxer existeixi (True) o no (False)
     * @return Ruta al fitxer entrada per l'usuari o null si s'ha cancelat
     */
    private String getFilePath(Scanner sc, boolean mustExist) {
        String filePath = null;

        // Mostrar el missatge demanant l'entrada
        System.out.println("Entra ruta completa fitxer (o ENTER per ometre):");

            // Llegim la ruta del fitxer
            filePath = sc.nextLine();

            // Si la ruta està buida retornem un null
            if(filePath.isEmpty()) {
                return null;
            }

        return filePath;
    }

    /**
     * Mètode que passa els Objectes de la llista introduïda en Strings
     * @param entrada
     * @return List<String> amb els objectes de la llista passada a String
     * @param <Tipus>
     */
    private <Tipus> List<String> ListToStringList(ArrayList<Tipus> entrada){

        List<String> llista = new ArrayList<>();
        for(Tipus objecte :  entrada) {
            llista.add(objecte.toString());
    }
        return llista;
    }

}
