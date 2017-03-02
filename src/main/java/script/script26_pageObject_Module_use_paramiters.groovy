/**
 * Module
 *
 * モジュールに引数を渡すサンプル
 */
import geb.Browser
import geb.Module
import geb.Page


def testPage = new File('src/main/java/html/script26.html')

// FIXME 引数でなんとかやりたいけど、うまくいかなかった。
Browser.drive {

	config.baseUrl = new File(testPage.getAbsolutePath()).toURI()

	to ExamplePage

	// page ExamplePage
	// theModule("something").button.click()

	theModule("button1").button.click()
	sleep 2 * 1000

	theModule("button2").button.click()
	sleep 2 * 1000

	theModule("button3").button.click()
	sleep 2 * 1000

	sleep 2 * 1000
}

class ExampleModule extends Module {
	def buttonName

	static content = {
		button { $("input", type: "button", name: buttonName) }
		// button { $("input", type: "button", name: buttonName) }
	}
}

class ExamplePage extends Page {
	static url = "script26.html"
	static content = {
		// moudule { name -> module ExampleModule }

		//theModule { name ->	module ExampleModule, buttonName: name }
		theModule { name ->	module ExampleModule, buttonName : name }
		// theModule { name ->	module ExampleModule }
	}
}


