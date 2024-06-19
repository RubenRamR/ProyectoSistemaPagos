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
public interface IBeneficiarioDAO {
void guardarBeneficiario(BeneficiarioEntidad beneficiario);
    void modificarBeneficiario(Long id, BeneficiarioEntidad beneficiario);
    void guardarBeneficiarioConRelaciones(BeneficiarioEntidad beneficiario, List<CuentaBancariaEntidad> cuentas, List<PagoEntidad> pagos);
}
