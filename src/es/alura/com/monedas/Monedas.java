
package es.alura.com.monedas;

public class Monedas{
  
    
    private static String listaMonedas[] = {"USD","EUR","DOP","JPY","GBP","KPW"};
    
    public String[] getListaMonedas(){
        return listaMonedas;
    }
        
public static enum USD implements ValorEnums{// Dolar Estado unidence
    
   
    EUR(0.91),
    KPW(1297.19),
    GBP(0.79),
    JPY(143.32),
    DOP(56.35);
    
    
    private double valor;
        
    private USD(double valor){
       this.valor = valor;
    }

        @Override
        public double getValor() {
            return this.valor;
        }
    }

public static enum EUR implements ValorEnums{// Euro
        
    KPW(1419.73),
    GBP(0.86),
    JPY(156.83),
    DOP(61.68),
    USD(1.09);
    
    private double valor;
        
    private EUR(double valor){
       this.valor = valor;
    }

        @Override
        public double getValor() {
            return this.valor;
        }
    }

public static enum DOP implements ValorEnums{// Peso Dominicano
        
    EUR(0.016),
    KPW(22.98),
    GBP(0.014),
    JPY(2.54),
    USD(0.018);
    
    private double valor;
        
    private DOP(double valor){
       this.valor = valor;
    }

        @Override
        public double getValor() {
            return this.valor;
        }
    }



public static enum JPY implements ValorEnums{// Dolar Estado unidence
    
    EUR(0.0064),
    KPW(9.03),
    GBP(0.0055),
    DOP(0.39),
    USD(0.0070);
    
    
    private double valor;
        
    private JPY(double valor){
       this.valor = valor;
    }

        @Override
        public double getValor() {
            return this.valor;
        }
}
	
public static enum GBP implements ValorEnums{// Dolar Estado unidence
    
    EUR(1.16),
    KPW(1652.99),
    JPY(182.23),
    DOP(71.68),
    USD(1.27);
    
    
    private double valor;
        
    private GBP(double valor){
       this.valor = valor;
    }

        @Override
        public double getValor() {
            return this.valor;
        }
    }

public static enum KPW implements ValorEnums{// Dolar Estado unidence
    
    EUR(0.00070),
    GBP(0.00061),
    JPY(0.11),
    DOP(0.043),
    USD(0.00077);
   
    
    
    private double valor;
        
    private KPW(double valor){
       this.valor = valor;
    }

        @Override
        public double getValor() {
            return this.valor;
        }
    }
}