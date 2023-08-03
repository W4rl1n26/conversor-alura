
package es.alura.com.temperatura;

import java.text.DecimalFormat;
import javax.swing.JLabel;

public class Temperatura {
    
    private JLabel labelTempIzquierda;
    private JLabel labelTempDerecha;

    public void setComponentesTemperatura(JLabel labelTempIzquierda,JLabel labelTempDerecha){
        this.labelTempIzquierda = labelTempIzquierda;
        this.labelTempDerecha = labelTempDerecha;
    }
    
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    
    public final String[] decoracion = {"°C","°F","K"};
    public final String[] escalas = {"Grado Celsius","Grado Fahrenheit","kelvin"};
    
    public String[] getListaEscalas(){
        return escalas;
    }
    
    public String temperatura(String escala,double valor,String salida){
        String resultado = "";
        switch(escala){
            case "Grado Celsius":
                labelTempIzquierda.setText(decoracion[0]);
                resultado = Celsius(valor,salida);
                break;
            case "Grado Fahrenheit":
                labelTempIzquierda.setText(decoracion[1]);
                resultado = Fahrenheit(valor,salida);
                break;
            case "kelvin":
                labelTempIzquierda.setText(decoracion[2]);
                resultado = kelvin(valor,salida);
                break;
        }
        return resultado;
    }
    
    private String Celsius(double valor,String salida){
        String resultado = "";
        switch(salida){
            case "Grado Fahrenheit":
                resultado = String.valueOf(decimalFormat.format((valor * 9/5) + 32));
                labelTempDerecha.setText(decoracion[1]);
                break;
            case "kelvin":
                resultado = String.valueOf(decimalFormat.format(valor + 273.15));
                labelTempDerecha.setText(decoracion[2]);
                break;
        }
        return resultado;
    }
    
    private String Fahrenheit(double valor,String salida){
        String resultado = "";
        switch(salida){
            case "kelvin":
                resultado = String.valueOf(decimalFormat.format((valor - 32) * 5/9 + 273.15));
                labelTempDerecha.setText(decoracion[2]);
                break;
            case "Grado Celsius":
                resultado = String.valueOf(decimalFormat.format((valor - 32) * 5/9));
                labelTempDerecha.setText(decoracion[0]);
                break; 
        }
        return resultado;
    }
    
    private String kelvin(double valor,String salida){
        String resultado = "";
        switch(salida){
            case "Grado Celsius":
                resultado = String.valueOf(decimalFormat.format(valor - 273.15));
                labelTempDerecha.setText(decoracion[0]);
                break;
            case "Grado Fahrenheit":
                resultado = String.valueOf(decimalFormat.format((valor - 273.15) * 9/5 + 32));
                labelTempDerecha.setText(decoracion[1]);
                break;
        }
        return resultado;
    }
 
    
}
