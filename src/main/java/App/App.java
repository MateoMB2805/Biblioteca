package App;

import java.util.*;

import Model.Biblioteca;



public class App {
    public static void main(String[] args) {
        // Crear una instancia de la Biblioteca
        Biblioteca miBiblioteca = new Biblioteca("Biblioteca Central");

        // Crear Bibliotecarios
        miBiblioteca.crearBibliotecario("Juan Pérez", "12345678", "123-4567", "juan@biblioteca.com", 1500.0);
        miBiblioteca.crearBibliotecario("Ana López", "87654321", "987-6543", "ana@biblioteca.com", 1800.0);

        // Crear Estudiantes
        miBiblioteca.crearEstudiante("Carlos García", "23456789", "234-5678", "carlos@estudiante.com", "Ingeniería");
        miBiblioteca.crearEstudiante("María González", "34567890", "345-6789", "maria@estudiante.com", "Derecho");

        // Crear Libros
        Calendar cal = Calendar.getInstance();
        cal.set(2020, Calendar.JANUARY, 1); // Fecha de publicación
        miBiblioteca.crearLibro("L001", "978-3-16-148410-0", "Autor 1", "Libro de Java", "Editorial A", cal.getTime(), 5);
        miBiblioteca.crearLibro("L002", "978-1-23-456789-7", "Autor 2", "Libro de Python", "Editorial B", cal.getTime(), 3);

        // Crear Préstamo
        Calendar fechaPrestamo = Calendar.getInstance();
        miBiblioteca.crearPrestamo("P001", fechaPrestamo.getTime(), "23456789", "12345678", "L001");

       

        
        // Consultar libro por código
        miBiblioteca.consultarLibroPorCodigo("L001");

    }
}
