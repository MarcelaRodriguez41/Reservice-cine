package horario;


import java.sql.Time;
import java.util.Date;

public class Horarios {
    private long    id;
    private Time   horaInicio;
    private Time   horaFinal;
    private String nombrePelicula;
    private Date   fecha;

    public Horarios (){}
    public Horarios (long id, Time horaInicio,Time horaFinal, String nombrePelicula, Date fecha)
    {
        this.id             = id;
        this.horaInicio     = horaInicio;
        this.horaFinal      = horaFinal;
        this.nombrePelicula = nombrePelicula;
        this.fecha          = fecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public Time getHoraInicio ()
    {
        return horaInicio;
    }
    public void setHoraInicio (Time horaInicio)
    {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Time horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getNombrePelicula ()
    {
        return nombrePelicula;
    }
    public void setNombrePelicula (String nombrePelicula)
    {
        this.nombrePelicula = nombrePelicula;
    }

    public Date getFecha ()
    {
        return fecha;
    }
    public void setFecha (Date fecha)
    {
        this.fecha = fecha;
    }

}
