package ProyectoPrograAvanzada;

public class ConcretePaginaNodo extends FactoryPagina {
    @Override
    public Pagina creaPagina(StringBuilder _descripcion,int _numero){
        return new PaginaNodo(_descripcion,"Nodo","Sin revisar",_numero);
    }
    
}
