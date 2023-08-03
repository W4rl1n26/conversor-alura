
package fonts;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.InputStream;

public class FontFiraCode {
    
    public Font getFont(int valor){
        
        Font fuente = null;
        try {
          InputStream ruta = getClass().getResourceAsStream("/fonts/FiraCode-Medium.ttf");
          fuente = Font.createFont(Font.TRUETYPE_FONT, ruta);
          fuente = fuente.deriveFont(Font.PLAIN, valor);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(fuente);
        
        return fuente;
    }
}
