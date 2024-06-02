package github.page.element;

import org.openqa.selenium.WebElement;


public record Paragraph(WebElement paragraph) {

    public String text() {
        return paragraph.getText();
    }
}
