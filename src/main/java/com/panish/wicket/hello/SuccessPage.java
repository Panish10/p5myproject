package com.panish.wicket.hello;

import com.panish.wicket.home.Hello;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class SuccessPage extends WebPage {

    public SuccessPage(final PageParameters parameters) {

        String username = "";
        String password = "";
        String address = "";

        add(new Link<Void>("homepage") {
            @Override
            public void onClick() {
                setResponsePage(Hello.class);
            }
        });

        if (parameters.getNamedKeys().contains("username"))
        username = parameters.get("username").toString();
        password = parameters.get("password").toString();
        address = parameters.get("address").toString();

        final Label userName = new Label("userName", username);
        final Label pass = new Label("password", password);
        final Label addr = new Label("address", address);

        add(userName);
        add(pass);
        add(addr);
    }
}
