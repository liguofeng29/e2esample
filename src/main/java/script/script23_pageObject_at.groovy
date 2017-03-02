/**
 * Page Object
 *
 * at
 * 呼ばれたpageが予期したpageであるのかを検証する
 */
import geb.Browser
import geb.Page

def keywords = 'javait.hatenablog.com'

Browser.drive {

	to YahooTopWithRightAt
	println 'ログイン画面 : ' + title
	検索(keywords)
	println 'ホーム画面 : ' + title


	// geb.waiting.WaitTimeoutException発生
	to YahooTopWithWrongAt
	println 'to YahooTopWithWrongAtのat条件を満たさないので、処理はここまでがこないはず'

	sleep 10 * 1000 // for debug
}.quit()


class YahooTopWithRightAt extends Page {

	static url = 'http://www.yahoo.co.jp/'

	static at = {
		title.endsWith("Yahoo! JAPAN")
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

class YahooTopWithWrongAt extends Page {

	static url = 'http://www.yahoo.co.jp/'

	static at = {
		// GebConfig.groovyに設定したtimeoutでエラー発生
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