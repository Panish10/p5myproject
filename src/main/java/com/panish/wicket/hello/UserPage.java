package com.panish.wicket.hello;

import com.panish.wicket.hello.validation.StrongPasswordValidator;
import com.panish.wicket.home.Hello;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.validation.validator.PatternValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserPage extends WebPage {

    private static final long serialVersionUID = 1L;

    // 1 digit, 1 lower, 1 upper, 1 symbol "@#$%", from 6 to 20
    private final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

    // Multiple check box example
    private static final List<String> LANGUAGES = Arrays.asList("Java", ".NET", "PHP", "Ruby", "C/C++");
    private static final List<String> HOSTING_TYPES = Arrays.asList("Shared Host", "VPS", "Clound Host", "Dedicated Server");

    // hold the checkbox values
    private ArrayList<String> languagesSelect = new ArrayList<String>();
    // checked vps and dedicated server by default
    private ArrayList<String> hostingtSelect = new ArrayList<String>(Arrays.asList("VPS", "Dedicated Server"));

    // choices in radio button
    private static final List<String> TYPES = Arrays.asList(new String[] { "Shared Host", "VPS", "Dedicated Server" });
    // variable to hold radio button values
    private String selected = "VPS";

    // single list choice
    private static final List<String> FRUITS = Arrays.asList("Apple", "Orang", "Banana" );
    // Banana is selected by default
    private String selectedFruit = "Banana";

    // Multiple choice list
    private static final List<String> NUMBERS = Arrays.asList("Number 1", "Number 2", "Number 3", "Number 4", "Number 5", "Number 6");
    // Number 6 is selected by default
    private ArrayList<String> selectedNumber = new ArrayList<String>(Arrays.asList(new String[] { "Number 6" }));

    // Dropdown list
    private static final List<String> SEARCH_ENGINES = Arrays.asList("Google", "Bing", "Baidu");
    //make Google selected by default
    private String selectedDropDown = "Google";

    public UserPage(final PageParameters parameters) {

        add(new Link<Void>("homepage") {
            @Override
            public void onClick() {
                setResponsePage(Hello.class);
            }
        });

        // FeedbackPanel will add validation massaged in html page
        add(new FeedbackPanel("feedback"));

        // Text box example
        final TextField<String> username = new TextField<String>("username", Model.of(""));
        username.setRequired(true);
        username.add(new UsernameValidator());

        // Password field example
        final PasswordTextField password = new PasswordTextField("password", Model.of(""));
        //attached custom validator to password field
        password.add(new StrongPasswordValidator());

        //for properties file
        password.setLabel(Model.of("Password"));

        // Password field example (for conform password)
        final PasswordTextField cpassword = new PasswordTextField("cpassword", Model.of(""));

        cpassword.setLabel(Model.of("Confirm Password"));

        password.add(new PatternValidator(PASSWORD_PATTERN));

        // Text area example
        final TextArea address = new TextArea("address", Model.of(""));
        address.setRequired(true);
        address.setLabel(Model.of("Address"));

        // Check box example
        final CheckBox chk0 = new CheckBox("checkbox0", Model.of(Boolean.TRUE));
        final CheckBox chk1 = new CheckBox("checkbox1", Model.of());
        final CheckBox chk2 = new CheckBox("checkbox2", Model.of());

        // Multiple check box example
        final CheckBoxMultipleChoice<String> listLanguages = new CheckBoxMultipleChoice<String>("languages", new Model(languagesSelect), LANGUAGES);
        final CheckBoxMultipleChoice<String> listHosting = new CheckBoxMultipleChoice<String>("hostings", new Model(hostingtSelect), HOSTING_TYPES);

        // Radio button example
        RadioChoice<String> hostingType = new RadioChoice<String>("hosting", new PropertyModel<String>(this, "selected"), TYPES);

        // single select listbox example
        ListChoice<String> listFruits = new ListChoice<String>("fruit", new PropertyModel<String>(this, "selectedFruit"), FRUITS);
        listFruits.setMaxRows(5);

        // multiple choice example
        ListMultipleChoice<String> listNumbers = new ListMultipleChoice<String>("number", new Model(selectedNumber), NUMBERS);
        listNumbers.setMaxRows(5);

        // drop down list
        DropDownChoice<String> listSites = new DropDownChoice<String>("sites", new PropertyModel<String>(this, "selectedDropDown"), SEARCH_ENGINES);

        Form<?> form = new Form<Void>("userForm") {
            @Override
            protected void onSubmit() {
                // get the entered value in form and pass to next page
                PageParameters pageParameters = new PageParameters();
                pageParameters.add("username", username.getModelObject());
                pageParameters.add("password", password.getModelObject());
                pageParameters.add("address", address.getModelObject());
                setResponsePage(SuccessPage.class, pageParameters);
            }
        };

        // add form component
        add(form);

        // add all field to form to show on html page
        form.add(username);
        form.add(password);
        form.add(cpassword);
        //form.add(new EqualPasswordInputValidator(password, cpassword));
        form.add(address);
        form.add(chk0);
        form.add(chk1);
        form.add(chk2);
        form.add(listLanguages);
        form.add(listHosting);
        form.add(hostingType);
        form.add(listFruits);
        form.add(listNumbers);
        form.add(listSites);
    }
}
