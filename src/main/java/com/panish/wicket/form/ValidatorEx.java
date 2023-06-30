package com.panish.wicket.form;

import com.panish.wicket.form.validator.UsernameValidator;
import com.panish.wicket.home.Hello;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.validation.validator.EmailAddressValidator;
import org.apache.wicket.validation.validator.UrlValidator;

public class ValidatorEx extends WebPage {

    public ValidatorEx(PageParameters parameters) {
        super(parameters);

        add(new Link<Void>("homepage") {
            @Override
            public void onClick() {
                setResponsePage(Hello.class);
            }
        });

        add(new FeedbackPanel("feedbackPanel"));

        TextField email = new TextField("email", Model.of());
        email.setRequired(true);
        email.add(EmailAddressValidator.getInstance());

        TextField url = new TextField("url", Model.of());
        url.add(new UrlValidator());

        TextField userName = new TextField("userName", Model.of(""));
        userName.add(new UsernameValidator());

        // Input value conversion
        TextField integerField = (TextField) new TextField("integerField", Model.of()).setType(Integer.class);

        Form<?> form = new Form<Void>("form") {
        };

        form.add(email);
        form.add(url);
        form.add(userName);
        form.add(integerField);
        add(form);
    }
}
