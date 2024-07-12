package com.chuwa.learn.future.payment;


import java.util.Arrays;
import java.util.List;

import static com.chuwa.learn.future.payment.OrderProcessUtil.*;

public class BatchPayment {
    /**
     * 单线程版本
     * */
    public static void main(String[] args) {
        List<String> orderIds = Arrays.asList("order1","order2","order3");
        for(String orderId: orderIds){
            Order order = queryOrder(orderId);
            boolean paymentResult = makePayment(order);
            sendEmail(order, paymentResult);
        }
    }
}
