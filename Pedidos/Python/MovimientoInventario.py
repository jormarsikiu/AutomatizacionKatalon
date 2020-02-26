# -*- coding: utf-8 -*-
#!/usr/bin/python
import pyodbc
import openpyxl
import pandas as pd
import os
import random

productos_almacen = pd.read_excel(r"../DataExcel/ProductoAlmacen.xlsx")
df_productos_almacen= pd.DataFrame(productos_almacen, columns= ['IdProducto'])
l=df_productos_almacen.iloc[:, 0].tolist()


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
#P.ID=PA.ID_PRODUCTO AND PA.ID_ALMACEN=A.ID AND
data = pd.read_sql('SELECT T.NOMBRE AS Concepto, P.CLAVE AS Motivo FROM PARAMETRO AS P, TIPO_PARAMETRO AS T WHERE T.ID = P.ID_TIPO_PARAMETRO AND P.ID_TIPO_PARAMETRO IN (17, 18, 19) ORDER BY T.ID',cnxn)
data2 = pd.read_sql('SELECT P.ID as IdProducto, P.CODIGO as CodProducto, P.NOMBRE as Producto, P.EXISTENCIA as Existencia, P.ID_GRUPO as IdGrupo FROM PRODUCTO AS P WHERE P.ID_GRUPO IN (6, 7, 32) AND P.ID IN (' + ','.join((str(n) for n in l)) + ')',cnxn)
data3=pd.read_sql('SELECT ID_PRODUCTO AS IdProducto, ID_ALMACEN AS IdAlmacen1, CANTIDAD_ACTUAL AS CantidadActual1 FROM PRODUCTO_ALMACEN WHERE ID_ALMACEN IN (1,2,6,7) AND ID_PRODUCTO IN (' + ','.join((str(n) for n in l)) + ')',cnxn)
data4=pd.read_sql('SELECT ID_PRODUCTO AS IdProducto, ID_ALMACEN AS IdAlmacen2, CANTIDAD_ACTUAL AS CantidadActual2 FROM PRODUCTO_ALMACEN WHERE ID_ALMACEN IN (1,2,6,7) AND ID_PRODUCTO IN (' + ','.join((str(n) for n in l)) + ')',cnxn)

data.to_excel('Concepto.xlsx')
data2.to_excel('Productos.xlsx')
data3.to_excel('Almacen1.xlsx')
data4.to_excel('Almacen2.xlsx')

concepto=pd.read_excel(r"Concepto.xlsx")
df_concepto=  pd.DataFrame(concepto, columns= ['Concepto', 'Motivo'])

producto=pd.read_excel(r"Productos.xlsx")
df_producto=  pd.DataFrame(producto, columns= ['IdProducto', 'IdGrupo', 'CodProducto', 'Producto', 'Existencia'])

#Cambiar el nombre del grupo
for i in range (0, len(df_producto)):
	if (df_producto.loc[i, 'IdGrupo']==6):
		df_producto.loc[i, 'IdGrupo'] = 'Materia Prima'
	elif (df_producto.loc[i, 'IdGrupo']==7):
		df_producto.loc[i, 'IdGrupo'] = 'Producto Terminado'
	elif (df_producto.loc[i, 'IdGrupo']==32):
		df_producto.loc[i, 'IdGrupo'] = 'MP: Liquidos'

#Crear dataframe con filas aleatorias
na=len(df_producto)
df_producto2 = df_producto.sample(na)

df_producto2 = df_producto2.iloc[0:12]

df_concepto = df_concepto.reset_index(drop=True)
df_producto2 = df_producto2.reset_index(drop=True)

df_mov=pd.concat([df_concepto, df_producto2], axis=1)


#Se Crea un dataframe con las columnas de los dataframes anteriores para los almacenes

almacen1 = pd.read_excel(r"Almacen1.xlsx")
almacen2 = pd.read_excel(r"Almacen2.xlsx")
df_almacen1= pd.DataFrame(almacen1, columns= ['IdProducto','IdAlmacen1', 'CantidadActual1'])
df_almacen2= pd.DataFrame(almacen2, columns= ['IdProducto','IdAlmacen2', 'CantidadActual2'])

df_almacenes=pd.merge(df_almacen1, df_almacen2, on="IdProducto", how="left")

df_aleatorio2=pd.DataFrame()
for i in range (0, len(df_almacenes)):
	if (df_almacenes.loc[i, 'IdAlmacen1']!=df_almacenes.loc[i, 'IdAlmacen2']):
		df_aleatorio2.loc[i, 'IdProducto']=df_almacenes.loc[i, 'IdProducto']
		df_aleatorio2.loc[i, 'IdAlmacen1']=df_almacenes.loc[i, 'IdAlmacen1']
		df_aleatorio2.loc[i, 'CantidadActual1']=df_almacenes.loc[i, 'CantidadActual1']
		df_aleatorio2.loc[i, 'IdAlmacen2']=df_almacenes.loc[i, 'IdAlmacen2']
		df_aleatorio2.loc[i, 'CantidadActual2']=df_almacenes.loc[i, 'CantidadActual2']

export_excel = df_aleatorio2.to_excel (r'Almacenes.xlsx', index = None, header=True)

df_mov_inventario=pd.merge(df_mov, df_aleatorio2, on="IdProducto", how="left")

export_excel = df_mov_inventario.to_excel (r'Movimiento.xlsx', index = None, header=True)

#################################################################################
#Escribir el Usuario y contrasena
wb = openpyxl.Workbook() 
sheet = wb.active
sheet.cell(row=1, column=1).value ="Idioma"
sheet.cell(row=1, column=2).value ="Usuario"
sheet.cell(row=1, column=3).value ="Contrasena"

count=0
count5=0

lg=(len(df_mov_inventario))+1
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


df_mov_inventario=df_mov_inventario.reset_index(drop=True)

df_movinventario2=pd.concat([df_usuarios, df_mov_inventario], axis=1)

df_n= pd.DataFrame(df_movinventario2, columns= ['CantidadActual1'])
n=df_n.iloc[:, 0].tolist()

#Convertir a positivo, pero queda decimal
for i in range(len(n)):
    n[i] = abs(n[i])

#Convertir de decimal a entero
for i in range(len(n)):
	n[i] = int(n[i])

for i in range (0, len(df_movinventario2)):
	df_movinventario2.loc[i, 'CantidadMovida'] = random.randint(0, n[i])

#Determinar si se debe iterar 1 o 2 productos
for j in range (0, len(df_movinventario2)):
	if (df_movinventario2.loc[j, 'Concepto']!='TransferenciaDeMercancias'):
		df_movinventario2.loc[j, 'IdAlmacen2'] = 'NA'
		df_movinventario2.loc[j, 'CantidadActual2'] = 'NA'
		

df_movinventario3= pd.DataFrame()
df_movinventario3 = df_movinventario2.drop_duplicates(subset='IdProducto', keep='first')

"""
nc=len(df_movinventario3)
df_movinventario3 = df_movinventario2.sample(nc)
"""

export_excel = df_movinventario3.to_excel (r'MovimientoDeInventario.xlsx', index = None, header=True)

os.remove('Concepto.xlsx')
os.remove('Productos.xlsx')
os.remove('Almacen1.xlsx')
os.remove('Almacen2.xlsx')
os.remove('Almacenes.xlsx')
os.remove('TestDataUser.xlsx')
os.remove('Movimiento.xlsx')








