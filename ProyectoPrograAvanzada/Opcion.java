package ProyectoPrograAvanzada;
public class Opcion {
    private StringBuilder narrativa;
    private int nuevaDireccion;
    private String estado;

    Opcion(){
        this.setNarrativa(new StringBuilder("narrativa"));
        this.setNuevaDireccion(0);
    }

    Opcion(StringBuilder _narrativa,int _nuevaDireccion,String _estado){
        this.setNarrativa(_narrativa);
        this.setNuevaDireccion(_nuevaDireccion);
        this.setEstado(_estado);
    }

    public StringBuilder getNarrativa() {
        return narrativa;
    }
    public void setNarrativa(StringBuilder narrativa) {
        this.narrativa = narrativa;
    }
    public int getNuevaDireccion() {
        return nuevaDireccion;
    }
    public void setNuevaDireccion(int nuevaDireccion) {
        this.nuevaDireccion = nuevaDireccion;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void mostrarDatos(){
        System.out.println(this.getNarrativa());
    }
}
