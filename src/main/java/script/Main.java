package script;

import geb.Browser;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Browser b = new Browser();

        b.setBaseUrl(JavaPage.url);
        b.to(JavaPage.class, "");

        Thread.sleep(10 * 1000);
    }
}