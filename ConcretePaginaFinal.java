package ProyectoPrograAvanzada;

public class ConcretePaginaFinal extends FactoryPagina {
    @Override
    public Pagina creaPagina(StringBuilder _descripcion,int _numero){
        return new PaginaFinal(_descripcion,"Final","Sin revisar",_numero);
    }
    
}
