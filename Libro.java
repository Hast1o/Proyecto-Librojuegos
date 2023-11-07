package ProyectoPrograAvanzada;

import java.util.ArrayList;
import java.util.Scanner;

public class Libro {
    private String autor;
    private String titulo;
    private String sinopsis;
    private ArrayList<Pagina> paginas = new ArrayList<Pagina>();
    private String estado;
    private String nombreJugador;

    Libro(){
        this.setAutor("autor");
        this.setTitulo("titulo");
        this.setSinopsis("sinopsis");
        ArrayList<Pagina> paginas = new ArrayList<Pagina>();
        this.setEstado("Sin terminar");
        this.setNombreJugador("Nuevo Jugador");
    }

    Libro(String _autor,String _titulo,String _sinopsis){
        this.setAutor(_autor);
        this.setTitulo(_titulo);
        this.setSinopsis(_sinopsis);
        ArrayList<Pagina> paginas = new ArrayList<Pagina>();
        this.setEstado("Sin leer");
        this.setNombreJugador("Nuevo Jugador");
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public ArrayList<Pagina> getPaginas() {
        return paginas;
    }
    public void setPaginas(ArrayList<Pagina> paginas) {
        this.paginas = paginas;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getNombreJugador() {
        return nombreJugador;
    }
    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public void mostrarDatos(){
        System.out.println(this.getTitulo());
        System.out.println(this.getSinopsis());
        System.out.println(this.getAutor());
        System.out.println("Numero de páginas: "+this.paginas.size());
        System.out.println("Estado: "+this.getEstado());  
    }

    public void pedirNombre(){
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese su nombre para comenzar su aventura:\n");
        this.setNombreJugador(in.nextLine());
        in.close();
        for(int i=0;i<paginas.size();i++){
            this.paginas.get(i).cambiaNombre(this.getNombreJugador());
        }
    }
    public void agregaPagina(Pagina p){
        this.getPaginas().add(p);
    }

    public void siguientePagina(int numpag){
        this.getPaginas().get(numpag).mostrarDatos(this);
    }


}
