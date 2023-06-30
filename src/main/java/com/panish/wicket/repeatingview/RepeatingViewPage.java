package com.panish.wicket.repeatingview;

import com.panish.wicket.home.Hello;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class RepeatingViewPage extends WebPage {

    public RepeatingViewPage(PageParameters parameters) {
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
        // ========== Repeated View Example ==========
        RepeatingView view = new RepeatingView("repeater");
        view.add(new Label(view.newChildId(), "hello"));
        view.add(new Label(view.newChildId(), "goodbye"));
        view.add(new Label(view.newChildId(), "good morning"));
        add(view);
    }
}
