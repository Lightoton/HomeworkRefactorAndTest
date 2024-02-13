package Test1;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtils {
//    public static void main(String[] args) {
//        System.out.println(formatDateForDisplayNew(new Date(System.currentTimeMillis()), new SimpleDateFormat("dd/MM" +
//                "/yyyy")));
//    }
    public static String formatDateForDisplay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }
    
    public static String formatTimeForDisplay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(date);
    }
    

    public static String formatDateTimeForDisplay(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(date);
    }
    //Решил что можно сразу формат передать чтобы не плодить методы
    public String formatDateForDisplayNew(Date date, SimpleDateFormat sdf){
        return sdf.format(date);
    }
}