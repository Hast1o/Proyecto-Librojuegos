package ProyectoPrograAvanzada;

import java.util.ArrayList;

public class PaginaInicio extends Pagina {
    PaginaInicio(){
        this.setDescripcion(new StringBuilder("descripcion"));
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        this.setTipo("tipo");
        this.setEstado("estado");
        this.setNumero(0);
    }
    PaginaInicio(StringBuilder _descripcion,String _tipo,String _estado,int _numero){
        super(_descripcion, _tipo, _estado, _numero);
    }

    @Override
    public void accion(){
        System.out.println("Has vuelto al inicio.");
    }
}