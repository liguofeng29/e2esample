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

def keywords = 'javait.hatenablog.com'
def testPage = new File('src/main\\java/html/script2.html')

Browser.drive {
    go testPage.toURI().toString()

//	// search element by tag, class, id
//    $("div")
//    // Match the first "div" element on the page.
//    $("div", 0)
//    // Match all "div" elements with a title attribute value of "section".
//    $("div", title: "section")
//    // Match the first "div" element with a title attribute value of "section".
//    $("div", 0, title: "section")
//    // Match all "div" elements who have the class "main".
//    $("div.main")
//    // Match the first "div" element with the class "main".
//    $("div.main", 0)

	// search element by traversing
//	<div class="a">
//		<div class="b">
//			<p class="c"></p>
//			<p class="d"></p>
//			<p class="e"></p>
//		</div>
//		<div class="f"></div>
//	</div>

//	assert $("p.d").previous() == $("p.c")
//	assert $("p.e").prevAll() == $("p.c").add("p.d")
//	assert $("p.d").next() == $("p.e")
//	assert $("p.c").nextAll() == $("p.d").add("p.e")
//	assert $("p.d").parent() == $("div.b")
//	assert $("p.c").siblings() == $("p.d").add("p.e")
//	assert $("div.a").children() == $("div.b").add("div.f")

	// by tag
	println "divタグ数 : " + $("div").size()
	println "2個目divタグのtext : " + $("div", 1).text()

    // by id
    $('#keyword').value(keywords)
    $('#btnSearch').click()

    sleep 10 * 1000

}.quit()

