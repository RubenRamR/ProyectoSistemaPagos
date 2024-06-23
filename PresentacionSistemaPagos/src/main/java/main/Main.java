/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import entidades.BeneficiarioEntidad;
import gui.FrmLogin;
import javax.swing.UIManager;



/**
 *
 * @author rramirez
 */
public class Main {

    public static void main(String[] args) {
        
        
        
        
        
        try {
            UIManager.setLookAndFeel(new FlatLightLaf()); 
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        FrmLogin fl = new FrmLogin();
        fl.setVisible(true);
        
    }
}
