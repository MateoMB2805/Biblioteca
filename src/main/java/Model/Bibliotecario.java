package Model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Bibliotecario extends Persona{
    private Double salario;
    private LocalDate fechaIngreso;
    private int prestamosRealizados = 0;

    public Bibliotecario(String nombre, String cedula, String telefono, String correo, double salario, LocalDate fechaIngreso) {
        super(nombre, cedula, telefono, correo);
        this.salario = salario;
        this.fechaIngreso = fechaIngreso;
    }

    public void incrementarPrestamos() {
        prestamosRealizados++;
    }

    public double calcularSalario() {
        long añosAntiguedad = ChronoUnit.YEARS.between(fechaIngreso, LocalDate.now());
        return salario + (salario * 0.02 * añosAntiguedad);
    }

    public double calcularPagoPrestamo(double totalPrestamo) {
        return totalPrestamo * 0.20;
    }

    public int getPrestamosRealizados() {
        return prestamosRealizados;
    }

}

