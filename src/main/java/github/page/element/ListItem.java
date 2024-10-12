package github.page.element;

import github.page.BaseRouter;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ListItem {
    private final List<WebElement> items;

    public ListItem(List<WebElement> items) {
        this.items = items;
    }

    public BaseRouter select(int index) {
        this.items.get(index).click();
        return new BaseRouter();
    }
}
