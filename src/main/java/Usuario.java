import java.util.ArrayList;

public class Usuario implements Notificable {
    private String id;
    private ArrayList<Libro> librosAlquilados;

    public Usuario(String id) {

        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del usuario no puede estar vacío.");
        }

        this.id = id;
        this.librosAlquilados = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void alquilarLibro(Libro libro) {
        librosAlquilados.add(libro);
    }

    public void devolverLibro(Libro libro) {
        librosAlquilados.remove(libro);
    }

    public boolean tieneLibroAlquilado(Libro libro) {
        return librosAlquilados.contains(libro);
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("Notificación para el usuario " + id + ": " + mensaje);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", librosAlquilados=" + librosAlquilados +
                '}';
    }
}