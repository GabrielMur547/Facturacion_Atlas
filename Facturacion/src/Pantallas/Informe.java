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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Gmurillo
 */
public class Informe extends javax.swing.JFrame {
    
    private String buscar = "";

    Menu Menu;
    Sesion Sesion;
    
    String pantalla;
    String factura;
    
    //Variable que contiene la fecha actual
    LocalDate FechaActual = LocalDate.now();
    DateTimeFormatter formatoPersonalizadoExcel = DateTimeFormatter.ofPattern("d-M-yyyy");
    String Fecha_Actual_Excel = FechaActual.format(formatoPersonalizadoExcel);
        
    DateTimeFormatter formatoPersonalizado = DateTimeFormatter.ofPattern("d/M/yyyy");
    String Fecha_Actual_Formateada = FechaActual.format(formatoPersonalizado);
    
    /**
     * Creates new form tet--
     */
    public Informe() {
        initComponents();
        facturasee();
        this.setLocationRelativeTo(null);
        //this.setResizable(false);
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
    String consulta_movi;
    String consulta_Excel;
    String consulta_insertar;
    
    public void facturasee(){
        //Factura.setText(null);
        //Cuenta.setText(null);
        //Nombre.setText(null);
        //Fiscal.setText(null);
        //Monto.setText(null);
        //Transaccion.setText(null);
        //Observacion_text_big.setText( null);
        Fecha_D.setDate(null);
        Fecha_H.setDate(null);
        Estado.setSelectedItem(null);
        
        DefaultTableModel modelo= (DefaultTableModel) table_factura.getModel();
        modelo.setRowCount(0);  
    try{
        Connection con = (Connection) ConexionMySQL.obtenerConexion();
        Statement stat = (Statement) con.createStatement();
            
        if(buscar.isEmpty()){
            consulta = "Select * From facturas";
        }
        else if (!buscar.isEmpty()){
            consulta = "Select * From facturas WHERE facturas.DeptorNumber LIKE '%" + buscar + "%' OR facturas.cmp_name LIKE '%" + buscar + "%'";
        }
        
        ResultSet rs = (ResultSet) stat.executeQuery(consulta);
        
        rs.first();
        
        do{ 
            String[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(5)};
                modelo.addRow(fila);
        }while(rs.next());
    }
    catch(ClassNotFoundException | SQLException ex){
        java.util.logging.Logger.getLogger(Informe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Regresar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        Estado_text = new javax.swing.JLabel();
        Estado = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_factura = new javax.swing.JTable();
        Fecha_text = new javax.swing.JLabel();
        Fecha_D = new com.toedter.calendar.JDateChooser();
        Fecha_text1 = new javax.swing.JLabel();
        Fecha_H = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        Buscar_text = new javax.swing.JLabel();
        Buscar = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        Descargar_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 374));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(0, 40, 87));
        jPanel3.setPreferredSize(new java.awt.Dimension(600, 87));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pantallas/Logo_Atlas.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(253, 215, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INFORME");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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
                .addComponent(jButton2)
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Regresar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(244, 244, 244));
        jPanel5.setPreferredSize(new java.awt.Dimension(600, 223));

        Estado_text.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Estado_text.setText("Estado");

        Estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aplicar", "Multa", "Por Presentar", "Presentado", "Retencion", "Sin información", " " }));
        Estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstadoActionPerformed(evt);
            }
        });

        table_factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N° De Factura", "N° De Cuenta", "Nombre", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_factura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                table_facturaMousePressed(evt);
            }
        });
        table_factura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table_facturaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table_factura);

        Fecha_text.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Fecha_text.setText("Desde");

        Fecha_D.setToolTipText("22/10/2023");
        Fecha_D.setDateFormatString("d/M/yyyy");

        Fecha_text1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Fecha_text1.setText("Hasta");

        Fecha_H.setToolTipText("22/10/2023");
        Fecha_H.setDateFormatString("d/M/yyyy");

        jPanel1.setBackground(new java.awt.Color(0, 40, 87));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 23));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Fecha_text)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Fecha_D, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(Fecha_text1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Fecha_H, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Estado_text, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Fecha_text)
                        .addComponent(Fecha_D, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Fecha_H, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Fecha_text1))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Estado_text)
                        .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(new java.awt.Color(244, 244, 244));
        jPanel6.setPreferredSize(new java.awt.Dimension(600, 52));

        Buscar_text.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Buscar_text.setText("Cliente");

        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscarKeyReleased(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton5.setText("Actualizar lista");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        Descargar_button.setText("Descargar informe");
        Descargar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Descargar_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Buscar_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Descargar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar_text)
                    .addComponent(Descargar_button, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String fechaFormatD = "";
    String fechaFormatH = "";
    Date fechaD;
    Date fechaH;
    String estado = "";
    int cantidad;
    
    public void crearExcel(Date fechaD, Date fechaH, String estado) throws FileNotFoundException, IOException {
        
        //this.fechaFormatD= fechaFormatD;
        //this.fechaFormatH = fechaFormatH;
        this.fechaD= fechaD;
        this.fechaH = fechaH;
        this.estado = estado;
        
        LocalDate FechaExcel = LocalDate.now();
        DateTimeFormatter Fecha_Personalizada = DateTimeFormatter.ofPattern("d-M-yyyy");
        String Fecha_Excel = FechaExcel.format(Fecha_Personalizada);
    
        String ExcelFileName = Fecha_Excel+".xlsx";
        File ExcelFile = new File(ExcelFileName);
                    
        boolean validacion_excel = ExcelFile.exists();
      
        Workbook book;
        book = new XSSFWorkbook();
        
        if(!validacion_excel){
            org.apache.poi.ss.usermodel.Sheet sheet = book.createSheet("Movimientos");
            
            sheet.setColumnWidth(0, 4000);
            sheet.setColumnWidth(1, 4000); 
            sheet.setColumnWidth(2, 8000);  
            sheet.setColumnWidth(3, 10000);  
            sheet.setColumnWidth(4, 4000);  
            sheet.setColumnWidth(5, 4000);  
            sheet.setColumnWidth(6, 10000);  
            sheet.setColumnWidth(7, 5000);  
            sheet.setColumnWidth(8, 4000);  
            sheet.setColumnWidth(9, 5000);  
            sheet.setColumnWidth(10, 4000);
            sheet.setColumnWidth(11, 4000);
            sheet.setColumnWidth(12, 4000);
           
            Row rowuno = sheet.createRow(0);
            rowuno.createCell(0).setCellValue("InvoiceNumber");
            rowuno.createCell(1).setCellValue("DeptorNumber");
            rowuno.createCell(2).setCellValue("cmp_name");
            rowuno.createCell(3).setCellValue("Descripcion");
            rowuno.createCell(4).setCellValue("AmountTC");
            rowuno.createCell(5).setCellValue("Transaccion");
            rowuno.createCell(6).setCellValue("Observacion");
            rowuno.createCell(7).setCellValue("Estatus");
            rowuno.createCell(8).setCellValue("Date");
            rowuno.createCell(9).setCellValue("Seccion");
            rowuno.createCell(10).setCellValue("DueDate");
            rowuno.createCell(11).setCellValue("Fechas");
            rowuno.createCell(12).setCellValue("Movimiento");
            
            String password = "12345";
            sheet.protectSheet(password);
        }

        else{
            org.apache.poi.ss.usermodel.Sheet sheet = book.getSheet("Movimientos");
            FileInputStream fileInput = new FileInputStream(ExcelFile);       
            book = new XSSFWorkbook(fileInput);
            
            try{
                Connection con = (Connection) ConexionMySQL.obtenerConexion();
                Statement stat = (Statement) con.createStatement();

                FileInputStream archivo = new FileInputStream(Fecha_Excel+".xlsx");
                XSSFWorkbook libro = new XSSFWorkbook(archivo);
                XSSFSheet hoja = libro.getSheetAt(0);

                int numero_Filas = hoja.getLastRowNum();

                numero_Filas = numero_Filas+1;
                System.out.println(numero_Filas);
                //CONTINUAR POR AQUI

                consulta_insertar = "SELECT * FROM facturas WHERE Estatus LIKE '%" + estado + "%' AND fecha BETWEEN '%" + fechaD + "%' AND '%" + fechaH + "%'";

                ResultSet ci = (ResultSet) stat.executeQuery(consulta_insertar);

                ci.first();

                do{ 
                    Row row = sheet.createRow(numero_Filas);
                        for(int i=0; i<13; i++){
                            row.createCell(i).setCellValue(ci.getString(i+1));
                            //row.createCell(3).setCellFormula("1+3");
                    }
                }
                while(ci.next());
            }
                catch(ClassNotFoundException | SQLException ex){
                    java.util.logging.Logger.getLogger(Informe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            System.out.println("Entró aquí");
        }
        
        
        try {
            FileOutputStream fileout = new FileOutputStream(ExcelFileName);
            book.write(fileout);
            fileout.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    public void leerExcel() {
        try {
            FileInputStream file = new FileInputStream(new File(Fecha_Actual_Excel+".xlsx"));

            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);

            int numFilas = sheet.getLastRowNum();

            for (int a = 0; a <= numFilas; a++) {
                Row fila = sheet.getRow(a);
                int numCols = fila.getLastCellNum();

                for (int b = 0; b < numCols; b++) {
                    Cell celda = fila.getCell(b);

                    switch (celda.getCellTypeEnum().toString()) {
                        case "NUMERIC":
                            System.out.print(celda.getNumericCellValue() + " ");
                            break;

                        case "STRING":
                            System.out.print(celda.getStringCellValue() + " ");
                            break;

                        case "FORMULA":
                            System.out.print(celda.getCellFormula() + " ");
                            break;
                    }
                }
                System.out.println("");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Informe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Informe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/*
    public void modificarExcel(String fecha_excel, String fecha_excel_formateada) {
        this.fecha_excel = fecha_excel;
        this.fecha_excel_formateada = fecha_excel_formateada;
        try {
            FileInputStream file = new FileInputStream(new File(fecha_excel+".xlsX"));

            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);

            String password = "12345";

            sheet.protectSheet(password);

            XSSFRow fila = sheet.getRow(0);

            if (fila == null) {
                fila = sheet.createRow(0);
            }

            XSSFCell celda = fila.createCell(0);

            if (celda == null) {
                celda = fila.createCell(0);
            }

            celda.setCellValue("Modificacionnumero2");

            file.close();

            FileOutputStream output = new FileOutputStream("Excel1.xlsX");
            wb.write(output);
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(Informe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    
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

    private void Descargar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Descargar_buttonActionPerformed
        // TODO add your handling code here:
        
        //Otorgamos la fecha del formulario a una variable para validarla mas adelante
    
        Date fechaD = Fecha_D.getDate();
        Date fechaH = Fecha_H.getDate();
        String estado = (String) Estado.getSelectedItem();
        
        //Validacion en caso de que el usuario no ingrese una fecha
        if(fechaD == null || fechaH ==null || estado== null){
            facturasee();
            JOptionPane.showMessageDialog(null, "Los campos de las fechas no pueden estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        else{
            SimpleDateFormat fechaPersonalizadaD = new SimpleDateFormat("d/M/yyyy");
            String fechaFormatD = fechaPersonalizadaD.format(fechaD);

            System.out.println(fechaD);
            System.out.println(fechaFormatD);

            SimpleDateFormat fechaPersonalizadaH = new SimpleDateFormat("d/M/yyyy");
            String fechaFormatH = fechaPersonalizadaH.format(fechaH);

            System.out.println(fechaH);
            System.out.println(fechaFormatH);
            System.out.println("El estado es: "+estado);
            
            try{
                System.out.println("try");
                //Conexión a la base de datos
                Connection con = (Connection) ConexionMySQL.obtenerConexion();
                Statement stat = (Statement) con.createStatement();

                        facturasee();
                        crearExcel(fechaD, fechaH, estado);
                        JOptionPane.showMessageDialog(null, "La factura fue enviada exitosamente a la ruta.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        //Vuelve a vaciar los elementos en la pantalla
                }     
            catch(ClassNotFoundException | SQLException | IOException ex){
                java.util.logging.Logger.getLogger(Informe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        
        
    }//GEN-LAST:event_Descargar_buttonActionPerformed

    private void BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarKeyReleased
        // TODO add your handling code here:
        String nuevobuscar = Buscar.getText();
        this.buscar_factura(nuevobuscar);
    }//GEN-LAST:event_BuscarKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        facturasee();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void table_facturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_facturaKeyReleased
        // TODO add your handling code here:
        int lista = table_factura.getSelectedRow();
        String fa = table_factura.getValueAt(lista, 0).toString();
        
        try{
            Connection con = (Connection) ConexionMySQL.obtenerConexion();
            Statement stat = (Statement) con.createStatement();

            consulta = "Select * From facturas WHERE facturas.InvoiceNumber LIKE '%" + fa + "%'";

            ResultSet rs = (ResultSet) stat.executeQuery(consulta);

            rs.first();

            //Factura.setText(rs.getString(1));
            //Factura.setCaretPosition(0);
            //Cuenta.setText(rs.getString(2));
            //Cuenta.setCaretPosition(0);
            //Nombre.setText(rs.getString(3));
            //Nombre.setCaretPosition(0);
            //Fiscal.setText(rs.getString(4));
            //Fiscal.setCaretPosition(0);
            //Monto.setText(rs.getString(5));
            //Monto.setCaretPosition(0);
            //Transaccion.setText(rs.getString(6));
            //Transaccion.setCaretPosition(0);
            //Observacion_text_big.setText(rs.getString(7));
            //Observacion_text_big.setCaretPosition(0);
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
            java.util.logging.Logger.getLogger(Informe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_table_facturaKeyReleased

    private void table_facturaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_facturaMousePressed
        // TODO add your handling code here:
        int lista = table_factura.getSelectedRow();
        String fa = table_factura.getValueAt(lista, 0).toString();
        
        try{
            Connection con = (Connection) ConexionMySQL.obtenerConexion();
            Statement stat = (Statement) con.createStatement();

            consulta = "Select * From facturas WHERE facturas.InvoiceNumber LIKE '%" + fa + "%'";

            ResultSet rs = (ResultSet) stat.executeQuery(consulta);

            rs.first();

            //Factura.setText(rs.getString(1));
            //Factura.setCaretPosition(0);
            //Cuenta.setText(rs.getString(2));
            //Cuenta.setCaretPosition(0);
            //Nombre.setText(rs.getString(3));
            //Nombre.setCaretPosition(0);
            //Fiscal.setText(rs.getString(4));
            //Fiscal.setCaretPosition(0);
            //Monto.setText(rs.getString(5));
            //Monto.setCaretPosition(0);
            //Transaccion.setText(rs.getString(6));
            //Transaccion.setCaretPosition(0);
            //Observacion_text_big.setText(rs.getString(7));
            //Observacion_text_big.setCaretPosition(0);
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
            java.util.logging.Logger.getLogger(Informe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_table_facturaMousePressed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarActionPerformed

    private void EstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EstadoActionPerformed

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
            java.util.logging.Logger.getLogger(Informe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscar;
    private javax.swing.JLabel Buscar_text;
    private javax.swing.JButton Descargar_button;
    private javax.swing.JComboBox<String> Estado;
    private javax.swing.JLabel Estado_text;
    private com.toedter.calendar.JDateChooser Fecha_D;
    private com.toedter.calendar.JDateChooser Fecha_H;
    private javax.swing.JLabel Fecha_text;
    private javax.swing.JLabel Fecha_text1;
    private javax.swing.JButton Regresar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_factura;
    // End of variables declaration//GEN-END:variables
}
