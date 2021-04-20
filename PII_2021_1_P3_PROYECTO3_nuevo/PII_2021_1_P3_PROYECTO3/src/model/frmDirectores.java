package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import Actores.actores;
import Directores.Directores;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class frmDirectores {


    private JPanel jpaPrincipal;
    private JPanel jpaSuperior;
    private JLabel lblTitulo;
    private JPanel jpaDerecho;
    private JLabel lblId;
    private JLabel lblNombreDirector;
    private JLabel lblFechaNacimiento;
    private JTextField txtId;
    private JLabel lblCantidadPeliculasDirigidas;
    private JLabel lblNacionalidad;
    private JLabel lblGenerosDirigidos;
    private JTextField txtNombre;
    private JTextField txtFechaNacimiento;
    private JTextField txtCantidadPeliculas;
    private JTextField txtNacionalidad;
    private JTextField txtDirigidos;
    private JButton btnPost;
    private JButton btnGetId;
    private JButton btnDelete;
    private JButton btnPut;
    private JButton btnGetAll;


   /* public frmDirectores() {
        btnPost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Client client= ClientBuilder.newClient();
                    WebTarget target = client.target(URL + "addDirector");

                    Invocation.Builder solicitud =target.request();
                    Directores director = new Directores();
                    director.setId(Long.parseLong(txtId.getText()));
                    director.setNombreDirector(txtNombre.getText());
                    director.setFechaNacimiento(LocalDate.parse(txtFechaNacimiento.getText()));
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    director.setCantidadPeliculasDirigidas(Integer.parseInt(txtCantidadPeliculas.getText()));
                    director.setGenerosDirigidos(txtDirigidos.getText());
                    Gson gson = new Gson();
                    String jsonString = gson.toJson(director);

                    Response post = solicitud.post(Entity.json(jsonString));


                    String responseJson = post.readEntity(String.class);
                    Directores data = new Gson().fromJson(responseJson, Directores.class);
                    res = data.getNombreDirector();


                    JOptionPane.showMessageDialog(null,post.getStatus());

                    switch (post.getStatus()) {
                        case 201:
                            res = data.getNombreDirector();
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

                    WebTarget target = client.target(URL + "/id/1");

                    //Invocation.Builder solicitud =target.queryParam("id",1).request();
                    Invocation.Builder solicitud =target.request();

                    Response get = solicitud.get();


                    String responseJson = get.readEntity(String.class);

                    Directores data = new Gson().fromJson(responseJson, Directores.class);

                    res = data.getNombreDirector();

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
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Client client = ClientBuilder.newClient();

                    WebTarget target = client.target(URL + "/delete/");

                    //Invocation.Builder solicitud =target.queryParam("id",4).request();
                    Invocation.Builder solicitud = target.request();

                    Response delete = solicitud.delete();

                    String responseJson = delete.readEntity(String.class);

                    JOptionPane.showMessageDialog(null, delete.getStatus());

                    switch (delete.getStatus()) {
                        case 200:
                            res = "Delete";
                            break;
                        default:
                            res = "Error";
                            break;
                    }
                } catch (Exception e1) {
                    res = e.toString();
                } finally {
                    JOptionPane.showMessageDialog(null, res);
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
                    Directores director = new Directores();
                    director.setId(Long.parseLong(txtId.getText()));
                    director.setNombreDirector(txtNombre.getText());
                    director.setFechaNacimiento(LocalDate.parse(txtFechaNacimiento.getText()));
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    director.setCantidadPeliculasDirigidas(Integer.parseInt(txtCantidadPeliculas.getText()));
                    director.setGenerosDirigidos(txtDirigidos.getText());
                    Gson gson = new Gson();
                    String jsonString = gson.toJson(director);

                    Response put = solicitud.put(Entity.json(jsonString));


                    String responseJson = put.readEntity(String.class);
                    Directores data = new Gson().fromJson(responseJson, Directores.class);

                    res = data.getNombreDirector();

                    JOptionPane.showMessageDialog(null,put.getStatus());

                    switch (put.getStatus()) {
                        case 200:
                            res = data.getNombreDirector();
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

                    java.util.List<Directores> data = new Gson().fromJson(responseJson,new TypeToken<List<Directores>>(){}.getType());

                    res = data.get(0).getNombreDirector();

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
    }
*/

    private void createUIComponents() {
        jpaPrincipal = new FondoPanel();
        jpaDerecho = new FondoPanel();
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
            imagen = new ImageIcon(getClass().getResource("/imagenes/directoresFondo.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
  /*  String res = "";
    String URL = "http://192.168.1.20:8080/api/v1/director";*/
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Directores");
        frame1.setContentPane(new frmDirectores().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
