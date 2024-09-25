package Model;

import java.util.*;




public class Biblioteca {
    private String nombre;
    private List<Bibliotecario> bibliotecarios;
    private List<Estudiante> estudiantes;
    private List<Libro> libros;
    private List<Prestamo> prestamos;
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.bibliotecarios = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
        this.libros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    // Crear Bibliotecario
    public void crearBibliotecario(String nombre, String cedula, String telefono, String correo, Double salario) {
        Bibliotecario bibliotecario = new Bibliotecario(nombre, cedula, telefono, correo, salario, null);
        bibliotecarios.add(bibliotecario);
        System.out.println("Bibliotecario " + nombre + " creado.");
    }

    // Crear Estudiante
    public void crearEstudiante(String nombre, String cedula, String telefono, String correo, String programa) {
        Estudiante estudiante = new Estudiante(nombre, cedula, telefono, correo, programa);
        estudiantes.add(estudiante);
        System.out.println("Estudiante " + nombre + " creado.");
    }

    // Crear Libro
    public void crearLibro(String codigo, String isbn, String autor, String titulo, String editorial, Date date, int unidadesDisponibles) {
        Libro libro = new Libro(codigo, isbn, autor, titulo, editorial, date, unidadesDisponibles);
        libros.add(libro);
        System.out.println("Libro " + titulo + " creado.");
    }

    // Consultar datos de un libro por código
    public Libro consultarLibroPorCodigo(String codigo) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                return libro;
            }
        }
        System.out.println("Libro no encontrado.");
        return null;
    }

    
    // Reemplazar un libro por otro
    public void reemplazarLibro(String codigoViejo, Libro nuevoLibro) {
        Libro viejo = consultarLibroPorCodigo(codigoViejo);
        if (viejo != null) {
            int indice = libros.indexOf(viejo);
            libros.set(indice, nuevoLibro); // Reemplazar el libro
            System.out.println("El libro " + nuevoLibro.getTitulo() + " ha reemplazado al libro con código " + codigoViejo);
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    // Crear Préstamo
    public void crearPrestamo(String codigo, Date date, String cedulaEstudiante, String cedulaBibliotecario, String codigoLibro) {
        Estudiante estudiante = buscarEstudiantePorCedula(cedulaEstudiante);
        Bibliotecario bibliotecario = buscarBibliotecarioPorCedula(cedulaBibliotecario);
        Libro libro = consultarLibroPorCodigo(codigoLibro);

        if (estudiante != null && bibliotecario != null && libro != null && libro.getUnidadesDisponibles() > 0) {
            Prestamo prestamo = new Prestamo(codigo, date, estudiante, bibliotecario, EstadoLibro.NO_ENTREGADO);
            prestamos.add(prestamo);
            libro.prestar(1);
            System.out.println("Préstamo creado con código: " + codigo);
        } else {
            System.out.println("No se puede crear el préstamo.");
        }
    }

    

    
    

    // Reporte: Estudiante con más préstamos
    public void estudianteConMasPrestamos() {
        Estudiante estudianteConMasPrestamos = null;
        int maxPrestamos = 0;

        for (Estudiante estudiante : estudiantes) {
            int prestamosEstudiante = 0;
            for (Prestamo prestamo : prestamos) {
                if (prestamo.getEstudiante().equals(estudiante)) {
                    prestamosEstudiante++;
                }
            }
            if (prestamosEstudiante > maxPrestamos) {
                maxPrestamos = prestamosEstudiante;
                estudianteConMasPrestamos = estudiante;
            }
        }

        if (estudianteConMasPrestamos != null) {
            System.out.println("Estudiante con más préstamos: " + estudianteConMasPrestamos.getNombre() + " con " + maxPrestamos + " préstamos.");
        } else {
            System.out.println("No hay préstamos registrados.");
        }
    }

    // Reporte: Total de dinero recaudado
    public void totalDineroRecaudado() {
        float totalRecaudado = 0;
        for (Prestamo prestamo : prestamos) {
            totalRecaudado += prestamo.getCosto();
        }
        System.out.println("Total de dinero recaudado por la biblioteca: " + totalRecaudado);
    }

    

    // Métodos auxiliares
    private Estudiante buscarEstudiantePorCedula(String cedula) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                return estudiante;
            }
        }
        return null;
    }

    private Bibliotecario buscarBibliotecarioPorCedula(String cedula) {
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula().equals(cedula)) {
                return bibliotecario;
            }
        }
        return null;
    }

    
}
