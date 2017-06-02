package hire.morgan.controllers;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;

/**
 * Created by morgan.shepherd
 */
public class FBConnectController {
    private Facebook facebook;

    public FBConnectController(String appId, String appSecret, String accessToken){

        ConfigurationBuilder confBuilder = new ConfigurationBuilder();
        confBuilder.setDebugEnabled(true);
        confBuilder.setOAuthAppId(appId);
        confBuilder.setOAuthAppSecret(appSecret);
        confBuilder.setOAuthAccessToken(accessToken);
        confBuilder.setOAuthPermissions("email,publish_stream, id, name, first_name, last_name, generic");
        confBuilder.setUseSSL(true);
        confBuilder.setJSONStoreEnabled(true);
        Configuration configuration = confBuilder.build();
        FacebookFactory ff = new FacebookFactory(configuration);
        facebook = ff.getInstance();
    }

    public Facebook getFacebook() {
        return facebook;
    }

    public void setFacebook(Facebook facebook) {
        this.facebook = facebook;
    }

}
