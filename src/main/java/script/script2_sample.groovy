/**
 * Geb Navigator API
 *
 * http://www.gebish.org/manual/current/#the-jquery-ish-navigator-api
 *
 * jquery selector
 * https://www.w3schools.com/jquery/trysel.asp
 * https://www.w3schools.com/jquery/jquery_selectors.asp
 *
 *
 */
import geb.Browser

/**
 * geb常用メソッド
 *
 * .value() elementのtext代入
 * .text()  elementのtext取得
 * .click() elementのclick
 * waitFor 	条件待ち、時間経過するとWaitTimeoutExceptionが発生する
 *
 */
def keyword = 'javait.hatenablog.com'

Browser.drive {
    go 'http://yahoo.co.jp'

	// タイトルがYahooになるまで待つ
	waitFor { title.startsWith('Yahoo') }

	// keyword入力
	$('#srchtxt').value(keyword)
	// ボタンクリック
	$($('#srchbtn')).click()

	// タイトルが検索結果で終わるまで待つ
	waitFor() { title.endsWith('検索') }

	// waitFor(1) { false } １秒後timeout
	// waitFor { title.endsWith('設定した時間後timeoutが発生する') }

	// 出力
	$('h3').each { println "* ${it.text()}" }

}.quit()

