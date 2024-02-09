
package com.mycompany.haar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import java.util.Date;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;





public class Cobro extends javax.swing.JFrame {
    private DefaultComboBoxModel<String> modeloComboClientes;
    private Menu menu;
    private Cconexion conexion; // Utilizamos la clase Cconexion para la conexión
 
    public Cobro() {
    setTitle("Cobro");
    setLocation(25,0);
    setSize(1280,720);
    initComponents();
    ComboBoxTipoCorte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Corte sencillo", "Normal", "Especial"}));
    ComboBoxServicioExtra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Sí", "No"}));
    
    // Inicializar el modelo del ComboBoxCliente
    modeloComboClientes = new DefaultComboBoxModel<>();
    ComboBoxCliente.setModel(modeloComboClientes);
    
    // Establecer la conexión en el constructor
    conexion = new Cconexion();
    establecerConexion();
    }
    private void establecerConexion() {
        try {
        Cconexion conexion = new Cconexion();
        Connection con = conexion.establecerConexion();

        // Modificar la consulta SQL para obtener el nombre y apellido del cliente
        String sql = "SELECT nombre_cliente, apellido_cliente FROM clientes ORDER BY nombre_cliente, apellido_cliente";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        // Limpiar el modelo actual del combo
        modeloComboClientes.removeAllElements();

        // Llenar el modelo con los nombres y apellidos de los clientes
        while (rs.next()) {
            String nombreCliente = rs.getString("nombre_cliente");
            String apellidoCliente = rs.getString("apellido_cliente");
            String clienteCompleto = nombreCliente + " " + apellidoCliente; // Modificar el formato si es necesario
            modeloComboClientes.addElement(clienteCompleto);
        }

        // Cerrar la conexión
        con.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cargar clientes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComboBoxTipoCorte = new javax.swing.JComboBox<>();
        ComboBoxServicioExtra = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnCobro1 = new javax.swing.JButton();
        txtMonto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ComboBoxCliente = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.magenta);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setSize(new java.awt.Dimension(1280, 720));

        ComboBoxTipoCorte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxTipoCorte.setName("ComboBoxTipoCorte"); // NOI18N
        ComboBoxTipoCorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxTipoCorteActionPerformed(evt);
            }
        });

        ComboBoxServicioExtra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxServicioExtra.setName("ComboBoxServicioExtra"); // NOI18N
        ComboBoxServicioExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxServicioExtraActionPerformed(evt);
            }
        });

        jLabel1.setText("Servicio Extra");

        jLabel2.setText("Tipo de corte");

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("VOLVER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnCobro1.setBackground(new java.awt.Color(51, 51, 51));
        btnCobro1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCobro1.setForeground(new java.awt.Color(255, 255, 255));
        btnCobro1.setText("COBRAR");
        btnCobro1.setName("btnCobrar1"); // NOI18N
        btnCobro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobro1ActionPerformed(evt);
            }
        });

        txtMonto.setName("txtMonto"); // NOI18N
        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });

        jLabel3.setText("Monto Adicional");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Cobro");

        jLabel5.setText("Corte Sencillo = 50$");

        jLabel6.setText("Corte Normal = 75$");

        jLabel7.setText("Corte Especial = 100$");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Costos:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Extras:");

        jLabel10.setText("Barba = 50$");

        jLabel11.setText("Peinado Mujer = 120$");

        ComboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxCliente.setName("ComboBoxTipoCorte"); // NOI18N
        ComboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxClienteActionPerformed(evt);
            }
        });

        jLabel12.setText("Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(303, 303, 303)
                                        .addComponent(btnCobro1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(138, 138, 138))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel4))
                                        .addGap(377, 377, 377))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(226, 226, 226)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ComboBoxTipoCorte, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(62, 62, 62)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ComboBoxServicioExtra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGap(292, 292, 292))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 592, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))))
                .addGap(182, 182, 182))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel10)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(57, 57, 57))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(26, 26, 26)))
                        .addComponent(jLabel5)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(ComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(ComboBoxTipoCorte, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ComboBoxServicioExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCobro1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(96, 96, 96))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxTipoCorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxTipoCorteActionPerformed


    }//GEN-LAST:event_ComboBoxTipoCorteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCobro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobro1ActionPerformed
        if (ComboBoxTipoCorte.getSelectedItem().toString().trim().isEmpty()
            || ComboBoxServicioExtra.getSelectedItem().toString().trim().isEmpty() || txtMonto.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Ningún campo puede ser vacío", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        String tipoCorte = ComboBoxTipoCorte.getSelectedItem().toString();
        String servicioExtra = ComboBoxServicioExtra.getSelectedItem().toString();
        double montoAdicional = Double.parseDouble(txtMonto.getText());
        double total = calcularTotal(tipoCorte, servicioExtra, montoAdicional);
        double subtotal = total / 1.16; // Calcula el subtotal (sin IVA)
        double iva = total - subtotal; // Calcula el IVA
        String clienteSeleccionado = ComboBoxCliente.getSelectedItem().toString(); // Obtener el cliente seleccionado

        try {
            // Generar un nombre de archivo único con la fecha y hora actual
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = "TotalCobro_" + timeStamp + ".pdf";

            // Ruta completa del archivo
            String filePath = "C:\\Users\\fabyb\\OneDrive\\Escritorio\\HAAR\\cobros\\" + fileName;

            // Crear directorios si no existen
            File file = new File(filePath);
            file.getParentFile().mkdirs();

            // Crear el documento PDF
            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf, PageSize.A4);

            // Agregar contenido al documento
            PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
            document.add(new Paragraph("HAAR \nRecibo de Cobro").setFont(font).setFontSize(20).setBold().setUnderline().setTextAlignment(TextAlignment.CENTER).setMarginBottom(20));

            // Agregar datos del cobro
            document.add(new Paragraph("Fecha: " + timeStamp).setFont(font).setFontSize(12).setTextAlignment(TextAlignment.RIGHT).setMarginBottom(10));
            document.add(new Paragraph("Cliente: " + clienteSeleccionado).setFont(font).setFontSize(12).setMarginBottom(10)); // Agregar nombre y apellido del cliente
            document.add(new Paragraph("Tipo de Corte: " + tipoCorte).setFont(font).setFontSize(12));
            document.add(new Paragraph("Servicio Extra: " + servicioExtra).setFont(font).setFontSize(12));
            document.add(new Paragraph("Monto Adicional: $" + montoAdicional).setFont(font).setFontSize(12));
            document.add(new Paragraph("Subtotal: $" + String.format("%.2f", subtotal)).setFont(font).setFontSize(12));
            document.add(new Paragraph("IVA (16%): $" + String.format("%.2f", iva)).setFont(font).setFontSize(12));
            document.add(new Paragraph("Total a Pagar: $" + String.format("%.2f", total)).setFont(font).setFontSize(12).setBold().setMarginBottom(20));

            // Cerrar el documento
            document.close();

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(null, "Documento PDF creado con éxito: " + fileName, "Total de Cobro",
                    JOptionPane.INFORMATION_MESSAGE);

            // No redirigir automáticamente a la ventana de Menú
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el documento PDF: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_btnCobro1ActionPerformed

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActionPerformed

    private void ComboBoxServicioExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxServicioExtraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxServicioExtraActionPerformed

    private void ComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxClienteActionPerformed

private double calcularTotal(String tipoCorte, String servicioExtra, double montoAdicional) {
        double precioBase = 0;

        // Asignar precios base según el tipo de corte
        switch (tipoCorte) {
            case "Corte sencillo":
                precioBase = 50;
                break;
            case "Normal":
                precioBase = 75;
                break;
            case "Especial":
                precioBase = 100;
                break;
        }

        // Aplicar cargo adicional si el servicio extra es "Sí"
        if (servicioExtra.equals("Sí")) {
            precioBase += 20; // Puedes ajustar este valor según tus necesidades
        }

        // Sumar el monto adicional
        precioBase += montoAdicional;

        return precioBase;
    }

    public static void main(String args[]) {
 /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cobro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
            try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(Cobro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(() -> {
        new Cobro().setVisible(true);
    });
    
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxCliente;
    private javax.swing.JComboBox<String> ComboBoxServicioExtra;
    private javax.swing.JComboBox<String> ComboBoxTipoCorte;
    private javax.swing.JButton btnCobro1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables

    }

