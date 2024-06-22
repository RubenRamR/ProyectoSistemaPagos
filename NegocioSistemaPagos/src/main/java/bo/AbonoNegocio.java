/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DTOs.AbonoDTO;
import DTOs.PagoDTO;
import InterfacesNegocio.IAbonoNegocio;
import conexion.ConexionBD;
import daos.AbonoDAO;
import daos.PagoDAO;
import entidades.AbonoEntidad;
import entidades.PagoEntidad;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IAbonoDAO;
import interfaces.IBeneficiarioDAO;
import interfaces.IConexionBD;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rramirez
 */
public class AbonoNegocio implements IAbonoNegocio {

    private IAbonoDAO abonoDAO;
    private IBeneficiarioDAO beneficiarioDAO;
    private static final Logger LOGGER = Logger.getLogger(AbonoNegocio.class.getName());
    IConexionBD conexion;

    public AbonoNegocio() {
        this.conexion = new ConexionBD();
        this.abonoDAO = new AbonoDAO(conexion);
    }

    @Override
    public void guardarAbono(AbonoDTO abonoDTO) throws NegocioException {
    }

    @Override
    public void modificarAbono(Long id, AbonoDTO abono) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardarAbonoConRelacion(AbonoDTO abonoDTO, PagoDTO pagoDTO) throws NegocioException {
        try {
            PagoEntidad pago = new PagoEntidad(
                    pagoDTO.getMonto(),
                    pagoDTO.getComprobante(),
                    pagoDTO.getFechaHora()
            );

            PagoDAO pagodao = new PagoDAO(conexion);
            if (pagoDTO.getId() == null) {
                pagodao.guardarPago(pago);
            } else {
                pago = pagodao.buscarPagoPorId(pagoDTO.getId());
            }

            AbonoEntidad abonoE = new AbonoEntidad(
                    abonoDTO.getFechaHora(),
                    abonoDTO.getMonto(),
                    pago);

            abonoDAO.guardarAbono(abonoE);

        } catch (PersistenciaException ex) {
            Logger.getLogger(AbonoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
