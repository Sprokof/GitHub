package github.page.element;

import github.page.BaseRouter;
import org.openqa.selenium.WebElement;


import java.util.List;

public class Options {
    private final List<WebElement> options;

    public Options(List<WebElement> options) {
        this.options = options;
    }

    public BaseRouter select(int index) {
        this.options.get(index).click();
        return new BaseRouter();
    }
}
