import static java.util.logging.Level.*
import static org.openqa.selenium.logging.LogType.*
import static org.openqa.selenium.remote.CapabilityType.*

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.logging.LoggingPreferences
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.remote.DesiredCapabilities

// Geb 設定ファイル

// FIXME ここは
// baseUrl = "file:///C:/Users/kokuho-ri/git/e2esample/src/main/java/html/"

reportsDir = "tmp"

// at()チェックの待機設定
atCheckWaiting = true

// base navigatorのための待機設定
baseNavigatorWaiting = true

autoClearCookies = false

// 待機時間の指定（キーワード指定）
waiting {
    timeout = 20
    retryInterval = 1
}

// デフォルトのWebDriver
driver = { new ChromeDriver() }

environments {
    // specify environment via -Dgeb.env=ie
    chrome {
        Map<String, Object> prefs = new HashMap<String, Object>()
        //prefs.put("profile.default_content_settings.popups", 2)
        prefs.put("download.default_directory", downloadDir)

        ChromeOptions options = new ChromeOptions()
        options.addArguments("start-maximized")
        options.setExperimentalOption("prefs", prefs)
        DesiredCapabilities cps = DesiredCapabilities.chrome()
        cps.setCapability(ChromeOptions.CAPABILITY, options)
        LoggingPreferences logPrefs = new LoggingPreferences()
        logPrefs.enable(BROWSER, ALL)
        cps.setCapability(LOGGING_PREFS, logPrefs)
        driver = { new ChromeDriver(cps) }
    }

    firefox {
        driver = { new FirefoxDriver() }
    }

    phantomJs {
        driver = { new PhantomJSDriver() }
    }

    ie {
        driver = { new InternetExplorerDriver() }
    }

}

// 実行環境に合わせた各種WebDriverバイナリのパスをシステムプロパティに設定する
script.DriverSystemPropertyInitializer.initialize()

