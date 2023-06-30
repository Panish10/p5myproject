package com.panish.wicket.login;

import com.panish.wicket.home.Hello;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class LoginForm extends WebPage {

    private TextField usernameField;
    private PasswordTextField passwordField;
    private Label loginStatus;

    public LoginForm(final PageParameters parameters) {
        super(parameters);

        // =================================================================================================
        // ========== Home page Link ==========
        add(new Link<Void>("homepage") {
            @Override
            public void onClick() {
                setResponsePage(Hello.class);
            }
        });

        usernameField = new TextField("username", Model.of(""));
        passwordField = new PasswordTextField("password", Model.of(""));
        // by default setRequired is true for password field
        passwordField.setRequired(false);
        loginStatus = new Label("loginStatus", Model.of(""));

        Form<?> form = new Form<Void>("loginForm") {

            public final void onSubmit() {
                String username = (String)usernameField.getDefaultModelObject();
                String password = (String)passwordField.getDefaultModelObject();

                if(username != null && username.equals("panish") && password != null && password.equals("panish"))
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
