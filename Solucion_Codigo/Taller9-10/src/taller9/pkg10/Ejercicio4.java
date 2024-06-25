package taller9.pkg10;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio4 {

}

abstract class Trabajador {

    public String nombre;
    public String apellidos;
    public String direccion;
    public String dni;

    public Trabajador(String nombre, String apellidos, String direccion, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.dni = dni;
    }

    public static void main(String[] args) {
        // Crear algunos trabajadores
        List<Trabajador> empleados = new ArrayList<>();
        FijoMensual fijo = new FijoMensual("Juan", "Gómez", "Calle Principal 123", "12345678A", 2000);
        Comisionista comisionista = new Comisionista("María", "López", "Av. Libertad 456", "87654321B", 5); // 5% de comisión
        PorHoras porHoras = new PorHoras("Pedro", "Martínez", "Plaza Mayor 789", "65432187C", 10, 15); // 10€/h normales, 15€/h extras
        Jefe jefe = new Jefe("Ana", "Rodríguez", "Paseo del Carmen 567", "34567890D", fijo);

        // Asignar ventas realizadas o horas trabajadas
        comisionista.setVentasRealizadas(10000); // Ejemplo de ventas realizadas
        porHoras.setHorasNormales(40); // Ejemplo de horas normales
        porHoras.setHorasExtra(5); // Ejemplo de horas extra

        // Agregar trabajadores a la lista
        empleados.add(fijo);
        empleados.add(comisionista);
        empleados.add(porHoras);
        empleados.add(jefe.getSubordinado());

        // Calcular y mostrar la nómina de cada trabajador
        System.out.println("Nómina de empleados:");
        for (Trabajador empleado : empleados) {
            System.out.println("\nNombre: " + empleado.nombre + " " + empleado.apellidos);
            System.out.println("DNI: " + empleado.dni);
            System.out.println("Dirección: " + empleado.direccion);
            System.out.println("Sueldo del mes: " + empleado.calcularSueldo() + " €");
        }
    }

    // Método abstracto para calcular el sueldo
    public abstract double calcularSueldo();
}

// Clase para representar a un trabajador fijo mensual
class FijoMensual extends Trabajador {

    private double sueldoMensual;

    public FijoMensual(String nombre, String apellidos, String direccion, String dni, double sueldoMensual) {
        super(nombre, apellidos, direccion, dni);
        this.sueldoMensual = sueldoMensual;
    }

    @Override
    public double calcularSueldo() {
        return sueldoMensual;
    }
}

// Clase para representar a un trabajador comisionista
class Comisionista extends Trabajador {

    private double ventasRealizadas;
    private double porcentajeComision;

    public Comisionista(String nombre, String apellidos, String direccion, String dni, double porcentajeComision) {
        super(nombre, apellidos, direccion, dni);
        this.porcentajeComision = porcentajeComision;
    }

    public void setVentasRealizadas(double ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }

    @Override
    public double calcularSueldo() {
        return ventasRealizadas * (porcentajeComision / 100);
    }
}

// Clase para representar a un trabajador por horas
class PorHoras extends Trabajador {

    private int horasNormales;
    private int horasExtra;
    private double precioHoraNormal;
    private double precioHoraExtra;

    public PorHoras(String nombre, String apellidos, String direccion, String dni, double precioHoraNormal, double precioHoraExtra) {
        super(nombre, apellidos, direccion, dni);
        this.precioHoraNormal = precioHoraNormal;
        this.precioHoraExtra = precioHoraExtra;
    }

    public void setHorasNormales(int horasNormales) {
        this.horasNormales = horasNormales;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    @Override
    public double calcularSueldo() {
        double sueldo = horasNormales * precioHoraNormal;
        if (horasExtra > 0) {
            sueldo += horasExtra * precioHoraExtra;
        }
        return sueldo;
    }
}

// Clase para representar a un jefe
class Jefe extends Trabajador {

    private Trabajador subordinado;

    public Jefe(String nombre, String apellidos, String direccion, String dni, Trabajador subordinado) {
        super(nombre, apellidos, direccion, dni);
        this.subordinado = subordinado;
    }

    @Override
    public double calcularSueldo() {
        // El sueldo del jefe es fijo (no hay que calcularlo)
        return 10000; // Ejemplo de sueldo fijo para el jefe
    }

    public Trabajador getSubordinado() {
        return subordinado;
    }

    public void setSubordinado(Trabajador subordinado) {
        this.subordinado = subordinado;
    }
}
