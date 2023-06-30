package com.panish.wicket;

import com.panish.wicket.home.Hello;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class MyApplication extends WebApplication {
    @Override
    public Class<? extends Page> getHomePage() {
        return Hello.class;
    }
}
