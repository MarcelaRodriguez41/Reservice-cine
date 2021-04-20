package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import peliculas.Peliculas;

import javax.swing.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class frmPeliculas {
    private JPanel jpaPrincipal;
    private JPanel jpaSuperior;
    private JPanel jpaDerecho;
    private JLabel lblTitulo;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtSinopsis;
    private JTextField txtGenero;
    private JTextField txtNacionalidad;
    private JTextField txtDuracion;
    private JTextField txtDirector;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblSinposis;
    private JLabel lblGenero;
    private JLabel lblNacionalidad;
    private JLabel lblDuracion;
    private JLabel lblDirector;
    private JButton btnPost;
    private JButton btnGetId;
    private JButton btnPut;
    private JButton btnDelete;
    private JButton btnGetAll;


    public frmPeliculas() {
        btnGetAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Client client= ClientBuilder.newClient();

                    WebTarget target = client.target(URL + "");

                    //Invocation.Builder solicitud =target.queryParam("id",1).request();
                    Invocation.Builder solicitud =target.request();

                    Response get = solicitud.get();


                    String responseJson = get.readEntity(String.class);

                    java.util.List<Peliculas> data = new Gson().fromJson(responseJson,new TypeToken<List<Peliculas>>(){}.getType());

                    res = data.get(0).getNombrePelicula();

                    JOptionPane.showMessageDialog(null,get.getStatus());

                    switch (get.getStatus()) {
                        case 200:
                            res = String.valueOf(data.get(0).getId());
                            break;
                        default:
                            res = "Error";
                            break;
                    }
                }catch(Exception e1){
                    res = e.toString();
                }
                finally {
                    JOptionPane.showMessageDialog(null,res);
                }
            }
        });

        btnPost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Client client= ClientBuilder.newClient();

                    WebTarget target = client.target(URL + "/addProduct");

                    Invocation.Builder solicitud =target.request();
                    Peliculas peliculas = new Peliculas();
                   peliculas.setNombrePelicula(txtNombre.getText());
                   peliculas.setSinopsis(txtSinopsis.getText());
                   peliculas.setGenero(txtGenero.getText());
                   peliculas.setDuracion(txtDuracion.getText());
                   peliculas.setDirector(txtDirector.getText());
                   peliculas.setNacionalidad(txtNacionalidad.getText());

                    Gson gson = new Gson();
                    String jsonString = gson.toJson(peliculas);

                    Response post = solicitud.post(Entity.json(jsonString));


                    String responseJson = post.readEntity(String.class);
                    Peliculas data = new Gson().fromJson(responseJson, Peliculas.class);

                    res = data.getNombrePelicula();

                    JOptionPane.showMessageDialog(null,post.getStatus());

                    switch (post.getStatus()) {
                        case 201:
                            res = data.getNombrePelicula();
                            break;
                        default:
                            res = "Error";
                            break;
                    }
                }catch(Exception e1){
                    res = e.toString();
                }
                finally {
                    JOptionPane.showMessageDialog(null,res);
                }
            }
        });
        btnGetId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Client client= ClientBuilder.newClient();

                    WebTarget target = client.target(URL + "/id/");

                    //Invocation.Builder solicitud =target.queryParam("id",1).request();
                    Invocation.Builder solicitud =target.request();

                    Response get = solicitud.get();


                    String responseJson = get.readEntity(String.class);

                    Peliculas data = new Gson().fromJson(responseJson, Peliculas.class);

                    res = data.getNombrePelicula();

                    JOptionPane.showMessageDialog(null,get.getStatus());

                    switch (get.getStatus()) {
                        case 200:
                            res = String.valueOf(data.getId());
                            break;
                        default:
                            res = "Error";
                            break;
                    }
                }catch(Exception e1){
                    res = e.toString();
                }
                finally {
                    JOptionPane.showMessageDialog(null,res);
                }
            }
        });

        btnPut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Client client= ClientBuilder.newClient();

                    WebTarget target = client.target(URL + "");

                    Invocation.Builder solicitud =target.request();

                    Peliculas peliculas = new Peliculas();
                    peliculas.setNombrePelicula(txtNombre.getText());
                    peliculas.setSinopsis(txtSinopsis.getText());
                    peliculas.setGenero(txtGenero.getText());
                    peliculas.setDuracion(txtDuracion.getText());
                    peliculas.setDirector(txtDirector.getText());
                    peliculas.setNacionalidad(txtNacionalidad.getText());

                    Gson gson = new Gson();
                    String jsonString = gson.toJson(peliculas);

                    Response put = solicitud.put(Entity.json(jsonString));


                    String responseJson = put.readEntity(String.class);
                    Peliculas data = new Gson().fromJson(responseJson, Peliculas.class);

                    res = data.getNombrePelicula();

                    JOptionPane.showMessageDialog(null,put.getStatus());

                    switch (put.getStatus()) {
                        case 200:
                            res = data.getNombrePelicula();
                            break;
                        default:
                            res = "Error";
                            break;
                    }
                }catch(Exception e1){
                    res = e.toString();
                }
                finally {
                    JOptionPane.showMessageDialog(null,res);
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Client client= ClientBuilder.newClient();

                    WebTarget target = client.target(URL + "/delete/id");

                    //Invocation.Builder solicitud =target.queryParam("id",4).request();
                    Invocation.Builder solicitud =target.request();

                    Response delete = solicitud.delete();

                    String responseJson = delete.readEntity(String.class);

                    JOptionPane.showMessageDialog(null,delete.getStatus());

                    switch (delete.getStatus()) {
                        case 200:
                            res = "Delete";
                            break;
                        default:
                            res = "Error";
                            break;
                    }
                }catch(Exception e1){
                    res = e.toString();
                }
                finally {
                    JOptionPane.showMessageDialog(null,res);
                }
            }
        });
    }

    private void createUIComponents() {
        jpaPrincipal = new FondoPanel();
        jpaDerecho   = new FondoPanel();
    }
    public class Index extends javax.swing.JFrame
    {
        FondoPanel fondo = new FondoPanel();
        public Index()
        {   this.setContentPane(fondo);
            frameInit();

        }
    }
    class FondoPanel extends JPanel
    {
        private Image imagen;
        public void paint (Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("/imagenes/Peliculas.jpeg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
    String res = "";
    String URL = "http://192.168.1.20:8080/api/v1/horario";
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Peliculas");
        frame1.setContentPane(new frmPeliculas().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
