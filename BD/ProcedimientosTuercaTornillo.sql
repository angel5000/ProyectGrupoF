use Ferreteria;
create PROCEDURE InsertarFactura
    @Num_Factura INT,
    @ID_Compra INT,
    @ID_Cliente INT,
    @MetodoPago INT,
    @Descuento INT,
    @Estado CHAR(1),
    @Fecha_Vencimiento DATE,
    @Fecha_Venta DATE,
    @Total_Venta DECIMAL(10, 2),
	 @Subtotal Float 
AS
BEGIN
    INSERT INTO Factura (Num_Factura, ID_Compra, ID_Cliente, MetodoPago, Descuento, Estado, Fecha_Vencimiento, fecha_venta, total_venta,Subtotal)
    VALUES (@Num_Factura, @ID_Compra, @ID_Cliente, @MetodoPago, @Descuento, @Estado, @Fecha_Vencimiento, @Fecha_Venta, @Total_Venta,@Subtotal);
END;
