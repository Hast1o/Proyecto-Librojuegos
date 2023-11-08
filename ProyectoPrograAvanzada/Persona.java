package ProyectoPrograAvanzada;

public class Persona {
    private String nombre;
    private String password;

    Persona(){
        this.setNombre("Nuevo usuario");
        this.setPassword("12345678");
    }

    Persona(String _nombre,String _password){
        this.setNombre(_nombre);
        this.setPassword(_password);
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void creaLibro(LibroJuegos juego){
        juego.agregarLibro();
    }

    public void agregaPagina(Libro L){
        
    }
    public void jugar(LibroJuegos juego){
        juego.jugar();
    }

    public void configurarUsuario(){

    }
}
