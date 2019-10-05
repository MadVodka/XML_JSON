package ivan.vatlin.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

import static ivan.vatlin.xml.XmlDataHolder.DATE_TIME_FORMATTER;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    public LocalDate unmarshal(String date) {
        return LocalDate.parse(date, DATE_TIME_FORMATTER);
    }

    public String marshal(LocalDate date) {
        return date.format(DATE_TIME_FORMATTER);
    }
}
