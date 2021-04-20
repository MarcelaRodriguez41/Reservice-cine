package reservas;

import java.sql.Time;
import java.util.Date;

public class Reservaciones {
    private long id;
    private String nombreCliente;
    private String nombreEmpleado;
    private String nombrePelicula;
    private Date fecha;
    private Time hora;

    public Reservaciones(){
    }
    public Reservaciones(long id, String nombreCliente, String nombreEmpleado, String nombrePelicula,Date fecha, Time hora)
    {
        this.id             = id;
        this.nombreCliente  = nombreCliente;
        this.nombreEmpleado = nombreEmpleado;
        this.nombrePelicula = nombrePelicula;
        this.fecha          = fecha;
        this.hora           = hora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getnombreCliente() {
        return nombreCliente;
    }

    public void setnombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getnombreEmpleado() {
        return nombreEmpleado;
    }

    public void setnombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getnombrePelicula() {
        return nombrePelicula;
    }

    public void setnombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public Date getfecha() {
        return fecha;
    }

    public void setfecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time gethora() {
        return hora;
    }

    public void sethora(Time hora) {
        this.hora = hora;
    }
}