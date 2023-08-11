
package ConversorMoneda;

/**
 *
 * @author Leidy Giraldo
 */
public class ConversorDivisa {
    
   private String[] tipoMoneda;
    private double[][] tasaCambio;

    public ConversorDivisa(String[] monedas) {
        this.tipoMoneda = monedas;
        this.tasaCambio = new double[tipoMoneda.length][tipoMoneda.length];

        for (int i = 0; i < tipoMoneda.length; i++) {
            tasaCambio[i][i] = 1.0;
        }
    }

    public void obtenerTasaCambio(String monedaOrigen, String monedaDestino, double tasa) {
        int posicionOrigen = obtenerPosicionMoneda(monedaOrigen);
        int posicionDestino = obtenerPosicionMoneda(monedaDestino);
        tasaCambio[posicionOrigen][posicionDestino] = tasa;
    }

    private int obtenerPosicionMoneda(String moneda) {
        for (int i = 0; i < tipoMoneda.length; i++) {
            if (tipoMoneda[i].equalsIgnoreCase(moneda)) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }
 double cantidad;
    public double convercionMoneda(String monedaOrigen, String monedaDestino, double cantidad) {
        int posicionOrigen = obtenerPosicionMoneda(monedaOrigen);
        int posicionDestino = obtenerPosicionMoneda(monedaDestino);
        double tasaOrigen = tasaCambio[posicionOrigen][posicionOrigen];
        double tasaDestino = tasaCambio[posicionOrigen][posicionDestino];
        return cantidad * tasaDestino / tasaOrigen;
    } 
    
}
