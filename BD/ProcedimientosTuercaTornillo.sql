use Ferreteria;

create PROCEDURE VerificarUsuario
    @Usuario VARCHAR(50),
    @Contrasena VARCHAR(50),
	@IDUsuario INT OUTPUT

AS
BEGIN
    SET NOCOUNT ON;

   set @IDUsuario=null;

    -- Verificar si el usuario y contraseña existen
    SELECT @IDUsuario=ID_DatosUsuario
    FROM  UsuariosClientes
    WHERE  Usuario =@Usuario and HashedContrasena =  HASHBYTES('SHA2_512', CONVERT(NVARCHAR(MAX), Salt) + @Contrasena);


    -- Devolver el ID del usuario si existe
    IF @Contrasena IS NOT NULL
        SELECT @IDUsuario AS 'ID del Usuario';
    ELSE
        PRINT 'Usuario o contraseña incorrectos';

END;





/*drop PROCEDURE InsertarFactura
    @Num_Factura INT,
    @ID_Cliente INT,
    @MetodoPago INT,
    @Estado CHAR(1),
    @Fecha_Vencimiento DATE,
    @Subtotal FLOAT,
    @Total_Venta DECIMAL(10, 2),
    @ID_Compra INT
AS
BEGIN
    INSERT INTO Factura (Num_Factura, ID_Cliente, MetodoPago, Estado, Fecha_Vencimiento, Subtotal, total_venta, idcompra)
    VALUES (@Num_Factura, @ID_Cliente, @MetodoPago, @Estado, @Fecha_Vencimiento, @Subtotal, @Total_Venta, @ID_Compra);
END;*/
CREATE PROCEDURE InsertarFactura
    @ID_Cliente INT,
    @MetodoPago INT,
    @Estado CHAR(1),
    @Fecha_Vencimiento DATE,
    @Subtotal FLOAT,
    @Total_Venta DECIMAL(10, 2),
    @ID_Compra INT,
    @Num_FacturaGenerado INT OUTPUT
AS
BEGIN
    -- Genera un número aleatorio de 4 dígitos
    DECLARE @Num_Factura INT = CAST((RAND() * 9000) + 1000 AS INT);

    -- Inserta la factura con el número aleatorio
    INSERT INTO Factura (Num_Factura, ID_Cliente, MetodoPago, Estado, Fecha_Vencimiento, Subtotal, total_venta, idcompra)
    VALUES (@Num_Factura, @ID_Cliente, @MetodoPago, @Estado, @Fecha_Vencimiento, @Subtotal, @Total_Venta, @ID_Compra);

    -- Devuelve el número de factura generado mediante el parámetro de salida
    SET @Num_FacturaGenerado = @Num_Factura;
END;

DECLARE @NuevoID INT;

EXEC InsertarFactura
    @ID_Cliente = 100,
    @MetodoPago = 1307,
    @Estado = 'A',
    @Fecha_Vencimiento = '2025-12-12',
    @Subtotal = 150.0,
    @Total_Venta = 160.0,
    @ID_Compra = 1518,
    @Num_FacturaGenerado = @NuevoID OUTPUT;

-- Ahora @NuevoID contendrá el número de factura generado
PRINT 'Número de factura generado: ' + CAST(@NuevoID AS VARCHAR(10));

create PROCEDURE MOSTRARINVENTARIO
   
AS
BEGIN
   SELECT i.ID_Invent,i.NombreProducto,i.Stock,i.Fecha_Ingreso,i.PrecioUnitario,i.catalogo,
   c.ID_DetallesPRD,c.Descripcion, c.Marca
   FROM INVENTARIO i
     inner join Detalles_Productos c on i.ID_Invent=c.ProductoID
END;
exec MOSTRARINVENTARIO

create PROCEDURE DATOSCLIENTE
    @ID_Cliente INT
AS
BEGIN
   SELECT Cedula,nombres,Apellidos,Direccion,Telefono,correo_electronico,Fecha_Nacimineto FROM CLIENTE where ID_cliente=@ID_Cliente;
END;




SELECT*FROM INVENTARIO
select*from Detalles_Productos

CREATE PROCEDURE InsertarCompra
    @ID_Cliente INT,
    @ProductoID INT,
    @ID_DetallesProd INT,
    @Cantidad INT,
    @PrecioUnitario DECIMAL(10, 2),
    @Subtotal_compra DECIMAL(10, 2),
    @Total_compra DECIMAL(10, 2),
    @ID_COMHCH INT 
AS
BEGIN
    -- Inserta la compra y obtén el ID_COMHCH generado
    INSERT INTO COMPRA (ID_Cliente, ProductoID, ID_DetallesProd, Cantidad, PrecioUnitario, Subttotal_compra, Total_compra,ID_COMHCH)
    
    VALUES (@ID_Cliente, @ProductoID, @ID_DetallesProd, @Cantidad, @PrecioUnitario, @Subtotal_compra, @Total_compra,@ID_COMHCH);
END;


drop PROCEDURE InsertarCompraRealiza
    @ID_Cliente INT,
    @NuevoID INT OUTPUT
AS
BEGIN
    INSERT INTO comprarealiza (ID_Cliente)
    OUTPUT INSERTED.idCpra
    VALUES (@ID_Cliente);
END;

CREATE PROCEDURE InsertarCompraRealiza
    @ID_Cliente INT,
    @NuevoID INT OUTPUT
AS
BEGIN
    BEGIN TRY
        -- Intenta realizar la inserción
        INSERT INTO comprarealiza (ID_Cliente)
        OUTPUT INSERTED.idCpra
        VALUES (@ID_Cliente);

        -- Captura el nuevo ID en la variable de salida
        SET @NuevoID = SCOPE_IDENTITY();
    END TRY
    BEGIN CATCH
        -- Si hay un error, imprime el mensaje de error
        PRINT 'Error al insertar en comprarealiza: ' + ERROR_MESSAGE();
    END CATCH;
END;

create PROCEDURE InsertarFormaPago
    @ID_Cliente INT,
    @Forma_Pago INT,
	  @NuevoID INT OUTPUT
AS
BEGIN
    INSERT INTO FORMA_PAGO (ID_cliente, Forma_pago)
	 OUTPUT INSERTED.ID_forma_pago
    VALUES (@ID_Cliente, @Forma_Pago);
	 SET @NuevoID = SCOPE_IDENTITY();
END;

create PROCEDURE MostrarDatosFactura
    @ID_Cliente INT
AS
BEGIN
    -- Consulta 1: Información del cliente y factura
    SELECT 
    F.Num_Factura,
	F.Fecha_Vencimiento,
	F.fecha_venta,
    C.Cedula AS CedulaCliente,
    C.Nombres AS NombreCliente,
    C.Apellidos AS ApellidoCliente,
    C.Direccion AS DireccionCliente,
    C.correo_electronico AS CorreoCliente,
    C.Telefono AS TelefonoCliente,
	F.Subtotal,
	f.total_venta
		
    FROM Factura F
    INNER JOIN CLIENTE C ON F.ID_Cliente = C.ID_cliente
    WHERE C.ID_cliente = @ID_Cliente;


   
END;
create PROCEDURE ItemsFactura
    @ID_Cliente INT
AS
BEGIN
 SELECT 
        I.NombreProducto,
        DP.Marca,
        CPR.Cantidad,
        CPR.PrecioUnitario,
        CPR.Subttotal_compra,
        CPR.Total_compra
    FROM Factura F
    INNER JOIN CLIENTE C ON F.ID_Cliente = C.ID_cliente
    JOIN COMPRA CPR ON F.idcompra = CPR.ID_COMHCH
    INNER JOIN Detalles_Productos DP ON CPR.ID_DetallesProd = DP.ID_DetallesPRD
    INNER JOIN Inventario I ON CPR.ProductoID = I.ID_Invent
    WHERE C.ID_cliente = @ID_Cliente;
END;
EXEC MostrarDatosFactura @ID_Cliente = 100;
