package ProyectoPrograAvanzada;

public class Main {
    public static void main (String[] args){
        LibroJuegos juego = new LibroJuegos();
        Menu menu = new Menu(juego);
        menu.arrancar();
    }
}
