package ProyectoPrograAvanzada;

import java.util.ArrayList;

public class PaginaNodo extends Pagina {
    PaginaNodo(){
        this.setDescripcion(new StringBuilder("descripcion"));
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        this.setTipo("tipo");
        this.setEstado("estado");
        this.setNumero(0);
    }
    PaginaNodo(StringBuilder _descripcion,String _tipo,String _estado,int _numero){
        super(_descripcion, _tipo, _estado, _numero);
        for(int i=0;i<3;i++){
        }
    }

    @Override
    public void accion(){
        System.out.println("Avazando hacia la siguiente página.");
    }
}