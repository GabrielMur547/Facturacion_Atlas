/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.toedter.calendar.JCalendar;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gmurillo
 */
public class Por_entregar extends javax.swing.JFrame {
    
    private String buscar = "";

    Menu Menu;
    Sesion Sesion;
    
    String pantalla;
    String factura;
    /**
     * Creates new form tet
     */
    public Por_entregar() {
        initComponents();
        facturasee();
        System.out.println("Por Entregar");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Logo_Atlas.png")));
    }
    
    public void buscar_factura(String busca){   
        buscar = busca;
        facturasee();
    }
    
    public void Pantallas(String pantalla){
        this.pantalla = pantalla;
    }
      
    String consulta;
    String factu;
    
    public void facturasee(){
                        
        Factura.setText(null);
        Cuenta.setText(null);
        Nombre.setText(null);
        Fiscal.setText(null);
        Monto.setText(null);
        Transaccion.setText(null);
        Observacion_text_big.setText( null);
        Estado.setSelectedItem(null);
        Fecha.setDate(null);
        
        DefaultTableModel modelo= (DefaultTableModel) table_factura.getModel();
        modelo.setRowCount(0);  
    try{
        Connection con = (Connection) ConexionMySQL.obtenerConexion();
        Statement stat = (Statement) con.createStatement();
            
        if(buscar.isEmpty()){
            consulta = "Select * From facturas";
        }
        else if (!buscar.isEmpty()){
            consulta = "Select * From facturas WHERE facturas.InvoiceNumber LIKE '%" + buscar + "%' OR facturas.DeptorNumber LIKE '%" + buscar + "%' OR facturas.cmp_name LIKE '%" + buscar + "%'";
        }
        
        ResultSet rs = (ResultSet) stat.executeQuery(consulta);
        
        rs.first();
        
        do{ 
            String[] fila = {rs.getString(1), rs.getString(2), rs.getString(3)};
                modelo.addRow(fila);
        }while(rs.next());
    }
    catch(ClassNotFoundException | SQLException ex){
        java.util.logging.Logger.getLogger(Por_entregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_factura = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Regresar = new javax.swing.JButton();
        Buscar_text = new javax.swing.JLabel();
        Buscar = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        Factura_text = new javax.swing.JLabel();
        Factura = new javax.swing.JTextField();
        Cuenta_text = new javax.swing.JLabel();
        Cuenta = new javax.swing.JTextField();
        Nombre_text = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        Fiscal_text = new javax.swing.JLabel();
        Fiscal = new javax.swing.JTextField();
        Monto_text = new javax.swing.JLabel();
        Monto = new javax.swing.JTextField();
        Transaccion = new javax.swing.JTextField();
        Transaccion_text = new javax.swing.JLabel();
        Estado_text = new javax.swing.JLabel();
        Fecha_text = new javax.swing.JLabel();
        Observacion_text = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Observacion_text_big = new javax.swing.JTextArea();
        Enviar_button = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        Estado = new javax.swing.JComboBox<>();
        Fecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 460));

        table_factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "N° De Factura", "N° De Cuenta", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_factura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_facturaMouseClicked(evt);
            }
        });
        table_factura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                table_facturaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(table_factura);
        if (table_factura.getColumnModel().getColumnCount() > 0) {
            table_factura.getColumnModel().getColumn(0).setMinWidth(90);
            table_factura.getColumnModel().getColumn(0).setMaxWidth(150);
            table_factura.getColumnModel().getColumn(1).setMinWidth(90);
            table_factura.getColumnModel().getColumn(1).setMaxWidth(150);
        }

        jPanel3.setBackground(new java.awt.Color(0, 40, 87));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pantallas/Logo_Atlas.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(253, 215, 0));
        jLabel1.setText("FACTURAS POR ENTREGAR");

        Regresar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Regresar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Buscar_text.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Buscar_text.setText("Buscar");

        Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarKeyReleased(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 40, 87));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Factura_text.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Factura_text.setText("Factura");

        Factura.setEditable(false);
        Factura.setEnabled(false);
        Factura.setFocusable(false);

        Cuenta_text.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Cuenta_text.setText("Cuenta");

        Cuenta.setEnabled(false);

        Nombre_text.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Nombre_text.setText("Nombre");

        Nombre.setAutoscrolls(false);
        Nombre.setEnabled(false);

        Fiscal_text.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Fiscal_text.setText("Fiscal");

        Fiscal.setEnabled(false);

        Monto_text.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Monto_text.setText("Monto");

        Monto.setEnabled(false);

        Transaccion.setEnabled(false);

        Transaccion_text.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Transaccion_text.setText("Transacción");

        Estado_text.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Estado_text.setText("Estado");

        Fecha_text.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Fecha_text.setText("Fecha presentación");

        Observacion_text.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Observacion_text.setText("Observación");

        Observacion_text_big.setColumns(20);
        Observacion_text_big.setLineWrap(true);
        Observacion_text_big.setRows(5);
        jScrollPane2.setViewportView(Observacion_text_big);

        Enviar_button.setText("Envíar a Ruta");
        Enviar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enviar_buttonActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton5.setText("Actualizar lista");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        Estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Por entregar", "En ruta", "Entregado", "Multa", "Sin información", "No encontrado" }));
        Estado.setEnabled(false);
        Estado.setFocusable(false);

        Fecha.setToolTipText("22/10/2023");
        Fecha.setDateFormatString("d/M/yyyy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Buscar_text)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Nombre_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Factura_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(Estado_text, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Fiscal_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Fiscal, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(Factura)
                            .addComponent(Nombre)
                            .addComponent(Estado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Transaccion_text)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Transaccion))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(Fecha_text)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(Cuenta_text)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(Monto_text)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Monto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(Enviar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Observacion_text))
                        .addGap(0, 66, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Factura_text)
                        .addComponent(Factura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Cuenta_text)
                        .addComponent(Cuenta))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Buscar_text)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Nombre)
                                .addComponent(Monto_text)
                                .addComponent(Monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Nombre_text)
                                .addGap(28, 28, 28)))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Fiscal_text)
                            .addComponent(Fiscal)
                            .addComponent(Transaccion_text)
                            .addComponent(Transaccion))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Fecha_text)
                                .addComponent(Estado_text)
                                .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(Observacion_text)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Enviar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, 1002, 1002, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1002, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        // TODO add your handling code here:
        if("admin".equals(this.pantalla)){
            Menu menu = new Menu();
            menu.setVisible(true);
            this.setVisible(false);
        }
        else if ("entregar".equals(this.pantalla)){
            Sesion sesion = new Sesion();
            sesion.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_RegresarActionPerformed

    private void Enviar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enviar_buttonActionPerformed
        // TODO add your handling code here:
        int lista = table_factura.getSelectedRow();
        String fa = table_factura.getValueAt(lista, 0).toString();
        
        Date fecha = Fecha.getDate();
        
        DefaultTableModel modelo= (DefaultTableModel) table_factura.getModel();
        modelo.setRowCount(0);  
        try{
            Connection con = (Connection) ConexionMySQL.obtenerConexion();
            Statement stat = (Statement) con.createStatement();

            String verificacion = "SELECT InvoiceNumber FROM ruta WHERE InvoiceNumber = '" + Factura.getText() + "'";
            ResultSet resultadoVerificacion = (ResultSet) stat.executeQuery(verificacion);

            if (!resultadoVerificacion.next()) {
                if(fecha == null){
                    facturasee();
                    JOptionPane.showMessageDialog(null, "El campo de la fecha no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{     
                    SimpleDateFormat formato = new SimpleDateFormat("d/M/yyyy");
                    String fechaFormateada = formato.format(fecha);
                    System.out.println(fechaFormateada);
                    
                    consulta =  """
                        INSERT INTO ruta (InvoiceNumber, DeptorNumber, cmp_name, Descripcion, AmountTC, Transaccion, Observacion, Estatus, DATE, Seccion, DueDate, Fecha)
                        SELECT InvoiceNumber, DeptorNumber, cmp_name, Descripcion, AmountTC, Transaccion, '%s' AS Observacion, '%s' AS Estatus, DATE, Seccion, DueDate, '%s' AS Fecha
                        FROM facturas WHERE InvoiceNumber LIKE '%%%s%%';
                    """.formatted(Observacion_text_big.getText(),Estado.getSelectedItem(),fechaFormateada, Factura.getText());

                    int filasAfectadas = stat.executeUpdate(consulta);

                    facturasee();
                    JOptionPane.showMessageDialog(null, "La factura fue enviada exitosamente a la ruta.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
       
            } 
            else {
                System.out.println("Esta factura ya fue enviada a la ruta.");
                facturasee();
                JOptionPane.showMessageDialog(null, "Esta factura ya fue enviada a la ruta.", "Error", JOptionPane.ERROR_MESSAGE);
            }
           
        }
        catch(ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(Por_entregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Enviar_buttonActionPerformed

    private void BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarKeyReleased
        // TODO add your handling code here:
        String nuevobuscar = Buscar.getText();
        this.buscar_factura(nuevobuscar);
    }//GEN-LAST:event_BuscarKeyReleased

    private void table_facturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_facturaMouseClicked
        // TODO add your handling code here:
        int lista = table_factura.getSelectedRow();
        String fa = table_factura.getValueAt(lista, 0).toString();
        
        try{
            Connection con = (Connection) ConexionMySQL.obtenerConexion();
            Statement stat = (Statement) con.createStatement();

            consulta = "Select * From facturas WHERE facturas.InvoiceNumber LIKE '%" + fa + "%'";

            ResultSet rs = (ResultSet) stat.executeQuery(consulta);

            rs.first();

            Factura.setText(rs.getString(1));
            Factura.setCaretPosition(0);
            Cuenta.setText(rs.getString(2));
            Cuenta.setCaretPosition(0);
            Nombre.setText(rs.getString(3));
            Nombre.setCaretPosition(0);
            Fiscal.setText(rs.getString(4));
            Fiscal.setCaretPosition(0);
            Monto.setText(rs.getString(5));
            Monto.setCaretPosition(0);
            Transaccion.setText(rs.getString(6));
            Transaccion.setCaretPosition(0);
            Observacion_text_big.setText(rs.getString(7));
            Observacion_text_big.setCaretPosition(0);
            if ("Por entregar".equals(rs.getString(8))){
                Estado.setSelectedIndex(0);
            }
            else if ("En ruta".equals(rs.getString(8))){
                Estado.setSelectedIndex(1);
            }
            else if ("Entregado".equals(rs.getString(8))){
                Estado.setSelectedIndex(2);
            }
            else if ("Multa".equals(rs.getString(8)) || "multa".equals(rs.getString(8)) || "MULTA".equals(rs.getString(8))){
                Estado.setSelectedIndex(3);
            }
            else if ("Sin informacion".equals(rs.getString(8))){
                Estado.setSelectedIndex(4);
            }
            else{
                Estado.setSelectedIndex(5);
            }
           // Estado.setCaretPosition(0);
            //Fecha.setDate(rs.getString(9));
            //Fecha.setCaretPosition(0);
        }
        catch(ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(Por_entregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_table_facturaMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        facturasee();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void table_facturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_facturaKeyPressed
        // TODO add your handling code here:
        int lista = table_factura.getSelectedRow();
        String fa = table_factura.getValueAt(lista, 0).toString();
        
        try{
            Connection con = (Connection) ConexionMySQL.obtenerConexion();
            Statement stat = (Statement) con.createStatement();

            consulta = "Select * From facturas WHERE facturas.InvoiceNumber LIKE '%" + fa + "%'";

            ResultSet rs = (ResultSet) stat.executeQuery(consulta);

            rs.first();

            Factura.setText(rs.getString(1));
            Factura.setCaretPosition(0);
            Cuenta.setText(rs.getString(2));
            Cuenta.setCaretPosition(0);
            Nombre.setText(rs.getString(3));
            Nombre.setCaretPosition(0);
            Fiscal.setText(rs.getString(4));
            Fiscal.setCaretPosition(0);
            Monto.setText(rs.getString(5));
            Monto.setCaretPosition(0);
            Transaccion.setText(rs.getString(6));
            Transaccion.setCaretPosition(0);
            Observacion_text_big.setText(rs.getString(7));
            Observacion_text_big.setCaretPosition(0);
            if ("Por entregar".equals(rs.getString(8))){
                Estado.setSelectedIndex(0);
            }
            else if ("En ruta".equals(rs.getString(8))){
                Estado.setSelectedIndex(1);
            }
            else if ("Entregado".equals(rs.getString(8))){
                Estado.setSelectedIndex(2);
            }
            else if ("Multa".equals(rs.getString(8)) || "multa".equals(rs.getString(8)) || "MULTA".equals(rs.getString(8))){
                Estado.setSelectedIndex(3);
            }
            else if ("Sin informacion".equals(rs.getString(8))){
                Estado.setSelectedIndex(4);
            }
            else{
                Estado.setSelectedIndex(5);
            }
           // Estado.setCaretPosition(0);
            //Fecha.setDate(rs.getString(9));
            //Fecha.setCaretPosition(0);
        }
        catch(ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(Por_entregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_table_facturaKeyPressed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Por_entregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Por_entregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Por_entregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Por_entregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Por_entregar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscar;
    private javax.swing.JLabel Buscar_text;
    private javax.swing.JTextField Cuenta;
    private javax.swing.JLabel Cuenta_text;
    private javax.swing.JButton Enviar_button;
    private javax.swing.JComboBox<String> Estado;
    private javax.swing.JLabel Estado_text;
    private javax.swing.JTextField Factura;
    private javax.swing.JLabel Factura_text;
    private com.toedter.calendar.JDateChooser Fecha;
    private javax.swing.JLabel Fecha_text;
    private javax.swing.JTextField Fiscal;
    private javax.swing.JLabel Fiscal_text;
    private javax.swing.JTextField Monto;
    private javax.swing.JLabel Monto_text;
    private javax.swing.JTextField Nombre;
    private javax.swing.JLabel Nombre_text;
    private javax.swing.JLabel Observacion_text;
    private javax.swing.JTextArea Observacion_text_big;
    private javax.swing.JButton Regresar;
    private javax.swing.JTextField Transaccion;
    private javax.swing.JLabel Transaccion_text;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_factura;
    // End of variables declaration//GEN-END:variables
}
