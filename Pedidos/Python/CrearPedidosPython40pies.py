# -*- coding: utf-8 -*-
#!/usr/bin/python
import pyodbc
import openpyxl
import pandas as pd
import os
from openpyxl.utils import get_column_letter
from datetime import datetime
import random


#Conexion con la base de fatos
try:
	server = '35.196.201.168' 
	database = 'PETROCHEMICAL_PRUEBAS' 
	username = 'KAIZEN' 
	password = 'SYSERP2016-9#' 
	cnxn = pyodbc.connect('DRIVER={SQL Server};SERVER='+server+';DATABASE='+database+';UID='+username+';PWD='+ password)
	print ("Conecto")
except Exception as e:
	print ("No Conecto")
	raise e

#Consultas SQL a la base de datos
data = pd.read_sql('Select C.ID as IdCliente, D.ID AS IdDireccion, ID_PUERTO AS IdPuerto, CAPACIDAD_DESCARGA AS CapacidadDescarga, (CAPACIDAD_DESCARGA - (SELECT PESO_TARA FROM CONTENEDOR WHERE ID = 4)) AS CapacidadDisponible From CLIENTE as C, DIRECCION_CLIENTE as D, PUERTO_CLIENTE as PC, PUERTO as O WHERE D.ID_CLIENTE = C.ID AND C.ID = PC.ID_CLIENTE AND C.ELIMINADO=0 AND C.ACTIVO=1 AND O.ID=PC.ID_PUERTO and O.ACTIVO=1 AND O.DE_SALIDA=0',cnxn)
data2 = pd.read_sql('Select PROD.ID AS Producto, P.SOPORTA_PESO AS SoportaPeso, PROD.PESO AS PesoProducto from PRESENTACION as P, PRODUCTO as PROD, PRESENTACION_PRODUCTO as PP where P.ID = 3 AND PROD.ID = PP.ID_PRODUCTO AND P.ID = PP.ID_PRESENTACION AND PROD.ELIMINADO=0 AND PROD.ACTIVO=1 AND P.ELIMINADO=0 AND P.ACTIVO=1 AND PROD.EN_VENTA=1',cnxn)
data3 = pd.read_sql('Select PROD.ID AS Producto2, P.SOPORTA_PESO AS SoportaPeso2, PROD.PESO AS PesoProducto2 from PRESENTACION as P, PRODUCTO as PROD, PRESENTACION_PRODUCTO as PP where P.ID != 3 AND PROD.ID = PP.ID_PRODUCTO AND  P.ID = PP.ID_PRESENTACION  AND PROD.ELIMINADO=0 AND PROD.ACTIVO=1 AND P.ELIMINADO=0 AND P.ACTIVO=1 AND PROD.EN_VENTA=1',cnxn)

#Se guardan las consultas en el excel 
data.to_excel('TestDataClient.xlsx')
data2.to_excel('TestDataProductSop.xlsx')
data3.to_excel('TestDataProductNo.xlsx')

#Leemos los excel 
cliente = pd.read_excel(r"TestDataClient.xlsx")
productoSoporta = pd.read_excel(r"TestDataProductSop.xlsx")
productoNoSoporta = pd.read_excel(r"TestDataProductNo.xlsx")


#Se crean dataframes a partir del excel
df_cliente = pd.DataFrame(cliente, columns= ['IdCliente', 'IdDireccion', 'IdPuerto', 'CapacidadDescarga', 'CapacidadDisponible'])
df_productoSoporta = pd.DataFrame(productoSoporta, columns= ['Producto', 'SoportaPeso', 'PesoProducto'])
df_productoNoSoporta =  pd.DataFrame(productoNoSoporta, columns= ['Producto2', 'SoportaPeso2', 'PesoProducto2'])

long1=len(df_cliente)
long2=len(df_productoSoporta)
long3=len(df_productoNoSoporta)
"""
if(long1 < long2 and long1 < long3):
	n=long1
else:
	if(long2 < long1 and long2 < long3):
		n=long2
	else:
		n=long3
"""

if (long1<=long2):
	n=long1
else:
	n=long2


df_cliente = df_cliente.iloc[0:n]
df_productoSoporta = df_productoSoporta.iloc[0:n]
df_productoNoSoporta = df_productoNoSoporta.iloc[0:n]

#Concatenar los dataframe en uno 

df_fusion=pd.concat([df_cliente, df_productoSoporta, df_productoNoSoporta], axis=1)
print(len(df_fusion))
for i in range (0, len(df_fusion)):
	if (df_fusion.loc[i, 'Producto2']==''):
		df_fusion.loc[i, 'Producto2']=0
		df_fusion.loc[i, 'SoportaPeso2']=0
		df_fusion.loc[i, 'PesoProducto2']=0


export_excel = df_fusion.to_excel (r'Testfusion.xlsx', index = None, header=True)
n=n+1


############################################
#Escribir el CIF y EXW
wb2 = openpyxl.Workbook() 
sheet2 = wb2.active
sheet2.cell(row=1, column=1).value ="Incoterms"

count=0
for rows in sheet2.iter_cols(min_col=1, max_col=1, min_row=2, max_row=n):
	for row in rows:
			count = count+1
			if count%2 == 0:
				row.value="CIF"
			else:
				row.value="EXW"

wb2.save("TestDataIncoterms.xlsx") 

################################################
#Escribir el Idioma
wb3 = openpyxl.Workbook() 
sheet3 = wb3.active
sheet3.cell(row=1, column=1).value ="Idioma"

count=0
for rows in sheet3.iter_cols(min_col=1, max_col=1, min_row=2, max_row=n):
	for row in rows:
			count = count+1
			if count%2 == 0:
				row.value="0"
			else:
				row.value="1"
wb3.save("TestDataIdioma.xlsx") 

############################################

#Escribir el Contenedor
wb4 = openpyxl.Workbook() 
sheet4 = wb4.active
sheet4.cell(row=1, column=1).value ="Contenedor"

count=0
for rows in sheet4.iter_cols(min_col=1, max_col=1, min_row=2, max_row=n):
	for row in rows:
			count = count+1
			if count%2 == 0:
				row.value="40"
			else:
				row.value="40"
wb4.save("TestDataContenedor.xlsx") 

############################################
#Escribir el Usuario y contrasena
wb5 = openpyxl.Workbook() 
sheet5 = wb5.active
sheet5.cell(row=1, column=1).value ="Usuario"
sheet5.cell(row=1, column=2).value ="Contrasena"
count=0

for rows in sheet5.iter_cols(min_col=1, max_col=1, min_row=2, max_row=n):
	for row in rows:
		row.value="automated.test@grupokaizen.net"


for rows in sheet5.iter_cols(min_col=2, max_col=2, min_row=2, max_row=n):
	for row in rows:
		row.value="aeHFOx8jV/A="

wb5.save("TestDataUser.xlsx") 

################################################
#Determinar si se debe iterar 1 o 2 productos
for j in range (0, len(df_fusion)):
	if (df_fusion.loc[j, 'Producto2']==''):
		df_fusion.loc[j, 'Iterar'] = 1
	else:
		df_fusion.loc[j, 'Iterar'] = 2


###############################################################################
#Leemos los excel 
idioma = pd.read_excel(r"TestDataIdioma.xlsx")
usuarios = pd.read_excel(r"TestDataUser.xlsx")
contenedor = pd.read_excel(r"TestDataContenedor.xlsx") 
incoterm = pd.read_excel(r"TestDataIncoterms.xlsx")

#Se crean dataframes a partir del excel
df_idioma= pd.DataFrame(idioma, columns= ['Idioma'])
df_usuarios =  pd.DataFrame(usuarios, columns= ['Usuario', 'Contrasena'])
df_icoterms= pd.DataFrame(incoterm, columns= ['Incoterms'])
df_contenedor = pd.DataFrame(contenedor, columns= ['Contenedor'])

#Concatenar los dataframe en uno 
df_fusion=pd.concat([df_idioma, df_usuarios, df_contenedor, df_icoterms, df_fusion], axis=1)
export_excel = df_fusion.to_excel (r'Testfusion.xlsx', index = None, header=True)


#Crear dataframe con filas aleatorias
na=len(df_fusion)
df_aleatorio = df_fusion.sample(na)

export_excel2 = df_aleatorio.to_excel (r'Pedidos/DataExcel/Crear_Pedido40pies.xlsx', index = None, header=True)


#Borrado de archivos
os.remove('TestDataIdioma.xlsx')
os.remove('TestDataClient.xlsx')
os.remove('TestDataContenedor.xlsx') 
os.remove('TestDataIncoterms.xlsx')
os.remove('TestDataProductNo.xlsx')
os.remove('TestDataProductSop.xlsx')
#os.remove('Testfusion.xlsx')
os.remove('TestDataUser.xlsx')
