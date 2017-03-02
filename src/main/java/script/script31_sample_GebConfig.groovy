import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

import geb.Browser

/*********/
/** URL **/
/*********/
// setBaseUrl(def baseUrl)
baseUrl = "http://localhost:8080"

/************/
/** Driver **/
/************/
// setDriver(WebDriver driver)
driver = {
	def driver = new FirefoxDriver()
	driver.javascriptEnabled = true
	driver
}

// 環境変数
environments {
	chrome {
		driver = { new ChromeDriver() }
	}
	firefox {
		driver = { new FirefoxDriver()}
	}
}

// sample : テストブラウザ切り替え
// mvn -Dgeb.env=chrome test
// or
// mvn -Dgeb.env=firefox test

/*************/
/** Waiting **/
/*************/
// setDefaultWaitTimeout(Double defaultWaitTimeout)
// setDefaultWaitRetryInterval(Double defaultWaitRetryInterval)

atCheckWaiting = true; // wait値がデフォルトtrueになる

waiting {
	timeout = 5
	retryInterval = 0.1
}

// setWaitPreset(String name, Double presetTimeout, Double	presetRetryInterval)
waiting {
	presets {
		slow {
			timeout = 20
			retryInterval = 2
		}
		quick {
			timeout = 3
			retryInterval = 0.5
		}
	}
}

// Sample for waiting
Browser.drive {
	waitFor("quick"){ 2 == 1 + 1 }
}

/**************/
/** ？？？？ **/
/**************/

// setUnexpectedPages(Collection pages)
unexpectedPages = [PageNotFoundPage, InternalServerErrorPage]


/**************/
/** Report **/
/**************/
/**  **/
// setReportsDir(File reportsDir)
reportsDir = new File("target/geb-reports")// 報告格納先

reportOnTestFailureOnly = true            // 失敗時のみ報告

// PageSourceReporter                      // only HTML
// ScreenshotAndPageSourceReporter         // HTML And png
// reporter = new CustomReporter()         // カスタム報告出力オブジェクト

// API
// void report(String label)
// void reportGroup(String path)
// cleanReportGroupDir()



