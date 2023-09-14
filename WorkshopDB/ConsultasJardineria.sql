use bdmakaiajar;
-- Devuelve un listado con el código de oficina y la ciudad donde hay oficinas

SELECT codigo_oficina, ciudad
FROM Oficina;

-- Devuelve un listado con la ciudad y el teléfono de las oficinas de España.

SELECT ciudad, telefono
FROM Oficina
WHERE pais = 'España';

-- Devuelve un listado con el nombre, apellidos y email de los empleados cuyo jefe tiene un código de jefe igual a 7.

SELECT nombre, concat(apellido1,' ', apellido2) as apellidos, email
FROM Empleados
WHERE codigo_jefe = 7;

-- Devuelve un listado con el código de cliente de aquellos clientes que realizaron algún pago en 2008. Tenga en cuenta que deberá eliminar aquellos códigos de cliente que aparezcan repetidos. Resuelva la consulta:

SELECT DISTINCT codigo_cliente
FROM Pagos
WHERE YEAR(fecha_pago) = 2008;

-- ¿Cuántos empleados hay en la compañía?

SELECT count(codigo_empleado) as cantidad_empleados 
FROM empleados;

-- ¿Cuántos clientes tiene cada país?

SELECT pais, count(codigo_cliente) as cantidad_clientes
FROM clientes
GROUP BY pais;

-- ¿Cuál fue el pago medio en 2009?

SELECT avg(total_pago) as promedio_pago
FROM pagos
WHERE YEAR(fecha_pago) = 2009;

-- ¿Cuántos pedidos hay en cada estado? Ordena el resultado de forma descendente por el número de pedidos.

SELECT estado, COUNT(*) AS cantidad_pedidos
FROM Pedidos
GROUP BY estado
ORDER BY cantidad_pedidos DESC;

-- Calcula el precio de venta del producto más caro y barato en una misma consulta.

SELECT  max(precio_venta) AS producto_mas_caro, min(precio_venta) AS producto_mas_barato
FROM productos;

--  Devuelve el nombre del cliente con mayor límite de crédito.

SELECT nombre_cliente
FROM clientes
ORDER BY limite_credito DESC 
LIMIT 1;

-- Devuelve el nombre del producto que tenga el precio de venta más caro.

SELECT nombre 
FROM productos
ORDER BY precio_venta DESC
LIMIT 1;

--  Devuelve el nombre del producto del que se han vendido más unidades.

SELECT nombre
FROM productos
WHERE codigo_producto = (
    SELECT codigo_producto
    FROM detalle_pedido
    GROUP BY codigo_producto
    ORDER BY SUM(cantidad) DESC
    LIMIT 1
);

-- . Los clientes cuyo límite de crédito sea mayor que los pagos que haya realizado

SELECT Clientes.nombre_cliente
FROM Clientes
WHERE Clientes.limite_credito > (
    SELECT SUM(Pagos.total_pago)
    FROM Pagos
    WHERE Pagos.codigo_cliente = Clientes.codigo_cliente
);

-- Devuelve el listado de clientes indicando el nombre del cliente y cuantos pedidos ha realizado

SELECT Clientes.nombre_cliente, 
	(SELECT COUNT(*) 
	FROM Pedidos 
	WHERE Pedidos.codigo_cliente = Clientes.codigo_cliente) AS numero_pedidos
FROM Clientes;

-- Devuelve el nombre, apellidos, puesto y teléfono de la oficina de aquellos empleados que no sean representante de ventas de ningún cliente

SELECT Empleados.nombre, Empleados.apellido1, Empleados.apellido2, Empleados.puesto, Oficina.telefono
FROM Empleados
INNER JOIN Oficina ON Empleados.codigo_oficina = Oficina.codigo_oficina
WHERE Empleados.puesto <> 'Representante de ventas';

-- Devuelve las oficinas donde no trabajan ninguno de los empleados que hayan sido los representantes de ventas de algún cliente que haya realizado la compra de algún producto de la gama Frutales

SELECT Oficina.*
FROM Oficina
WHERE Oficina.codigo_oficina NOT IN (
    SELECT DISTINCT Empleados.codigo_oficina
    FROM Empleados
    INNER JOIN Clientes ON Empleados.codigo_empleado = Clientes.codigo_empleado
    INNER JOIN Pedidos ON Clientes.codigo_cliente = Pedidos.codigo_cliente
    INNER JOIN detalle_pedido ON Pedidos.codigo_pedido = detalle_pedido.codigo_pedido
    INNER JOIN Productos ON detalle_pedido.codigo_producto = Productos.codigo_producto
    INNER JOIN GamasProductos ON Productos.gama = GamasProductos.codigo_gama
    WHERE GamasProductos.descripcion = 'Frutales'
);

-- . Devuelve un listado con los nombres de los clientes y el total pagado por cada uno de ellos.

SELECT Clientes.nombre_cliente, SUM_Pagos.total_pago AS total_pagado
FROM Clientes
INNER JOIN (
    SELECT Pagos.codigo_cliente, SUM(Pagos.total_pago) AS total_pago
    FROM Pagos
    GROUP BY Pagos.codigo_cliente
) AS SUM_Pagos ON Clientes.codigo_cliente = SUM_Pagos.codigo_cliente;
