package Directores;

import java.time.LocalDate;
import java.util.Date;

public class Directores {
    private long    id;
    private String  nombreDirector;
    private Date    fechaNacimiento;
    private int     cantidadPeliculasDirigidas;
    private String  nacionalidad;
    private String  generosDirigidos;

    public Directores(){
    }
    public Directores(long id, String nombreDirector, Date fechaNacimiento, int cantidadPeliculasDirigidas,
                      String nacionalidad, String generosDirigidos)
    {
        this.id                         = id;
        this.nombreDirector             = nombreDirector;
        this.fechaNacimiento            = fechaNacimiento;
        this.cantidadPeliculasDirigidas = cantidadPeliculasDirigidas;
        this.nacionalidad               = nacionalidad;
        this.generosDirigidos           = generosDirigidos;
    }

    public long getId() {
        return id;
    }

    public void setId(long  id) {
        this.id = id;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCantidadPeliculasDirigidas() {
        return cantidadPeliculasDirigidas;
    }

    public void setCantidadPeliculasDirigidas(int cantidadPeliculasDirigidas) {
        this.cantidadPeliculasDirigidas = cantidadPeliculasDirigidas;
    }

    public String getGenerosDirigidos() {
        return generosDirigidos;
    }

    public void setGenerosDirigidos(String generosDirigidos) {
        this.generosDirigidos = generosDirigidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

}

