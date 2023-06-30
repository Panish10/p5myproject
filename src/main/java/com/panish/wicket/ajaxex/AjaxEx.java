package com.panish.wicket.ajaxex;

import com.panish.wicket.home.Hello;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class AjaxEx extends WebPage {

    public AjaxEx(PageParameters parameters) {
        super(parameters);

        add(new Link<Void>("homepage") {
            @Override
            public void onClick() {
                setResponsePage(Hello.class);
            }
        });

        String first = "Initial value.";
        String second = "Another value 4 label.";
        final Label label = new Label("labelComponent", first);
        //autogenerate a markup id
        label.setOutputMarkupId(true);
        label.add(AttributeModifier.replace("style", "color:red"));
        add(label);
        //...

        final Label hiddenLabel = new Label("hiddenLabel", "Hidden Label");
        //make label invisible
        hiddenLabel.setVisible(false);
        //ensure that label will leave a placeholder for its markup id
        hiddenLabel.setOutputMarkupPlaceholderTag(true);
        add(hiddenLabel);

        add(new AjaxLink("ajaxLink"){
            @Override
            public void onClick(AjaxRequestTarget target) {

                String current = label.getDefaultModel().getObject().toString();

                if(current.equals(first)){
                    current = second;
                    label.add(AttributeModifier.replace("style", "color:green"));
                } else {
                    current = first;
                    label.add(AttributeModifier.replace("style", "color:red"));
                }

                //modify the model of a label and refresh it on client side
                label.setDefaultModelObject(current);

                target.add(label);
                target.appendJavaScript(";alert('Hello!!');");

                hiddenLabel.setVisible(true);
                target.add(hiddenLabel);
            }
        });
    }
}
