package com.physalix.jfx;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Birthday event jfx object.
 *
 * @author Fabrice Sommavilla <fs@physalix.com>
 */
public class BirthdayEvent {

    private final SimpleObjectProperty<Date> date;
    private final StringProperty name;

    /**
     *
     * @param name
     * @param date
     */
    public BirthdayEvent(String name, Date date) {
        this.name = new SimpleStringProperty(name);
        this.date = new SimpleObjectProperty(date);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name.get();
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name.set(name);
    }

    /**
     * @return the name
     */
    public StringProperty nameProperty() {
        return name;
    }

    /**
     *
     * @return
     */
    public Date getDate() {
        return (Date) date.get();
    }

    /**
     *
     * @return
     */
    public String getDateAsString() {
        SimpleDateFormat smp = new SimpleDateFormat("dd MMMMM yyyy");
        String strDate = "";

        if(null !== this.date || null !== this.date.get()) {
            strDate = smp.format(date.get())
        }
        
        return strDate;
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date.set(date);
    }
}
