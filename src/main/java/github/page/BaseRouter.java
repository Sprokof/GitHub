package github.page;

import github.page.instance.Driver;

public class BaseRouter {

    public SignInPage signInPage() {
        return (SignInPage) PageFactory.page(SignInPage.class);
    }

    public GenerateSSHKeyPage generateSSHKeyPage() {
        return (GenerateSSHKeyPage) PageFactory.page(GenerateSSHKeyPage.class);
    }

    public TokenPage tokenPage() {
        return (TokenPage) PageFactory.page(TokenPage.class);
    }

    public GenerateTokenPage generateTokenPage() {
        return (GenerateTokenPage) PageFactory.page(GenerateTokenPage.class);
    }


    public BaseRouter() {

    }

    public BaseRouter(String url) {
        Driver.getInstance().get(url);
    }


}
