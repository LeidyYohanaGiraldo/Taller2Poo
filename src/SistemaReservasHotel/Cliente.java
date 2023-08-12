package SistemaReservasHotel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Leidy Giraldo
 */
public class Cliente {

    private String id;
    private int idEmpleado;
    private String nombreEmpresa;
    private String nitEmpresa;
    private String nombreEmpleado;
    private String cedulaEmpleado;
    private List<Cliente> datosEmpresa = new ArrayList<>();

    public Cliente(String id, String nombreEmpresa, String nitEmpresa) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.nitEmpresa = nitEmpresa;
    }

    public Cliente(int idEmpleado, String nombreEmpleado, String cedulaEmpleado) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public Cliente() {
    }

    public void empresasVinculadas() {

        Cliente nombreEmpresa1 = new Cliente("1.", "ByteTech ", "865467890");
        Cliente nombreEmpresa2 = new Cliente("2.", "FuturaByte ", "9876544");
        Cliente nombreEmpresa3 = new Cliente("3.", "CyberShield ", "253679934");
        Cliente nombreEmpresa4 = new Cliente("4.", "CloudSolution ", "14546795");

        datosEmpresa.add(nombreEmpresa1);
        datosEmpresa.add(nombreEmpresa2);
        datosEmpresa.add(nombreEmpresa3);
        datosEmpresa.add(nombreEmpresa4);

    }

    public int mostrarInfoEmpresas() {
        StringBuilder mensajeEmpresa = new StringBuilder();

        for (int i = 0; i < datosEmpresa.size(); i++) {

            mensajeEmpresa.append("Id ").append(datosEmpresa.get(i).id)              
                    .append("  ")
                    .append(datosEmpresa.get(i).nombreEmpresa)
                    .append("\n");

        }

        return Integer.parseInt(JOptionPane.showInputDialog("BIENVENIDO, A NUESTRA PLATAFORMA DE RESERVAS\n\n\n"
                + "Ingresa el numero de id de la empresa a la que perteneces \n\n" + mensajeEmpresa.toString()
                + "5. Salir"));
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(String cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public List<Cliente> getDatosEmpresa() {
        return datosEmpresa;
    }

    public void setDatosEmpresa(List<Cliente> datosEmpresa) {
        this.datosEmpresa = datosEmpresa;
    }

}
