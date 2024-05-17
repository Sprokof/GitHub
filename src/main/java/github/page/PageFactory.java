package github.page;

public class PageFactory {

    public static BasePage page(Class<? extends BasePage> pageClass) {
        if (pageClass.equals(SignInPage.class)){
            return new SignInPage();
        } else if (pageClass.equals(TokenPage.class)) {
            return new TokenPage();
        } else if (pageClass.equals(GenerateTokenPage.class)) {
            return new GenerateTokenPage();
        }
        return null;
    }
}
