package ProyectoPrograAvanzada;
import java.util.Scanner;

public abstract class FactoryPagina {
    public abstract Pagina creaPagina(StringBuilder _descripcion,int _numero);

    public Pagina creaPagina(){
        Scanner in = new Scanner(System.in);
        System.out.println("De que tipo será la página: Nodo - Final - Inicio\n");
        String _tipo = in.nextLine();
        if(_tipo.equalsIgnoreCase("final")){
            int _numero;
            System.out.println("Agregue La descripción de la página:\n");
            StringBuilder _descripcion = new StringBuilder(in.nextLine());
            System.out.println("Ingrese el número de la página:\n");
            _numero = in.nextInt();
            return new ConcretePaginaFinal().creaPagina(_descripcion, _numero);
            
            
        }
        if(_tipo.equalsIgnoreCase("nodo")){
            int _numero;
            System.out.println("Agregue La descripción de la página:\n");
            StringBuilder _descripcion = new StringBuilder(in.nextLine());
            System.out.println("Ingrese el número de la página:\n");
            _numero = in.nextInt();
            return new ConcretePaginaNodo().creaPagina(_descripcion,_numero);
        }
        if(_tipo.equalsIgnoreCase("inicio")){
            int _numero;
            System.out.println("Agregue La descripción de la página:\n");
            StringBuilder _descripcion = new StringBuilder(in.nextLine());
            System.out.println("Ingrese el número de la página:\n");
            _numero = in.nextInt();
            return new ConcretePaginaInicio().creaPagina(_descripcion,_numero);
        }
        return null;
        }            
}
