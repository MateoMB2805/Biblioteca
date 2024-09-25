package Model;




import java.util.Date;

public class Libro {
    private static final int TARIFA_POR_DIA = 2000;
    private String codigo;
    private String isbn;
    private String autor;
    private String titulo;
    private String editorial;
    private Date fechaPublicacion;
    private int unidadesDisponibles;
    private int totalPrestamos = 0;

    public Libro(String codigo, String isbn, String autor, String titulo, String editorial, Date fechaPublicacion, int unidadesDisponibles) {
        this.codigo = codigo;
        this.isbn = isbn;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public void prestar(int cantidad) {
        if (unidadesDisponibles >= cantidad) {
            unidadesDisponibles -= cantidad;
            totalPrestamos++;
        }
    }

    public void devolver(int cantidad) {
        unidadesDisponibles += cantidad;
    }

    public int getTotalPrestamos() {
        return totalPrestamos;
    }


    // Método para reemplazar el libro
    
    public void reemplazarLibro(Libro nuevoLibro) {
        this.isbn = nuevoLibro.isbn;
        this.autor = nuevoLibro.autor;
        this.titulo = nuevoLibro.titulo;
        this.editorial = nuevoLibro.editorial;
        this.fechaPublicacion = nuevoLibro.fechaPublicacion;
        this.unidadesDisponibles = nuevoLibro.unidadesDisponibles;
    }

    // Método equals
    public boolean equals(String codigo) {
        return this.codigo.equals(codigo);
    }

    // getter y setter
    
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo){
        this.codigo= codigo;
    }

    public String getIsbn(){
        return isbn;
    }
    public void setIsbn( String isbn){
        this.isbn= isbn;
    }

    public String getAutor(){
        return autor;
    }
    public void setAutor(String autor){
        this.autor= autor;
    }

    public String getTitulo (){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo= titulo;
    }

    public String getEditorial(){
        return editorial;
    }
    public void setEditorial(String editorial){
        this.editorial= editorial;
    }

    public Date getFechaPublicacion(){
        return fechaPublicacion;
    }
    public void setFechaPublicacion(Date fechaPublicacion){
        this.fechaPublicacion= fechaPublicacion;
    }

    public int getUnidadesDisponibles(){
        return unidadesDisponibles;
    }
    public void setUnidadesDisponibles(int unidadesDisponibles){
        this.unidadesDisponibles= unidadesDisponibles;
    }

    public void setEstado(EstadoLibro estado){
        return; 
    }

    public float calcularCostoPrestamo(int diasPrestamo) {
        // Multiplicamos la tarifa por día por el número de días del préstamo
        float costoTotal = TARIFA_POR_DIA * diasPrestamo;
        return costoTotal;
    
    }

}
