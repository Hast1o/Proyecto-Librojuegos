package ProyectoPrograAvanzada;

public class Main {
    public static void main (String[] args){
        LibroJuegos juego = new LibroJuegos();
        Pagina pagina;
        FactoryPagina fabrica;
        fabrica = new ConcretePaginaFinal();
        Libro l1 = new Libro("Nicolas Cabrera","La llamada","Eres un estudiante al cual acosan constantemente por celular"); 
        Libro l2 = new Libro("Matias Cabrera","Nadie me toma en cuenta","Eres el hermano del medio"); 
        pagina = fabrica.creaPagina();
        
        juego.registrarse();
        System.out.println(juego.getJugadores().get(0));
        juego.jugar();
    }
}
