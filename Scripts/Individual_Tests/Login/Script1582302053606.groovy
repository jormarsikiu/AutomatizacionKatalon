import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

print("Evento Seleccionado: "+Evento+"\n")

WebUI.openBrowser(GlobalVariable.Web)

WebUI.maximizeWindow()

if (Evento=="Crear20"){
	List<String> data = CustomKeywords.'obtener_excels.obtener_pedidos20pies.getValuesExcelCreate20'(Index)	
	String Usuario = data[1]	
	String Contrasena = data[2]
	WebUI.setText(findTestObject('Page_Iniciar Sesion - KAIZEN/is_input_email'), Usuario)
	WebUI.setEncryptedText(findTestObject('Page_Iniciar Sesion - KAIZEN/IS_input_contrasena'), Contrasena)
	WebUI.click(findTestObject('Page_Iniciar Sesion - KAIZEN/is_btn_ingresar_sistema'))
}

else if (Evento=="Crear40"){
	List<String> data7 = CustomKeywords.'obtener_excels.obtener_pedidos40pies.getValuesExcelCreate40'(Index)
	String Usuario = data7[1]
	String Contrasena = data7[2]
	WebUI.setText(findTestObject('Page_Iniciar Sesion - KAIZEN/is_input_email'), Usuario)
	WebUI.setEncryptedText(findTestObject('Page_Iniciar Sesion - KAIZEN/IS_input_contrasena'), Contrasena)
	WebUI.click(findTestObject('Page_Iniciar Sesion - KAIZEN/is_btn_ingresar_sistema'))
}

else if (Evento=="Aprobar"){
	List<String> data2 = CustomKeywords.'obtener_excels.obtener_aprobaciones.getValuesExcelAprob20'(Index)
	String Usuario = data2[1]
	String Contrasena = data2[2]
	WebUI.setText(findTestObject('Page_Iniciar Sesion - KAIZEN/is_input_email'), Usuario)
	WebUI.setEncryptedText(findTestObject('Page_Iniciar Sesion - KAIZEN/IS_input_contrasena'), Contrasena)
	WebUI.click(findTestObject('Page_Iniciar Sesion - KAIZEN/is_btn_ingresar_sistema'))
}

else if (Evento=="Logistica"){
	List<String> data3 = CustomKeywords.'obtener_excels.obtener_logistica.getValuesExcelLogistic'(Index)
	String Usuario = data3[1]
	String Contrasena = data3[2]
	WebUI.setText(findTestObject('Page_Iniciar Sesion - KAIZEN/is_input_email'), Usuario)
	WebUI.setEncryptedText(findTestObject('Page_Iniciar Sesion - KAIZEN/IS_input_contrasena'), Contrasena)
	WebUI.click(findTestObject('Page_Iniciar Sesion - KAIZEN/is_btn_ingresar_sistema'))	
}

else if (Evento=="Produccion"){
	List<String> data4 = CustomKeywords.'obtener_excels.obtener_produccion.getValuesExcelProduction'(Index)
	String Usuario = data4[1]
	String Contrasena = data4[2]
	WebUI.setText(findTestObject('Page_Iniciar Sesion - KAIZEN/is_input_email'), Usuario)
	WebUI.setEncryptedText(findTestObject('Page_Iniciar Sesion - KAIZEN/IS_input_contrasena'), Contrasena)
	WebUI.click(findTestObject('Page_Iniciar Sesion - KAIZEN/is_btn_ingresar_sistema'))
}	

else if (Evento=="Inventario"){
	List<String> data5 = CustomKeywords.'obtener_excels.obtener_inventario.getValuesExcelInventary'(Index)
	String Usuario = data5[1]
	String Contrasena = data5[2]
	WebUI.setText(findTestObject('Page_Iniciar Sesion - KAIZEN/is_input_email'), Usuario)
	WebUI.setEncryptedText(findTestObject('Page_Iniciar Sesion - KAIZEN/IS_input_contrasena'), Contrasena)
	WebUI.click(findTestObject('Page_Iniciar Sesion - KAIZEN/is_btn_ingresar_sistema'))
}

else if (Evento=="Despacho"){
	List<String> data6 = CustomKeywords.'obtener_excels.obtener_despacho.getValuesExcelDespach'(Index)
	String Usuario = data6[1]
	String Contrasena = data6[2]
	WebUI.setText(findTestObject('Page_Iniciar Sesion - KAIZEN/is_input_email'), Usuario)
	WebUI.setEncryptedText(findTestObject('Page_Iniciar Sesion - KAIZEN/IS_input_contrasena'), Contrasena)
	WebUI.click(findTestObject('Page_Iniciar Sesion - KAIZEN/is_btn_ingresar_sistema'))
}

else if (Evento=="ProductoAlmacen"){
	List<String> data7 = CustomKeywords.'obtener_excels.obtener_producto_almacen.getValuesExcelProductoAlmacen'(Index)
	String Usuario = data7[1]
	String Contrasena = data7[2]
	WebUI.setText(findTestObject('Page_Iniciar Sesion - KAIZEN/is_input_email'), Usuario)
	WebUI.setEncryptedText(findTestObject('Page_Iniciar Sesion - KAIZEN/IS_input_contrasena'), Contrasena)
	WebUI.click(findTestObject('Page_Iniciar Sesion - KAIZEN/is_btn_ingresar_sistema'))
}

else if (Evento=="MovimientoDeInventario"){
	List<String> data8 = CustomKeywords.'obtener_excels.obtener_mov_inventario.getValuesExcelMovInventario'(Index)
	String Usuario = data8[1]
	String Contrasena = data8[2]
	WebUI.setText(findTestObject('Page_Iniciar Sesion - KAIZEN/is_input_email'), Usuario)
	WebUI.setEncryptedText(findTestObject('Page_Iniciar Sesion - KAIZEN/IS_input_contrasena'), Contrasena)
	WebUI.click(findTestObject('Page_Iniciar Sesion - KAIZEN/is_btn_ingresar_sistema'))
}