/**
 * Page Object
 */
import geb.Browser
import geb.Page

def keywords = 'javait.hatenablog.com'

Browser.drive {

	to YahooTopWithWrong
	println 'ログイン画面 : ' + title

	検索(keywords)

	println 'ホーム画面 : ' + title

	waitFor {
		$('h3').size() > 0
	}

	$('h3').each { println "* ${it.text()}" }

	sleep 10 * 1000 // for debug

}.quit()

/**
 * Page Object
 *
 * url：相対パス、絶対パス
 * at： page確認条件
 * content DSL：pageの要素
 *
 *
 */
class YahooTopWithWrong extends Page {

	static url = 'http://www.yahoo.co.jp/'

	static at = { // GebConfig.groovyに設定したtimeoutでエラー発生
		title.endsWith("xxxxxxxxxxxxxxx wrong")
	}

	static content = {
		検索欄 { $('#srchtxt') }
		検索ボタン { $('#srchbtn') }
	}

	// pageが提供するサービス
	void 検索 (String keywords) {
		検索欄 = keywords
		検索ボタン.click()
	}
}