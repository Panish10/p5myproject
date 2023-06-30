package com.panish.wicket.fileupload;

import com.panish.wicket.home.Hello;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.file.File;
import org.apache.wicket.util.lang.Bytes;

import java.io.IOException;

public class FileUploadEx extends WebPage {

    private FileUploadField fileUploadField;

    public FileUploadEx(final PageParameters parameters) {
        fileUploadField = new FileUploadField("fileUploadField");

        add(new Link<Void>("homepage") {
            @Override
            public void onClick() {
                setResponsePage(Hello.class);
            }
        });

        Form form = new Form("form") {
            protected void onSubmit() {
                super.onSubmit();

                FileUpload fileUpload = fileUploadField.getFileUpload();

                try {
                    String filePath = "D:\\Panish\\temp\\" + fileUpload.getClientFileName();
                    File file = new File(filePath);
                    fileUpload.writeTo(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        // Enable multipart mode calling MultiPart(true)
        form.setMultiPart(true);

        // Set a limit for uploaded file's size
        form.setMaxSize(Bytes.kilobytes(100));
        form.add(fileUploadField);
        add(new FeedbackPanel("feedbackPanel"));
        add(form);
    }
}
