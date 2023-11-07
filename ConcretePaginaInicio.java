package ProyectoPrograAvanzada;

public class ConcretePaginaInicio extends FactoryPagina {
    @Override
    public Pagina creaPagina(StringBuilder _descripcion,int _numero){
        return new PaginaInicio(_descripcion,"Inicio","Sin revisar",_numero);
    }
    
}
