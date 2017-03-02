import geb.Page
import geb.spock.GebReportingSpec

/**
 * NOTE : GebSpecを継承すれば、Browserのメソッドが使える。
 *
 * @author kokuho-ri
 *
 */
class SampleSpec extends GebReportingSpec {

	def "yahoo検索1"() {
		given:
		to YahooTopForSpec

		when:
		検索 'エス・エム・エス'

		then:
		at YahooResultSpec

		assert 検索結果[0].text() == '株式会社エス・エム・エス SMS CO., LTD.'
	}

	def "yahoo検索2"() {
		given:
		to YahooTopForSpec

		when:
		検索 'エス・エム・エス'

		then:
		at YahooResultSpec

		assert 検索結果[0].text() == '株式会社エス・エム・エス SMS CO., LTD.'
	}
}

class YahooTopForSpec extends Page {

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

class YahooResultSpec extends Page {

		static at = {
			// String geb.Page.getTitle()
			waitFor { 検索結果.size() > 0 }
		}

		static content = {
			検索結果 { $('H3') }
		}

	}