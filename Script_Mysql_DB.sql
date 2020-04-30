

Create database BDProductos;
Use BDProductos;


Create table tbl_territorio
(
	codigo int AUTO_INCREMENT primary key,
    departamento varchar(50) not null,
    provincia varchar(50) not null,
    distrito varchar(50) not null
);


Create table tbl_proveedor
(
	codigo int AUTO_INCREMENT primary key,
    nombre varchar(50) not null,
    direccion varchar(50) not null,
    idterritorio int not null,
    telefono varchar(12),
    email varchar(50),
    
    /*Creando referencia entidad relacion*/
    Foreign key (idterritorio) references tbl_territorio (codigo)
);

create table tbl_categoria
    codigo int AUTO_INCREMENT primary key,
    nombre varchar(50) not null
);

create table tbl_productos
(
codigo int AUTO_INCREMENT primary key,
nombre varchar(50) not null,
idcategoria int not null,
idproveedor int not null,
stock_inicial int not null,
fecha_registro_stock_inicial date not null,
stock_minimo int not null,
codigo_de_barra varchar(15),
fecha_ven date,
precio_unitario numeric(15,3) not null
);

/*Alterando la tabla PRODUCTOS y creando las referencias entidad relacion*/
alter table tbl_productos
add constraint FK_idcategoria foreign key (idcategoria) references tbl_categoria (codigo);
alter table tbl_productos
add constraint FK_idproveedor foreign key (idproveedor) references tbl_proveedor (codigo);



/*Procedimiento almacenados*/
/*Proveedores*/

DELIMITER $
create procedure sp_RegistroProveedor
(var_nombre varchar(50), var_direccion varchar(50), var_idterritorio int, var_telefono varchar(15), var_email varchar(50))
begin

Insert into tbl_proveedor (nombre,direccion,idterritorio,telefono,email)
values (ar_nombre, var_direccion, var_idterritorio, var_telefono, var_email);
end $


DELIMITER $
CREATE PROCEDURE sp_EditarProveedor
(var_codigo int,var_nombre varchar(50), var_direccion varchar(50), var_idterritorio int, var_telefono varchar(15), var_email varchar(50))
BEGIN
UPDATE tbl_proveedor set nombre = var_nombre, direccion = var_direccion,
idterritorio = var_idterritorio, telefono = var_telefono, email = var_email where codigo = var_codigo;
END $

DELIMITER $
CREATE PROCEDURE sp_ListarProveedor()
BEGIN
select 
proveedor.codigo, proveedor.nombre, proveedor.direccion, territorio.distrito, proveedor.telefono, proveedor.email
from tbl_proveedor proveedor,tbl_territorio territorio where proveedor.codigo = territorio.codigo;
END $


DELIMITER $
CREATE PROCEDURE sp_BuscarTerritorio ( var_codigo int)
BEGIN
SELECT * FROM tbl_territorio where codigo = var_codigo;
END $

call sp_RegistroProveedor('Carlos','Miraflores',1,'9589585','asdasd');

DELIMITER $
CREATE PROCEDURE sp_EliminarProveedor( var_codigo int)
BEGIN
delete from tbl_proveedor where codigo = var_codigo;
END $

DELIMITER $
CREATE PROCEDURE sp_BuscarProveedor( var_codigo int)
BEGIN
select * from tbl_proveedor where codigo = var_codigo;
END $

/*Creando los procedimiento para la tabla producto*/
/*Fecha actual y hora*/
Select curdate(); /*Solo fecha*/
Select now(); /*Fecha y hora*/

DELIMITER $
CREATE PROCEDURE sp_RegistroProducto
(var_nombre varchar(50), var_codcategoria int,
var_codproveedor int, var_stock_inicial int, 
var_stock_minimo int, var_codbarra varchar(15), var_fechaven Date, var_precio_unitario numeric (15,3)
 )
BEGIN
insert into tbl_productos 
(nombre,idcategoria,idproveedor,stock_inicial, fecha_registro_stock_inicial,stock_minimo, codigo_de_barra,fecha_ven,precio_unitario)
value(var_nombre,var_codcategoria,var_codproveedor,var_stock_inicial,CURDATE(),
var_stock_minimo,var_codbarra,var_fechaven,var_precio_unitario);
END $

/*Probando procedure registrar*/
call sp_RegistroProducto('',1,16,50,25,'asdasd',curdate(),15.4);

DELIMITER $
CREATE PROCEDURE sp_ListarProductos()
BEGIN
Select producto.codigo, producto.nombre, categoria.nombre as categoria, proveedor.nombre ,
producto.stock_inicial, producto.fecha_registro_stock_inicial, producto.stock_minimo,
producto.codigo_de_barra, producto.fecha_ven, producto.precio_unitario
 from tbl_productos producto, tbl_categoria categoria, tbl_proveedor proveedor where
producto.idcategoria = categoria.codigo and proveedor.codigo = producto.idproveedor ;
END $

DELIMITER $
DROP PROCEDURE IF EXISTS sp_EditarProducto; 
CREATE PROCEDURE sp_EditarProducto
( var_codigo int,var_nombre varchar(50), var_codcategoria int,
var_codproveedor int, var_stock_inicial int, 
var_stock_minimo int, var_codbarra varchar(15), var_fechaven Date, var_precio_unitario numeric (15,3)
 )
BEGIN
update tbl_productos set nombre = var_nombre, idcategoria = var_codcategoria
, idproveedor = var_codproveedor , stock_inicial = var_stock_inicial , stock_minimo = var_stock_minimo ,
 codigo_de_barra =  var_codbarra , fecha_ven = var_fechaven, precio_unitario = var_precio_unitario  where codigo = var_codigo;
END $

DELIMITER $
CREATE PROCEDURE sp_EliminarProducto
(var_codigo int)
BEGIN
delete from tbl_productos where codigo = var_codigo;
END $

DELIMITER $
CREATE PROCEDURE sp_BuscarProducto
(var_codigo int)
BEGIN
select * from tbl_productos where codigo = var_codigo;
END $

