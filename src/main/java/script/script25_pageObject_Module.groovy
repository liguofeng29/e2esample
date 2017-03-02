/**
 * Module
 *
 * 複数の画面で使う共通部品(メニュとか)はMoudleを継承することで再利用できる。
 */
import geb.Browser
import geb.Module
import geb.Page

Browser.drive {
	to YahooTopUseModule

	検索モジュール.検索欄.value("検索内容")
	検索モジュール.検索ボタン.click()

	sleep 10 * 1000 // for debug
}.quit()

class YahooSearchModule extends Module {
	static content = {
		検索欄 (required: true) { $('#srchtxt') }
		検索ボタン (required: true) { $('#srchbtn') }
	}
}

class YahooTopUseModule extends Page {

	static url = 'http://www.yahoo.co.jp/'

	static at = { title.endsWith("Yahoo! JAPAN") }

	static content = {
		//	検索欄 (required: true) { $('#srchtxt') }
		//	検索ボタン (required: true) { $('#srchbtn') }

		検索モジュール {module YahooSearchModule}
	}
}