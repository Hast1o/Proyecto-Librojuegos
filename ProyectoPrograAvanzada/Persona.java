package ProyectoPrograAvanzada;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Persona {
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
}
