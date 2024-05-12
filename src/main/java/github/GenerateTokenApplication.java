package github;


import github.gui.NoticeWindow;
import github.job.GitHubJob;
import github.util.FileUtil;
import github.util.GitHubJobUtil;
import github.util.PropertiesUtil;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;

public class GenerateTokenApplication {

    static {
        System.setProperty("webdriver.edge.driver",
                System.getProperty("user.dir") + "/src/main/resources/msedgedriver.exe");
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) throws InterruptedException, IOException {
        GitHubJob job = new GitHubJob();
        while (true) {
            boolean expired = job.init(EdgeDriver.class).getPage().tokenExpired();
            if (expired) {
                String token = job.generateTokenPage().generateToken();
                String accessLink = GitHubJobUtil.getAccessLink(token);
                File file = FileUtil.createOrGetFile(
                        PropertiesUtil.get(FileUtil.FILE_PATH_KEY),
                        PropertiesUtil.get(FileUtil.FILE_NAME_KEY)
                );
                FileUtil.writeToFile(file, accessLink);
                NoticeWindow window = new NoticeWindow(accessLink);
                window.open();

            }
            job.close();
        }
    }
}