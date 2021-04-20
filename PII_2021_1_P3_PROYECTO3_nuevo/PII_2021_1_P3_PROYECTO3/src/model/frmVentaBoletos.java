package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ventas.VentaBoletos;

import javax.swing.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

public class frmVentaBoletos {
    private JPanel jpaPrincipal;
    private JPanel jpaSuperior;
    private JPanel jpaDerecho;
    private JLabel lblTitulo;
    private JButton btnPost;
    private JButton btnGetId;
    private JButton btnPut;
    private JButton btnDelete;
    private JLabel lblId;
    private JTextField txtId;
    private JLabel lblNombreCliente;
    private JTextField txtNombreCliente;
    private JLabel lblNombreEmpleado;
    private JTextField txtNombreEmpleado;
    private JLabel lblNombrePelicula;
    private JTextField txtNombrePelicula;
    private JLabel lblCantidadBoletos;
    private JLabel lblPrecioBoleto;
    private JTextField txtCantidadBoletos;
    private JTextField txtPrecioBoleto;
    private JLabel lblFecha;
    private JTextField txtfecha;
    private JButton btnGetAll;


    public frmVentaBoletos() {
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

                    java.util.List<VentaBoletos> data = new Gson().fromJson(responseJson,new TypeToken<List<VentaBoletos>>(){}.getType());

                    res = data.get(0).getnombreCliente();

                    JOptionPane.showMessageDialog(null,get.getStatus());

                    switch (get.getStatus()) {
                        case 200:
                            res = String.valueOf(data.get(0).getid());
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

                    WebTarget target = client.target(URL + "/addVentaBoleto");

                    Invocation.Builder solicitud =target.request();
                    VentaBoletos ventaBoletos = new VentaBoletos();
                    ventaBoletos.setnombreCliente(txtNombreCliente.getText());
                    ventaBoletos.setnombreEmpleado(txtNombreEmpleado.getText());
                    ventaBoletos.setnombrePelicula(txtNombrePelicula.getText());
                    ventaBoletos.setcantidadBoletos(Integer.parseInt(txtCantidadBoletos.getText()));
                    ventaBoletos.setprecioBoleto(Integer.parseInt(txtPrecioBoleto.getText()));
                    ventaBoletos.setfecha(Date.valueOf(txtfecha.getText()));

                    Gson gson = new Gson();
                    String jsonString = gson.toJson(ventaBoletos);

                    Response post = solicitud.post(Entity.json(jsonString));


                    String responseJson = post.readEntity(String.class);
                   VentaBoletos data = new Gson().fromJson(responseJson, VentaBoletos.class);

                    res = data.getnombreCliente();

                    JOptionPane.showMessageDialog(null,post.getStatus());

                    switch (post.getStatus()) {
                        case 201:
                            res = data.getnombreCliente();
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

                    VentaBoletos data = new Gson().fromJson(responseJson, VentaBoletos.class);

                    res = data.getnombreCliente();

                    JOptionPane.showMessageDialog(null,get.getStatus());

                    switch (get.getStatus()) {
                        case 200:
                            res = String.valueOf(data.getid());
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
                    VentaBoletos ventaBoletos = new VentaBoletos();
                    ventaBoletos.setnombreCliente(txtNombreCliente.getText());
                    ventaBoletos.setnombreEmpleado(txtNombreEmpleado.getText());
                    ventaBoletos.setnombrePelicula(txtNombrePelicula.getText());
                    ventaBoletos.setcantidadBoletos(Integer.parseInt(txtCantidadBoletos.getText()));
                    ventaBoletos.setprecioBoleto(Integer.parseInt(txtPrecioBoleto.getText()));
                    ventaBoletos.setfecha(Date.valueOf(txtfecha.getText()));
                    ventaBoletos.getid();
                    Gson gson = new Gson();
                    String jsonString = gson.toJson(ventaBoletos);

                    Response put = solicitud.put(Entity.json(jsonString));


                    String responseJson = put.readEntity(String.class);
                    VentaBoletos data = new Gson().fromJson(responseJson, VentaBoletos.class);

                    res = data.getnombreCliente();

                    JOptionPane.showMessageDialog(null,put.getStatus());

                    switch (put.getStatus()) {
                        case 200:
                            res = data.getnombreCliente();
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
            imagen = new ImageIcon(getClass().getResource("/imagenes/VentaBoletos.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
    String res = "";
    String URL = "http://192.168.1.20:8080/api/v1/ventaboleto";
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Venta de Boletos" );
        frame1.setContentPane(new frmVentaBoletos().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
