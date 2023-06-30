package com.panish.wicket.home;

import com.panish.wicket.ajaxex.AjaxEx;
import com.panish.wicket.fileupload.FileUploadEx;
import com.panish.wicket.form.ValidatorEx;
import com.panish.wicket.hello.UserPage;
import com.panish.wicket.layout.JugTemplate;
import com.panish.wicket.login.LoginForm;
import com.panish.wicket.model.LoginForm2;
import com.panish.wicket.modelsex.ModelsEx;
import com.panish.wicket.repeatingview.RepeatingViewPage;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class Hello extends WebPage {

    private static final long serialVersionUID = 1L;

    public Hello(final PageParameters parameters) {

        Label msg = new Label("message", "Hello World, Wicket");
        /*
        * Modify attribute: add style to label
        * approach 1: label.add(new AttributeModifier("style", "color:red;font-weight:bold"));
        * approach 2: label.add(AttributeModifier.replace("style", "color:red;font-weight:bold"));
        * */

        msg.add(AttributeModifier.replace("style", "color:red;font-weight:bold"));
        msg.setVisible(false);
        // msg.setRenderBodyOnly(true);
        add(msg);

        add(new Link<Void>("show") {
            @Override
            public void onClick() {
                msg.setVisible(true);
            }
        });

        add(new Link<Void>("userpage") {
            @Override
            public void onClick() {
                setResponsePage(UserPage.class);
            }
        });

        add(new Link<Void>("loginForm") {
            @Override
            public void onClick() {
                setResponsePage(LoginForm.class);
            }
        });

        add(new Link<Void>("ajaxEx") {
            @Override
            public void onClick() {
                setResponsePage(AjaxEx.class);
            }
        });

        add(new Link<Void>("modelsEx") {
            @Override
            public void onClick() {
                setResponsePage(ModelsEx.class);
            }
        });

        add(new Link<Void>("loginForm2") {
            @Override
            public void onClick() {
                setResponsePage(LoginForm2.class);
            }
        });

        add(new Link<Void>("formEx") {
            @Override
            public void onClick() {
                setResponsePage(ValidatorEx.class);
            }
        });

        add(new Link<Void>("fileUploadEx") {
            @Override
            public void onClick() {
                setResponsePage(FileUploadEx.class);
            }
        });

        add(new Link<Void>("repeaterViewEx") {
            @Override
            public void onClick() {
                setResponsePage(RepeatingViewPage.class);
            }
        });

        add(new Link<Void>("layout") {
            @Override
            public void onClick() {
                setResponsePage(JugTemplate.class);
            }
        });

        Form<?> form = new Form<Void>("userForm") {
            @Override
            protected void onSubmit() {
                PageParameters pageParameters = new PageParameters();
                setResponsePage(UserPage.class, pageParameters);
            }
        };
        add(form);

        String messagesNumber = "\"New message to read\"";
        WebMarkupContainer informationBox = new WebMarkupContainer("informationBox");
        informationBox.add(new Label("messagesNumber", messagesNumber));

        if (messagesNumber == null)
        informationBox.setVisible(false);

        add(informationBox);

        // onComponentTagBody example
        add(new Label("helloMessage", "Hello World") {

            public void onComponentTagBody(MarkupStream markupStream, ComponentTag tag) {
                if(!isEnabled())
                    replaceComponentTagBody(markupStream, tag, "(the component is disabled)");
                else
                    super.onComponentTagBody(markupStream, tag);
            }
        });

       /* Link loginFormEx = new Link("loginFormEx") {
            @Override
            public void onClick() {
                setResponsePage(JugTemplate.class);
            }
        };
        add(loginFormEx);*/

        //add(new LoginForm("loginForm"));
    }
}
