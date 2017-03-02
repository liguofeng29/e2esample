/**
 * Page Object
 *
 * URL
 * urlは baseUrl + パスで構成
 * Page Objectのurlは、相対、絶対両方OK
  */
import geb.Browser
import geb.Page

Browser.drive {
	// baseUrl
	config.baseUrl = "http://www.gebish.org/"

	to ExamplePage1

	sleep 3 * 1000 // for debug

	to ExamplePage2

	sleep 3 * 1000 // for debug

	to ExamplePageWithArguments, "args1", "args2"
	// will go to「http://www.gebish.org/manual/args1/args2」

	sleep 3 * 1000 // for debug

	to ExamplePageWithInstance, new Person(id : "12345")
	// will go to [http://www.gebish.org/manual/12345]
	sleep 3 * 1000 // for debug
}.quit()

/** 相対url **/
class ExamplePage1 extends Page {
	static url = "manual/current/all.html"
}

/** 絶対url **/
class ExamplePage2 extends Page {
	static url = "http://www.gebish.org/manual/current/#at-checking"
}

/** 引数ありurl **/
class ExamplePageWithArguments extends Page {
	static url = "http://www.gebish.org/manual"
}

/** インスタンスを引数とするurl **/
class ExamplePageWithInstance extends Page{
	static url = "http://www.gebish.org/manual/"

	String convertToPath(Person person) {
		person.id.toString()
	}
}

class Person {
	String id
}
