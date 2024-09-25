package Model;

public class DetallePrestamo {
    private float costoPrestamo;
    private int unidadesPrestadas;
    private Libro libro;

    public DetallePrestamo(float costoPrestamo, int unidadesPrestadas) {
        this.costoPrestamo = costoPrestamo;
        this.unidadesPrestadas = unidadesPrestadas;
    }


    public DetallePrestamo(Libro libro2, int i, Object calcularCostoPrestamo) {
        //TODO Auto-generated constructor stub
    }


    public Float getCostoPrestamo (){
        return costoPrestamo;
    }
    public void setCostoPrestamo(Float costoPrestamo){
        this.costoPrestamo= costoPrestamo;
    }

    public int getUnidadesPrestadas(){
        return unidadesPrestadas;
    }
    public void setUnidadesPrestadas(int unidadesPrestadas){
        this.unidadesPrestadas= unidadesPrestadas;
    }

    public Libro libro(){
        return libro;
    }


    public Libro getLibro() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLibro'");
    }


    public void add(DetallePrestamo detalle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }
}
