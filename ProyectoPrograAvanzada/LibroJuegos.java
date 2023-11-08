package ProyectoPrograAvanzada;
import java.util.ArrayList;
import java.util.Scanner;

public class LibroJuegos {
    static LibroJuegos instancia;
    private ArrayList<Persona> jugadores = new ArrayList<Persona>();
    private ArrayList<Libro> libros = new ArrayList<Libro>();
    private Persona jugadorActual;

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
    
    public Persona getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(Persona jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    public void registrarse(){
        Scanner in = new Scanner(System.in);
        String nombre = in.nextLine();
        String contraseña = in.nextLine();
        this.getJugadores().add(new Persona(nombre, contraseña,this.getLibros()));
        in.close();
    }

    public void iniciarSesion(){
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese su nombre de usuario:\n");
        String nombre = in.nextLine();
        System.out.println("Ingrese su contraseña:\n");
        String contraseña = in.nextLine();
        for(int i=0;i<this.getJugadores().size();i++){
            if(this.getJugadores().get(i).getNombre().equalsIgnoreCase(nombre)){
                if(this.getJugadores().get(i).getPassword().equalsIgnoreCase(contraseña)){
                    this.setJugadorActual(this.getJugadores().get(i));
                    System.out.println("Bienvenido "+this.getJugadores().get(i).getNombre());
                }else{
                    System.out.println("Contraseña incorrecta");
                }
            }else{
                System.out.println("Usuario incorrecto");
            }
        }
        
    }

    public void jugar(){
        Scanner in = new Scanner(System.in);
        for(int i=0;i<this.getLibros().size();i++){
            this.getLibros().get(i).mostrarDatos();
            System.out.println("------------------------------------------------------------");
        }
        System.out.println("Cual libro desea leer:\n");
        int opcion = in.nextInt();
        this.getJugadorActual().getLibros().get(opcion).pedirNombre();
        this.getJugadorActual().getLibros().get(opcion).siguientePagina(0); 
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

    public void editarLibro(){
        Scanner in = new Scanner(System.in);
        System.out.println("Cual libro desea editar");
        for(int i=0;i<this.getLibros().size();i++){
            System.out.println(i+" "+this.getLibros().get(i).getTitulo());
        }
        int opcion = in.nextInt();
        System.out.println("Que desea editar:\n");
        System.out.println("1. Titulo\n");
        System.out.println("2. Autor\n");
        System.out.println("3. Sinopsis\n");
        System.out.println("4. Páginas\n");
        int opcion2 = in.nextInt();
        if(opcion2==1){
            System.out.println("Ingrese el nuevo titulo:\n");
            String titulo = in.nextLine();
            this.getLibros().get(opcion).setTitulo(titulo);
            System.out.println("Titulo cambiado\n");
        }
        if(opcion2==2){
            System.out.println("Ingrese el nuevo autor:\n");
            String autor = in.nextLine();
            this.getLibros().get(opcion).setAutor(autor);
            System.out.println("Autor cambiado\n");
        }
        if(opcion2==3){
            System.out.println("Ingrese la nueva sinopsis:\n");
            String sinopsis = in.nextLine();
            this.getLibros().get(opcion).setSinopsis(sinopsis);
            System.out.println("Sinopsis cambiada\n");
        }
        if(opcion2==4){
            System.out.println("Que desea hacer:\n");
            System.out.println("1. Agregar página\n");
            System.out.println("2. Eliminar página\n");
            int opcion3 = in.nextInt();
            if(opcion3==1){
                this.getLibros().get(opcion).agregaPagina();
            }
            if(opcion3==2){
                System.out.println("Cual página desea eliminar:\n");
                for(int i=0;i<this.getLibros().get(opcion).getPaginas().size();i++){
                    System.out.println(i+" "+this.getLibros().get(opcion).getPaginas().get(i).getDescripcion());
                }
                int opcion4 = in.nextInt();
                this.getLibros().get(opcion).remuevePagina(opcion4);
                System.out.println("Página eliminada\n");
            }
        }
    }
}
