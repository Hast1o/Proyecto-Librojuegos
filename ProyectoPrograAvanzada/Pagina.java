package ProyectoPrograAvanzada;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Pagina {
    private StringBuilder descripcion;
    protected ArrayList<Opcion> opciones = new ArrayList<Opcion>();
    private String tipo;
    private String estado;
    private int numero;

    Pagina(){
        this.setDescripcion(new StringBuilder("descripcion"));
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        this.setTipo("tipo");
        this.setEstado("estado");
        this.setNumero(0);
    }

    Pagina(StringBuilder _descripcion,String _tipo,String _estado,int _numero){
        this.setDescripcion(_descripcion);
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        this.setTipo(_tipo);
        this.setEstado(_estado);
        this.setNumero(_numero);
    }

    public StringBuilder getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(StringBuilder descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Opcion> getOpciones() {
        return opciones;
    }

    public void setOpciones(ArrayList<Opcion> opciones) {
        this.opciones = opciones;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public abstract void accion();
    
    protected void cambiaNombre(String _nombreJugador,String _palabra){
        int i = this.getDescripcion().indexOf(_palabra);
        while(i!=-1){
            this.getDescripcion().replace(i, i+13, _nombreJugador);
            i = this.getDescripcion().indexOf(_palabra,i+_nombreJugador.length());
        }
        for(int n=0;i<opciones.size();i++){
            int j = this.getDescripcion().indexOf(_palabra);
            while(j!=-1){
                this.opciones.get(n).getNarrativa().replace(j, j+13, _nombreJugador);
                j = this.getDescripcion().indexOf(_palabra,i+_nombreJugador.length());
            }
        }
    }

    protected void reestableceOpciones(){
        for(int i=0;i<this.getOpciones().size();i++){
            this.getOpciones().get(i).setEstado("Sin utilizar");
        }
    }

    protected void quemarOpcion(Opcion o){
        o.setEstado("Utilizada");
    }

    protected void creaOpciones(){
        Scanner entrada14 = new Scanner(System.in);
        int nuevaDireccion = 0;
        if(this.getTipo().equalsIgnoreCase("Nodo")){
            do {
                try {
                    System.out.println("Creando Opcion ");
                    System.out.println("Ingrese una descripcion");
                    StringBuilder narrativa = new StringBuilder(entrada14.nextLine());
                    System.out.println("Ingrese la direccion");
                    String entrada = entrada14.nextLine();
                    nuevaDireccion = Integer.parseInt(entrada);
                    this.getOpciones().add(new Opcion(narrativa,nuevaDireccion,"Sin usar"));
                } catch (NumberFormatException e) {
                    System.out.println("Nueva direccion no valida");
                }
            } while (this.getOpciones().size()<3);       
        }
        
        if(this.getTipo().equalsIgnoreCase("Final")){
           do {
                try {
                    System.out.println("Creando Opcion final");
                    System.out.println("Ingrese una descripcion");
                    StringBuilder narrativa = new StringBuilder(entrada14.nextLine());
                    System.out.println("Ingrese la direccion");
                    String entrada = entrada14.nextLine();
                    nuevaDireccion = Integer.parseInt(entrada);
                    this.getOpciones().add(new Opcion(narrativa,nuevaDireccion,"Sin usar"));
                } catch (NumberFormatException e) {
                    System.out.println("Nueva direccion no valida");
                }
            } while (this.getOpciones().size()<1);   
        }
        if(this.getTipo().equalsIgnoreCase("Inicio")){
            do {
                try {
                    System.out.println("Creando Opcion que devuelve al inicio");
                    System.out.println("Ingrese una descripcion");
                    StringBuilder narrativa = new StringBuilder(entrada14.nextLine());
                    System.out.println("Ingrese la direccion");
                    String entrada = entrada14.nextLine();
                    nuevaDireccion = Integer.parseInt(entrada);
                    this.getOpciones().add(new Opcion(narrativa,nuevaDireccion,"Sin usar"));
                } catch (NumberFormatException e) {
                    System.out.println("Nueva direccion no valida");
                }
            } while (this.getOpciones().size()<1);   
        }
    }

    protected void escogerOpcion(Opcion o,Libro l,LibroJuegos juego){
        this.quemarOpcion(o);
        if(l.getPaginas().get(o.getNuevaDireccion()).tipo=="Nodo"){
            l.getPaginas().get(o.getNuevaDireccion()).accion();
        }
        if(l.getPaginas().get(o.getNuevaDireccion()).tipo=="Inicio"){
            l.getPaginas().get(o.getNuevaDireccion()).accion();
        }
        if(l.getPaginas().get(o.getNuevaDireccion()).tipo=="Final"){
            l.getPaginas().get(o.getNuevaDireccion()).accion();
            l.setEstado("Terminado");
            System.out.println("Volviendo al menú principal.......");
            l.siguientePagina(o.getNuevaDireccion(),juego);
        }
        l.siguientePagina(o.getNuevaDireccion(),juego);
        
    }
    
    protected void mostrarDatos(Libro L,LibroJuegos juego){
        System.out.println(this.getDescripcion());
        System.out.println("Estas son las opciones");
        for(int i=0;i<this.getOpciones().size();i++){
            this.getOpciones().get(i).mostrarDatos();
        }
        Scanner in = new Scanner(System.in);
        int opcion = in.nextInt();
        while(this.getOpciones().get(opcion).getEstado()=="Utilizada"){
            System.out.println("Esta opción no está disponible, escoga otra:");
            opcion = in.nextInt();   
        }
        in.close();
        this.escogerOpcion(this.getOpciones().get(opcion),L,juego);
        }   
}
