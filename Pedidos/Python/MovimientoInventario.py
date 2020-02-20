# -*- coding: utf-8 -*-
#!/usr/bin/python
import pyodbc
import openpyxl
import pandas as pd
import os

#Conexion con la base de fatos
try:
	server = '35.196.201.168' 
	database = 'PETROCHEMICAL_PRUEBAS' 
	username = 'KAIZEN' 
	password = 'SYSERP2016-9#' 
	cnxn = pyodbc.connect('DRIVER={SQL Server};SERVER='+server+';DATABASE='+database+';UID='+username+';PWD='+ password)
	print ("Conecto a la BD")
except Exception as e:
	print ("No Conecto a la BD")
	raise e

data = pd.read_sql('SELECT T.NOMBRE AS Concepto, P.CLAVE AS Motivo FROM PARAMETRO AS P, TIPO_PARAMETRO AS T WHERE T.ID = P.ID_TIPO_PARAMETRO AND P.ID_TIPO_PARAMETRO IN (17, 18, 19) ORDER BY T.ID',cnxn)
data2 = pd.read_sql('SELECT P.CODIGO AS CodProducto, P.ID_GRUPO AS IdGrupo, P.NOMBRE AS Producto, PA.CANTIDAD_ACTUAL AS CantidadActual, P.EXISTENCIA As Existencia, PA.ID_ALMACEN AS IdAlmacen, PA.ID_ALMACEN AS IdAlmacen1, A.NOMBRE AS Almacen1, PA.CANTIDAD_MAXIMA AS CantMaxAlmacen1 FROM PRODUCTO_ALMACEN AS PA, PRODUCTO AS P, ALMACEN AS A WHERE P.ID_GRUPO IN (6, 7) AND P.ELIMINADO=0 AND P.ACTIVO=1 AND P.ID=PA.ID_PRODUCTO AND PA.ID_ALMACEN=A.ID order by P.ID',cnxn)
data3 = pd.read_sql('SELECT  PA.ID_ALMACEN AS IdAlmacen2, A.NOMBRE AS Almacen2, PA.CANTIDAD_MAXIMA AS CantMaxAlmacen2 FROM PRODUCTO_ALMACEN AS PA, PRODUCTO AS P, ALMACEN AS A WHERE P.ID_GRUPO IN (6, 7) AND P.ELIMINADO=0 AND P.ACTIVO=1 AND P.ID=PA.ID_PRODUCTO AND PA.ID_ALMACEN=A.ID order by P.ID',cnxn)

data.to_excel('Concepto.xlsx')
data2.to_excel('Producto.xlsx')
data3.to_excel('Almacen2.xlsx')

concepto=pd.read_excel(r"Concepto.xlsx")
df_concepto=  pd.DataFrame(concepto, columns= ['Concepto', 'Motivo'])

producto=pd.read_excel(r"Producto.xlsx")
df_producto=  pd.DataFrame(producto, columns= ['CodProducto', 'IdGrupo', 'Producto', 'CantidadActual', 'Existencia', 'IdAlmacen1', 'Almacen1', 'CantMaxAlmacen1'])

almacen2=pd.read_excel(r"Almacen2.xlsx")
df_almacen2=  pd.DataFrame(almacen2, columns= ['IdAlmacen2', 'Almacen2','CantMaxAlmacen2'])

#Crear dataframe con filas aleatorias
na=len(df_producto)
df_producto2 = df_producto.sample(na)

#Combinar los almacenes
nc=len(df_almacen2)
df_almacen2 = df_almacen2.sample(nc)
df_almacen2 = df_almacen2.reset_index(drop=True)

export_excel2 = df_almacen2.to_excel (r'Almacen2.xlsx', index = None, header=True)

df_almacenes=pd.concat([df_producto2, df_almacen2], axis=1)

#################################################################################
#Determina que la cantidad de registros de productos sea igual a la cantidad del concepto
#para que no se desborde la tabla
long1=len(df_concepto)
long2=len(df_producto2)
if (long1<=long2):
	n=long1
else:
	n=long2

df_concepto = df_concepto.iloc[0:n]
df_almacenes = df_almacenes.iloc[0:n]

export_excel = df_concepto.to_excel (r'Concepto.xlsx', index = None, header=True)
export_excel2 = df_producto2.to_excel (r'Producto.xlsx', index = None, header=True)


#################################################################################
#Escribir el Usuario y contrasena
wb = openpyxl.Workbook() 
sheet = wb.active
sheet.cell(row=1, column=1).value ="Idioma"
sheet.cell(row=1, column=2).value ="Usuario"
sheet.cell(row=1, column=3).value ="Contrasena"

count=0
count5=0

lg=(len(df_concepto))+1
for rows in sheet.iter_cols(min_col=1, max_col=1, min_row=2, max_row=lg):
	for row in rows:
			count = count+1
			if count%2 == 0:
				row.value="0"
			else:
				row.value="1"	

for rows in sheet.iter_cols(min_col=2, max_col=2, min_row=2, max_row=lg):
	for row in rows:
		row.value="automated.test@grupokaizen.net"

for rows in sheet.iter_cols(min_col=3, max_col=3, min_row=2, max_row=lg):
	for row in rows:
		row.value="aeHFOx8jV/A="

wb.save("TestDataUser.xlsx") 

usuarios = pd.read_excel(r"TestDataUser.xlsx")
df_usuarios =  pd.DataFrame(usuarios, columns= ['Idioma', 'Usuario', 'Contrasena'])


#################################################################################

df_movinventario=pd.concat([df_usuarios, df_concepto], axis=1)

df_movinventario=df_movinventario.reset_index(drop=True)

df_producto2=df_producto2.reset_index(drop=True)

df_movinventario2=pd.concat([df_movinventario, df_almacenes], axis=1)

#Determinar si se debe iterar 1 o 2 productos
for j in range (0, len(df_movinventario2)):
	if (df_movinventario2.loc[j, 'Concepto']!='TransferenciaDeMercancias'):
		df_movinventario2.loc[j, 'Almacen2'] = 0
		df_movinventario2.loc[j, 'IdAlmacen2'] = 0
		df_movinventario2.loc[j, 'CantMaxAlmacen2'] = 0

nc=len(df_movinventario2)
df_movinventario2 = df_movinventario2.sample(nc)

export_excel = df_movinventario2.to_excel (r'Pedidos/DataExcel/MovimientoDeInventario.xlsx', index = None, header=True)

os.remove('Concepto.xlsx')
os.remove('Producto.xlsx')
os.remove('Almacen2.xlsx')
os.remove('TestDataUser.xlsx')








