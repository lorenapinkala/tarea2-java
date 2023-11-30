public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Libro libro1 = new Libro("El señor de los anillos", "J.R.R. Tolkien", "Fantasía");
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", "Realismo mágico");

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        Usuario usuario1 = new Usuario("001");
        biblioteca.registrarUsuario(usuario1);

        biblioteca.alquilarLibro(usuario1, libro1);

        System.out.println("Libros alquilados por el usuario: " + usuario1);

        try {
            biblioteca.devolverLibro(usuario1, libro1);
        } catch (BibliotecaException e) {
            System.out.println("Error al devolver el libro: " + e.getMessage());
        }


    }
}