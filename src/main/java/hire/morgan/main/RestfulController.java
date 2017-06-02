package hire.morgan.main;

import hire.morgan.constants.Constants;
import hire.morgan.controllers.FBFeedController;
import hire.morgan.entity.ResponseObj;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by morgan.shepherd
 */

@RestController
public class RestfulController {



    @RequestMapping(value = "/data", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<ResponseObj> getData()
    {
        FBFeedController fbFeedController = new FBFeedController();
        return new ResponseEntity<>(fbFeedController.getJasonData(), HttpStatus.OK);
    }

    @RequestMapping(value = "/sqlStatements", method = RequestMethod.GET)
    @ResponseBody
    public String sqlStatements() {
        return Constants.SQL;
    }

}