/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.List;

/**
 *
 * @author rramirez
 */
public class TipoPagoDTO {

    private Long id;
    private String nombre;
    private int numMensualidades;
    private List<PagoDTO> pagos;

    public TipoPagoDTO() {
    }

    public TipoPagoDTO(String nombre, int numMensualidades, List<PagoDTO> pagos) {
        this.nombre = nombre;
        this.numMensualidades = numMensualidades;
        this.pagos = pagos;
    }

    public TipoPagoDTO(Long id, String nombre, int numMensualidades, List<PagoDTO> pagos) {
        this.id = id;
        this.nombre = nombre;
        this.numMensualidades = numMensualidades;
        this.pagos = pagos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumMensualidades() {
        return numMensualidades;
    }

    public void setNumMensualidades(int numMensualidades) {
        this.numMensualidades = numMensualidades;
    }

    public List<PagoDTO> getPagos() {
        return pagos;
    }

    public void setPagos(List<PagoDTO> pagos) {
        this.pagos = pagos;
    }

    @Override
    public String toString() {
        return "TipoPagoDTO{" + "id=" + id + ", nombre=" + nombre + ", numMensualidades=" + numMensualidades + ", pagos=" + pagos + '}';
    }

}
