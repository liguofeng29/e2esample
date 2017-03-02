/**
 * Page Object
 *
 * Content DSL
 * 引数：
 * required : default true
 *            要素が存在しない場合、RequiredPageContentNotPresent例外を投げるかどうか
 *
 * cache :  defalut false
 *          ページをリロードしないと値はそのままだ。
 *
 * to    :  指定pageのURLを開く
 * wait  :  defalut false 値、true, a string, a number, a 2 element list of numbers
 * toWait : default false 、toと組み合わせで使う
 *          主に非同期遷移とかの場合、ページ遷移を待つのか？未検証。
 *
 * page  :  defalut null
 */
import geb.Browser
import geb.Page

def testPage = new File('src/main/java/html/script24.html')

Browser.drive {
	to YahooTopTestRequired

	/** required 検証 **/
	/** http://www.gebish.org/manual/current/#code-required-code **/
	try {
		println 存在しない要素1
	} catch (MissingPropertyException e) {
		println "required: true の場合は、MissingPropertyException発生 : " + 存在しない要素2
	}

	println "required: false の場合は、null : " + 存在しない要素2

	/** cache 検証 **/
	/** http://www.gebish.org/manual/current/#code-cache-code **/

	to YahooTopTestCache

	assert キャッシュ利用する == "value1"
	assert キャッシュ利用しない == "value1"

	value1 = "value99"

	assert キャッシュ利用する == "value1"        // 値が変わらない
	// assert キャッシュ利用しない == "value99"   // 変わるはずだが・・・・ 公式ページのコードでもやったが。

	/** page 検証 **/
	// 通常IFrame操作で利用する。
	// script5_Geb_API_Frame.groovy参照

	/** to 検証 **/
	/* The to option allows the definition of which page the browser will be sent to if the content is clicked. */
	/** http://www.gebish.org/manual/current/#content-dsl-to **/
	config.baseUrl = new File(testPage.getAbsolutePath()).toURI()
	to PageTestTo
	リンク.click()

	/** NOTE
	 *
	 * toを使う際に、指定pageにはatを実装すべきである
	 * toを指定することで実際に遷移が行われるわけではなく、指定pageのatが実行される。
	 *
	 * テキスト.click()をクリックしてもページ遷移は発生しない。
	 */

	 sleep 10 * 1000 // for debug
}.quit()

class YahooTopTestRequired extends Page {

	static url = 'http://www.yahoo.co.jp/'

	static at = { title.endsWith("Yahoo! JAPAN") }

	static content = {
		検索欄 (required: true) { $('#srchtxt') }
		検索ボタン (required: true) { $('#srchbtn') }

		存在しない要素1 (required: true) { $('#abcde1').text() }
		存在しない要素2 (required: false) { $('#abcde2').text() }
	}
}

class YahooTopTestCache extends Page {

	def value1 = "value1"

	static url = 'http://www.yahoo.co.jp/'

	static at = { title.endsWith("Yahoo! JAPAN") }

	static content = {
		検索欄 (required: true) { $('#srchtxt') }
		検索ボタン (required: true) { $('#srchbtn') }

		キャッシュ利用する   (cache: true) { value1 }
		// キャッシュ利用しない (cache: false) { value1 }
		キャッシュ利用しない  { value1 }
	}
}

class PageTestTo extends Page {
	static url = "script24.html"
	static content = {
		テキスト(to : GoogleTopTestTo) {$('#div1')}
		リンク (to : GoogleTopTestTo) {$('#googleLink')}
	}
}

class GoogleTopTestTo extends Page {
	static url = 'http://www.google.co.jp/'
	static at = { waitFor { title.startsWith("Google")} }
}
