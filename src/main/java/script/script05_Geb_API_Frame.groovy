/**
 * Geb API
 * Control Frame
 *
 * http://www.gebish.org/manual/
 *
 * Frameを操作する方法
 * 1. 直接操作
 * 2. Page Object Model利用
 *
 */
import geb.Browser
import geb.Page

def testPage = new File('src/main/java/html/script05.html')

Browser.drive {
	// baseUrl設定
	config.baseUrl = new File(testPage.getAbsolutePath()).toURI()

	// 指定URLでブラウザオープン
	go testPage.toURI().toString()

	/** 1. 直接操作 ** **/
	// page.withFameと同価
	withFrame('header') {assert $('span').text() == 'HEADER' }
	withFrame('footer') {assert $('span').text() == 'FOOTER' }

	withFrame(0) { assert $('span').text() == 'HEADER' }
	withFrame(2) { assert $('span').text() == 'FOOTER' }

	withFrame($('#content')) { assert $('div', 2).text() == 'CONTENT3' }


	/** 2. Page Object **/
	to LayoutPage
	withFrame(contentsFrame) { println "contents frame内のdiv要素数 : " + ($('div').size()) }

	sleep 10 * 1000
}.quit()


class LayoutPage extends Page {
	// baseUrl + url
	static url = 'script05.html'

	static content = {
		contentsFrame(page: ContentsPage){$('#content')}
	}
}

class ContentsPage extends Page {
	// baseUrl + url
	static url = 'script5_content_frame.html'
}
