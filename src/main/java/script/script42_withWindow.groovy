import geb.Browser

def testPage = new File('src/main/java/html/script42.html')

Browser.drive {

    go testPage.toURI().toString()

    $("a").click()
    withWindow("myWindow") {
        // myWindow内部
        println title
        println "現在のWindow名 : " + browser.getCurrentWindow()

        assert title == "Geb - Very Groovy Browser Automation"
    }

    println "現在のWindow名 : " + browser.getCurrentWindow()
    println "現在有効なWindow名 : " + browser.getAvailableWindows()

    sleep 3 *1000

    /**
     If you don’t know the name of the window but you know something about the content of the window
     you can use the withWindow(Closure specification,
     Closure block) method. The first closure passed should return true for the window, or windows,
     you want to use as context for execution of the second closure.
     **/

}.quit()

/**
 Browser.drive {
 go()
 withNewWindow({ $('a').click() }) {
 assert title == 'Geb - Very Groovy Browser Automation'
 }
 }
 **/

/**
 **/