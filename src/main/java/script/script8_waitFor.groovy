/**
 * Geb for waitFor
 * http://www.gebish.org/manual/
 * Ajaxなど処理待ちが発生する場合、waitForを利用して待つことができる
 *
 * API:
 *
 * waitFor {}  			デフォルト
 * waitFor(10) {}		最長１０秒待ち
 * waitFor(10, 0.5){} 	最長１０秒待ち、 0.5秒間隔
 * waitFor("quick"){} 	GebConfig.groovyの設定
 *
 *
 * Geb does not provide any support for prompt() due to its infrequent and generally discouraged use.

 */
import geb.Browser

Browser.drive {
	go 'https://www.google.com/recaptcha/demo/ajax'

	$('input', value: 'Click Me').click()
	page.waitFor {
		$('#recaptcha_challenge_image').size() > 0
	}
	println $('#recaptcha_challenge_image').attr('src')

	sleep 10 * 1000
}.quit()


