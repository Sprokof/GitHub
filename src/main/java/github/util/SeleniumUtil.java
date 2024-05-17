package github.util;

import github.page.instance.Driver;

public class SeleniumUtil {
    public static void driverClose() {
        Driver.getInstance().quit();
        Driver.setNull();
    }
}
