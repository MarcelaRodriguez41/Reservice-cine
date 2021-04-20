package ventas;

import java.sql.Date;

public class VentaBoletos {
    private long    id;
    private String nombreCliente;
    private String nombreEmpleado;
    private String nombrePelicula;
    private int    cantidadBoletos;
    private int    precioBoleto;
    private Date   fecha;

    public VentaBoletos() {
    }
    public VentaBoletos(long id, String nombreCliente, String nombreEmpleado, String nombrePelicula, int cantidadBoletos, int precioBoleto, Date fecha)
    {
        this.id              = id;
        this.nombreCliente   = nombreCliente;
        this.nombreEmpleado  = nombreEmpleado;
        this.nombrePelicula  = nombrePelicula;
        this.cantidadBoletos = cantidadBoletos;
        this.precioBoleto    = precioBoleto;
        this.fecha           = fecha;
    }

    public long getid() {
        return id;
    }

    public void setid(long id) {
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

    public void setnombreEmpleado(String NnombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getnombrePelicula() {
        return nombrePelicula;
    }

    public void setnombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public int getcantidadBoletos() {
        return cantidadBoletos;
    }

    public void setcantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    public int getprecioBoleto() {
        return precioBoleto;
    }

    public void setprecioBoleto(int precioBoleto) {
        this.precioBoleto = precioBoleto;
    }

    public Date getfecha() {
        return fecha;
    }

    public void setfecha(Date fecha) {
        this.fecha = fecha;
    }
}
