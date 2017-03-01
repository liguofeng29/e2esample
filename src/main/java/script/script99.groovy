import org.openqa.selenium.By

import geb.Browser
import geb.Page

def keywords = 'javait.hatenablog.com'

Browser.drive {

	to Login
	println 'ログイン画面 : ' + title

	login("jojo", "bean")
	println 'ホーム画面 : ' + title
}.quit()


class Login extends Page {

	static url = "http://localhost:1080/webtours/"

	static at = { waitFor { title.endsWith("Web Tours")} }

	static content = {
		username { $("input[name='username']") }
		loginButton { $("input[name=login]") }
		// TODO wait と trueとは？ waitは設定でtrueになっているのでは？
		// loginButton (wait:true, to:Home){ $("input[name=login]") }
		loginButton { $("input[name=login]") }
	}

	void login (String u, String p) {
		// FIXME ここはgebのframe制御を使うべきね
		driver.switchTo().frame(driver.findElement(By.name("body")))
		driver.switchTo().frame(driver.findElement(By.name("navbar")))

		println "ログイン処理開始"
		username = u
		password = p
		loginButton.click()
	}
}

class Home extends Page {
}





