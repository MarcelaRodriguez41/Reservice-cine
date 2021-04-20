package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import establecimiento.Salas;

import javax.swing.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class frmSalas {
    private JPanel jpaPrincipal;
    private JPanel jpaSuperior;
    private JLabel lblTitulo;
    private JPanel jpaDerecho;
    private JTextField txtId;
    private JTextField txtNombreSala;
    private JTextField txtCantidadFilas;
    private JTextField txtCantidadColumnas;
    private JTextField txtCantidadAsientosPreferencial;
    private JLabel lblId;
    private JLabel lblNombreSala;
    private JLabel lblCantidadFilas;
    private JLabel lblCantidadColumnas;
    private JLabel lblCantidadAsientosPreferencial;
    private JTextField txtEstadoDisponibilidad;
    private JLabel lblEstadoDisponibilidad;
    private JButton btnPost;
    private JButton btnGetId;
    private JButton btnPut;
    private JButton btnDelete;
    private JButton btnGetAll;


    public frmSalas() {
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

                    java.util.List<Salas> data = new Gson().fromJson(responseJson,new TypeToken<List<Salas>>(){}.getType());

                    res = data.get(0).getNombreSala();

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

                    WebTarget target = client.target(URL + "/addSala");

                    Invocation.Builder solicitud =target.request();
                    Salas salas = new Salas();
                   salas.setNombreSala(txtNombreSala.getText());
                   salas.setCantidadFilas(Integer.parseInt(txtCantidadFilas.getText()));
                   salas.setCantidadColumnas(Integer.parseInt(txtCantidadColumnas.getText()));
                   salas.setEstadoDisponibilidad(txtEstadoDisponibilidad.getText());

                    Gson gson = new Gson();
                    String jsonString = gson.toJson(salas);

                    Response post = solicitud.post(Entity.json(jsonString));


                    String responseJson = post.readEntity(String.class);
                    Salas data = new Gson().fromJson(responseJson, Salas.class);

                    res = data.getNombreSala();

                    JOptionPane.showMessageDialog(null,post.getStatus());

                    switch (post.getStatus()) {
                        case 201:
                            res = data.getNombreSala();
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

                    Salas data = new Gson().fromJson(responseJson, Salas.class);

                    res = data.getNombreSala();

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
                    Salas salas = new Salas();
                    salas.setId(salas.getId());
                    salas.setNombreSala(txtNombreSala.getText());
                    salas.setCantidadFilas(Integer.parseInt(txtCantidadFilas.getText()));
                    salas.setCantidadColumnas(Integer.parseInt(txtCantidadColumnas.getText()));
                    salas.setEstadoDisponibilidad(txtEstadoDisponibilidad.getText());


                    Gson gson = new Gson();
                    String jsonString = gson.toJson(salas);

                    Response put = solicitud.put(Entity.json(jsonString));


                    String responseJson = put.readEntity(String.class);
                  Salas data = new Gson().fromJson(responseJson, Salas.class);

                    res = data.getNombreSala();

                    JOptionPane.showMessageDialog(null,put.getStatus());

                    switch (put.getStatus()) {
                        case 200:
                            res = data.getNombreSala();
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
    String res = "";
    String URL = "http://192.168.1.20:8080/api/v1/sala";
    private void createUIComponents() {
        jpaPrincipal = new FondoPanel();
        jpaDerecho = new FondoPanel();
    }

    public class Index extends javax.swing.JFrame
    {     FondoPanel fondo = new FondoPanel();
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
            imagen = new ImageIcon(getClass().getResource("/imagenes/Salas.jpeg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Salas");
        frame1.setContentPane(new frmSalas().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
