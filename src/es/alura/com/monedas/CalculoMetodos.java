
package es.alura.com.monedas;

import java.text.DecimalFormat;

public class CalculoMetodos{
    
    //{"USD","EUR","DOP","JPY","GBP","KPW"};
    
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
   
    public String Calculo(double cantidadMoneda, String monedaEntrada, String monedaConvertir){
        String calculo = monedaEntrada + "." + monedaConvertir;
        double resultado = 0;
        
       if(calculo.equals(USDAll(monedaConvertir))){
          
           resultado = Monedas.USD.valueOf(monedaConvertir).getValor() * cantidadMoneda;
           
       }else if(calculo.equals(EURAll(monedaConvertir))){
           
           resultado = Monedas.EUR.valueOf(monedaConvertir).getValor() * cantidadMoneda;
           
       }else if(calculo.equals(DOPAll(monedaConvertir))){
           
           resultado = Monedas.DOP.valueOf(monedaConvertir).getValor() * cantidadMoneda;
           
       }else if(calculo.equals(KPWAll(monedaConvertir))){
           
           resultado = Monedas.KPW.valueOf(monedaConvertir).getValor() * cantidadMoneda;
           
       }else if(calculo.equals(GBPAll(monedaConvertir))){
           
           resultado = Monedas.GBP.valueOf(monedaConvertir).getValor() * cantidadMoneda;
           
       }else if(calculo.equals(JPYAll(monedaConvertir))){
           
           resultado = Monedas.JPY.valueOf(monedaConvertir).getValor() * cantidadMoneda;
           
       }
      
       
       return String.valueOf(decimalFormat.format(resultado));
    }
    
    private String USDAll(String convertir){
        String resultado;
        resultado = "USD." + convertir;
        return resultado;
    }
    
    private String JPYAll(String convertir){
        String resultado;
        resultado = "JPY." + convertir;
        return resultado;
    }
    
    private String GBPAll(String convertir){
        String resultado;
        resultado = "GBP." + convertir;
        return resultado;
    }
    
    private String EURAll(String convertir){
        String resultado;
        resultado = "EUR." + convertir;
        return resultado;
    }
            
    private String DOPAll(String convertir){
        String resultado;
        resultado = "DOP." + convertir;
        return resultado;
    }
    
    private String KPWAll(String convertir){
        String resultado;
        resultado = "KPW." + convertir;
        return resultado;
    }
    
}
