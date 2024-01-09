USE Ferreteria;



create TABLE Administradores (
    ID_Administrador INT PRIMARY KEY IDENTITY(1, 1),
    NombreUsuario NVARCHAR(50),
    Contraseña NVARCHAR(100),
    NombreCompleto NVARCHAR(100),
    CorreoElectronico NVARCHAR(100),
    Rol int,
    FechaRegistro DATE
);

INSERT INTO Administradores (NombreUsuario, Contraseña, NombreCompleto, CorreoElectronico, Rol, FechaRegistro)
VALUES ('admin01', 'contrasena123', 'Juan Pérez', 'admin@example.com', 1, '2023-10-29');

CREATE TABLE Roles (
    ID_Rol INT PRIMARY KEY IDENTITY(1, 1),
    NombreRol NVARCHAR(50) UNIQUE
);
INSERT INTO Roles (NombreRol)
VALUES ('Administrador'), ('Cliente');

select*from roles
CREATE TABLE CLIENTE(
ID_cliente	INT PRIMARY KEY IDENTITY(100,1),
Cedula VARCHAR (10),
nombres VARCHAR (50),
Apellidos VARCHAR (50),
Rol int,
Direccion VARCHAR (100),
correo_electronico VARCHAR (100),
Telefono VARCHAR (13),
Fecha_Nacimineto Date

);
ALTER TABLE CLIENTE
ADD CONSTRAINT fk_Rol_Cliente FOREIGN KEY (Rol) REFERENCES Roles(ID_Rol);

ALTER TABLE Administradores
ADD CONSTRAINT fk_Rol_Administrador FOREIGN KEY (Rol) REFERENCES Roles(ID_Rol);

INSERT INTO CLIENTE (Cedula, Nombres, Apellidos, Direccion, correo_electronico, Telefono, Fecha_Nacimineto)
VALUES ('123456789', 'Juan', 'Pérez', 'Calle 123, Ciudad', 'juan@example.com', '123-456-7890', '12/12/2000');

create table UsuariosClientes(
ID_USUCL	INT PRIMARY KEY IDENTITY(100,1),
ID_DatosUsuario int not null,
Usuario varchar(50)unique not null,
Rol int not null,
Activa char(1) not null,
 Salt VARBINARY(32) NOT NULL,
 HashedContrasena VARBINARY(64) NOT NULL,
constraint Rolfk FOREIGN KEY (Rol) REFERENCES Roles(ID_Rol),
constraint UsuarioPCTfk FOREIGN KEY (ID_DatosUsuario) REFERENCES CLIENTE(ID_cliente)

);

DECLARE @Salt VARBINARY(32);
SET @Salt = CRYPT_GEN_RANDOM(32); 
DECLARE @Contraseña NVARCHAR(MAX);
SET @Contraseña = 'Angel123456';

INSERT INTO UsuariosClientes (ID_DatosUsuario, Usuario,Rol , Activa,Salt, HashedContrasena)
VALUES (
    100,
    'Juan5000',2,'A',
    @Salt,
    HASHBYTES('SHA2_512', CONVERT(NVARCHAR(MAX), @Salt) + @Contraseña)
);



select*from  cliente
CREATE TABLE PROVEEDOR(
ID_proveedor INT PRIMARY KEY IDENTITY(1,1),
nombre_proveedor VARCHAR not null,
Tipo_Proveedor VARCHAR not null,
RUC	VARCHAR not null,
direccion VARCHAR not null,
Correo_electronico VARCHAR not null,
telefono VARCHAR not null

);

create TABLE INVENTARIO(

ID_Invent INT PRIMARY KEY IDENTITY(1,1) not null,
NombreProducto NVARCHAR(100),
Stock INT,
Fecha_Ingreso date,
Imagen varbinary(max),
PrecioUnitario DECIMAL(10, 2),
catalogo char
);
alter table INVENTARIO add catalogo char(1)

/*
alter table INVENTARIO
add Imagen varbinary(max) */
select*from CATALOGO_PRODUCTO
update INVENTARIO set catalogo='S' where ID_Invent=1
update INVENTARIO set catalogo='S' where ID_Invent=2
update INVENTARIO set catalogo='S' where ID_Invent=3
update INVENTARIO set catalogo='S' where ID_Invent=4
update INVENTARIO set catalogo='S' where ID_Invent=5
update INVENTARIO set catalogo='S' where ID_Invent=6
update INVENTARIO set catalogo='S' where ID_Invent=7
update INVENTARIO set catalogo='N' where ID_Invent=8
update INVENTARIO set catalogo='N' where ID_Invent=9
select*from INVENTARIO
INSERT INTO INVENTARIO ( NombreProducto,Stock ,Fecha_Ingreso,PrecioUnitario)
VALUES
    ( 'Perno Hexagonal 1/4',10,'10/10/20',10.2),
    ('Perno Galvanizado 1/4',20,'10/10/23', 5),
    ('Tuerca Hexagona 1/4',50,'10/10/22',0.5),
    ('Tuerca hexagonal galvanizado 3/8',100,'10/10/21',0.7);

	('Tuerca de acero inoxidable M8',10,'10/10/20',4.2),
    ('Perno de acero galvanizado M10',20,'10/10/23', 2.5),
    ('Tornillo de cabeza hexagonal M6',50,'10/10/22',1.5),
    ('Llave inglesa 8 pulgadas',100,'10/10/21',20.30),
	('Llave M10',100,'10/10/21',15.50);
	select*from Detalles_Productos
	update INVENTARIO set NombreProducto ='Llave M10' where ID_Invent =9


	

	DELETE FROM Inventario ;
	DELETE FROM Detalles_Productos ;

	select*from Detalles_Productos
	select*from Inventario
create TABLE Detalles_Productos(
  ID_DetallesPRD INT PRIMARY KEY  IDENTITY(0001,1),
    ProductoID INT,
	Categoria VARCHAR(50),
	Marca VARCHAR(255),
    Descripcion VARCHAR(255),
   
);
CONSTRAINT fk_DetallesPrd FOREIGN KEY (ProductoID) REFERENCES INVENTARIO(ID_Invent)


SELECT name
FROM sys.foreign_keys
WHERE OBJECT_NAME(parent_object_id) = 'Detalles_Productos';

alter table Detalles_Productos
add CONSTRAINT fk_DetallesPrd FOREIGN KEY (ProductoID) REFERENCES INVENTARIO(ID_Invent)
alter table Detalles_Productos
drop constraint fk_DetallesPrd ;

select*from Detalles_Productos
INSERT INTO Detalles_Productos ( ProductoID, Categoria,Marca,Descripcion)
VALUES
    ( 1, 'Perno','STANLEY0','Perno hexagonal de acero inoxidable, 1/4" x 2"'),
    (2,'Perno','STANLEY1', 'Perno galvanizado, 1/4" x 1.5"'),
    (3, 'Perno','STANLEY2','Tuerca hexagonal de acero, 1/4"'),
    (4, 'Perno','STANLEY3','Tuerca hexagonal de acero galvanizado, 3/8"');
	



	INSERT INTO Detalles_Productos (ProductoID, Categoria, Marca, Descripcion)
VALUES (5, 'Tuercas', 'BOSCH', 'Tuerca de acero inoxidable, tamaño M8');

-- Insertar un perno
INSERT INTO Detalles_Productos (ProductoID, Categoria, Marca, Descripcion)
VALUES (6, 'Pernos', 'DEWALT', 'Perno de acero galvanizado, tamaño M10');

-- Insertar un tornillo
INSERT INTO Detalles_Productos (ProductoID, Categoria, Marca, Descripcion)
VALUES (7, 'Tornillos', 'BLACK&DECKER', 'Tornillo de cabeza hexagonal, tamaño M6');

-- Insertar una herramienta
INSERT INTO Detalles_Productos (ProductoID, Categoria, Marca, Descripcion)
VALUES (8, 'Herramientas', 'DOLMAR', 'Llave inglesa ajustable de 8 pulgadas');
INSERT INTO Detalles_Productos (ProductoID, Categoria, Marca, Descripcion)
VALUES (9, 'Herramientas', 'DOLMAR', 'Llave M10');

select*from CATALOGO_PRODUCTO
CREATE TABLE CATALOGO_PRODUCTO(
ID_cata INT PRIMARY KEY IDENTITY(001,1),
Producto INT,
Detalle_Producto INT,
Disponible char(1),
CONSTRAINT fk_invent FOREIGN KEY (Producto ) REFERENCES INVENTARIO(ID_Invent),
CONSTRAINT fk_Detallprd FOREIGN KEY (Detalle_Producto ) REFERENCES Detalles_Productos(ID_DetallesPRD)
);
delete from CATALOGO_PRODUCTO where Producto =1;
INSERT INTO CATALOGO_PRODUCTO ( Producto,Detalle_Producto  )
VALUES
    ( 1, 5);

	INSERT INTO CATALOGO_PRODUCTO ( Producto,Detalle_Producto  )
VALUES
    ( 2, 6);
	INSERT INTO CATALOGO_PRODUCTO ( Producto,Detalle_Producto  )
VALUES
    ( 3, 7);
	INSERT INTO CATALOGO_PRODUCTO ( Producto,Detalle_Producto  )
VALUES
    ( 4, 8);
	INSERT INTO CATALOGO_PRODUCTO ( Producto,Detalle_Producto  )
VALUES
    ( 5, 9);
	INSERT INTO CATALOGO_PRODUCTO ( Producto,Detalle_Producto  )
VALUES
    ( 6, 10);
		INSERT INTO CATALOGO_PRODUCTO ( Producto,Detalle_Producto  )
VALUES
    ( 7, 11);
	select*from inventario


sELECT
    C.ID_cata,
    c.Producto,C.Detalle_Producto,IP.NombreProducto,DP.Marca,
    DP.Descripcion, IP.PrecioUnitario,IP.Imagen
FROM CATALOGO_PRODUCTO AS C
 JOIN INVENTARIO IP ON C.Producto = IP.ID_Invent
JOIN Detalles_Productos DP ON C.Detalle_Producto = DP.ID_DetallesPRD;

SELECT  CATALOGO_PRODUCTO.ID_cata,INVENTARIO.PrecioUnitario,INVENTARIO.Imagen, INVENTARIO.NombreProducto,
Detalles_Productos.Descripcion, Detalles_Productos.Marca
FROM CATALOGO_PRODUCTO
INNER JOIN INVENTARIO ON CATALOGO_PRODUCTO.Producto = INVENTARIO.ID_Invent 
INNER JOIN Detalles_Productos ON CATALOGO_PRODUCTO.Detalle_Producto = Detalles_Productos.ID_DetallesPRD 
WHERE INVENTARIO.NombreProducto LIKE '%pern%' ; 









select*from INVENTARIO
create table Carrito(
ID_carrito	INT primary key identity (1,1),
ID_cliente INT,
ID_producto int,
ID_detallesProd int,
antidad int,
CONSTRAINT fk_dtclientecr   FOREIGN KEY (ID_Cliente) REFERENCES Cliente(ID_CLIENTE),
CONSTRAINT fk_productcr  FOREIGN KEY (ID_Producto) REFERENCES INVENTARIO(ID_Invent),
CONSTRAINT fk_detprocr  FOREIGN KEY (ID_DetallesProd) REFERENCES Detalles_productos(ID_DetallesPRD)
);
select*from carrito;


IF EXISTS (SELECT 1 FROM Carrito WHERE ID_Producto = 1 AND ID_cliente=100) SELECT 1 ELSE SELECT 0

           
INSERT INTO Carrito (ID_cliente,ID_producto,ID_detallesProd)
VALUES
    ( 100, 1,5);
	

	SELECT C.ID_cliente ,C.ID_DetallesProd , I.NombreProducto, DP.Descripcion, I.Imagen, ID_producto, c.ID_carrito,c.cantidad, i.PrecioUnitario From Carrito AS C 
                 JOIN INVENTARIO AS I ON C.ID_Producto = I.ID_Invent 
                 JOIN Detalles_productos AS DP ON C.ID_DetallesProd = DP.ID_DetallesPRD;
				 select*from Detalles_Productos

create TABLE COMPRA(
IDCOMPRA INT PRIMARY KEY IDENTITY(1, 1),
ID_Cliente INT not null,
Fecha_compra DATE DEFAULT GETDATE(),
 ProductoID INT,
 ID_DetallesProd int ,
    Cantidad INT,
    PrecioUnitario DECIMAL(10, 2),
	Subttotal_compra DECIMAL (10, 2),
Total_compra DECIMAL (10, 2),
ID_COMHCH int,
CONSTRAINT fk_product2  FOREIGN KEY ( ProductoID) REFERENCES INVENTARIO(ID_Invent),
CONSTRAINT fk_dtcliente   FOREIGN KEY (ID_Cliente) REFERENCES Cliente(ID_CLIENTE),
CONSTRAINT fk_detpro   FOREIGN KEY (ID_DetallesProd) REFERENCES Detalles_productos(ID_DetallesPRD),
CONSTRAINT fk_COMPRAHECHA   FOREIGN KEY (ID_COMHCH) REFERENCES comprarealiza(idCpra)
);
ALTER TABLE COMPRA ADD ID_COMHCH int
ALTER TABLE COMPRA ADD CONSTRAINT fk_COMPRAHECHA   FOREIGN KEY (ID_COMHCH) REFERENCES comprarealiza(idCpra)

drop table comprarealiza(
idCpra INT PRIMARY KEY identity(1500,1),
ID_Cliente INT  not null,
CONSTRAINT fk_cliencom   FOREIGN KEY (ID_Cliente) REFERENCES Cliente(ID_CLIENTE),
);
INSERT INTO comprarealiza (ID_Cliente)
VALUES (100);


alter table comprarealiza
drop constraint fk_dtcliente
delete from comprarealiza where ID_Cliente=100
select*from comprarealiza
INSERT INTO comprarealiza (ID_Cliente)
VALUES (100);
select*from comprarealiza
alter table compra
drop constraint fk_dtcliente
alter table compra
drop constraint fk_product2
alter table compra
drop constraint fk_detpro

INSERT INTO COMPRA (ID_Cliente,ProductoID,ID_DetallesProd,Cantidad,PrecioUnitario,Subttotal_compra,Total_compra,ID_COMHCH)
VALUES (100,1, 5,2,10.20,1.2,11.40,1518),
(100, 6, 10,2,2.50,0.3,2.80,1518);

select*from COMPRA
update COMPRA SET ID_COMHCH=1500 where IDCOMPRA=5
update COMPRA SET ID_COMHCH=1500 where IDCOMPRA=6
select*from Detalles_Productos
select*from INVENTARIO
select*from Carrito
delete from Carrito where ID_carrito=115

delete from Carrito where ID_carrito=116
select*from Carrito
select*from compra
delete from compra where ID_Cliente=100
delete from compra where IDCOMPRA=16
select*from Detalles_Compra
drop TABLE Detalles_Compra (
    ID_DetalleCompra INT PRIMARY KEY IDENTITY(1, 1),
    ID_Compra INT,
   
);
alter table Detalles_Compra
drop constraint fk_product2
INSERT INTO Detalles_Compra (ID_Compra, ProductoID, Cantidad, PrecioUnitario, Subttotal_compra, Total_compra)
VALUES (2, 2, 5, 10.00, 50.00, 50.00);

/*ELIMINAAAAAAAAAAAAAAATTTTT*/



delete from Factura  where ID_Cliente=100

delete from compra where ID_Cliente=100
delete from FORMA_PAGO where ID_cliente=100
delete from comprarealiza where ID_Cliente=100

-- Tabla de productos y sus precios
create table Productos_Precios (
    ProductoPreciID INT PRIMARY KEY identity(0001,1),
	Id_Producto int,
    PrecioUnitario DECIMAL(10, 2),
	CONSTRAINT fk_produpre  FOREIGN KEY ( Id_Producto) REFERENCES INVENTARIO(ID_Invent)
);
INSERT INTO Productos_Precios (Id_Producto ,PrecioUnitario)
VALUES  ( 1,10.2),
    (2, 5),
    (3,0.5),
    (4,0.7);




-- Actualizar la tabla Factura para agregar una columna de importe total


create TABLE Factura(
ID_factura  INT PRIMARY KEY IDENTITY(1004,1),
Num_Factura int,
ID_Cliente int,
MetodoPago int,
Estado char(1),
Fecha_Vencimiento date,
Subtotal float,
fecha_venta	DATE DEFAULT GETDATE(),
total_venta	DECIMAL (10, 2),
idcompra int,
CONSTRAINT fk_CLNTE  FOREIGN KEY (ID_cliente) REFERENCES CLIENTE(ID_cliente),
CONSTRAINT fk_TipPag  FOREIGN KEY (MetodoPago) REFERENCES FORMA_PAGO(ID_forma_pago),
constraint fk_comprado FOREIGN KEY (idcompra) REFERENCES comprarealiza(idCpra)
);
alter table Factura add idcompra int

use Ferreteria
alter table Factura add constraint fk_comprado FOREIGN KEY (idcompra) REFERENCES comprarealiza(idCpra)

alter table Factura drop constraint fk_CLNTE;
alter table Factura drop constraint fk_comprado
alter table Factura add CONSTRAINT fk_TipPag  FOREIGN KEY (MetodoPago) REFERENCES FORMA_PAGO(ID_forma_pago),
alter table Factura drop column ID_comprado int
alter table Factura drop column descuento
select*from carrito
drop CONSTRAINT fk_compra2 
INSERT INTO Factura (Num_Factura, ID_Cliente, MetodoPago, Estado, Fecha_Vencimiento, fecha_venta, total_venta,Subtotal)
VALUES (1001, 100, 1,  'P', '2023-11-15', '2023-11-01', 1.52, 14.22);

select*from Factura
update Factura set idcompra=1500 where ID_Cliente=
delete from Factura  where ID_Cliente=100;
select*from CLIENTE
SELECT 
    F.ID_factura,
    F.Num_Factura,
	F.Fecha_Vencimiento,
	F.fecha_venta,
    C.Cedula AS CedulaCliente,
    C.Nombres AS NombreCliente,
    C.Apellidos AS ApellidoCliente,
    C.Direccion AS DireccionCliente,
    C.correo_electronico AS CorreoCliente,
    C.Telefono AS TelefonoCliente
	
	
FROM Factura F
 INNER JOIN CLIENTE C ON F.ID_Cliente = c.ID_cliente
 WHERE C.ID_cliente = 100;
 /****************/
 SELECT 
   i.NombreProducto,
   dp.Marca,
   cpr.Cantidad,
   cpr.PrecioUnitario,
   cpr.Subttotal_compra,
   cpr.Total_compra
   
FROM Factura F
 INNER JOIN CLIENTE C ON F.ID_Cliente =c.ID_cliente
 JOIN COMPRA CPR ON F.idcompra=cpr.ID_COMHCH

INNER JOIN Detalles_Productos DP ON CPR.ID_DetallesProd = DP.ID_DetallesPRD
inner join inventario i on CPR.ProductoID=i.ID_Invent

WHERE C.ID_cliente = 100;
	i.NombreProducto,
SELECT*FROM COMPRAREALIZA

select*from Factura
select*from INVENTARIO
select*from Carrito
select*from Detalles_Productos
select*from COMPRA
update COMPRA set ID_COMHCH =1515 where ID_Cliente=100
select total_venta FROM Factura F
INNER JOIN COMPRA Cmp ON F.ID_Compra =1


create TABLE FORMA_PAGO(
ID_forma_pago	INT  PRIMARY KEY IDENTITY(1300,1),
ID_cliente int,
Forma_pago int,

CONSTRAINT fk_TipoPago  FOREIGN KEY (Forma_pago) REFERENCES TipoPago(ID_tipoPago),
CONSTRAINT fk_CLNT  FOREIGN KEY (ID_cliente) REFERENCES CLIENTE(ID_cliente)
);

alter table forma_pago drop CONSTRAINT fk_TipoPago
alter table forma_pago drop CONSTRAINT fk_CLNT

select*from FORMA_PAGO
delete from FORMA_PAGO where ID_cliente=100
INSERT INTO  FORMA_PAGO( ID_cliente,
Forma_pago )
VALUES
    (100,1);



CREATE TABLE TipoPago(
ID_tipoPago INT  PRIMARY KEY IDENTITY(1,1),
TipoPago varchar(50)

);
select *from TipoPago
INSERT INTO TipoPago ( TipoPago)
VALUES
    ('Efectivo'),
	 ('Tarjeta de Credito');
