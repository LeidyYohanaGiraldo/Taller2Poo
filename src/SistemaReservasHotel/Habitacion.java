
package SistemaReservasHotel;

/**
 *
 * @author Leidy Giraldo
 */
public class Habitacion {
    
    private String numeroHabitacion;
    private boolean disponible;
    private String  tipo;
    private String costoDia;

    public Habitacion(String numeroHabitacion, boolean disponible, String tipo, String costoDia) {
        this.numeroHabitacion = numeroHabitacion;
        this.disponible = disponible;
        this.tipo = tipo; 
        this.costoDia = costoDia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCostoDia() {
        return costoDia;
    }

    public void setCostoDia(String costoDia) {
        this.costoDia = costoDia;
    }



    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }


    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    
}
