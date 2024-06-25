package taller9.pkg10;
import java.util.Scanner;
import java.util.Scanner;
public class Ejercicio2 {
}
class Pelicula {
    public String titulo;
    public String autor;
    public int anioEdicion;
    public String[] idiomas;
    public double precioAlquiler;
    // Constructor de la clase Pelicula
    public Pelicula(String titulo, String autor, int anioEdicion, String[] idiomas) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioEdicion = anioEdicion;
        this.idiomas = idiomas;
    }
    public static void main(String[] args) {
        // Ejemplo de creación de películas
        String[] idiomasDVD = {"Español Latino", "Inglés"};
        DVD peliculaDVD = new DVD("Titanic", "James Cameron", 1997, idiomasDVD, 4.7);

        String[] idiomasVHS = {"Español"};
        VHS peliculaVHS = new VHS("E.T.", "Steven Spielberg", 1982, idiomasVHS, "Tipo 1");

        // Mostrar información y precio de alquiler
        System.out.println("Película en DVD:");
        mostrarInformacionYPrecio(peliculaDVD);

        System.out.println("\nPelícula en VHS:");
        mostrarInformacionYPrecio(peliculaVHS);
    }
    // Método para mostrar información y precio de alquiler de una película
    private static void mostrarInformacionYPrecio(Pelicula pelicula) {
        System.out.println("Título: " + pelicula.titulo);
        System.out.println("Autor: " + pelicula.autor);
        System.out.println("Año de Edición: " + pelicula.anioEdicion);
        System.out.print("Idiomas: ");
        for (String idioma : pelicula.idiomas) {
            System.out.print(idioma + " ");
        }
        System.out.println("\nPrecio de alquiler: $" + pelicula.calcularPrecioAlquiler());
    }
    // Método para calcular el precio de alquiler
    public double calcularPrecioAlquiler() {
        int precioAlquiler=10;
        return precioAlquiler;
    }
}
// Clase DVD que hereda de Pelicula
class DVD extends Pelicula {
    private double capacidadGb;
    // Constructor de la clase DVD
    public DVD(String titulo, String autor, int anioEdicion, String[] idiomas, double capacidadGb) {
        super(titulo, autor, anioEdicion, idiomas);
        this.capacidadGb = capacidadGb;
        this.precioAlquiler = calcularPrecioAlquiler();
    }
    // Método para calcular el precio de alquiler (DVD es 10% más caro que VHS)
    @Override
    public double calcularPrecioAlquiler() {
        return 1.1 * super.calcularPrecioAlquiler(); // DVD es 10% más caro que VHS
    }
}
// Clase VHS que hereda de Pelicula
class VHS extends Pelicula {
    private String tipoCinta; // Tipo de cinta magnética
    // Constructor de la clase VHS
    public VHS(String titulo, String autor, int anioEdicion, String[] idiomas, String tipoCinta) {
        super(titulo, autor, anioEdicion, idiomas);
        this.tipoCinta = tipoCinta;
        this.precioAlquiler = calcularPrecioAlquiler();
    }
    // Método para calcular el precio de alquiler
    @Override
    public double calcularPrecioAlquiler() {
        return 10; // Precio base de VHS
    }
}
