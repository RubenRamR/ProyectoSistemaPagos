/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.BeneficiarioEntidad;
import entidades.CuentaBancariaEntidad;
import entidades.PagoEntidad;
import java.util.List;

/**
 *
 * @author caarl
 */
public interface ICuentaBancariaDAO {
   void guardarCuentaBancaria(CuentaBancariaEntidad cuentaBancaria);
    void modificarCuentaBancaria(Long id, CuentaBancariaEntidad cuentaBancaria);
    void guardarCuentaBancariaConRelaciones(CuentaBancariaEntidad cuentaBancaria, BeneficiarioEntidad beneficiario, List<PagoEntidad> pagos);
}
