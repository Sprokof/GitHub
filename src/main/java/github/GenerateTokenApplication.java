package github;


import github.gui.NoticeWindow;
import github.job.GitHubJob;
import org.openqa.selenium.edge.EdgeOptions;

public class GenerateTokenApplication {

    static {
        System.setProperty("webdriver.edge.driver",
                System.getProperty("user.dir") + "/src/main/resources/msedgedriver.exe");
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) throws InterruptedException {
        GitHubJob job = new GitHubJob(new EdgeOptions());
        while (true) {
            boolean expired = job.getPage().tokenExpired();
            if (!expired) {
                job.exit();
            } else {
                String token = job.generateTokenPage().generateToken();
                NoticeWindow window = new NoticeWindow(token);
                window.open();
                job.exit();
            }
        }
    }
}