import geb.Browser

def keywords = 'javait.hatenablog.com'

Browser.drive {

	println baseUrl // debug
    go baseUrl
	println title

	// chrome, firefoxでの動きが異なっている
	// chrome btnK  , firefox btnG
	$('form#tsf').with {
		q = keywords
		btnG().click()
	}
	sleep 3000

	waitFor {               // GebConfig.groovyのtimeoutを待つ
		$('h3').size() > 0
	}

	$('h3').each { println "* ${it.text()}" }

}.quit()
