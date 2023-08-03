
package conversor;

import java.util.Timer;
import interfaz.Retraso;
import interfaz.InicioBienvenida;

public class Conversor {
    public static void main(String[] args) {
        
        InicioBienvenida bienvenida = new InicioBienvenida();
        
        Retraso retraso = new Retraso(bienvenida);
       
        Timer timer = new Timer();
        
        bienvenida.setLocationRelativeTo(null);
        bienvenida.setVisible(true);
        
        
        timer.schedule(retraso, 5500);
        
        
    }
    
}
