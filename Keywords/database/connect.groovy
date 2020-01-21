package database

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

import groovy.sql.Sql

public class connect {

	def configuration = [
		'dbInstance' : '35.196.201.168',
		'dbPort' : 1433,
		'dbName' : 'PETROCHEMICAL_PRUEBAS',
		'dbUser' : 'KAIZEN' ,
		'dbPass' : 'SYSERP2016-9#'
	]

	def sql = Sql.newInstance(
	"jdbc:sqlserver://${configuration.dbInstance}:${configuration.dbPort};" +
	"databaseName=" +
	configuration.dbName, configuration.dbUser, configuration.dbPass,
	'com.microsoft.sqlserver.jdbc.SQLServerDriver')
	/*
	 try {
	 sql.eachRow("select a.cimsi, a.ciccid, b.cserial from tdatos_cliente a, tcliente b where a.qmovil=b.qmovil and a.qmovil=\'149083062\'") {
	 row -> println row
	 }
	 } finally {
	 sql.close()
	 }
	 */
}