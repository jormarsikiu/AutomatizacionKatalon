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

public class Ex_inventario_pedidos_20pies {

	@Keyword
	def runPython(){

		try {
			System.out.println("Espere mientras se crea el archivo...");
			// -- Linux --

			// Run a shell command
			// Process process = Runtime.getRuntime().exec("ls /home/mkyong/");

			// -- Windows --

			// Run a command
			String home = System.getProperty("user.dir");
			String actual = "\\Pedidos\\Python\\InventarioPedidos.py"
			String ruta = home + actual

			Process process = Runtime.getRuntime().exec("cmd /c py "+ruta);

			StringBuilder output = new StringBuilder();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println("Archivo Creado: Pedidos/DataExcel/Inventario_20pies.xlsx");
				System.out.println(output);
				//System.exit(0);
			} else {
				System.out.println("No se puedo crear el archivo!. (Cierre el archivo o revise la instalación de python)");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
