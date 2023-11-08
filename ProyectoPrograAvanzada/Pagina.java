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
    
    protected void cambiaNombre(String _nombreJugador){
        int i = this.getDescripcion().indexOf("NOMBREJUGADOR");
        while(i!=-1){
            this.getDescripcion().replace(i, i+13, _nombreJugador);
            i = this.getDescripcion().indexOf("NOMBREJUGADOR",i+_nombreJugador.length());
        }
        for(int n=0;i<opciones.size();i++){
            int j = this.getDescripcion().indexOf("NOMBREJUGADOR");
            while(j!=-1){
                this.opciones.get(n).getNarrativa().replace(j, j+13, _nombreJugador);
                j = this.getDescripcion().indexOf("NOMBREJUGADOR",i+_nombreJugador.length());
            }
        }
    }

    protected void quemarOpcion(Opcion o){
        o.setEstado("Utilizada");
    }

    protected void creaOpciones(){
        Scanner in = new Scanner(System.in);
        if(this.getTipo().equalsIgnoreCase("Nodo")){
            for(int i=0;i<3;i++){
                System.out.println("Creando Opcion "+(i+1));
                StringBuilder narrativa = new StringBuilder(in.nextLine());
                int nuevaDireccion = in.nextInt();
                in.nextLine();
                this.getOpciones().add(new Opcion(narrativa,nuevaDireccion,"Sin usar"));
            }
        }
        if(this.getTipo().equalsIgnoreCase("Final")){
            System.out.println("Creando Opcion final");
            StringBuilder narrativa = new StringBuilder(in.nextLine());
            int nuevaDireccion = in.nextInt();
            in.nextLine();
            this.getOpciones().add(new Opcion(narrativa,nuevaDireccion,"Sin usar"));
        }
        if(this.getTipo().equalsIgnoreCase("Inicio")){
            System.out.println("Creando opcion que llevará al jugador al inicio");
            StringBuilder narrativa = new StringBuilder(in.nextLine());
            int nuevaDireccion = in.nextInt();
            in.nextLine();
            this.getOpciones().add(new Opcion(narrativa,nuevaDireccion,"Sin usar"));
        }
    }

    protected void escogerOpcion(Opcion o,Libro l){
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
        }
        if(l.getEstado()!="Terminado"){
            l.siguientePagina(o.getNuevaDireccion());
        }else{
            System.out.println("Volviendo al menú principal.......");
        }
    }

    protected void mostrarDatos(Libro L){
        System.out.println(this.getDescripcion());
        System.out.println("Estas son las opciones\n");
        for(int i=0;i<this.getOpciones().size();i++){
            this.getOpciones().get(i).mostrarDatos();
        }
        Scanner in = new Scanner(System.in);
        int opcion = in.nextInt();
        while(this.getOpciones().get(opcion).getEstado()=="Utilizada"){
            System.out.println("Esta opción no está disponible, escoga otra:\n");
            opcion = in.nextInt();   
        }
        in.close();
        this.escogerOpcion(this.getOpciones().get(opcion),L);
        }   
}
