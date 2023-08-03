
package interfaz;

import java.util.TimerTask;

public class Retraso extends TimerTask{
   
    ConversorInterfaz conversor = new ConversorInterfaz();
    
    InicioBienvenida bienvenida;
    
    public Retraso(InicioBienvenida bienvenida){
        this.bienvenida = bienvenida;
    }
    
    @Override
    public void run() {
        conversor.setVisible(true);
        bienvenida.setVisible(false);
        
    }
    
}
