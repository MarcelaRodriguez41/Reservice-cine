package model;


import javax.swing.*;
import java.awt.*;

public class frmActores {
    private JPanel jpaPrincipal;
    private JLabel lblTitulo;
    private JPanel jpaSuperior;
    private JPanel jpaIzquierdo;
    private JLabel lblId;
    private JPanel jpaDerecho;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtAlias;
    private JTextField txtGenerosInterpretados;
    private JTextField txtNacionalidad;
    private JTextField txtSexo;
    private JTextField txtfechaNacimiento;
    private JTextField txtCantidadPeliculasGrabadas;
    private JLabel lblNombre;
    private JLabel lblAlias;
    private JLabel lblGeneros;
    private JLabel lblNacionalidad;
    private JLabel lblSexo;
    private JLabel lblfechaNacimiento;
    private JLabel lblCantidadPeliculasGrabadas;
    private JPanel jpaInferior;
    private JButton btnPost;
    private JButton btnGetId;
    private JButton btnDelete;
    private JButton btnPut;
    private JButton btnGetAll;

   /* public frmActores() {
        btnPost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Client client= ClientBuilder.newClient();

                    WebTarget target = client.target(URL + "/addActor");

                    Invocation.Builder solicitud =target.request();
                    actores actor = new actores();
                    actor.setId(Long.parseLong(txtId.getText()));
                    actor.setNombreActor(txtNombre.getText());
                    actor.setAlias(txtAlias.getText());
                    actor.setNacionalidad(txtNacionalidad.getText());
                    actor.setFechaNacimiento(LocalDate.parse(txtfechaNacimiento.getText()));
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    actor.setSexo(txtSexo.getText());
                    actor.setCantidadPeliculasGrabadas(Integer.parseInt(txtCantidadPeliculasGrabadas.getText()));
                    actor.setGenerosInterpretados(txtGenerosInterpretados.getText());

                    Gson gson = new Gson();
                    String jsonString = gson.toJson(actor);

                    Response post = solicitud.post(Entity.json(jsonString));


                    String responseJson = post.readEntity(String.class);
                    actores data = new Gson().fromJson(responseJson, actores.class);
                    res = data.getNombreActor();


                    JOptionPane.showMessageDialog(null,post.getStatus());

                    switch (post.getStatus()) {
                        case 201:
                            res = data.getNombreActor();
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

                    java.util.List<actores> data = new Gson().fromJson(responseJson,new TypeToken<List<actores>>(){}.getType());

                    res = data.get(0).getNombreActor();

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
        btnPut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Client client= ClientBuilder.newClient();

                    WebTarget target = client.target(URL + "");

                    Invocation.Builder solicitud =target.request();
                    actores actor = new actores();
                    actor.setId(Long.parseLong(txtId.getText()));
                    actor.setNombreActor(txtNombre.getText());
                    actor.setAlias(txtAlias.getText());
                    actor.setNacionalidad(txtNacionalidad.getText());
                    actor.setFechaNacimiento(LocalDate.parse(txtfechaNacimiento.getText()));
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    actor.setSexo(txtSexo.getText());
                    actor.setCantidadPeliculasGrabadas(Integer.parseInt(txtCantidadPeliculasGrabadas.getText()));
                    actor.setGenerosInterpretados(txtGenerosInterpretados.getText());


                    Gson gson = new Gson();
                    String jsonString = gson.toJson(actor);

                    Response put = solicitud.put(Entity.json(jsonString));


                    String responseJson = put.readEntity(String.class);
                    actores data = new Gson().fromJson(responseJson, actores.class);

                    res = data.getNombreActor();

                    JOptionPane.showMessageDialog(null,put.getStatus());

                    switch (put.getStatus()) {
                        case 200:
                            res = data.getNombreActor();
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

                    WebTarget target = client.target(URL + "/delete/");

                    //Invocation.Builder solicitud =target.queryParam("id").request();
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

                    actores data = new Gson().fromJson(responseJson, actores.class);

                    res = data.getNombreActor();

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
    }*/

    private void createUIComponents() {
        jpaPrincipal = new FondoPanel();
        jpaIzquierdo = new FondoPanel();
        jpaDerecho   = new FondoPanel();
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
            imagen = new ImageIcon(getClass().getResource("/imagenes/fondocine.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
    /*String res = "";
    String URL = "http://192.168.1.20:8080/api/v1/actor";*/
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Actores");
        frame1.setContentPane(new frmActores().jpaPrincipal);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
