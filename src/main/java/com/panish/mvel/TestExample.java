package com.panish.mvel;

import com.panish.mvel.model.Address;
import com.panish.mvel.model.User;
import org.mvel2.MVEL;

import java.util.*;

public class TestExample {

    public static void main(String[] args) {
        Map<String, Object> context = new HashMap<>();
        context.put("fname", "panish");
        context.put("lname", "pawade");

        String expression = "fname == 'panish' && lname == 'pawade'";

        Boolean result = (Boolean)MVEL.eval(expression, context);
        //System.out.println(result);

        result = (Boolean) MVEL.eval("\"123\" == 123;");
        //System.out.println(result);

        m1();
    }

    public static void m1() {
        Map<String, Object> context = new HashMap<>();
        String expression;
        Boolean result;
        List<Address> addressInfo = Arrays.asList(new Address("street1", "street2"));

        User user = new User("panish", "pawade", addressInfo);
        context.put("user", user);

        expression = "user.fname == 'panish' && user.addressList[0].street1 == 'street2'";
        result = (Boolean) MVEL.eval(expression, context);
        System.out.println(result);

        expression = "user.fname = 'neha'";
        MVEL.eval(expression, context);
        System.out.println(user);

        expression = "user.addressList[0].street1 == 'sff' ? 'hi': 'no'+' '+'way'";
        String stringResult = (String) MVEL.eval(expression, context);
        System.out.println(stringResult);
    }
}
