package Model;

import java.time.LocalDate;
import java.util.Date;


public class Prestamo {
    private String codigo;
    private LocalDate fechaPrestamo;
    private LocalDate fechaEntrega;
    private float costo;
    private EstadoLibro estado;
    private DetallePrestamo detallesPrestamo;
    private Estudiante estudiante;  


    public Prestamo(String codigo, LocalDate fechaPrestamo, LocalDate fechaEntrega, float costo, EstadoLibro estado) {
        this.codigo = codigo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.costo = costo;
        this.estado = estado;
    }

    public void adicionarDetalle(Libro libro, int unidadesPrestadas) {
        // Verificar si hay suficientes unidades disponibles
        if (libro.getUnidadesDisponibles() >= unidadesPrestadas) {
            // Crear un nuevo DetallePrestamo
            DetallePrestamo detalle = new DetallePrestamo(libro, unidadesPrestadas, calcularCostoPorLibro(libro, unidadesPrestadas));

            // Restar las unidades prestadas del inventario de libros
            libro.setUnidadesDisponibles(libro.getUnidadesDisponibles() - unidadesPrestadas);

            // Agregar el detalle a la lista de detalles del préstamo
            detallesPrestamo.add(detalle);

            // Actualizar el costo total del préstamo
            costo += detalle.getCostoPrestamo();

            System.out.println("El libro " + libro.getTitulo() + " ha sido añadido al préstamo.");
        } else {
            System.out.println("No hay suficientes unidades disponibles del libro " + libro.getTitulo());
        }
    }


    private Object calcularCostoPorLibro(Libro libro, int unidadesPrestadas) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularCostoPorLibro'");
    }

    public Prestamo(String codigo2, LocalDate fechaPrestamo2, Estudiante estudiante2, Bibliotecario bibliotecario,
            EstadoLibro noEntregado) {
        //TODO Auto-generated constructor stub
    }

    public Prestamo(String codigo2, Date date, Estudiante estudiante2, Bibliotecario bibliotecario,
            EstadoLibro noEntregado) {
        //TODO Auto-generated constructor stub
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public float getCosto() {
        return costo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    public DetallePrestamo getDetallePrestamos(){
        return detallesPrestamo;
    }


    public EstadoLibro estado(){
        return estado;
    }




}    