package org.example.web3.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ManagedBean(name = "clockBean")
@SessionScoped
public class ClockBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy");

    public String getCurrentTime() {
        return LocalDateTime.now().format(formatter);
    }
}
