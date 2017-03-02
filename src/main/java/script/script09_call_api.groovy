/**
 * Geb for calling api
 * http://www.gebish.org/manual/
 */
import geb.Browser
import groovy.json.JsonSlurper

def testPage = new File('src/main/java/json/json-data1.json')

Browser.drive {
	URL apiUrl = testPage.toURL()
	def data = new JsonSlurper().parseText(apiUrl.text)

	println data.name
	println data.age

	assert data.name == 'Alex'
	assert data.age == '20'

}.quit()


