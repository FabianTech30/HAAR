/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.haar;


/**
 *
 * @author fabyb
 */
public class HAAR {

    public static void main(String[] args) {
                // Ejecutar la aplicación
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            Login frame = new Login(); // Reemplaza NewJFrame con el nombre de tu clase JFrame
            frame.setVisible(true);
        }
    });
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            Cobro frame = new Cobro(); // Reemplaza NewJFrame con el nombre de tu clase JFrame
            frame.setVisible(true);
        }

    });
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            AgregarCliente frame = new AgregarCliente(); // Reemplaza NewJFrame con el nombre de tu clase JFrame
            frame.setVisible(true);
        }

    });
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            Clientes frame = new Clientes(); // Reemplaza NewJFrame con el nombre de tu clase JFrame
            frame.setVisible(true);
        }

    });
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            NuevaCita frame = new NuevaCita(); // Reemplaza NewJFrame con el nombre de tu clase JFrame
            frame.setVisible(true);
        }

    }); 
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            Menu frame = new Menu(); // Reemplaza NewJFrame con el nombre de tu clase JFrame
            frame.setVisible(true);
        }

    });
         
         
         
    }
}
