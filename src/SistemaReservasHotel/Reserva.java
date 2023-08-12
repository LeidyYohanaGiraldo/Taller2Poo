
package SistemaReservasHotel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Leidy Giraldo
 */
public class Reserva {
    
    private int id;
    private Cliente cliente;
    private Hotel hotel;
    private List<Reserva> listaReserva = new ArrayList<>();

    public Reserva(int id, Cliente cliente, Hotel hotel) {
        this.id = id;
        this.cliente = cliente;
        this.hotel = hotel;
    }

    Reserva() {
    }

    public void crearReserva(List<Hotel> listaHoteles, List<Cliente> listaCliente, int opcionesEmpresa,
            int opcionesHotel, String numeroHabitacion) {
        Cliente cliente2 = new Cliente();
        Hotel datosHotel2 = new Hotel();

        ++id;
        cliente2.setNombreEmpleado(JOptionPane.showInputDialog("Ingrese nombre de el empleado"));
        cliente2.setCedulaEmpleado(JOptionPane.showInputDialog("Ingrese cedula de el empleado"));
        cliente2.setNombreEmpresa(listaCliente.get(opcionesEmpresa - 1).getNombreEmpresa());
        cliente2.setNitEmpresa(listaCliente.get(opcionesEmpresa - 1).getNitEmpresa());

        datosHotel2.setIdHotel(listaHoteles.get(opcionesHotel - 1).getIdHotel());
        datosHotel2.setNombreHotel(listaHoteles.get(opcionesHotel - 1).getNombreHotel());
        datosHotel2.setUbicacion(listaHoteles.get(opcionesHotel - 1).getUbicacion());
       
        extraerInfoHabitacion(listaHoteles.get(opcionesHotel - 1), numeroHabitacion);

        datosHotel2.agregarHabitacion(new Habitacion(numeroHabitacion, false,
                String.valueOf(extraerInfoHabitacion(listaHoteles.get(opcionesHotel - 1), numeroHabitacion).get(0)),
                String.valueOf(extraerInfoHabitacion(listaHoteles.get(opcionesHotel - 1), numeroHabitacion).get(1))));

        Reserva nuevaReserva = new Reserva(id, cliente2, datosHotel2);

        listaReserva.add(nuevaReserva);
    }
    
        private List<Object> extraerInfoHabitacion(Hotel datosHotel, String numeroHabitacion) {
        List<Object> datosAExtraer = new ArrayList<>();
            for(int i = 0 ; i < datosHotel.getHabitacion().size(); i++){
            if(datosHotel.getHabitacion().get(i).getNumeroHabitacion().equals(numeroHabitacion)){
                datosAExtraer.add(datosHotel.getHabitacion().get(i).getTipo());
                datosAExtraer.add(datosHotel.getHabitacion().get(i).getCostoDia());
                break;
            }
            }
            return datosAExtraer;
    }

    public void consultarReserva(int opcionesHotel) {
        StringBuilder mensajeroReserva = new StringBuilder();
        for (int i = 0; i < listaReserva.size(); i++) {

            if (listaReserva.get(i).hotel.getIdHotel() == (opcionesHotel)) {
                mensajeroReserva.append(listaReserva.get(i).id)
                        .append("\nNombre: ")
                        .append(listaReserva.get(i).cliente.getNombreEmpleado())
                        .append("\nCedula: ")
                        .append(listaReserva.get(i).cliente.getCedulaEmpleado())
                        .append("\nNombre de la Empresa: ")
                        .append(listaReserva.get(i).cliente.getNombreEmpresa())
                        .append("\nNumero de Habitacion: ")
                        .append(listaReserva.get(i).hotel.getHabitacion().get(0).getNumeroHabitacion())
                        .append("\nTipo de Habitacion: ")
                        .append(listaReserva.get(i).hotel.getHabitacion().get(0).getTipo())
                         .append("\nCosto de Habitacion: ")
                        .append(listaReserva.get(i).hotel.getHabitacion().get(0).getCostoDia())
                        .append("\n\n\n");
            }
        }
        JOptionPane.showMessageDialog(null, (mensajeroReserva.toString()));
    }

    public List<Object> cancelarReserva() {
        List<Object> infoHotel = new ArrayList<>();
        int eliminarPosicion = Integer.parseInt(JOptionPane.showInputDialog("Digita el id de la reserva que desea eliminar"));
        
        
        for(int i = 0; i < listaReserva.size(); i++){
        
            if(listaReserva.get(i).id == eliminarPosicion){
             infoHotel.add(listaReserva.get(i).getHotel().getIdHotel()-1);
              infoHotel.add(listaReserva.get(i).getHotel().getHabitacion().get(0).getNumeroHabitacion());
            listaReserva.remove(i);
            System.out.println(" Su registro fue eliminado con éxito.");
            }
        }

        return infoHotel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Reserva> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(List<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }


    
}
