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
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.CarCompras;
import model.Factura;
/**
 *
 * @author angeldvvp
 */
public class GenerarFactura {
   public void factura(Factura dt){
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
    document.add(new Paragraph(line+"Dispensario Mata Sano\n"
    +"Fecha emision: "+fechaHoraActual+"\n"+"Codigo Factura: "+dt.getIdfactura()

   /* +"\nPrecio: $"+dt.getCosto()+"\nDescuento: %"+dt.getDescuento()+"\nIva: %"+dt.getIva()+
            "\nSubtotal: $"+dt.getSubtotal()+"\nTotal: $"+dt.getTotal()+"\n**********GRACIAS POR SU VISITA***** "*/
    ).setFontSize(12));
    
    document.close();

 ;
          }catch(Exception e){
              System.out.println(e.getMessage());
          }
    }

     public void mostrardatos(AdmVenta advt) throws Exceptions{
         
        
     try {
       /*  for ( Factura crp : advt.MostrarPrecompra()) {
               factura(crp);
             
         }*/
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
