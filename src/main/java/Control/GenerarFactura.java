/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Visual.FrmVenta;
import com.itextpdf.barcodes.BarcodeEAN;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Factura;

/**
 *
 * @author angeldvvp
 */
public class GenerarFactura {
      double subtotal=0,total=0;
      BarcodeEAN barcode; PdfFormXObject barcodeObject;
       PdfDocument pdf; String DEST;
   public void factura(Factura dt,AdmFactura ft,int id){
  DEST = "C:/Users/angeldvvp/Desktop/FACTURA_TUERCA_TORNILLO.pdf";//RUTA DE LA FACTURA
          
    try{
    pdf = new PdfDocument(new PdfWriter(DEST));//OBJETOS PDF
     Document document = new Document(pdf);//OBJETO DOCUMENT RECIVE EL OBJETO PDF
    
 barcode = new BarcodeEAN(pdf);//OBJETO CODIGO DE BARRA
  
//ESTRUCTURA DE LA FACTURA

    String line = "--------------------------------------FACTURA--------------------------------------\n";
     String imageFile = "C:/Users/angeldvvp/Desktop/Proyecto_SisControl_Pernos_y_TuercaGrupoF_Venta"
             + "/BD/imagenes/IMGFACT.PNG"; //RUTA DE LA IMAGEN INCRUSTA EN EL PDF IMAGEN LOGO
ImageData data = ImageDataFactory.create(imageFile);//CARGA DE LA IMAGEN
Image img = new Image(data); 
img.setWidth(328);
img.setHeight(107);//TAMAÑO DE LA IMANGEN
img.setMarginTop(5);
img.setMarginLeft(100);//CAMBIOS DE POSICION DE LA IMAGENS
document.add(img);//SE AGREGA LA IMAGEN AL DOCUMENTO
 LocalDateTime ahora = LocalDateTime.now();

        // Formatear la fecha y hora como un String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String fechaHoraActual = ahora.format(formatter);
    document.add(new Paragraph(line+"FERRETERIA TUERCA TORNILLO\n"
    +"Fecha emision: "+fechaHoraActual+"\n"+"Codigo Factura: "+dt.getIdfactura()+"\nCEDULA:"+dt.getCedula()+
            "\nNOMBRES:"+dt.getNombres()+" "+dt.getApellidos()+"\n Fecha Vencimiento:"+dt.getFechavencimiento()
           
    ).setFontSize(12));
   subtotal=dt.getSubtofac();total=dt.getTotalfac();
    /*DATOS PRINCIPALES DE LA FACTURA*/
itemfactura(document,ft,id);//METODO QUE RECIBE OBJETO DOCUMENT, LA CLASE FACTURA, Y UN ID DE LA FACTURA
 
          }catch(Exception e){
             JOptionPane.showMessageDialog(null, "NO SE PUDO GENERAR LA FACTURA REVISAR RUTAS ENTRE OTROS DATOS DE ENTRADA\n"+e.getMessage());
          }
    }
   
   
   public void itemfactura(Document doc,AdmFactura ft,int id) throws Exceptions, Exception{
       //METODO QUE CARGA LOS ITEMS COMPRADOS CON SUS DATOS 
        doc.add(new Paragraph( "\n-----------------------------------------------------------------\n"  ).setFontSize(10));
          doc.add(new Paragraph( "\n---------------------DESCRIPCION-------------------------------\n"  ).setFontSize(10));
          doc.add(new Paragraph( "\n"+"NOMBRE   "
                  + " "+" MARCA:"+"                     CANTIDAD:"+"       PRECIO:"+""
                  + "    \tIVA:"+" \t SUBTOTAL:"+
               "         TOTAL:"+"\n"  ).setFontSize(10));
     
       for ( Factura crp :  ft.Mostrarfacturaitem(id)){
             //SE RECORRE LOS ITEMN INGRESADOS EN EL LIST POR MEDIO DEL METODO MOSTRAFACTURAITEM
    doc.add(new Paragraph(
           
    crp.getNombre().substring(0, 13)+"  "+crp.getMarca().substring(0, 5)+"    "
            + "               "
            + "          "+crp.getCantidad()+"                 $"+Math.round(crp.getPrecio()*10.0)/10.0+"         12% "
                    +"             $"+Math.round(crp.getSubtotal()*10.0)/10.0+
                    "             $"+Math.round(crp.getTotal()*10.0)/10.0+"\n"
    
      ).setFontSize(10));
    
         }
       doc.add(new Paragraph( "\n"+"Subtotal: $"+Math.round(subtotal*10.0)/10.0+"  \nTotal: $"+Math.round(total*10.0)/10.0 ).setFontSize(12));
         doc.add(new Paragraph( "\n---------------------------------------------------------\n"  ).setFontSize(12));
           doc.add(new Paragraph( "\n----------GRACIAS POR SU VISITA---------------\n"  ).setFontSize(12));
        doc.add(new Paragraph( "\n----------------------------------------------------------\n"  ).setFontSize(12));
    
         File file = new File(DEST);
        file.getParentFile().mkdirs();
       manipulatePdf(DEST,doc);
       
      
   }
   
   //CLASES DE LA CREACION DEL CODIGO DE BARRA
   protected void manipulatePdf(String dest, Document document) throws Exception {
       
        
        Table table = new Table(UnitValue.createPercentArray(4)).useAllAvailableWidth();

        for (int i = 0; i < 1; i++) {
            table.addCell(createBarcode(String.format("%08d", 12345678), pdf));
        }

        document .add(table);

       document .close();
       JOptionPane.showMessageDialog(null, "PAGO REALIZADO- SE GENERO SU FACTURA");
        
    }
   
   
   ///SGT CLASES
private static Cell createBarcode(String code, PdfDocument pdfDoc) {
        BarcodeEAN barcode = new BarcodeEAN(pdfDoc);
        barcode.setCodeType(BarcodeEAN.EAN8);
        barcode.setCode(code);
        // Create barcode object to put it to the cell as image
        PdfFormXObject barcodeObject = barcode.createFormXObject(null, null, pdfDoc);
        Cell cell = new Cell().add(new Image(barcodeObject));
        cell.setPaddingTop(10);
        cell.setPaddingRight(10);
        cell.setPaddingBottom(10);
        cell.setPaddingLeft(10);

        return cell;
    }//FIN


     public void mostrardatos(AdmFactura ft, int id) throws Exceptions{
//METODO QUE RECORRE LOS DATOS DE LA FACTURA Y LO ENVIA EN EL METODO FACTURA         
        
     try {
         for ( Factura crp :  ft.Mostrarfactura(id)){
               factura(crp, ft,id);
         
         }
     } catch (Exception ex) {
         JOptionPane.showMessageDialog(null, ex.getMessage());
         Logger.getLogger(FrmVenta.class.getName()).log(Level.SEVERE, null, ex);
     }
        
    }
    
}
