package ProyectoPrograAvanzada;

public class PaginaFinal extends Pagina {
    PaginaFinal(){
        this.setDescripcion(new StringBuilder("descripcion"));
        this.setTipo("tipo");
        this.setEstado("estado");
        this.setNumero(0);
    }
    PaginaFinal(StringBuilder _descripcion,String _tipo,String _estado,int _numero){
        super(_descripcion, _tipo, _estado, _numero);
    }

    @Override
    public void accion(){
        System.out.println("Fin.");
    }
}
