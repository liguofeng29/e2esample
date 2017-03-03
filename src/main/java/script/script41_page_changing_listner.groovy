import geb.Browser
import geb.Page
import geb.PageChangeListener

Browser.drive {

    def listener = new RecordingPageChangeListener()

    // page変更リスナー追加
    registerPageChangeListener(listener)

    go 'http://www.google.co.jp/'
    sleep 3 *1000

    go 'http://www.yahoo.co.jp/'
    sleep 30 * 1000

    removePageChangeListener(listener)

    go 'http://www.google.co.jp/'
    sleep 3 *1000
}.quit()

class RecordingPageChangeListener implements PageChangeListener {
    Page oldPage
    Page newPage

    @Override
    void pageWillChange(Browser browser, Page oldPage, Page newPage) {
        this.oldPage = oldPage
        this.newPage = newPage

        println "page changing"
    }
}
