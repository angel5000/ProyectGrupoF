/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Visual.FrmVenta;
import static com.itextpdf.forms.xfdf.XfdfConstants.DEST;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.CarCompras;
import model.Compra;
import model.Factura;

/**
 *
 * @author angeldvvp
 */
public class GenerarFactura {
   public void factura(Factura dt,AdmFactura ft,int id){
    String DEST = "C:/Users/angeldvvp/Desktop/hola.pdf";
          try{
     PdfDocument pdf = new PdfDocument(new PdfWriter(DEST));
    Document document = new Document(pdf);
    String imagePath = "ruta/a/tu/imagen.jpg";

// Agregar imagen al documento

    String line = "*********Factura********\n";
     String imageFile = "C:/Users/angeldvvp/Desktop/DispensarioMedico/src/main/Imagenes/medicina.jpg"; 
ImageData data = ImageDataFactory.create(imageFile);
Image img = new Image(data); 
img.setWidth(100);
img.setHeight(100);
img.setMarginTop(5);
document.add(img);
 LocalDateTime ahora = LocalDateTime.now();

        // Formatear la fecha y hora como un String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String fechaHoraActual = ahora.format(formatter);
    document.add(new Paragraph(line+"FERRETERIA TUERCA TORNILLO\n"
    +"Fecha emision: "+fechaHoraActual+"\n"+"Codigo Factura: "+dt.getIdfactura()+"\nCEDULA:"+dt.getCedula()+"\nNOMBRES:"+dt.getNombres()
           
    ).setFontSize(12));
    /*for(Compra cpr :acpr.MostrarPrecompra()){
        
    }*/
   /*
         
        try{
            PdfWriter.getInstance(document, new FileOutputStream("tablas.pdf"));
            document.open();
             
            // Este codigo genera una tabla de 3 columnas
            PdfPTable table = new PdfPTable(3);                
             
            // addCell() agrega una celda a la tabla, el cambio de fila
            // ocurre automaticamente al llenar la fila
            table.addCell("Celda 1");
            table.addCell("Celda 2");
            table.addCell("Celda 3");
             
            table.addCell("Celda 4");
            table.addCell("Celda 5");
            table.addCell("Celda 6");
             
            table.addCell("Celda 7");
            table.addCell("Celda 8");
            table.addCell("Celda 9");
             
            // Si desea crear una celda de mas de una columna
            // Cree un objecto Cell y cambie su propiedad span
             
            PdfPCell celdaFinal = new PdfPCell(new Paragraph("Final de la tabla"));
             
            // Indicamos cuantas columnas ocupa la celda
            celdaFinal.setColspan(3);
            table.addCell(celdaFinal);
             
            // Agregamos la tabla al documento            
            document.add(table);
             
            document.close();
     PdfPTable table = getTable();
    
    document.add(getHeader(tituloFactura));
    document.add(getInformation(" "));
         
        table.addCell(getCell("Id"));
        table.addCell(getCell("Producto"));
        table.addCell(getCell("Precio"));
        
        for(int i=0;i<datos.length;i++){
         for(int j=0;j<datos[0].length;j++){
          if(datos[i][j]!=null){
           table.addCell(getCell(datos[i][j]));
          }
         }
        }
        
        table.addCell(getCell(" "));
        table.addCell(getCell(" "));
        table.addCell(getCell(" "));
         
        document.add(table);*/
    
      
   // document.close();
itemfactura(document,ft,id);
 
          }catch(Exception e){
              System.out.println(e.getMessage());
          }
    }
   public void itemfactura(Document doc,AdmFactura ft,int id) throws Exceptions{
        String DEST = "C:/Users/angeldvvp/Desktop/hola.pdf"; 
       doc.add(new Paragraph( "\nProductos: \n"  ).setFontSize(12));
       for ( Factura crp :  ft.Mostrarfacturaitem(id)){
             
           doc.add(new Paragraph(
    crp.getNombre()+"   "+crp.getMarca()+"   "+crp.getCantidad()+"   "+crp.getPrecio()
    
      ).setFontSize(12));
         }
      //doc.add(getBarcode(doc, DEST, "MJZ", "2363123"));
       doc.close();
   }

     public void mostrardatos(AdmFactura ft, int id) throws Exceptions{
         
        
     try {
         for ( Factura crp :  ft.Mostrarfactura(id)){
               factura(crp, ft,id);
           //  System.out.println(crp.getIdfactura()+ ft.factura.toString());
         }
     } catch (Exception ex) {
         Logger.getLogger(FrmVenta.class.getName()).log(Level.SEVERE, null, ex);
     }
        
    }
     /*
     public void GenerarFactura(){
        AdmFactura ft = new AdmFactura();
        try {
            for(Factura dt : ft.listarFacturas(idpaci)){
                factura(dt);
                System.out.println("paci: "+dt.getApellidos()+" doc: "+dt.getApellidoDoc()+" "+dt.getCosto());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmFactura.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } catch (Excepciones ex) {
            Logger.getLogger(Generarfactura.class.getName()).log(Level.SEVERE, null, ex);
        }
     }*/
}
