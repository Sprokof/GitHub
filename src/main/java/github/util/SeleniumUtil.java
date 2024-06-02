package github.util;

import github.page.instance.Driver;

public class SeleniumUtil {

    public static void driverClose() {
        Driver.getInstance().quit();
        Driver.setNull();
    }

    public static void waitVisible() {
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
