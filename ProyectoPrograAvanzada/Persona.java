package ProyectoPrograAvanzada;


import java.util.ArrayList;

public class Persona implements Observador{
    private String nombre;
    private String password;
    private ArrayList<Libro> libros = new ArrayList<Libro>();

    Persona(){
        this.setNombre("Nuevo usuario");
        this.setPassword("12345678");
        ArrayList<Libro> libros = new ArrayList<Libro>();
    }

    Persona(String _nombre,String _password,ArrayList<Libro> _libros){
        this.setNombre(_nombre);
        this.setPassword(_password);
        this.setLibros(_libros);
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public void creaLibro(LibroJuegos juego){
        juego.agregarLibro();
    }

    public void editarLibro(LibroJuegos juego){
        juego.editarLibro();
    }

    public void jugar(LibroJuegos juego){
        juego.jugar();
    }

    public void configurarUsuario(){

    }

    @Override
    public void actualizar(int numLibro,int opcion,String cambio){
        if(opcion==1){
            this.getLibros().get(numLibro).setTitulo(cambio);
        }
        if(opcion==2){
            this.getLibros().get(numLibro).setAutor(cambio); 
        }
        if(opcion==3){
            this.getLibros().get(numLibro).setSinopsis(cambio);
        }
    }

    @Override
    public void actualizar(int numLibro,Pagina P,int pagina,int opcion2){
        if(opcion2==1){
            this.getLibros().get(numLibro).getPaginas().add(P);
        }
        if(opcion2==2){
            this.getLibros().get(numLibro).getPaginas().remove(pagina);
        }
        
    }
}
