package com.panish.mvel;

import org.mvel2.MVEL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListMapArrayEx {

    public static void main(String[] args) {

        // ========== List example ==========
        String expression = "[\"Jim\", \"Bob\", \"Smith\"]";

        List<String> nameList = (List)MVEL.eval(expression);
        System.out.println(nameList);

        // ========== Map example ==========
        expression = "[\"Foo\" : \"Bar\", \"Bar\" : \"Foo\"]";
        Map<String, String> nameMap = (Map)MVEL.eval(expression);
        System.out.println(nameMap);

        // ========== Array example ==========
        expression = "{\"Jim\", \"Bob\", \"Smith\"}";
        Object[] nameArray =  (Object[]) MVEL.eval(expression);
        System.out.println(nameArray[0]);

        MvelUtil mvelUtil = new MvelUtil();
        mvelUtil.someMethod();

        expression = "mvelUtil.someMethod()";
        MVEL.eval(expression);
    }


}
