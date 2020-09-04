package Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeStamp {
    public String timeStamp(){
        String time  = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        return time;
    }
}
