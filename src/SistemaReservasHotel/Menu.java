package SistemaReservasHotel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Leidy Giraldo
 */
public class Menu {

    List<Hotel> Listahoteles = new ArrayList<>();
    int contador = 0;

    public void MenuPrincipal() {
        Cliente cliente = new Cliente();
        Hotel hotel = new Hotel();
        Reserva reservacion = new Reserva();
        boolean bandera = true;
        while (bandera) {

            if (contador < 1) {
                cliente.empresasVinculadas();
                hotel.CrearHoteles();
            }
            int opcionesEmpresa = cliente.mostrarInfoEmpresas();
            if (opcionesEmpresa == 5) {
                bandera = false;
                break;
            }

            int OpcionesHotel = hotel.mostrarinfoHotel();
            if (OpcionesHotel == 5) {
                bandera = false;
                MenuPrincipal();
            }
            hotel.mostrarInformacionHabitacion(OpcionesHotel);

            int opcionReserva = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero de la accion que deseas realizar\n\n"
                    + "1. Consultar reserva \n\n"
                    + "2. Crear Reserva \n\n"
                    + "3. Cancelar reserva \n\n"
                    + "4. Volver Al Menu De inicio"));

            contador++;

            switch (opcionReserva) {
                case 1:
                    reservacion.consultarReserva(OpcionesHotel);
                    break;
                case 2:
                    String numeroHabitacion = hotel.modificarEstadoHabitacion(OpcionesHotel);
                    if (numeroHabitacion != null) {
                        reservacion.crearReserva(hotel.getHotel(), cliente.getDatosEmpresa(), opcionesEmpresa,
                                OpcionesHotel, numeroHabitacion);
                    }
                    break;
                case 3:

                    hotel.activarHabitacion(reservacion.cancelarReserva());
                    break;
                case 4:
                    MenuPrincipal();
                    break;
                case 5:
                    bandera = false;
                    break;
                default:

            }
        }
    }

}
