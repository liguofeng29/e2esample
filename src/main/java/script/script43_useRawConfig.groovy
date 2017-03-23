import geb.Browser

def keywords = 'javait.hatenablog.com'

Browser.drive {

	go 'http://www.yahoo.co.jp/'

    def word1 = config.rawConfig.keywords.word1
    def word2 = config.rawConfig.keywords.word2

    $('#srchtxt').value(word1 + word2)
    $('#srchbtn').click()


	waitFor {
		$('h3').size() > 0
	}

	$('h3').each { println "* ${it.text()}" }

	sleep 10 * 1000 // for debug

}.quit()