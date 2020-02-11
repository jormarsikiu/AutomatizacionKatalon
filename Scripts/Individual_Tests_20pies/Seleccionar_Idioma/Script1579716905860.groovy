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

int Idioma = 0

if (Evento=="Crear"){
	List<String> data = CustomKeywords.'obtener_excels.obtener_pedidos20pies.getValuesExcelCreate20'(Index)
	Idioma = data[0]
}
else if (Evento=="Aprobar"){
	List<String> data2 = CustomKeywords.'obtener_excels.obtener_aprobaciones_20pies.getValuesExcelAprob20'(Index)
	Idioma = data2[0]
}
else if (Evento=="Logistica"){
	List<String> data3 = CustomKeywords.'obtener_excels.obtener_logistica_20pies.getValuesExcelLogistic'(Index)
	Idioma = data3[0]
}
else if (Evento=="Produccion"){
	List<String> data4 = CustomKeywords.'obtener_excels.obtener_produccion_20pies.getValuesExcelProduction'(Index)
	Idioma = data4[0]
}
else if (Evento=="Inventario"){
	List<String> data5 = CustomKeywords.'obtener_excels.obtener_inventario_20pies.getValuesExcelInventary'(Index)
	Idioma = data5[0]
}
else if (Evento=="Despacho"){
	List<String> data6 = CustomKeywords.'obtener_excels.obtener_despacho_20pies.getValuesExcelDespach'(Index)
	Idioma = data6[0]
}
WebUI.click(findTestObject('Page_- KAIZEN/si_btn_idioma'))

if (Idioma == '0'){ 
	
	WebUI.click(findTestObject('Page_- KAIZEN/si_Ingles'))
}

else {

	WebUI.click(findTestObject('Page_- KAIZEN/si_Spanish'))
 }


