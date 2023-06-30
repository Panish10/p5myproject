package com.panish.wicket.modelsex;

import com.panish.wicket.home.Hello;
import com.panish.wicket.model.DB;
import com.panish.wicket.model.Person;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ModelsEx extends WebPage {

    public ModelsEx(PageParameters parameters) {
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
        // ========== Model Example ==========
        // model example
        add(new Label("helloMessage1", new Model<>("Model Example 1")));

        // model example using Factory method
        add(new Label("helloMessage2", Model.of("Model Example 2 using factory method")));

        // =================================================================================================
        // ========== Custom Model Example ==========
        // Custom model example
        IModel timeStampModel = new Model<String>() {
            @Override
            public String getObject() {
                return new Date().toString();
            }
        };

        add(new Label("timeStamp", timeStampModel));

        // model with JavaBesns/POJO
        Person person = DB.getPerson();
        add(new Label("name1", new Model(person.getName())));

        // =================================================================================================
        // ========== Property Model Example ==========
        // Property Model example
        add(new Label("name2", new PropertyModel<>(person, "name")));
        add(new Label("spouseName1", new PropertyModel(person, "spouse.name")));
        add(new Label("child1", new PropertyModel(person, "children.0.name")));
        add(new Label("child2", new PropertyModel(person, "children[0].name")));

        // =================================================================================================
        // ========== Compound Property Model Example ==========

        //set CompoundPropertyModel as model for the container of the label
        setDefaultModel(new CompoundPropertyModel<>(person));
        /*
        *
        * no need to set CompoundPropertyModel for every label as PropertyModel
        * also id of the label is equal to the property expression
        * */
        add(new Label("name"));
        add(new Label("spouse.name"));
        add(new Label("children[0].name"));

        // =================================================================================================
        // ========== Component DropDownChoice ==========
        List<String> fruits = Arrays.asList("apple", "strawberry", "watermelon");

        Form<?> form = new Form<Void>("form"){
            protected void onSubmit() {
            }
        };
        form.add(new DropDownChoice<>("fruits", new Model(), fruits));
        add(form);
    }
}
