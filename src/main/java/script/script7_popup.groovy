/**
 * Geb for popup
 *
 * http://www.gebish.org/manual/
 *
 * use AlertAndConfirmSupport for alert,confirm,prompt
 *
 *
 * Geb does not provide any support for prompt() due to its infrequent and generally discouraged use.

 */
import geb.Browser
import geb.Page

def keywords = 'javait.hatenablog.com'
// def testPage = new File('src/main/java/html/script7.html')

Browser.drive {
	// go testPage.toURI().toString()

	to PopupPage

	// API for AlertAndConfirmSuppor
	/** alert **/
//	def withAlert(Closure actions)
//	def withAlert(Map params, Closure actions)
//	void withNoAlert(Closure actions)

	/** confirm **/
//	def withConfirm(boolean ok, Closure actions)
//	def withConfirm(Closure actions)
//	def withConfirm(Map params, Closure actions)
//	def withConfirm(Map params, boolean ok, Closure actions)
//	void withNoConfirm(Closure actions)

	assert withAlert(wait: true) { showAlert.click() } == "alert!"
	//assert withAlert(wait: true) { showAlert.click() } == "some alert!" // エラー

	// actionsでalertが表示されるとAssertionError発生する
	withNoAlert { $("input", name: "dontShowAlert").click() }

	assert withConfirm(true) { showConfirm.click() } == "confirm?"
	sleep 2 * 1000
	assert withConfirm(false) { showConfirm.click() } == "confirm?"

	sleep 10 * 1000
}.quit()



class PopupPage extends Page{
	// baseURL +
	static url = "script7.html"
	static content = {
		showAlert      {$("input", name: "showAlert")}
		donotShowAlert {$("input", name: "dontShowAlert")}
		showConfirm    {$("input", name: "showConfirm")}
	}
}
