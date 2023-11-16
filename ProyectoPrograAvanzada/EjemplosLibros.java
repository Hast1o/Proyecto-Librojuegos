package ProyectoPrograAvanzada;

public class EjemplosLibros{
    private Libro l1;
    
    EjemplosLibros(){
        this.setL1(new Libro("Consola","Batalla contra los zombies","Eres un estudiante que debe sobrevivir al apocalipsis zombie"));
        Opcion o0 = new Opcion(new StringBuilder("Salir"), 0, "Sin utilizar");
        PaginaNodo p = new PaginaNodo(new StringBuilder("NOMBREJUGADOR se ha quedado sin alimentos y busca un medio de transporte para salir a buscar comida"),"Nodo","Sin revisar",1);
        Opcion o1 = new Opcion(new StringBuilder("Robas una moto (ve a la pagina 2)"),2,"Sin utilizar");
        Opcion o2 = new Opcion(new StringBuilder("Vas a pie (ve a la pagina 2)"),2,"Sin utilizar");
        Opcion o3 = new Opcion(new StringBuilder("Coges una bicicleta (ve a la pagina 2)"),2,"Sin utilizar");
        p.getOpciones().add(o1);
        p.getOpciones().add(o2);
        p.getOpciones().add(o3);
        l1.getPaginas().add(p);
        PaginaNodo p2 = new PaginaNodo(new StringBuilder("NOMBREJUGADOR ha conseguido un transporte y ahora analiza donde buscar la comida"),"Nodo","Sin revisar",2);
        Opcion o4 = new Opcion(new StringBuilder("Decides ir al supermercado (ve a la pagina 3)"),3,"Sin utilizar");
        Opcion o5 = new Opcion(new StringBuilder("Decides ir al mall (ve a la pagina 4)"),4,"Sin utilizar");
        Opcion o6 = new Opcion(new StringBuilder("Decides ir a la casa de su vecino (ve a la pagina 5)"),5,"Sin utilizar");
        p2.getOpciones().add(o4);
        p2.getOpciones().add(o5);
        p2.getOpciones().add(o6);
        l1.getPaginas().add(p2);
        PaginaInicio p3 = new PaginaInicio(new StringBuilder("NOMBREJUGADOR Llega al supermercado y ve que está infestado de zombies pero le gana el hambre y decide entrar de todas formas, los zombies deboran tu cerebro aunque resulta que es un sueño."),"inicio","Sin revisar",3);
        Opcion o7 = new Opcion(new StringBuilder("Volver al inicio"),1,"Sin utilizar");
        p3.getOpciones().add(o7);
        l1.getPaginas().add(p3);
        PaginaNodo p4 = new PaginaNodo(new StringBuilder("Ya en el mall NOMBREJUGADOR observa que está totalmente vacio y la tienda de abarrotes está totalmente abastecida"),"Nodo","Sin revisar",4);
        Opcion o8 = new Opcion(new StringBuilder("Como está vacio y nadie te apura te colocas a consumir lo que encuentras (ve a la pagina 6)"), 6,"Sin utilizar");
        Opcion o9 = new Opcion(new StringBuilder("Tomas lo necesario y vuelves a tu casa (ve a la pagina 7)"), 7, "Sin utilizar"); 
        Opcion o10 = new Opcion(new StringBuilder("Decides revisar bien todo el mall antes de entrar a la tienda por recursos (ve a la pagina 8)"), 8, "Sin utilizar");
        p4.getOpciones().add(o8);
        p4.getOpciones().add(o9);
        p4.getOpciones().add(o10);
        l1.getPaginas().add(p4);
        PaginaNodo p5 = new PaginaNodo(new StringBuilder("NOMBREJUGADOR llega donde su vecino quien le abre las puertas de su casa sin dudarlo"), "Nodo", "Sin revisar", 5);
        Opcion o11 = new Opcion(new StringBuilder("Le pides si por favor te puede convidar algo de alimentos (ve a la pagina 7)"), 7, "Sin utilizar");
        Opcion o12 = new Opcion(new StringBuilder("Lo golpeas y le robas la comida (ve a la pagina 10)"), 10, "Sin utilizar");
        Opcion o13 = new Opcion(new StringBuilder("Le propones ir al mall (Ve a la pagina 4)"), 4, "Sin utilizar");
        p5.getOpciones().add(o11);
        p5.getOpciones().add(o12);
        p5.getOpciones().add(o13);
        l1.getPaginas().add(p5);
        PaginaNodo p6 = new PaginaNodo(new StringBuilder("Al comer haces demasiado ruido y despiertas a los zombies que estaban en los baños del centro comercial"), "Nodo", "Sin revisar", 6);
        Opcion o14 = new Opcion(new StringBuilder("Tratas de enfrentarte a los zombies (ve a la pagina 10)"), 10, "Sin utilizar");
        Opcion o15 = new Opcion(new StringBuilder("Alcanzas a escapar antes de que te deboren (ve a la pagina 9)"), 9, "Sin utilizar");
        Opcion o16 = new Opcion(new StringBuilder("Tomas unas bolsas sin pensarlo y huyes como puedes del lugar (ve a la pagina 7)"), 7, "Sin utilizar");
        p6.getOpciones().add(o14);
        p6.getOpciones().add(o15);
        p6.getOpciones().add(o16);
        l1.getPaginas().add(p6);
        PaginaFinal p7 = new PaginaFinal(new StringBuilder("Consigues alimento, llegas a tu casa y vives un par de meses mas"), "Final", "Sin revisar", 7);
        p7.getOpciones().add(o0);
        l1.getPaginas().add(p7);
        PaginaNodo p8 = new PaginaNodo(new StringBuilder("NOMBREJUGADOR revisa los baños y se da cuenta que está lleno de zombies"),"Nodo","Sin revisar",8);
        Opcion o17 = new Opcion(new StringBuilder("Vuelves a la tienda en silencio y tomas lo que necesitas (ve a la pagina 7)"), 7,"Sin utilizar");
        Opcion o18= new Opcion(new StringBuilder("Tratas de bloquear la puerta del baño (ve a la pagina 10)"), 10, "Sin utilizar"); 
        Opcion o19 = new Opcion(new StringBuilder("huyes como puedes(ve a la pagina 9)"), 9, "Sin utilizar");
        p8.getOpciones().add(o17);
        p8.getOpciones().add(o18);
        p8.getOpciones().add(o19);
        l1.getPaginas().add(p8);
        PaginaFinal p9 = new PaginaFinal(new StringBuilder("Arrancas pero no consigues alimento y debes pasar hambre unos dias"), "Final", "Sin revisar", 9);
        p7.getOpciones().add(o0);
        l1.getPaginas().add(p9);
        PaginaFinal p10 = new PaginaFinal(new StringBuilder("Gracias a tu imprudencia eres brutalmente asesinado"), "Final", "Sin revisar", 10);
        p7.getOpciones().add(o0);
        l1.getPaginas().add(p10);
    }

    public Libro getL1() {
        return l1;
    }


    public void setL1(Libro l1) {
        this.l1 = l1;
    }


    
}