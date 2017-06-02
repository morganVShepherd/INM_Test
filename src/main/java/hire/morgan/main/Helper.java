package hire.morgan.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by morgan.shepherd
 */
public class Helper {

    static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public static Date convertDateFromString(String date) throws Exception{
        return formatter.parse(date);
    }

    public static String convertStringFromDate(Date date){
        return formatter.format(date);
    }

    public static Date getYesterday(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -1);
        Date yesterday = cal.getTime();
        return yesterday;
    }
}
