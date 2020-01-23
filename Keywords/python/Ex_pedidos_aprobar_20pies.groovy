package python

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.exception.BrowserNotOpenedException


public class Ex_pedidos_aprobar_20pies {

	@Keyword
	def runPython(){

		try {

			// -- Linux --

			// Run a shell command
			// Process process = Runtime.getRuntime().exec("ls /home/mkyong/");

			// -- Windows --

			// Run a command
			String home = System.getProperty("user.dir");
			String actual = "\\Pedidos\\Python\\AprobacionesPedidosPython.py"
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
				System.out.println("Archivo Creado!");
				System.out.println(output);
				//System.exit(0);
			} else {
				System.out.println("No se puedo crear el archivo!");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
