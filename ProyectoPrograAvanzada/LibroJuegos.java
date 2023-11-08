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
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el nombre del libro:\n");
        String nombre = in.nextLine();
        System.out.println("Ingrese el autor del libro:\n");
        String autor = in.nextLine();
        System.out.println("Ingrese la descripción del libro:\n");
        String descripcion = in.nextLine();
        Libro libro = new Libro(autor,nombre,descripcion);
        System.out.println("Desea agregar una página al libro:");
        String opcion = in.nextLine();
        while(opcion.equalsIgnoreCase("si")){
            libro.agregaPagina();
            System.out.println("Desea agregar otra página al libro:");
            opcion = in.nextLine();
        }
        this.getLibros().add(libro);
    }
}
