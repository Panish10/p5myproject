package com.panish.wicket.layout;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class JugTemplate extends WebPage {

    public static final String CONTENT_ID = "contentComponent";
    private Component headerPanel;
    private Component menuPanel;
    private Component footerPanel;

    public JugTemplate() {
        add(headerPanel = new HeaderPanel("headerPanel"));
        add(menuPanel = new HeaderPanel("menuPanel"));
        add(footerPanel = new HeaderPanel("footerPanel"));
        add(new Label(CONTENT_ID, "Put your content here"));
    }

    public Component getHeaderPanel() {
        return headerPanel;
    }

    public Component getMenuPanel() {
        return menuPanel;
    }

    public Component getFooterPanel() {
        return footerPanel;
    }
}
