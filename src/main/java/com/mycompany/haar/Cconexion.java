package com.mycompany.haar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Cconexion {

    private Connection conectar = null;
    private final String usuario = "usersql";
    private final String contrasenia = "FAbt@2020";
    private final String bd = "haar";
    private final String ip = "localhost";
    private final String puerto = "1433";

    // Método para establecer la conexión
    public Connection establecerConexion() {
        try {
            String cadena = "jdbc:sqlserver://" + ip + ":" + puerto + ";databaseName=" + bd;
            conectar = DriverManager.getConnection(cadena, usuario, contrasenia);
            JOptionPane.showMessageDialog(null, "Se conectó correctamente a la base de datos");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos, error: " + e.toString());
        }
        return conectar;
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        try {
            if (conectar != null && !conectar.isClosed()) {
                conectar.close();
                JOptionPane.showMessageDialog(null, "Se cerró correctamente la conexión a la base de datos");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión, error: " + e.toString());
        }
    }

    // Método para obtener un PreparedStatement
    public PreparedStatement prepararConsulta(String consulta) {
        try {
            return conectar.prepareStatement(consulta);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al preparar la consulta, error: " + e.toString());
            return null;
        }
    }
}
