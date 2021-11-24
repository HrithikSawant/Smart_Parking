package api;
import java.util.Random;

public class Generator {

    public static int OTP() {
        Random random = new Random();
        String id = String.format("%04d", random.nextInt(10000));
        int otp = Integer.parseInt(id);
        return otp;
    }

    public static void main(String[] args) {
//        Dao d = new Dao();
//        boolean f = d.CheckEmailIdofUser("hrithiksawant@gmail.com");
//        boolean s = d.StoreToken("hrithiksawant80@gmail.com",1243);
//        System.out.println(f);
        for (int i = 0; i < 10; i++) {
            int o = OTP();
            System.out.println(o);
        }

    }
}
