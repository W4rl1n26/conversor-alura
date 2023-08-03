
package interfaz;

import fonts.FontFiraCode;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class InicioBienvenida extends JFrame{
    // Objetos
    FondoPanel panel = new FondoPanel("/recursos/bienvenida1.png");
    ImageIcon divisasImage = new ImageIcon(getClass().getResource("/recursos/card.png"));
    ImageIcon frioImage = new ImageIcon(getClass().getResource("/recursos/frio.png"));
    ImageIcon calorImage = new ImageIcon(getClass().getResource("/recursos/calor.png"));
    JLabel titulo = new JLabel();
    JLabel subTitulo = new JLabel();
    JLabel  labelDivisas = new JLabel();
    JLabel labelFrio = new JLabel();
    JLabel  labelCalor = new JLabel();
    FontFiraCode fontFiraCode = new FontFiraCode();
    
    public InicioBienvenida(){
        
        //Propiedades de la ventana.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(676,376);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);
        
        panel.setSize(this.getWidth(),this.getHeight());
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.setVisible(true);
        add(panel);
        
        CreadorLabel(titulo,150,10,380,50,"Conversor Alura",40,null);
        CreadorLabel(subTitulo,100,110,480,40,"Divisas       |      Temperatura",24,null);
        CreadorLabel(labelDivisas,30,180,260,180,null,0,divisasImage);
        CreadorLabel(labelFrio,345,180,160,180,null,0,frioImage);
        CreadorLabel(labelCalor,495,180,160,180,null,0,calorImage);
        
    }
    
     public void CreadorLabel(JLabel label,int x, int y, int width, int height, String text, int font,ImageIcon icon){
        label.setBounds(x, y, width, height);
        label.setText(text);
        if(icon != null){
            label.setIcon(new ImageIcon(icon.getImage()));
        }
        label.setFont(fontFiraCode.getFont(font));
        label.setForeground(Color.WHITE);
        label.setVisible(true);
        panel.add(label);
    }
    
}
