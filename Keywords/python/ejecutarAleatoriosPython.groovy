package python

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class ejecutarAleatoriosPython {

	String actual;

	@Keyword
	def runPython(String tipo){

		if (tipo == 'Crear20'){
			actual = "\\Pedidos\\Python\\CrearPedidosPython20pies.py";
			System.out.println("Archivo: Pedidos/DataExcel/Crear_Pedido20pies.xlsx");
		}
		else if (tipo == 'Crear40'){
			actual = "\\Pedidos\\Python\\CrearPedidosPython40pies.py";
			System.out.println("Archivo: Pedidos/DataExcel/Crear_Pedido40pies.xlsx");
		}
		else if (tipo == 'Aprobar'){
			actual = "\\Pedidos\\Python\\AprobacionesPedidosPython.py";
			System.out.println("Archivo: Pedidos/DataExcel/AprobacionesPedidos.xlsx");
		}
		else if (tipo == 'Logistica'){
			actual = "\\Pedidos\\Python\\LogisticaPedidosPython.py";
			System.out.println("Archivo: Pedidos/DataExcel/Cargos_Logisticos.xlsx");
		}
		else if (tipo == 'Produccion'){
			actual = "\\Pedidos\\Python\\ProduccionPedidosPython.py";
			System.out.println("Archivo: Pedidos/DataExcel/Orden_Produccion.xlsx");
		}
		else if (tipo == 'Inventario'){
			actual = "\\Pedidos\\Python\\InventarioPedidos.py";
			System.out.println("Archivo: Pedidos/DataExcel/Inventario.xlsx");
		}
		else if (tipo == 'Despacho'){
			actual = "\\Pedidos\\Python\\DespachoPedidosPython.py";
			System.out.println("Archivo Creado: Pedidos/DataExcel/Despacho.xlsx");
		}
		else if (tipo == 'BorradoTotal'){
			actual = "\\Pedidos\\Python\\BorrarTodosExcelsPython.py";
			System.out.println("Archivos Borrados en: Pedidos/DataExcel");
		}
		else if (tipo == 'ProductoAlmacen'){
			actual = "\\Pedidos\\Python\\ProductoAlmacenPython.py";
			System.out.println("Archivo Creado: Pedidos/DataExcel/ProductoAlmacen.xlsx");
		}
		else if (tipo == 'MovimientoInventario'){
			actual = "\\Pedidos\\Python\\MovimientoInventario.py";
			System.out.println("Archivo Creado: Pedidos/DataExcel/MovimientoInventario.xlsx");
		}
		else if (tipo == 'Reporte'){
			actual = "\\Pedidos\\Python\\ReporteMovimientoInventario.py";
			System.out.println("Archivo Creado: Pedidos/DataExcel/ReporteMovimientoInventario.xlsx");
		}


		try {
			System.out.println("Espere mientras se crea el archivo...");
			// -- Linux --

			// Run a shell command
			// Process process = Runtime.getRuntime().exec("ls /home/mkyong/");

			// -- Windows --

			// Run a command
			String home = System.getProperty("user.dir");

			String ruta = home + actual;

			Process process = Runtime.getRuntime().exec("cmd /c py "+ruta);

			StringBuilder output = new StringBuilder();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;

			while ((line = reader.readLine()) != null) {

				output.append(line + "\n");
			}

			int exitVal = process.waitFor();

			if (exitVal == 0) {

				System.out.println(output);

			} else {

				System.out.println("\nNo se puedo crear el archivo!. \n\nPOSIBLES SOLUCIONES: \n1. Cierre el archivo. \n2. Revise la instalación de python. \n3. Error en el código de python\n");
			}

		} catch (IOException e) {

			e.printStackTrace();

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}

