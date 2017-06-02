package hire.morgan.scheduler;

import hire.morgan.controllers.FBFeedController;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by morgan.shepherd
 */
@EnableScheduling
@Component
public class Jobs {

    private FBFeedController fbFeedController;

    //runs an update every 5 minutes to check fb
    @Scheduled(cron = "0 0/1 * * * *")
    public void updateCouchDB() {
        if(fbFeedController == null ) {
            fbFeedController = new FBFeedController();
        }
        fbFeedController.facebookRun();

    }
}
