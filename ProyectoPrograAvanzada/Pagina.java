package ProyectoPrograAvanzada;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Pagina {
    private StringBuilder descripcion;
    protected ArrayList<Opcion> opciones = new ArrayList<Opcion>();
    private String tipo;
    private String estado;
    private int numero;
    private String imagen;

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
            this.getDescripcion().replace(i, i+_palabra.length(), _nombreJugador);
            i = this.getDescripcion().indexOf(_palabra,i+_nombreJugador.length());
        }
        for(int n=0;n<opciones.size();n++){
            int j = this.getDescripcion().indexOf(_palabra);
            while(j!=-1){
                this.opciones.get(n).getNarrativa().replace(j, j+_palabra.length(), _nombreJugador);
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
        if(l.getPaginas().get(o.getNuevaDireccion()-1).tipo=="Nodo"){
            l.getPaginas().get(o.getNuevaDireccion()-1).accion();
        }
        if(l.getPaginas().get(o.getNuevaDireccion()-1).tipo=="Inicio"){
            l.getPaginas().get(o.getNuevaDireccion()-1).accion();
        }
        if(l.getPaginas().get(o.getNuevaDireccion()-1).tipo=="Final"){
            l.setEstado("Terminado");
            System.out.println(l.getPaginas().get(o.getNuevaDireccion()-1).getDescripcion());
            System.out.println("Volviendo al menú principal.......");
            l.siguientePagina(o.getNuevaDireccion(),juego);
        }
        l.siguientePagina(o.getNuevaDireccion(),juego);
        
    }
    
    protected void mostrarDatos(Libro L,LibroJuegos juego){
        System.out.println(this.getDescripcion());
        System.out.println("Estas son las opciones");
        for(int i=0;i<this.getOpciones().size();i++){
            System.out.println("Opcion "+(i+1));
            this.getOpciones().get(i).mostrarDatos();
        }
        Scanner in = new Scanner(System.in);
        int opcion = 0;
        do {
            try {
                System.out.println("Que opcion tomarás");
                String entrada = in.nextLine();
                opcion = Integer.parseInt(entrada);
                }catch (NumberFormatException e){ 
                }
                if(opcion<=0||opcion>3){
                    System.out.println("Opcion invalida");
                }
        }while(opcion<=0||opcion>3||this.getOpciones().get(opcion-1).getEstado()=="Utilizada");      
        this.escogerOpcion(this.getOpciones().get(opcion-1),L,juego);
    }
          
}
