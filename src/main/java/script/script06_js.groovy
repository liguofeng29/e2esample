/**
 * Geb for javascript
 *
 * http://www.gebish.org/manual/
 *
 * 1. get variable from javascript
 * 2. call method
 * 3. add script
 */
import geb.Browser

def testPage = new File('src/main/java/html/script06.html')

Browser.drive {
	// 指定URLでブラウザオープン
	go testPage.toURI().toString()

	// JavascriptInterface geb.Browser.getJs()

	// get variable
	assert js.var1 == 100
	// 2. call method
	assert js.add(1, 10) == 11
	// 3. add script
	assert js."document.title" == "for javascript"
	js."alert('add script')"

	sleep 10 * 1000
}.quit()

