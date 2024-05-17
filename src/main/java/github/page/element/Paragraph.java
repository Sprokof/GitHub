package github.page.element;

import org.openqa.selenium.WebElement;


public class Paragraph {
    private final WebElement paragraph;

    public Paragraph(WebElement paragraph) {
        this.paragraph = paragraph;
    }

    public WebElement getParagraph() {
        return paragraph;
    }

    public String text() {
        return paragraph.getText();
    }
}
