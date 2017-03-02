/**
 * Page Object
 *
 * PageObjectとは？
 * PageObjectデザインパターンとは、アプリケーションの画面を１つのオブジェクトとしてとらえるデザインパターンの１種のことです。
 * Seleniumの公式サイトでも推奨されている、保守性の高いテストコードの書き方です。
 *
 * 公式サイトに記載されているPageObjectの原則は以下のようなものです。
 * ・The public methods represent the services that the page offers（publicメソッドは、ページが提供するサービスを表す）
 * ・Try not to expose the the internals of the page （ページの内部を公開しないこと）
 * ・Generally don’t make assertions （原則としてassertionを行わないこと）
 * ・Methods return other PageObjects （メソッドは他のPageObjectsを返す）
 * ・Need not represent an entire page （ページ全体を表す必要はない）
 * ・Different results for the same action are modelled as different as different methods （同じアクションに対して異なる結果となる場合には異なるメソッドとしてモデル化する）
 *
 * 参考：http://softwaretest.jp/labo/tech/labo-292/
 *
 * * GebはPageクラスを継承することで、Page Objectパターンを実装することができる。
 *
 */
import geb.Browser
import geb.Page

def keywords = 'javait.hatenablog.com'

Browser.drive {

	to YahooTop
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
 */
class YahooTop extends Page {

	static url = 'http://www.yahoo.co.jp/'

	static at = {
		// String geb.Page.getTitle()
		waitFor { title.endsWith("Yahoo! JAPAN")
	} }

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