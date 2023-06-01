package Model;

import java.time.LocalDate;

public class Model {

    private LocalDate localDate;
    private String description;

    public LocalDate getLocalDate() {
        return localDate;
    }
    public String getDescription() {
        return description;
    }

    public Model(LocalDate localDate, String description) {
        this.localDate = localDate;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Gorev Zamanı: " + localDate + " Göreviniz: " + description;
    }
}
