
package interfaz;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import es.alura.com.monedas.Monedas;
import java.awt.Image;
import javax.swing.ImageIcon;
import es.alura.com.monedas.Metodos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import es.alura.com.temperatura.Temperatura;
import java.awt.Color;
import fonts.FontFiraCode;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class ConversorInterfaz extends JFrame{
    
    //Componentes
    FondoPanel panel = new FondoPanel("/recursos/backgraundConversor.png");
    JComboBox boxPrimario = new JComboBox();
    public JComboBox boxEntrada = new JComboBox();
    public JComboBox boxSalida = new JComboBox();
    JTextField boxFieldEntrada = new JTextField();
    JTextField boxFieldSalida = new JTextField();
    JButton cambio = new JButton();
    JLabel labelBoxPrimario = new JLabel();
    JLabel labelBoxIzquierda = new JLabel();
    JLabel labelBoxDerecha = new JLabel();
    JLabel labelIgual = new JLabel();
    JLabel labelTempIzquierda = new JLabel();
    JLabel labelTempDerecha = new JLabel();
    JLabel labelAvisos = new JLabel();
    Monedas monedas = new Monedas();
    Metodos metodos = new Metodos();
    Temperatura temperatura = new Temperatura();
    FontFiraCode fontFiraCode = new FontFiraCode();
    
    ImageIcon iconoBoton = new ImageIcon(getClass().getResource("/recursos/cambiar.png"));
    
    //Variables
    private int alto = 40;
    private int anchoDefecto = 200;
    private int anchoTemperatura = 160;
    private final String valorBoxPrimario[] = {"Conversor Divisas","Conversor Temperatura"};
    private final String[] opciones = {"Salir", "Cancelar"};
    private JComboBox boxSeleccionado;
    
    public ConversorInterfaz(){
        //Propiedades de la ventana.
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Conversor alura");
        setSize(600,310);
        setResizable(false);
        setLocationRelativeTo(null);
        //setUndecorated(true);
        
        //panel.setBounds(0, 0, 599, 201);
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.setVisible(true);
        add(panel);

        CreadorLabel(labelBoxPrimario,50, 25, 100, 15, "Convertir:", 14);
        CreadorComboBox(boxPrimario, 50, 40, 500, 40,valorBoxPrimario);
        
        CreadorLabel(labelBoxIzquierda,50, 125, 200, 15, "Cantidad a convertir:", 14);
        CreadorCajaTexto(boxFieldEntrada,50, 140, 200, 40, 28);
        CreadorComboBox(boxEntrada,50, 180, 200, 40,seleccion());
       
        CreadorLabel(labelBoxDerecha,350, 125, 200, 15, "Cantidad equivalente:", 14);
        CreadorCajaTexto(boxFieldSalida,350, 140, 200, 40, 28);
        boxFieldSalida.setEditable(false);
        CreadorComboBox(boxSalida,350, 180, 200, 40,seleccion());
        
        CreadorLabel(labelTempIzquierda,210, 140, 40, 40, "", 24);
        labelTempIzquierda.setOpaque(true);
        labelTempIzquierda.setBackground(Color.WHITE);
        
        CreadorLabel(labelTempDerecha,510, 140, 40, 40, "", 24);
        labelTempDerecha.setOpaque(true);
        labelTempDerecha.setBackground(Color.WHITE);
        
        CreadorLabel(labelIgual,283, 150, 100, 15, "=", 48);
        cambio.setBounds(260,180, 80,40);
        cambio.setFocusable(rootPaneCheckingEnabled);
        cambio.setIcon(new ImageIcon(iconoBoton.getImage().getScaledInstance(iconoBoton.getIconWidth(), cambio.getHeight(), Image.SCALE_SMOOTH)));
        cambio.setVisible(true);
        panel.add(cambio);
        
        CreadorLabel(labelAvisos,50, 220, 500, 50, "", 18);
        
        //Este metodo pasa las referencias de los componentes necesarios en otas clases.
        metodos.setComponentesReferencias(boxEntrada, boxSalida,boxPrimario,
               boxFieldEntrada, boxFieldSalida, labelAvisos, labelTempIzquierda, labelTempDerecha);
        
        metodos.cambioValorIgualdad((boxSeleccionado == null) ? "ComboBoxIzquierdo" : boxSeleccionado.getSelectedItem().toString());
        
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirmacionCierre = JOptionPane.showOptionDialog(null, "¿Seguro que desea salir?", null, 0, 0, null, opciones, "Cancelar");
                
                if(confirmacionCierre == 0){
                    System.exit(0);
                }
            }
        });
        
        //Eventos de selección en los comboBox
       ActionListener AccionComboBox = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boxSeleccionado = (JComboBox) e.getSource();
                
                metodos.cambioValorIgualdad(getBoxSeleccionado(boxSeleccionado));
                metodos.getValorTextField(boxFieldEntrada.getText());
                
                if("Conversor Temperatura".equals(boxPrimario.getSelectedItem().toString()) && boxSeleccionado.getItemCount() != 0){
                decoracion(boxEntrada.getSelectedItem().toString(),boxSalida.getSelectedItem().toString());
                }
            }
           
        };
       
       //Evento de selección en boxPrimario.
       ActionListener AccionComboBoxPrimario = new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent e) {
                if("Conversor Temperatura".equals(boxPrimario.getSelectedItem().toString())){
                    
                    limpiarCajaTexto();
                    limpiarComboBox();
                    metodos.cambioValorIgualdad(getBoxSeleccionado(boxSeleccionado));
                    boxFieldEntrada.setSize(anchoTemperatura,alto);
                    boxFieldSalida.setSize(anchoTemperatura,alto);
                    decoracion(boxEntrada.getSelectedItem().toString(),boxSalida.getSelectedItem().toString());

                }else{
                    limpiarCajaTexto();
                    limpiarComboBox();
                    metodos.cambioValorIgualdad(getBoxSeleccionado(boxSeleccionado));
                    boxFieldEntrada.setSize(anchoDefecto,alto);
                    boxFieldSalida.setSize(anchoDefecto,alto);
                }
            }

        };
       
       //Evento click en boton de intercambio de valores.
       ActionListener AccionIntercambio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                metodos.intercambioValor();
                metodos.cambioValorIgualdad(getBoxSeleccionado(boxSeleccionado));
                metodos.getValorTextField(boxFieldEntrada.getText());
                
            }
        };
       
       //Evento de escritura en caja de texto.
       KeyListener AccionBoxField = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
               
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
               metodos.getValorTextField(boxFieldEntrada.getText());
            }
            
        };
       
       //Añadiendo eventos a los elementos correspondientes.
       boxSalida.addActionListener(AccionComboBox);
       boxEntrada.addActionListener(AccionComboBox);
       cambio.addActionListener(AccionIntercambio);
       boxFieldEntrada.addKeyListener(AccionBoxField);
       boxPrimario.addActionListener(AccionComboBoxPrimario);
 
    }
    
    //Metodo limpiador de las cajas de texto.
    public void limpiarCajaTexto(){
        boxFieldEntrada.setText("");
        boxFieldSalida.setText("");
    }
    
    //Metodo limpiador de los comboBoxs.
    public void limpiarComboBox(){
        boxEntrada.removeAllItems();
        addItems(seleccion(),boxEntrada);
        boxSalida.removeAllItems();
        addItems(seleccion(),boxSalida);
    }
    
    //Metodo para añadir elementos a los comboBoxs
    public void addItems(String[] valores,JComboBox comboBox){
        for(int i = 0; i < valores.length;i++){
            comboBox.addItem(valores[i]);
        }
    }
    
    //Metodo identificador de donde ocurrio el evento
    private String getBoxSeleccionado(JComboBox evento){
        
        if(evento == boxEntrada){
            return "ComboBoxIzquierdo";
        }else{
            return "ComboBoxDerecho";
        }
    }
    
    //Metodo que devuelve una lista de elementos, de divisas o escalas de temperatura.
    public String[] seleccion(){
        if(boxPrimario.getSelectedItem().toString() == "Conversor Divisas"){
            return monedas.getListaMonedas();
        }
        return temperatura.getListaEscalas();
    }
    
    //Metodo que coloca °F, °C o k, en el label correspondiente.
    public void decoracion(String entrada, String salida){
       switch(entrada){
           case "Grado Celsius":
               if("Grado Fahrenheit".equals(salida)){
                    labelTempIzquierda.setText(temperatura.decoracion[0]);
                    labelTempDerecha.setText(temperatura.decoracion[1]);
               }else{
                   labelTempIzquierda.setText(temperatura.decoracion[0]);
                   labelTempDerecha.setText(temperatura.decoracion[2]);
               }
               break;
            case "Grado Fahrenheit":
               if("Grado Celsius".equals(salida)){
                    labelTempIzquierda.setText(temperatura.decoracion[1]);
                    labelTempDerecha.setText(temperatura.decoracion[0]);
               }else{
                   labelTempIzquierda.setText(temperatura.decoracion[1]);
                   labelTempDerecha.setText(temperatura.decoracion[2]);
               }
               break;
            case "kelvin":
               if("Grado Celsius".equals(salida)){
                    labelTempIzquierda.setText(temperatura.decoracion[2]);
                    labelTempDerecha.setText(temperatura.decoracion[0]);
               }else{
                   labelTempIzquierda.setText(temperatura.decoracion[2]);
                   labelTempDerecha.setText(temperatura.decoracion[1]);
               }
               break;
       }
    }
    
    //Metodo debuelve un nuevo objeto tipo fuente, se debe pasar el temaño de la fuente.
    
    
    //Metodo para crear JLabel
    public void CreadorLabel(JLabel label,int x, int y, int width, int height, String text, int font){
        label.setBounds(x, y, width, height);
        label.setText(text);
        label.setFont(fontFiraCode.getFont(font));
        label.setVisible(true);
        panel.add(label);
    }
    
    //Metodo para crear JComboBoxs
    private void CreadorComboBox(JComboBox box,int x, int y, int width, int height, String[] elementos){

        addItems(elementos,box);
        
        box.setBounds(x,y,width,height);
        box.setFont(fontFiraCode.getFont(16));
        box.setVisible(true);
        panel.add(box);
    }
    
    //Metodo para crear JTextField
    private void CreadorCajaTexto(JTextField field, int x, int y,int width,int height, int font){
        field.setBounds(x,y,width,height);
        field.setBorder(null);
        field.setFont(fontFiraCode.getFont(font));
        field.setVisible(true);
        panel.add(field);
    }
    
}
