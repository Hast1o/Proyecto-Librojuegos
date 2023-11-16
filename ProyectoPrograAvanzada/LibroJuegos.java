package ProyectoPrograAvanzada;

import java.util.ArrayList;
import java.util.Scanner;

public class LibroJuegos implements SujetoObservable {
    static LibroJuegos instancia;
    private ArrayList<Persona> jugadores = new ArrayList<Persona>();
    private ArrayList<Libro> libros = new ArrayList<Libro>();
    private Persona jugadorActual = null;

    public LibroJuegos() {
        this.getLibros().add(new EjemplosLibros().getL1());
    }

    public static LibroJuegos getInstancia() {
        if (instancia == null) {
            instancia = new LibroJuegos();
        }
        return instancia;
    }

    public ArrayList<Persona> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Persona> jugadores) {
        this.jugadores = jugadores;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public Persona getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(Persona jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    public void registrarse() {
        Scanner entrada4 = new Scanner(System.in);
        System.out.println("Nombre de usuario:");
        String nombre = entrada4.nextLine();
        System.out.println("Contraseña:");
        String contraseña = entrada4.nextLine();
        Persona p = new Persona(nombre, contraseña, this.getLibros());
        this.getJugadores().add(p);
        System.out.println("Usuario creado exitosamente");
    }

    public void iniciarSesion() {
        if (this.getJugadorActual() != null) {
            System.out.println("Ya hay un usuario en linea, cierre sesion e intentelo nuevamente");
        } else {
            Scanner entrada5 = new Scanner(System.in);
            System.out.println("Ingrese su nombre de usuario:");
            String nombre = entrada5.nextLine();
            System.out.println("Ingrese su contraseña:");
            String contraseña = entrada5.nextLine();
            for (int i = 0; i < this.getJugadores().size(); i++) {
                if (this.getJugadores().get(i).getNombre().equals(nombre)) {
                    if (this.getJugadores().get(i).getPassword().equals(contraseña)) {
                        this.setJugadorActual(this.getJugadores().get(i));
                        System.out.println("Bienvenido " + this.getJugadores().get(i).getNombre());
                    }else{
                        System.out.println("Usuario o contraseña incorrectos");
                    }
                }else{
                    System.out.println("Usuario o contraseña incorrectos");
                }
            }
            
        }
    }

    public void jugar() {
        Scanner entrada6 = new Scanner(System.in);
        int opcion = 0;
        if (this.getJugadorActual() == null) {
            System.out.println("No hay ningun jugador en linea");
        } else {
            if (this.getLibros().size() > 0) {
                do {
                    System.out.println(
                            "Para comenzar a jugar debes escoger un libro de entre todas las opciones validas\nluego deberas escoger un nombre, el cual será tu identificador a lo largo de esta aventura\ncada opcion indica la pagina a la cual te llevará por ende solo debes escoger una [1-2-3]\nlas paginas de inicio solo tienen una opcion, volver al principio, las de tipo nodo cuenta con 3 posibles opciones y las de tipo final terminan el cuento.");
                            System.out.println("IMPORTANTE las opciones que hayas utilizado no estarán disponibles nuevamente en caso de que vuelvas al inicio.\n");
                    try {
                        for (int i = 0; i < this.getLibros().size(); i++) {
                            System.out.println("Libro " + (i + 1));
                            System.out.println("Titulo: " + this.getLibros().get(i).getTitulo());
                            System.out.println("Sinopsis: " + this.getLibros().get(i).getSinopsis());
                            System.out.println("Autor: " + this.getLibros().get(i).getAutor());
                            System.out.println("Numero de paginas: " + this.getLibros().get(i).getPaginas().size());
                            System.out.println("Estado: "+this.getLibros().get(i).getEstado());
                        }
                        System.out.println("Cual libro desea leer:");
                        String entrada = entrada6.nextLine();
                        opcion = Integer.parseInt(entrada);
                    } catch (NumberFormatException e) {
                    }
                    if ((opcion) <= 0 || (opcion) > this.getLibros().size()) {
                        System.out.println("Opcion invalida");
                    }
                } while ((opcion) <= 0 || (opcion) > this.getLibros().size());

                this.getJugadorActual().getLibros().get((opcion - 1)).setEstado("Sin revisar");
                if (this.getLibros().get(opcion - 1).getPaginas().size() == 0) {
                    System.out.println("El libro no tiene paginas");
                } else {
                    this.getJugadorActual().getLibros().get((opcion - 1)).pedirNombre();
                    this.getJugadorActual().getLibros().get((opcion - 1)).siguientePagina(1, this);
                }
            } else {
                System.out.println("No hay ningun libro creado");
            }

        }
    }

    public void agregarLibro() {
        if (this.getJugadorActual() == null) {
            System.out.println("No hay ningun jugador en linea");
        } else {
            System.out.println(
                    "Para crear un libro debes hacerlo con un nombre, una descripcion y un numero de paginas a tu criterio [0...N], el autor por defecto será quien cree el escrito");
            System.out.println(
                    "se te preguntará cada vez que quieras agregar una pagina si esta sera de tipo\nnodo (con 3 opciones)\ninicio (volver al principio)\nfinal (concluyen la historia)");
            System.out.println(
                    "las opciones que crees te pediran siempre que ingreses una direccion la cual es clave para avanzar en la historia\nlas opciones que te lleven al principio llevaran siempre el numero 1 y las de final terminaran la historia llevandote a la pagina 0 o al menu principal");
            System.out.println(
                    "si te equivocas no te preocupes puedes editar el libro en cualquier momento desde el menu");
            System.out.println(
                    "IMPORTANTE si deseas que el nombre del jugador se refleje en tu historia debes escribir en la narrativa de la pagina o de la opcion la palabra NOMBREJUGADOR (en mayúsculas)");
            System.out.println("Ejemplo: NOMBREJUGADOR es atacado.");
            System.out.println("de esta forma cuando alguien ingrese un nombre se reflejará de la siguiente forma");
            System.out.println("Nicolas es atacado\n-------------------------------------------------------");
            Scanner entrada7 = new Scanner(System.in);
            System.out.println("Ingrese el nombre del libro:");
            String nombre = entrada7.nextLine();
            System.out.println("Ingrese la descripción del libro:");
            String descripcion = entrada7.nextLine();
            Libro libro = new Libro(this.getJugadorActual().getNombre(), nombre, descripcion);
            System.out.println("Desea agregar una página al libro (si/no)");
            String opcion = entrada7.nextLine();
            while (opcion.equalsIgnoreCase("si")) {
                libro.agregaPagina();
                System.out.println("Desea agregar otra página al libro (si/no)");
                opcion = entrada7.nextLine();
            }
            System.out.println("Libro creado exitosamente");
            for (int i = 0; i < this.getJugadores().size(); i++) {
                this.getJugadores().get(i).getLibros().add(libro);
            }
        }
    }

    public void editarLibro() {
        if (this.getLibros().size() == 0) {
            System.out.println("No hay libros para editar");
        } else {
            if (this.getJugadorActual() == null) {
                System.out.println("No hay ningun jugador en linea");
            } else {
                Scanner entrada8 = new Scanner(System.in);
                Scanner entrada9 = new Scanner(System.in);
                Scanner entrada10 = new Scanner(System.in);
                Scanner entrada11 = new Scanner(System.in);
                Scanner entrada12 = new Scanner(System.in);
                int opcionLibro = 0;
                int accion = 0;
                int accionPagina = 0;
                int opcionPagina = 0;
                do {
                    try {
                        System.out.println("Cual libro desea editar");
                        for (int i = 0; i < this.getLibros().size(); i++) {
                            System.out.println((i + 1) + " " + this.getLibros().get(i).getTitulo());
                        }
                        String entrada = entrada8.nextLine();
                        opcionLibro = Integer.parseInt(entrada);
                    } catch (NumberFormatException e) {
                    }
                    if ((opcionLibro) <= 0 || (opcionLibro) > this.getLibros().size()) {
                        System.out.println("Opcion invalida");
                    }
                } while ((opcionLibro) <= 0 || (opcionLibro) > this.getLibros().size());

                if (this.getJugadorActual().getNombre() != this.getLibros().get(opcionLibro - 1).getAutor()) {
                    System.out.println("Solo el autor del libro puede editarlo");
                    this.menuOpciones();
                } else {
                    try {
                        System.out.println("Que desea editar:");
                        System.out.println("1. Titulo");
                        System.out.println("2. Autor");
                        System.out.println("3. Sinopsis");
                        System.out.println("4. Páginas");
                        System.out.println("5. Eliminar");
                        String entrada = entrada8.nextLine();
                        accion = Integer.parseInt(entrada);
                    } catch (NumberFormatException e) {
                    }
                    if (accion < 1 || accion > 5) {
                        System.out.println("Opcion invalida");
                    }
                }
                while (accion < 1 || accion > 5)
                    ;
                if (accion == 1) {
                    System.out.println("Ingrese el nuevo titulo:");
                    String titulo = entrada10.nextLine();
                    this.getLibros().get((opcionLibro - 1)).setTitulo(titulo);
                    this.notificar((opcionLibro - 1), accion, titulo, null, 0, 0);
                    System.out.println("Titulo cambiado");
                }
                if (accion == 2) {
                    System.out.println("Ingrese el nuevo autor:");
                    String autor = entrada10.nextLine();
                    this.getLibros().get((opcionLibro - 1)).setAutor(autor);
                    this.notificar((opcionLibro - 1), accion, autor, null, 0, 0);
                    System.out.println("Autor cambiado");
                }
                if (accion == 3) {
                    System.out.println("Ingrese la nueva sinopsis:");
                    String sinopsis = entrada10.nextLine();
                    this.getLibros().get((opcionLibro - 1)).setSinopsis(sinopsis);
                    this.notificar((opcionLibro - 1), accion, sinopsis, null, 0, 0);
                    System.out.println("Sinopsis cambiada");
                }
                if (accion == 4) {
                    do {
                        try {
                            System.out.println("Que desea hacer:");
                            System.out.println("1. Agregar página");
                            System.out.println("2. Eliminar página");
                            String entrada = entrada11.nextLine();
                            accionPagina = Integer.parseInt(entrada);
                        } catch (NumberFormatException e) {
                        }
                        if (accionPagina < 1 || accionPagina > 2) {
                            System.out.println("Opcion invalida");
                        }
                    } while (accionPagina < 1 || accionPagina > 2);
                    if (accionPagina == 1) {
                        Pagina p;
                        FactoryPagina fabrica;
                        fabrica = new ConcretePaginaFinal();
                        p = fabrica.creaPagina();
                        p.creaOpciones();
                        this.getLibros().get((opcionLibro - 1)).getPaginas().add(p);
                        this.notificar((opcionLibro - 1), accion, "", p, 0, accionPagina);
                        System.out.println("Pagina agregada con exito");
                    }
                    if (accionPagina == 2) {
                        do {
                            try {
                                System.out.println("Cual página desea eliminar:");
                                for (int i = 0; i < this.getLibros().get((opcionLibro - 1)).getPaginas().size(); i++) {
                                    System.out.println((i + 1) + " " + this.getLibros().get((opcionLibro - 1))
                                            .getPaginas().get(i).getDescripcion());
                                }
                                String entrada = entrada12.nextLine();
                                opcionPagina = Integer.parseInt(entrada);
                            } catch (NumberFormatException e) {
                            }
                            if (opcionPagina <= 0
                                    || opcionPagina > this.getLibros().get((opcionLibro - 1)).getPaginas().size()) {
                                System.out.println("Opcion invalida");
                            }
                        } while (opcionPagina <= 0
                                || opcionPagina > this.getLibros().get((opcionLibro - 1)).getPaginas().size());
                        this.getLibros().get((opcionLibro - 1)).remuevePagina(opcionPagina - 1);
                        this.notificar((opcionLibro - 1), accion, "", null, opcionPagina - 1, accionPagina);
                        System.out.println("Página eliminada");
                    }
                }
                if (accion == 5) {
                    for (int i = 0; i < this.getJugadores().size(); i++) {
                        this.getJugadores().get(i).getLibros().remove((opcionLibro - 1));
                        System.out.println("Libro eliminado con exito");
                    }
                }
            }
        }
    }

    public void cerrarSesion() {
        System.out.println("Cerrando sesion.........");
        this.setJugadorActual(null);
        System.out.println("Sesion cerrada");
    }

    public void menuOpciones() {
        Scanner entrada13 = new Scanner(System.in);
        int opcion = 0;
        do {
            try {
                System.out.println("----------------------------------------------------------------------------------------------------");
                System.out.println("Bienvenido a libro juegos, que desea hacer");
                System.out.println(  "1) Registrarse\n2) Iniciar sesion\n3) Jugar\n4) Agregar libro\n5) Editar libro\n6) Cerrar sesion\n7) Salir");
                System.out.println("Digite una opcion");
                String entrada = entrada13.nextLine();
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
            }
            if (opcion < 1 || opcion > 7) {
                System.out.println("Opcion invalida");
            }
        } while (opcion < 1 || opcion > 7);
        if (opcion == 1) {
            this.registrarse();
            this.menuOpciones();
        }
        if (opcion == 2) {
            this.iniciarSesion();
            this.menuOpciones();
        }
        if (opcion == 3) {
            this.jugar();
        }
        if (opcion == 4) {
            this.agregarLibro();
            this.menuOpciones();
        }
        if (opcion == 5) {
            this.editarLibro();
            this.menuOpciones();
        }
        if (opcion == 6) {
            if (this.getJugadorActual() != null) {
                this.cerrarSesion();
            } else {
                System.out.println("No hay ninguna sesion iniciada");
            }
            this.menuOpciones();
        }
        if (opcion == 7) {
            if (this.getJugadorActual() != null) {
                this.cerrarSesion();
            }
            System.out.println("Cerrando el juego..........");
            System.out.println("Adios.");
        }
    }

    @Override
    public void notificar(int numLibro, int opcion, String cambio, Pagina P, int numPag, int opcion2) {
        if (opcion == 1) {
            for (Persona persona : jugadores) {
                persona.actualizar(numLibro, opcion, cambio);
            }
        }
        if (opcion == 2) {
            for (Persona persona : jugadores) {
                persona.actualizar(numLibro, opcion, cambio);
            }
        }
        if (opcion == 3) {
            for (Persona persona : jugadores) {
                persona.actualizar(numLibro, opcion, cambio);
            }
        }
        if (opcion == 4) {
            if (opcion2 == 1) {
                for (Persona persona : jugadores) {
                    persona.actualizar(numLibro, P, numPag, opcion2);
                }
            }
            if (opcion2 == 2) {
                for (Persona persona : jugadores) {
                    persona.actualizar(numLibro, P, numPag, opcion2);
                }
            }
        }
    }

}
