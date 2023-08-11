
package Calculadora;

import javax.swing.JOptionPane;

/**
 *
 * @author Leidy Giraldo
 */
public class Calculadora {
    private OperacionMatematica[] operaciones = {
        new Suma(),
        new Resta(),
        new Multiplicacion(),
        new Division()
    };

    public void ejecutarCalculadora() {
        Object[] opcionOperacion = {"1. Sumar", "2. Restar", "3. Multiplicar", "4. Dividir", "5. Salir"};
        Object opcionesDeOperacion = JOptionPane.showInputDialog(null, "Seleccione la opción de operación que desea realizar", "Menu", JOptionPane.QUESTION_MESSAGE, null, opcionOperacion, opcionOperacion[0]);

        if (opcionesDeOperacion == null|| opcionesDeOperacion.equals("5. Salir")) {
            JOptionPane.showMessageDialog(null, "Programa Finalizado","Adios!",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
        }

        String operacionElegida = (String) opcionesDeOperacion;
        int indiceOperacion = obtenerIndiceOperacion(operacionElegida);

        double numero1 = obtenerNumero();
        double numero2 = obtenerNumero();

        double resultado = operaciones[indiceOperacion].calcular(numero1, numero2);

        mostrarResultado(resultado);
    }

    public int obtenerIndiceOperacion(String operacionElegida) {
        switch (operacionElegida) {
            case "1. Sumar":
                return 0;
            case "2. Restar":
                return 1;
            case "3. Multiplicar":
                return 2;
            case "4. Dividir":
                return 3;
            default:
                throw new IllegalArgumentException("Operación no válida");
        }
    }

    public double obtenerNumero() {
        String input = JOptionPane.showInputDialog("Por favor ingrese un número");
        return Double.parseDouble(input);
    }

    public void mostrarResultado(double resultado) {
        JOptionPane.showMessageDialog(null, "El resultado de la operacion es: " + resultado);
    }
    
}
