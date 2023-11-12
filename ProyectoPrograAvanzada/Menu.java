package ProyectoPrograAvanzada;

public class Menu {
    private LibroJuegos juego;

    Menu(LibroJuegos _juego){
        this.setJuego(_juego);
        
    }

    public LibroJuegos getJuego() {
        return juego;
    }

    public void setJuego(LibroJuegos juego) {
        this.juego = juego;
    }

    public void arrancar(){
        juego.menuOpciones();
    }
    
}
