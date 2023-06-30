package com.panish.wicket.model;

import com.panish.wicket.home.Hello;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class LoginForm2 extends WebPage {

    private TextField usernameField;
    private PasswordTextField passwordField;
    private Label loginStatus;

    public LoginForm2(PageParameters parameters) {
        super(parameters);

        // =================================================================================================
        // ========== Home page Link ==========
        add(new Link<Void>("homepage") {
            @Override
            public void onClick() {
                setResponsePage(Hello.class);
            }
        });

        // =================================================================================================
        // ========== Login Form using Compound Property Model ==========

        User user = new User();
        setDefaultModel(new CompoundPropertyModel<>(user));
        usernameField = new TextField("username");
        passwordField = new PasswordTextField("password");
        loginStatus = new Label("loginStatus");

        Form<?> form = new Form<Void>("loginForm") {

            public final void onSubmit() {
                String username = (String)usernameField.getDefaultModelObject();
                String password = (String)passwordField.getDefaultModelObject();

                if(username != null && username.equals("test") && password != null && password.equals("test"))
                    loginStatus.setDefaultModelObject("Congratulations!");
                else
                    loginStatus.setDefaultModelObject("Wrong username or password!");
            }
        };

        form.add(usernameField);
        form.add(passwordField);
        form.add(loginStatus);

        add(form);
    }
}
