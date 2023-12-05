

package com.mycompany.haar;


/**
 *
 * @author fabyb
 */
public class HAAR {

    public static void main(String[] args) {
        Cconexion objetoconexion = new Cconexion();
        objetoconexion.establecerConexion();
                // Ejecutar la aplicación
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login frame = new Login(); // Reemplaza NewJFrame con el nombre de tu clase JFrame
                frame.setVisible(true);
            }
        });
    }
}
 

