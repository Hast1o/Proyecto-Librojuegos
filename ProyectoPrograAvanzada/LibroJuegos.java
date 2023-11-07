package ProyectoPrograAvanzada;
import java.util.ArrayList;
import java.util.Scanner;

public class LibroJuegos {
    static LibroJuegos instancia;
    private ArrayList<Persona> jugadores = new ArrayList<Persona>();
    private ArrayList<Libro> libros = new ArrayList<Libro>();

    public LibroJuegos(){

    }

    public static LibroJuegos getInstancia(){
        if(instancia==null){
            instancia = new LibroJuegos();
        }
        return instancia;
    }

    public ArrayList<Persona> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Persona> jugadores) {
        this.jugadores = jugadores;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public void registrarse(){
        Scanner in = new Scanner(System.in);
        String nombre = in.nextLine();
        String contraseña = in.nextLine();
        this.getJugadores().add(new Persona(nombre, contraseña));
        in.close();
    }
    public void jugar(){
        Scanner in = new Scanner(System.in);
        for(int i=0;i<this.getLibros().size();i++){
            this.getLibros().get(i).mostrarDatos();
            System.out.println("------------------------------------------------------------");
        }
        System.out.println("Cual libro desea leer:\n");
        int opcion = in.nextInt();
        
        this.getLibros().get(opcion).pedirNombre();
        this.getLibros().get(opcion).siguientePagina(0);
        in.close();
    }

    public void agregarLibro(){
        
    }
}
