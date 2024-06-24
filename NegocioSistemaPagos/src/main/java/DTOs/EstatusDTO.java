/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.List;

public class EstatusDTO {

    private Long id;
    private String nombre;
    private List<Estatus_pagoDTO> estatusPagos;
    private boolean eliminado;

    public EstatusDTO() {
    }

    public EstatusDTO(String nombre, List<Estatus_pagoDTO> estatusPagos) {
        this.nombre = nombre;
        this.estatusPagos = estatusPagos;
    }

    public EstatusDTO(Long id, String nombre, List<Estatus_pagoDTO> estatusPagos) {
        this.id = id;
        this.nombre = nombre;
        this.estatusPagos = estatusPagos;
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

    public List<Estatus_pagoDTO> getEstatusPagos() {
        return estatusPagos;
    }

    public void setEstatusPagos(List<Estatus_pagoDTO> estatusPagos) {
        this.estatusPagos = estatusPagos;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    @Override
    public String toString() {
        return "EstatusDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estatusPagos=" + estatusPagos +
                ", eliminado=" + eliminado +
                '}';
    }
}
