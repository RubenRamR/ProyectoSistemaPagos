/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadestemporales;

/**
 *
 * @author crazy
 */
public class Abono {
    String id;
    String FechaHora;
    String monto;

    public Abono() {
    }

    public Abono(String id, String FechaHora, String monto) {
        this.id = id;
        this.FechaHora = FechaHora;
        this.monto = monto;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(String FechaHora) {
        this.FechaHora = FechaHora;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }
    
    
    
}
