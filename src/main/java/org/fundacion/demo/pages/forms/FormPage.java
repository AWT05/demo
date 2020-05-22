package org.fundacion.demo.pages.forms;

import java.util.Map;

public class FormPage {
    private final Map<FieldsEnum, IFiller> form;

    public FormPage(Map<FieldsEnum, IFiller> form) {
        this.form = form;
    }

    public void fillForm(final Map<String, String> data) {
        for (Map.Entry<String, String> entry: data.entrySet()) {
            try {
                FieldsEnum fieldKey = FieldsEnum.valueOf(entry.getKey().toUpperCase());
                IFiller field = form.get(fieldKey);
                field.fill(entry.getValue());
            }
            catch (IllegalArgumentException ex) {
                // To do throw a custom exception
                String message = String.format("Error: <%s> is not a valid field. ", entry.getKey());
                throw new IllegalArgumentException(message.concat(ex.getMessage()));
            }
        }
    }
}
