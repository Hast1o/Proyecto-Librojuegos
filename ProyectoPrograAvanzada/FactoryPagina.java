package ProyectoPrograAvanzada;
import java.util.Scanner;

public abstract class FactoryPagina {
    public abstract Pagina creaPagina(StringBuilder _descripcion,int _numero);

    public Pagina creaPagina(){
        Scanner entrada1 = new Scanner(System.in);
        Scanner entrada2 = new Scanner(System.in);
        System.out.println("De que tipo será la página: Nodo - Final - Inicio");
        String _tipo = entrada1.nextLine();
        if(_tipo.equalsIgnoreCase("final")){
            System.out.println("Agregue La descripción de la página:");
            StringBuilder _descripcion = new StringBuilder(entrada1.nextLine());
            int _numero = 0;
            do{
                try {
                    System.out.println("Ingrese el número de la página:");
                    String entrada = entrada2.nextLine();
                    _numero = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                }if(_numero<0){
                    System.out.println("Digite una opcion valida");
                }
            } while(_numero<0);
            return new ConcretePaginaFinal().creaPagina(_descripcion, _numero);
        }
        if(_tipo.equalsIgnoreCase("nodo")){
            System.out.println("Agregue La descripción de la página:");
            StringBuilder _descripcion = new StringBuilder(entrada1.nextLine());
            int _numero = 0;
            do{
                try {
                    System.out.println("Ingrese el número de la página:");
                    String entrada = entrada2.nextLine();
                    _numero = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                }if(_numero<0){
                    System.out.println("Digite una opcion valida");
                }
            } while(_numero<0);
            return new ConcretePaginaNodo().creaPagina(_descripcion, _numero);
        }
        if(_tipo.equalsIgnoreCase("inicio")){
            System.out.println("Agregue La descripción de la página:");
            StringBuilder _descripcion = new StringBuilder(entrada1.nextLine());
            int _numero = 0;
            do{
                try {
                    System.out.println("Ingrese el número de la página:");
                    String entrada = entrada2.nextLine();
                    _numero = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                }if(_numero<0){
                    System.out.println("Digite una opcion valida");
                }
            } while(_numero<0);
            return new ConcretePaginaInicio().creaPagina(_descripcion, _numero);
        }
        return null;
        }            
}
