/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author angeldvvp
 */
public class Venta{
    private String codigo="";
    private String producto="";
    private String proveedor="";
    private String pagarCon="";
    private int cantidad=0;
    private double total=0.0;
    private double vuelto=0.0;
    private double totalApagar=0.0;
    
    public Venta() {
     
    }
    
    public Venta(String codigo, String producto, String proveedor, String pagarCon, int cantidad, double total, double vuelto, double totalApagar) {
     this.codigo=codigo;
     this.producto=producto;
     this.proveedor=proveedor;
     this.pagarCon=pagarCon;
     this.cantidad=cantidad;
     this.total=total;
     this.vuelto=vuelto;
     this.totalApagar=totalApagar;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getPagarCon() {
        return pagarCon;
    }

    public void setPagarCon(String pagarCon) {
        this.pagarCon = pagarCon;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getVuelto() {
        return vuelto;
    }

    public void setVuelto(double vuelto) {
        this.vuelto = vuelto;
    }

    public double getTotalApagar() {
        return totalApagar;
    }

    public void setTotalApagar(double totalApagar) {
        this.totalApagar = totalApagar;
    }
    
    
    
    
}
