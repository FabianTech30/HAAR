
package com.mycompany.haar;

import java.sql.Connection;
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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Random;
import javax.swing.JOptionPane;





public class Cobro extends javax.swing.JFrame {
    private DefaultComboBoxModel<String> modeloComboClientes;
    private Menu menu;
    private Cconexion conexion; // Utilizamos la clase Cconexion para la conexión
 
    public Cobro() {
      setTitle("Cobro");
        setLocation(25, 0);
        setSize(1280, 720);
        initComponents();
        ComboBoxTipoCorte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Corte sencillo", "Normal", "Especial"}));
        ComboBoxServicioExtra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Sí", "No"}));
        modeloComboClientes = new DefaultComboBoxModel<>();
        ComboBoxCliente.setModel(modeloComboClientes);
        conexion = new Cconexion();
        establecerConexion();
    }
    private void establecerConexion() {
        try {
            Connection con = conexion.establecerConexion();
            String sql = "SELECT nombre_cliente, apellido_cliente FROM clientes ORDER BY nombre_cliente, apellido_cliente";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            modeloComboClientes.removeAllElements();
            while (rs.next()) {
                String nombreCliente = rs.getString("nombre_cliente");
                String apellidoCliente = rs.getString("apellido_cliente");
                String clienteCompleto = nombreCliente + " " + apellidoCliente;
                modeloComboClientes.addElement(clienteCompleto);
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar clientes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void insertarRegistroCobroEnDB(String clienteSeleccionado, Date fechaCobro, String tipoCorte, String servicioExtra, double montoAdicional, double subtotal, double iva, double total) {
    try {
        Connection con = conexion.establecerConexion();
        String sql = "INSERT INTO Cobros (Cliente, FechaCobro, TipoCorte, ServicioExtra, MontoAdicional, Subtotal, IVA, Total) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, clienteSeleccionado);
        ps.setTimestamp(2, new java.sql.Timestamp(fechaCobro.getTime()));
        ps.setString(3, tipoCorte);
        ps.setString(4, servicioExtra);
        ps.setDouble(5, montoAdicional);
        ps.setDouble(6, subtotal);
        ps.setDouble(7, iva);
        ps.setDouble(8, total);
        ps.executeUpdate();
        con.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al insertar el registro de cobro en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComboBoxTipoCorte = new javax.swing.JComboBox<>();
        ComboBoxServicioExtra = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnCobro1 = new javax.swing.JButton();
        txtMonto = new javax.swing.JTextField();
        ComboBoxCliente = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));
        setBounds(new java.awt.Rectangle(25, 0, 1280, 720));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.magenta);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ComboBoxTipoCorte.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        ComboBoxTipoCorte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxTipoCorte.setName("ComboBoxTipoCorte"); // NOI18N
        ComboBoxTipoCorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxTipoCorteActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBoxTipoCorte, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 379, 259, 47));

        ComboBoxServicioExtra.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        ComboBoxServicioExtra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxServicioExtra.setName("ComboBoxServicioExtra"); // NOI18N
        ComboBoxServicioExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxServicioExtraActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBoxServicioExtra, new org.netbeans.lib.awtextra.AbsoluteConstraints(718, 493, -1, 26));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel12.setText("Cliente");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 224, 70, -1));

        jLabel2.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel2.setText("Tipo de corte");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(619, 338, -1, 20));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("VOLVER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 555, 121, 39));

        btnCobro1.setBackground(new java.awt.Color(102, 102, 0));
        btnCobro1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnCobro1.setForeground(new java.awt.Color(255, 255, 255));
        btnCobro1.setText("COBRAR");
        btnCobro1.setName("btnCobrar1"); // NOI18N
        btnCobro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobro1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCobro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(823, 555, 121, 39));

        txtMonto.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtMonto.setName("txtMonto"); // NOI18N
        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });
        getContentPane().add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 493, 75, 30));

        ComboBoxCliente.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        ComboBoxCliente.setMaximumRowCount(40);
        ComboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxCliente.setName("ComboBoxTipoCorte"); // NOI18N
        ComboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxClienteActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBoxCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 265, 259, 47));

        jPanel1.setBackground(new java.awt.Color(0, 0, 27));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel3.setText("Monto Adicional");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, 130, 30));

        jLabel1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel1.setText("Servicio Extra");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        jLabel4.setText("COBRO");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 110, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 690, 630));

        jTextArea1.setBackground(new java.awt.Color(0, 0, 27));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setText("Corte Sencillo = 50$\nCorte Normal = 75$\nCorte Especial = 100$\nServicio Extra = 20$\n");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 390, 170, 110));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1290, 740));

        pack();
        setLocationRelativeTo(null);
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
            double subtotal = total / 1.16;
            double iva = total - subtotal;
            String clienteSeleccionado = ComboBoxCliente.getSelectedItem().toString();

            try {
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String fileName = "TotalCobro_" + timeStamp + ".pdf";
                String filePath = "C:\\Users\\fabyb\\OneDrive\\Escritorio\\HAAR\\cobros\\" + fileName;
                File file = new File(filePath);
                file.getParentFile().mkdirs();
                PdfWriter writer = new PdfWriter(filePath);
                PdfDocument pdf = new PdfDocument(writer);
                Document document = new Document(pdf, PageSize.A4);
                PdfFont font = PdfFontFactory.createFont();
                document.add(new Paragraph("HAAR \nRecibo de Cobro").setFont(font).setFontSize(20).setBold().setUnderline().setTextAlignment(TextAlignment.CENTER).setMarginBottom(20));
                document.add(new Paragraph("Fecha: " + timeStamp).setFont(font).setFontSize(12).setTextAlignment(TextAlignment.RIGHT).setMarginBottom(10));
                document.add(new Paragraph("Cliente: " + clienteSeleccionado).setFont(font).setFontSize(12).setMarginBottom(10));
                document.add(new Paragraph("Tipo de Corte: " + tipoCorte).setFont(font).setFontSize(12));
                document.add(new Paragraph("Servicio Extra: " + servicioExtra).setFont(font).setFontSize(12));
                document.add(new Paragraph("Monto Adicional: $" + montoAdicional).setFont(font).setFontSize(12));
                document.add(new Paragraph("Subtotal: $" + String.format("%.2f", subtotal)).setFont(font).setFontSize(12));
                document.add(new Paragraph("IVA (16%): $" + String.format("%.2f", iva)).setFont(font).setFontSize(12));
                document.add(new Paragraph("Total a Pagar: $" + String.format("%.2f", total)).setFont(font).setFontSize(12).setBold().setMarginBottom(20));
                document.close();
                JOptionPane.showMessageDialog(null, "Documento PDF creado con éxito: " + fileName, "Total de Cobro", JOptionPane.INFORMATION_MESSAGE);
                insertarRegistroCobro(Files.readAllBytes(Paths.get(filePath)), fileName);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al crear el documento PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
       insertarRegistroCobroEnDB(clienteSeleccionado, new Date(), tipoCorte, servicioExtra, montoAdicional, subtotal, iva, total);

        }
}

   private void insertarRegistroCobro(byte[] pdfData, String fileName) {
    try {
        Connection con = conexion.establecerConexion();

        // Insertar el registro en la tabla 'cobro' sin especificar un valor para la columna 'id'
        String sql = "INSERT INTO cobro (registro_pdf, nombre_archivo) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setBytes(1, pdfData);
        ps.setString(2, fileName); // Agregar el nombre del archivo
        ps.executeUpdate();

        con.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al insertar el registro en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }


    }
       private void actualizarRegistroPDF(String fileName) {
        try {
            Connection con = conexion.establecerConexion();
            String sql = "UPDATE clientes SET registros_pdf = ? WHERE nombre_cliente = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fileName);
            ps.setString(2, ComboBoxCliente.getSelectedItem().toString());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el registro PDF en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        if (servicioExtra.equals("Sí")) {
            precioBase += 20;
        }
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
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables

    }

