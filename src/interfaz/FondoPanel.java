
package interfaz;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FondoPanel extends JPanel{
    private Image imagen;
    
    public FondoPanel(String ruta){
     
        try {
            imagen = ImageIO.read(getClass().getResource(ruta));
            //new ImageIcon(getClass().getResource(ruta));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(imagen != null){
        g.drawImage(imagen, 0, 0, this);
        }
    }
    
}
