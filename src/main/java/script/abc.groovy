import geb.Browser

System.setProperty("webdriver.gecko.driver", "E:\\dev\\groovy_geb\\geckodriver.exe")

def keywords = 'javait.hatenablog.com'
Browser.drive {
	go 'http://google.com'
	$('form#tsf').with {
		q = keywords
		btnK().click()
	}
	waitFor {
		$('h3').size() > 0
	}
	$('h3').each { println "* ${it.text()}" }
}.quit()
