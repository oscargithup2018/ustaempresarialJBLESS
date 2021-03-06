CREATE SCHEMA facturacion;

CREATE TABLE facturacion."CATEGORIA_PRODUCTO"
(
   "CODIGO"            INTEGER NOT NULL,
   "NOMBRE"            CHARACTER VARYING (50)  NOT NULL,
   "CARACTERISTICA"    CHARACTER VARYING (200) NOT NULL,
   PRIMARY KEY ("CODIGO")
);
COMMENT ON COLUMN facturacion."CATEGORIA_PRODUCTO"."CARACTERISTICA" IS   'Cacteristicas de la categor�a';
COMMENT ON COLUMN facturacion."CATEGORIA_PRODUCTO"."NOMBRE" IS 'Nombre categor�a';
COMMENT ON COLUMN facturacion."CATEGORIA_PRODUCTO"."CODIGO" IS 'C�digo de la categor�a';

--------------------------------------------------------

CREATE TABLE facturacion."CLIENTE"
(
   "CODIGO"                  INTEGER NOT NULL,
   "NOMBRE"              CHARACTER VARYING (50) NOT NULL,
   "APELLIDO"            CHARACTER VARYING (100) NOT NULL,
   "TELEFONO"            CHARACTER VARYING (10),
   "CODIGO_POSTAL"       CHARACTER VARYING (5),
   "SEXO"                CHARACTER (1) NOT NULL,
   "FECHA_NACIMIENTO"    DATE NOT NULL,
   "POBLACION"           CHARACTER VARYING (20) NOT NULL,
   PRIMARY KEY ("CODIGO")
);

COMMENT ON COLUMN facturacion."CLIENTE"."NOMBRE" IS 'Nombre CLIENTE';
COMMENT ON COLUMN facturacion."CLIENTE"."APELLIDO" IS 'Apellidos CLIENTE';
COMMENT ON COLUMN facturacion."CLIENTE"."TELEFONO" IS 'Movil';
COMMENT ON COLUMN facturacion."CLIENTE"."POBLACION" IS 'poblaci�n donde vive el CLIENTE';

--------------------------------------------------------

CREATE TABLE facturacion."PRODUCTO"
(
   "CODIGO"              INTEGER NOT NULL,
   "NOMBRE"              CHARACTER VARYING (50) NOT NULL,
   "CARACTERISTICA"      CHARACTER VARYING (200) NOT NULL,
   "CATE_PROD_CODIGO"    INTEGER NOT NULL,
   PRIMARY KEY ("CODIGO")
);

ALTER TABLE facturacion."PRODUCTO"
   ADD CONSTRAINT "FK_PRODUCTO_categ_PRODUCTO" FOREIGN KEY
          ("CATE_PROD_CODIGO")
          REFERENCES facturacion."CATEGORIA_PRODUCTO" ("CODIGO");

COMMENT ON COLUMN facturacion."PRODUCTO"."CODIGO" IS 'codigo del PRODUCTO';
COMMENT ON COLUMN facturacion."PRODUCTO"."NOMBRE" IS 'nombre del PRODUCTO';
COMMENT ON COLUMN facturacion."PRODUCTO"."CARACTERISTICA" IS    'Caracteristicas de la PRODUCTO';
COMMENT ON COLUMN facturacion."PRODUCTO"."CATE_PROD_CODIGO" IS    'Codigo heredado de la categoria del PRODUCTO';

--------------------------------------------------------

CREATE TABLE facturacion."PROVEEDOR"
(
   "CODIGO"        INTEGER NOT NULL,
   "NOMBRE"        CHARACTER VARYING (100) NOT NULL,
   "DIRECCION"     CHARACTER VARYING (100) NOT NULL,
   "TELEFONO"      CHARACTER VARYING (12) NOT NULL,
   "PAGINA_WEB"    CHARACTER VARYING (100) NULL,
   PRIMARY KEY ("CODIGO")
);

COMMENT ON COLUMN facturacion."PROVEEDOR"."CODIGO" IS    'N�mero RUT dado por la DIAN';
COMMENT ON COLUMN facturacion."PROVEEDOR"."NOMBRE" IS 'Nombre PROVEEDOR';
COMMENT ON COLUMN facturacion."PROVEEDOR"."DIRECCION" IS    'Direcci�n del PROVEEDOR';
COMMENT ON COLUMN facturacion."PROVEEDOR"."TELEFONO" IS 'M�vil';
COMMENT ON COLUMN facturacion."PROVEEDOR"."PAGINA_WEB" IS    'Url de la p�gina web del PROVEEDOR';
COMMENT ON TABLE facturacion."PROVEEDOR" IS 'Tabla de PROVEEDORes';

--------------------------------------------------------

CREATE TABLE facturacion."PROVEEDOR_PRODUCTO"
(
   "PRECIO_UNITARIO"     INTEGER NOT NULL,
   "FECHA_VIGENCIA"      DATE NOT NULL,
   "PESO"                NUMERIC (20, 4) NOT NULL,
   "PROVEEDOR_CODIGO"    INTEGER,
   "PRODUCTO_CODIGO"     INTEGER,
   PRIMARY KEY ("PROVEEDOR_CODIGO", "PRODUCTO_CODIGO")
);

ALTER TABLE facturacion."PROVEEDOR_PRODUCTO"
   ADD CONSTRAINT "FK_PROVEEDOR_PRODUCTO_1" FOREIGN KEY ("PROVEEDOR_CODIGO")
          REFERENCES facturacion."PROVEEDOR" ("CODIGO");

ALTER TABLE facturacion."PROVEEDOR_PRODUCTO"
   ADD CONSTRAINT "FK_PROVEEDOR_PRODUCTO_2" FOREIGN KEY ("PRODUCTO_CODIGO")
          REFERENCES facturacion."PRODUCTO" ("CODIGO");

COMMENT ON TABLE facturacion."PROVEEDOR_PRODUCTO" IS 'tabla de los PRODUCTOs que tengo de un PROVEEDOR';
COMMENT ON COLUMN facturacion."PROVEEDOR_PRODUCTO"."PRECIO_UNITARIO" IS 'Precio unitario del PRODUCTO';
COMMENT ON COLUMN facturacion."PROVEEDOR_PRODUCTO"."FECHA_VIGENCIA" IS 'Fecha de vigencia del PRODUCTO';
COMMENT ON COLUMN facturacion."PROVEEDOR_PRODUCTO"."PESO" IS 'peso en kilogramos del PRODUCTO';
COMMENT ON COLUMN facturacion."PROVEEDOR_PRODUCTO"."PROVEEDOR_CODIGO" IS 'codigo HEREDADO del PROVEEDOR';
COMMENT ON COLUMN facturacion."PROVEEDOR_PRODUCTO"."PRODUCTO_CODIGO" IS 'codigo HEREDADO del PRODUCTO';


--------------------------------------------------------
CREATE TABLE facturacion."VENTA"
(
   "CODIGO"            INTEGER NOT NULL,
   "FECHA"             DATE NOT NULL,
   "CLIENTE_CODIGO"    INTEGER,
   PRIMARY KEY ("CODIGO")
);

ALTER TABLE facturacion."VENTA"
   ADD CONSTRAINT "FK_VENTA_1" FOREIGN KEY ("CLIENTE_CODIGO")
          REFERENCES facturacion."CLIENTE" ("CODIGO");

COMMENT ON TABLE facturacion."VENTA" IS
   'tabla de las VENTAs detallado por CLIENTE';
COMMENT ON COLUMN facturacion."VENTA"."CODIGO" IS
   'codigo de la factura (numero dado por la DIAN)';
COMMENT ON COLUMN facturacion."VENTA"."FECHA" IS
   'Fecha de VENTA de la factura';
COMMENT ON COLUMN facturacion."VENTA"."CLIENTE_CODIGO" IS
   'Codigo HEREDADO del CLIENTE';

--------------------------------------------------------

CREATE TABLE facturacion."VENTA_DETALLE"
(
   "CANTIDAD"            INTEGER NOT NULL,
   "DESCUENTO"           NUMERIC (20, 4) DEFAULT 0 NOT NULL,
   "VENTA_CODIGO"        INTEGER NOT NULL,
   "PROVEEDOR_CODIGO"    INTEGER,
   "PRODUCTO_CODIGO"     INTEGER,
   PRIMARY KEY ("VENTA_CODIGO", "PROVEEDOR_CODIGO", "PRODUCTO_CODIGO")
);

ALTER TABLE facturacion."VENTA_DETALLE"
   ADD CONSTRAINT "FK_VENTA_DETALLE_2" FOREIGN KEY
          ("PROVEEDOR_CODIGO", "PRODUCTO_CODIGO")
          REFERENCES facturacion."PROVEEDOR_PRODUCTO"
             ("PROVEEDOR_CODIGO", "PRODUCTO_CODIGO");

ALTER TABLE facturacion."VENTA_DETALLE"
   ADD CONSTRAINT "FK_VENTA_DETALLE_1" FOREIGN KEY ("VENTA_CODIGO")
          REFERENCES facturacion."VENTA" ("CODIGO");

COMMENT ON TABLE facturacion."VENTA_DETALLE" IS  'tabla del detalle de la VENTA';
COMMENT ON COLUMN facturacion."VENTA_DETALLE"."CANTIDAD" IS   'Cantidad de PRODUCTO vendido';
COMMENT ON COLUMN facturacion."VENTA_DETALLE"."DESCUENTO" IS 'descuento aplicado al PRODUCTO';
COMMENT ON COLUMN facturacion."VENTA_DETALLE"."VENTA_CODIGO" IS 'codigo heredado de la VENTA';
COMMENT ON COLUMN facturacion."VENTA_DETALLE"."PROVEEDOR_CODIGO" IS 'codigo del PROVEEDOR HEREDADO de PROVEEDOR_PRODUCTO';
COMMENT ON COLUMN facturacion."VENTA_DETALLE"."PRODUCTO_CODIGO" IS 'codigo del PRODUCTO HEREDADO de PROVEEDOR_PRODUCTO';

--------------------------------------------------------


