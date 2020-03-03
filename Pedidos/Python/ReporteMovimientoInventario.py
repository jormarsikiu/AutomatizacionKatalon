# -*- coding: utf-8 -*-
#!/usr/bin/python
import pyodbc
import openpyxl
import pandas as pd
import os
import random

productos_almacen = pd.read_excel(r"Pedidos/DataExcel/ProductoAlmacen.xlsx")
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

data = pd.read_sql('SELECT PA.ID_PRODUCTO AS IdProducto, P.CODIGO AS CodProducto, P.NOMBRE AS Producto, P.ID_GRUPO AS IdGrupo, P.EXISTENCIA AS Existencia, PA.ID_ALMACEN AS IdAlmacenes, PA.CANTIDAD_ACTUAL AS CantidadActual  FROM PRODUCTO_ALMACEN AS PA, PRODUCTO AS P WHERE PA.ID_ALMACEN IN (1,2,6,7) AND P.ID=PA.ID_PRODUCTO AND PA.ID_PRODUCTO IN (' + ','.join((str(n) for n in l)) + ')  ORDER BY PA.ID_PRODUCTO',cnxn)
data.to_excel('Pedidos/DataExcel/ReporteMovimientoDeInventario.xlsx')

reporte=pd.read_excel(r"Pedidos/DataExcel/ReporteMovimientoDeInventario.xlsx")
df_reporte=  pd.DataFrame(reporte, columns= ['IdProducto', 'CodProducto', 'Producto', 'IdGrupo', 'Existencia', 'IdAlmacenes', 'CantidadActual'])

#Cambiar el nombre del grupo
for i in range (0, len(df_reporte)):
	if (df_reporte.loc[i, 'IdGrupo']==6):
		df_reporte.loc[i, 'IdGrupo'] = 'Materia Prima'
	elif (df_reporte.loc[i, 'IdGrupo']==7):
		df_reporte.loc[i, 'IdGrupo'] = 'Producto Terminado'
	elif (df_reporte.loc[i, 'IdGrupo']==32):
		df_reporte.loc[i, 'IdGrupo'] = 'MP: Liquidos'

export_excel = df_reporte.to_excel (r'Vista.xlsx', index = None, header=True)


##################################################
#Asociar los movimientos con los productos
concepto_motivo = pd.read_excel(r"Pedidos/DataExcel/MovimientoDeInventario.xlsx")

df_concepto_motivo= pd.DataFrame(concepto_motivo, columns= ['Concepto', 'Motivo', 'IdProducto'])

df_mov_inv_concepto=pd.merge(df_concepto_motivo, df_reporte, on=['IdProducto'], how="left")

df_mov_inv_concepto = df_mov_inv_concepto.drop_duplicates(['IdProducto', 'IdAlmacenes'], keep='first')

export_excel = df_mov_inv_concepto.to_excel (r'Pedidos/DataExcel/ReporteMovimientoDeInventario.xlsx', index = None, header=True)

os.remove('Vista.xlsx')

