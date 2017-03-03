import geb.Browser
import geb.report.ReportState
import geb.report.Reporter
import geb.report.ReportingListener

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

    // リスナ定義
    reportingListener = new ReportingListener() {
        void onReport(Reporter reporter, ReportState reportState, List<File> reportFiles) {
            reportFiles.each {
                println "[[ATTACHMENT|$it.absolutePath]]"
            }
        }
    }

    // リスナ追加
    config.reporter.addListener(reportingListener);

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

