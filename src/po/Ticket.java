package po;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Vigo on 16/3/30.
 */
public class Ticket {

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 有效期，按照天数计算
     */
    private int validDays;

    /**
     * 失效时间
     */
    private Date expireTime;

    private User user;


    public Ticket(Date createTime, int validDays, User user) {
        this.createTime = createTime;
        this.validDays = validDays;
        this.expireTime = setExpireTime();
        this.user = user;
    }

    /**
     * 设置过期时间
     * @return
     */
    private Date setExpireTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(createTime);
        calendar.add(calendar.DATE, validDays);
        return calendar.getTime();
    }


    public User getUser() {
        return user;
    }

    /**
     * 判断ticket是否失效
     * @return 失效返回true
     */
    public boolean isInvalid(){
        boolean flag = false;// 有效
        Date now = new Date();
        if (expireTime.compareTo(now) <= 0){
            flag = true;
            System.out.println("-------ticket失效-----");
        }
        return flag;
    }

    public static void main(String[] args) {
//        Date currentTime = new Date();// 当前时间
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String nowtime = formatter.format(currentTime);
//        System.out.println("now:"  + nowtime);
//
//        Calendar now = Calendar.getInstance();
//        now.setTime(currentTime);
//        now.add(now.DATE, 1);
//        Date end = now.getTime();
//        System.out.println("end :" +  formatter.format(end));
//        if (end.compareTo(currentTime) <= 0){
//            System.out.println("过期");
//        }else {
//            System.out.println("不过期");
//        }



    }
}
