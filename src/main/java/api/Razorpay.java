package api;

import com.mycompany.smartparkingmanagement.entities.OrderBean;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import org.json.JSONObject;

public class Razorpay {

    public static int receipt_Generator(int receipt) {
        int receipt_increment = receipt;
        receipt_increment++;
        return receipt_increment;
    }

    public static Order fetch_Payment(String id) throws RazorpayException{
        RazorpayClient client = new RazorpayClient("", "");
        Order order = client.Orders.fetch(id);
        return order;
    }
    
    public static Order Generate_Order(double amt, int receipt) throws RazorpayException {
        RazorpayClient client = new RazorpayClient("", "");
        JSONObject ob = new JSONObject();
        String receiptNo = Integer.toString(receipt);
        double amount = amt * 100;
        ob.put("amount", amount);
        ob.put("currency", "INR");
        ob.put("receipt", receiptNo);

        //creating new order
        Order order = client.Orders.create(ob);

        System.out.println(order);
        String id = order.get("id");

        System.out.println(id);
        String currency = order.get("currency");

        System.out.println(currency);
        //if you want you can save it to db
         
        return order;
    }

    public String getOrderId(Order order) {
        String orderId = order.get("id");
        return orderId;
    }

    public static void main(String args[]) throws RazorpayException {
        int receipt = receipt_Generator(13);
        Order order = Generate_Order(50, receipt);

        OrderBean orderBean = new OrderBean();
        orderBean.setId((String) order.get("id"));
        System.out.println(order);
        
        //fetching order
        Order orders = fetch_Payment("order_I2nfseG88ARLHc");
        System.out.println(order);

    }

}
