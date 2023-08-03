
package es.alura.com.monedas;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import es.alura.com.temperatura.Temperatura;


public class Metodos extends CalculoMetodos{
    
    
    Temperatura temperatura = new Temperatura();
    
    private JComboBox comboIzquierda;
    private JComboBox comboDerecha;
    private JComboBox comboPrincipal;
    private JTextField boxFieldIzquierda;
    private JTextField boxFieldDerecha;
    private JLabel labelAvisos;
    private JLabel labelTempIzquierda;
    private JLabel labelTempDerecha;
    
    //Guardar referencias de los componentes necesarios.
    public void setComponentesReferencias(JComboBox boxIzquierda,JComboBox boxDerecha,JComboBox boxPrincipal,
            JTextField boxFieldIzquierda,JTextField boxFieldDerecha,JLabel labelAvisos,JLabel labelTempIzquierda,JLabel labelTempDerecha){
        
        this.comboIzquierda = boxIzquierda;
        this.comboDerecha = boxDerecha;
        this.comboPrincipal = boxPrincipal;
        this.boxFieldIzquierda = boxFieldIzquierda;
        this.boxFieldDerecha = boxFieldDerecha;
        this.labelAvisos = labelAvisos;
        this.labelTempDerecha = labelTempDerecha;
        this.labelTempIzquierda = labelTempIzquierda;
    }
    
    //Metodo principal de entrada y verificacion por submetodos.
    //
    public void getValorTextField(String rango){
        
        if(!VerificarRango(rango)) {
            
            switch(comboPrincipal.getSelectedItem().toString()){
                case "Conversor Divisas":
                    //cambioValorIgualdad();
                    boxFieldDerecha.setText(super.Calculo(entradaDouble(),
                    comboIzquierda.getSelectedItem().toString(), comboDerecha.getSelectedItem().toString()));
                    labelAvisos.setText("");
                    break;
                case "Conversor Temperatura":
                    temperatura.setComponentesTemperatura(labelTempIzquierda, labelTempDerecha);
                    boxFieldDerecha.setText(temperatura.temperatura(comboIzquierda.getSelectedItem().toString(), entradaDouble(), comboDerecha.getSelectedItem().toString()));
                    labelAvisos.setText("");
                    break;
            }
        }else if(rango.length() != 0 && String.valueOf(rango.charAt(0)) != "-"){
            labelAvisos.setText("Solo se permiten valores númericos.");
        }else{
            labelAvisos.setText("");
            boxFieldDerecha.setText("");
        }
        
        
    }
    
    //Metodo para verificar si solo hay valores númericos.
    public boolean VerificarRango(String rango){
        boolean existe = true;
        
        for(int i = 0; i < rango.length(); i++){
            
            int caracter = rango.codePointAt(i);
            
            if(caracter > 47 && caracter < 58|| caracter == 46 && i > 0 || caracter == 45 && negativosPuntos(rango,caracter)){
                existe = false;
            }else{
                existe = true;
                break;
            }
        }
        return existe;
    }
    
    //Metodo verifica si existe
    private boolean negativosPuntos(String rango, int caracter){
        int caracterMenos = 0;
        int caracterPuntos = 0;
        int giro = 0;
        boolean resultado = false;
        
        for(int i = 0; i < rango.length(); i++){
            if(rango.charAt(i) == '-'){
                caracterMenos++;
            }else if(rango.charAt(i) == '.'){
                caracterPuntos++;
            }
            giro++;
        }
            if(comboPrincipal.getSelectedItem().toString() == "Conversor Temperatura" && rango.length() >= 2 && rango.charAt(0) == '-' && rango.charAt(1) != '.'){
                if(caracterMenos < 2 && caracterPuntos < 2){
                    resultado = true;
                }else{
                    resultado = false;
                }
            }
        
        return resultado;
    }
    
    //Metodo para intercambiar los valores de los ComboBox entre si y cajas de texto.
    public void intercambioValor(){
        
        int valorBoxIzquierdo = comboIzquierda.getSelectedIndex();
        int valorBoxDerecha = comboDerecha.getSelectedIndex();
        String valorFieldIzquierdo =  boxFieldIzquierda.getText();
        String valorFieldDerocho = boxFieldDerecha.getText();
                
        comboIzquierda.setSelectedIndex(valorBoxDerecha);
        comboDerecha.setSelectedIndex(valorBoxIzquierdo);
        boxFieldDerecha.setText(valorFieldIzquierdo);
        boxFieldIzquierda.setText(valorFieldDerocho);
        
        if(!VerificarRango(boxFieldIzquierda.getText())){
        
        boxFieldDerecha.setText(super.Calculo(entradaDouble(),
                    comboIzquierda.getSelectedItem().toString(), comboDerecha.getSelectedItem().toString()));
        }
    }
    
    //Metodo evita que los JComboBox tengan el mismo valor y hace salto de posición.
    public void cambioValorIgualdad(String boxSeleccionado){
        switch(boxSeleccionado){
            case "ComboBoxIzquierdo":
                if(comboIzquierda.getSelectedIndex() == comboDerecha.getItemCount() -1 && comboDerecha.getSelectedIndex() == comboIzquierda.getItemCount() -1){
                    comboDerecha.setSelectedIndex(0);
                }else if(comboIzquierda.getSelectedIndex() == comboDerecha.getSelectedIndex()){
                    comboDerecha.setSelectedIndex(comboIzquierda.getSelectedIndex() +1);
                }
                break;
            case "ComboBoxDerecho":
                if(comboIzquierda.getSelectedIndex() == comboDerecha.getItemCount() - 1 && comboDerecha.getSelectedIndex() == comboIzquierda.getItemCount() -1){
                    comboIzquierda.setSelectedIndex(0);
                }else if(comboDerecha.getSelectedIndex() == comboIzquierda.getSelectedIndex()){
                    comboIzquierda.setSelectedIndex(comboIzquierda.getSelectedIndex() +1);
                }
                break;
        }
  
    }
    
    public double entradaDouble(){
        
        return Double.parseDouble(boxFieldIzquierda.getText());
    }
}
