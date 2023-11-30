import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Biblioteca {
    private ArrayList<Libro> libros;
    private HashMap<String, Usuario> usuarios;

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new HashMap<>();
    }

    public void agregarLibro(Libro libro) {

        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo.");
        }

        libros.add(libro);
        System.out.println("Libro agregado a la biblioteca: " + libro);
    }

    public void eliminarLibro(Libro libro) {
        libros.remove(libro);
        System.out.println("Libro eliminado de la biblioteca: " + libro);
    }

    public void registrarUsuario(Usuario usuario) {

        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo.");
        }

        usuarios.put(usuario.getId(), usuario);
        System.out.println("Usuario registrado: " + usuario);
    }

    public void alquilarLibro(Usuario usuario, Libro libro) {
        if (libros.contains(libro)) {
            usuario.alquilarLibro(libro);
            System.out.println("Libro alquilado por el usuario: " + usuario);
        } else {
            System.out.println("El libro no está disponible en la biblioteca.");
        }
    }

    public void devolverLibro(Usuario usuario, Libro libro) throws BibliotecaException {
        if (!usuario.tieneLibroAlquilado(libro)) {
            throw new BibliotecaException("El usuario no tiene este libro alquilado.");
        }
        usuario.devolverLibro(libro);
        System.out.println("Libro devuelto por el usuario: " + usuario);
    }

    public ArrayList<Libro> buscarLibros(String criterio, String valor) {
        return libros.stream()
                .filter(libro -> libro.cumpleCriterio(criterio, valor))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void generarInforme() {
        System.out.println("Generando informe...");

    }
}