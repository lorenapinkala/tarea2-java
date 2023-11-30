public class Libro {
    private String titulo;
    private String autor;
    private String genero;

    public Libro(String titulo, String autor, String genero) {

        if (titulo == null || autor == null || genero == null ||
                titulo.trim().isEmpty() || autor.trim().isEmpty() || genero.trim().isEmpty()) {
            throw new IllegalArgumentException("Los datos del libro no pueden estar vacíos.");
        }

        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }

    public boolean cumpleCriterio(String criterio, String valor) {
        switch (criterio.toLowerCase()) {
            case "titulo":
                return titulo.toLowerCase().contains(valor.toLowerCase());
            case "autor":
                return autor.toLowerCase().contains(valor.toLowerCase());
            case "genero":
                return genero.toLowerCase().contains(valor.toLowerCase());
            default:
                return false;
        }
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}