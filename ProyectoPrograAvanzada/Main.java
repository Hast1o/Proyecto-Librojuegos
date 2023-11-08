package ProyectoPrograAvanzada;

public class Main {
    public static void main (String[] args){
        LibroJuegos juego = new LibroJuegos();
        /* Libro l1 = new Libro("Nicolas Cabrera","La llamada","Eres un estudiante al cual acosan constantemente por celular"); 
        Libro l2 = new Libro("Matias Cabrera","Nadie me toma en cuenta","Eres el hermano del medio");  */
        juego.agregarLibro();
        juego.getLibros().get(0).mostrarDatos();
    }
}
