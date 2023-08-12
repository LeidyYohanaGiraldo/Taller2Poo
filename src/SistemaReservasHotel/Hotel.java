package SistemaReservasHotel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Leidy Giraldo
 */
public class Hotel {

    private int idHotel;
    private String nombreHotel;
    private String ubicacion;
    private String categoria;
    private List<Habitacion> habitacion = new ArrayList<>();
    private List<Hotel> hotel = new ArrayList<>();

    public Hotel(int idHotel, String nombreHotel, String ubicacion, String categoria) {
        this.idHotel = idHotel;
        this.nombreHotel = nombreHotel;
        this.ubicacion = ubicacion;
        this.categoria = categoria;
        this.habitacion = new ArrayList<>();
    }

    public Hotel() {
    }

    public void CrearHoteles() {

        Hotel hotel1 = new Hotel(1, "Hotel de la Costa", "- San Andres", "- 5 Estrellas (Lujo)");

        hotel1.agregarHabitacion(new Habitacion("122", true, "Individual", "$217.000"));
        hotel1.agregarHabitacion(new Habitacion("123", true, "Triple", "$395.000"));
        hotel1.agregarHabitacion(new Habitacion("223", true, "Queen", "$429.000"));
        hotel1.agregarHabitacion(new Habitacion("224", true, "Individual", "$217.000"));
        hotel1.agregarHabitacion(new Habitacion("225", true, "Suite", "$648.000"));
        hotel1.agregarHabitacion(new Habitacion("325", true, "Queen", "$429.000"));
        hotel1.agregarHabitacion(new Habitacion("326", true, "Doble", "$300.000"));
        hotel1.agregarHabitacion(new Habitacion("327", true, "Triple", "$395.000"));

        Hotel hotel2 = new Hotel(2, "Malibú Hotel", "- Cartagena", "- 3 Estrellas (Estándar)");
        hotel2.agregarHabitacion(new Habitacion("111", true, "Triple", "$200.000"));
        hotel2.agregarHabitacion(new Habitacion("112", true, "Doble", "$150.000"));
        hotel2.agregarHabitacion(new Habitacion("113", true, "Queen", "$256.000"));
        hotel2.agregarHabitacion(new Habitacion("214", true, "Doble", "$150.000"));
        hotel2.agregarHabitacion(new Habitacion("215", true, "Queen", "$256.000"));
        hotel2.agregarHabitacion(new Habitacion("311", true, "Individual", "$100.000"));
        hotel2.agregarHabitacion(new Habitacion("313", true, "Triple", "$200.000"));

        Hotel hotel3 = new Hotel(3, "Hotel Islas Encantadas", "-   Santa Martha", "- 4 Estrellas (Superior)");
        hotel3.agregarHabitacion(new Habitacion("132", true, "Individual", "$138.000"));
        hotel3.agregarHabitacion(new Habitacion("133", true, "Individual", "$138.000"));
        hotel3.agregarHabitacion(new Habitacion("134", true, "Queen", "$322.000"));
        hotel3.agregarHabitacion(new Habitacion("235", true, "Queen", "$322.000"));
        hotel3.agregarHabitacion(new Habitacion("335", true, "Doble", "$214.000"));
        hotel3.agregarHabitacion(new Habitacion("336", true, "Suite", "$450.000"));
        hotel3.agregarHabitacion(new Habitacion("337", true, "Doble", "$214.000"));

        Hotel hotel4 = new Hotel(4, "Hillside Hotel", "-  Medellin", "-  5 Estrellas (Lujo)");
        hotel4.agregarHabitacion(new Habitacion("102", true, "Individual", "$170.000"));
        hotel4.agregarHabitacion(new Habitacion("103", true, "Doble", "$260.000"));
        hotel4.agregarHabitacion(new Habitacion("204", true, "Queen", "$380.000"));
        hotel4.agregarHabitacion(new Habitacion("205", true, "Triple", "$320.000"));
        hotel4.agregarHabitacion(new Habitacion("305", true, "Suite", "$550.000"));
        hotel4.agregarHabitacion(new Habitacion("306", true, "Triple", "$320.000"));
        hotel4.agregarHabitacion(new Habitacion("307", true, "Doble", "$260.000"));

        hotel.add(hotel1);
        hotel.add(hotel2);
        hotel.add(hotel3);
        hotel.add(hotel4);

    }

    public void agregarHabitacion(Habitacion nuevaHabitacion) {
        habitacion.add(nuevaHabitacion);
    }

    public int mostrarinfoHotel() {
        StringBuilder mensajeHoteles = new StringBuilder();

        for (int i = 0; i < hotel.size(); i++) {
            mensajeHoteles.append(hotel.get(i).idHotel)
                    .append("  ")
                    .append(hotel.get(i).nombreHotel)
                    .append("   ")
                    .append(hotel.get(i).ubicacion)
                    .append("  ")
                    .append(hotel.get(i).categoria)
                    .append("\n");
        }

        return Integer.parseInt(JOptionPane.showInputDialog("Hoteles disponibles \n\n\n" + "Ingrese el Id del Hotel, para consultar o crear su reserva \n\n\n" + mensajeHoteles.toString()
                + "5. Salir"));
    }

    public void mostrarInformacionHabitacion(int idHotel) {
        StringBuilder mensajeHoteles = new StringBuilder();
        for (int j = 0; j < hotel.get(idHotel - 1).habitacion.size(); j++) {

            Habitacion habitacionActual = hotel.get(idHotel - 1).habitacion.get(j);

            if (habitacionActual.isDisponible()) {
                String estado = habitacionActual.isDisponible() ? "Disponible" : "Ocupada";
                String tipo = habitacionActual.getTipo();
                String costoDia = habitacionActual.getCostoDia();

                mensajeHoteles.append("Habitación: ").append(habitacionActual.getNumeroHabitacion())
                        .append("\nTipo: ").append(tipo)
                        .append("\nCosto por día: ").append(costoDia)
                        .append(estado)
                        .append("\n\n");

            }
        }
        JOptionPane.showMessageDialog(null, "Habitaciones disponibles \n\n\n"
                + mensajeHoteles.toString());

    }

    public String modificarEstadoHabitacion(int opcionesHotel) {
        boolean reservaHecha = false;
        String opcionHabitacion = JOptionPane.showInputDialog("Ingrese el numero de habitación a reservar");
        for (int i = 0; i < hotel.get(opcionesHotel - 1).getHabitacion().size(); i++) {

            if (hotel.get(opcionesHotel - 1).getHabitacion().get(i).isDisponible() == true
                    && hotel.get(opcionesHotel - 1).getHabitacion().get(i).getNumeroHabitacion()
                            .equals(opcionHabitacion)) {

                hotel.get(opcionesHotel - 1).getHabitacion().get(i).setDisponible(false);
                reservaHecha = true;
                break;
            }

        }
        opcionHabitacion = reservaHecha ? opcionHabitacion : null;
        System.out.println("Validando información");
        return opcionHabitacion;
    }

    public void activarHabitacion(List<Object> infoHabitacionActivar) {
        for (int i = 0; i < hotel.get(Integer.parseInt(String.valueOf(infoHabitacionActivar.get(0))))
                .getHabitacion().size(); i++) {
            if (hotel.get(Integer.parseInt(String.valueOf(infoHabitacionActivar.get(0))))
                    .getHabitacion().get(i).getNumeroHabitacion().equals(infoHabitacionActivar.get(1))) {
                hotel.get(Integer.parseInt(String.valueOf(infoHabitacionActivar.get(0))))
                        .getHabitacion().get(i).setDisponible(true);
            }
        }

    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Habitacion> getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(List<Habitacion> habitacion) {
        this.habitacion = habitacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Hotel> getHotel() {
        return hotel;
    }

    public void setHotel(List<Hotel> hotel) {
        this.hotel = hotel;
    }

}
