package github;


import github.gui.NoticeWindow;
import github.page.BaseRouter;
import github.util.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class GenerateTokenApplication {

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) throws InterruptedException, IOException {
        while (true) {
            BaseRouter baseRouter = new BaseRouter(GitHubJobUtil.START_URL);

            baseRouter
                    .signInPage().email.fill(PropertiesUtil.get(GitHubJobUtil.EMAIL_KEY))
                    .signInPage().password.fill(PropertiesUtil.get(GitHubJobUtil.PASSWORD_KEY))
                    .signInPage().signInBtn.click()

                    .generateSSHKeyPage().dontAskBtn.click();

            String tokenDesc = baseRouter.tokenPage().tokenDescription.text();
            LocalDate expiryDate = DateUtil.parse(baseRouter.tokenPage().tokenExpiry.text());
            if (tokenDesc.contains(GitHubJobUtil.TOKEN_PREFIX) && GitHubJobUtil.tokenExpired(expiryDate)) {

           baseRouter
                    .tokenPage().selectTokenBtn.click()
                    .tokenPage().tokenVariants.select(GitHubJobUtil.CLASSIC_TOKEN_INDEX);

           SeleniumUtil.waitVisible();

           String token = baseRouter
                    .generateTokenPage().tokenNote.fill(GitHubJobUtil.generateTokenNote())
                    .generateTokenPage().openExpiryTermButton.click()
                    .generateTokenPage().expiryTerm.select(GitHubJobUtil.EXPIRATION_OPTION_INDEX)
                    .generateTokenPage().scopes.check(GitHubJobUtil.DEFAULT_SCOPE_INDEX)
                    .generateTokenPage().generateButton.click()

                    .tokenPage().generated().newToken.text();

                String link = GitHubJobUtil.getAccessLink(token);
                NoticeWindow window = new NoticeWindow(link);
                window.open();
                File fileToWrite = FileUtil.createOrGetFile(PropertiesUtil.get(FileUtil.FILE_PATH_KEY),
                        PropertiesUtil.get(FileUtil.FILE_NAME_KEY));
                FileUtil.writeToFile(fileToWrite, link);
            }
            SeleniumUtil.driverClose();
            GitHubJobUtil.waitDay();
        }
    }

}