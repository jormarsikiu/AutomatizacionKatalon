import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.apache.commons.lang.RandomStringUtils as RandStr
Random rand = new Random();

String IdGrupo='Materia Prima'
if(IdGrupo=='Materia Prima'){
	
	cantidad = rand.nextInt((10000 - 10) + 1) + 10;
}
else if(IdGrupo=='Producto Terminado'){
	
	cantidad = rand.nextInt((250 - 1) + 1) + 1;
}
else if(IdGrupo=='MP: Liquidos'){
	
	cantidad = rand.nextInt((20000 - 4000) + 1) + 4000;
}
print(cantidad + '/n')
nuevacantidad = rand.nextInt((cantidad - 10) + 1) + 10;
print(nuevacantidad + '/n')
