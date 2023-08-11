
package ConversorMoneda;

import javax.swing.JOptionPane;

/**
 *
 * @author Leidy Giraldo
 */
public class MainConversionMoneda {

 
    public static void main(String[] args) {
       
        String[] tipoMoneda = {"USD", "COP", "ARS"};
        ConversorDivisa conversorDivisa = new ConversorDivisa(tipoMoneda);

        conversorDivisa.obtenerTasaCambio("USD", "COP", 4.140);
        conversorDivisa.obtenerTasaCambio("USD", "ARS", 280);
        conversorDivisa.obtenerTasaCambio("COP", "USD", 0.00024);
        conversorDivisa.obtenerTasaCambio("COP", "ARS", 0.0675);
        conversorDivisa.obtenerTasaCambio("ARS", "COP", 14.82);
        conversorDivisa.obtenerTasaCambio("ARS", "USD", 0.0036);

        double cantidad;
        cantidad = Double.parseDouble(JOptionPane.showInputDialog("Por favor ingrese un valor de conversion"));

        double cantidadDolaresAPesosColombianos = conversorDivisa.convercionMoneda("USD", "COP", cantidad);
        double cantidadDolaresAPesosArgentinos = conversorDivisa.convercionMoneda("USD", "ARS", cantidad);
        double cantidadPesosColombianosADolares = conversorDivisa.convercionMoneda("COP", "USD", cantidad);
        double cantidadPesosColombianosAArgentinos = conversorDivisa.convercionMoneda("COP", "ARS", cantidad);
        double cantidadPesosArgentinosAColombianos = conversorDivisa.convercionMoneda("ARS", "COP", cantidad);
        double cantidadPesosArgentinosADolares = conversorDivisa.convercionMoneda("ARS", "USD", cantidad);

        JOptionPane.showMessageDialog(null, "La cantidad ingresada en Dolares equivale a: " + "\n"
                + cantidadDolaresAPesosColombianos + " COP: pesos Colombianos." + "\n" + "\n"
                + "La cantidad ingresada en Dolares equivale a: " + "\n"
                + cantidadDolaresAPesosArgentinos + " ARS: pesos Argentinos." + "\n" + "\n"
                + "La cantidad ingresada en pesos Colombianos equivale a: "
                + "\n" + cantidadPesosColombianosADolares + " USD: Dolares" + "\n" + "\n"
                + "La cantidad ingresada en pesos Colombianos equivale a: " + "\n"
                + cantidadPesosColombianosAArgentinos + " ARS: pesos Argentinos." + "\n" + "\n"
                + "La cantidad ingresada en pesos Argentinos equivale a: " + "\n"
                + cantidadPesosArgentinosAColombianos + " COP: pesos Colombianos." + "\n" + "\n"
                + "La cantidad ingresada en pesos Argentinos equivale a: " + "\n"
               + cantidadPesosArgentinosADolares + " USD: Dolares");   
        
    }
    
}
