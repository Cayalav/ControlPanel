/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import javax.swing.JButton;

/**
 *
 * @author caya
 */
public class OpaqueButton {

    public OpaqueButton(JButton Button) {
        Button.setOpaque(false);
        Button.setContentAreaFilled(false);
        Button.setBorderPainted(false);
    }
}
