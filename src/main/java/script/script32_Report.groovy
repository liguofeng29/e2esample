import geb.Browser

Browser.drive {
	/**
	 * The following methods are available in Browser.drive:
		$()
		go()
		to()
		via()
		at()
		waitFor()
		withAlert()
		withNoAlert()
		withConfirm()
		withNoConfirm()
		download()
		downloadStream()
		downloadText()
		downloadBytes()
		downloadContent()
		report()
		reportGroup()
		cleanReportGroupDir()
	 */

	go 'http://www.google.co.jp/'
	report 'google-'

	go 'http://www.yahoo.co.jp/'
	report 'yahoo-'


	/** reportGroup  **/
	reportGroup "google"
	go "http://google.com"
	report "home page"

	reportGroup "github"
	go "http://github.com"
	report "home page"


	// cleanReportGroupDir()

	sleep 30 * 1000

}