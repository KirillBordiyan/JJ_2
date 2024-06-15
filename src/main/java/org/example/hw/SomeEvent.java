package org.example.hw;

import org.example.hw.annotation.RandomDate;

import java.time.LocalDate;
import java.util.Date;

public class SomeEvent {
    @RandomDate//для проверки, что сюда не запишет
    private String name;
    @RandomDate
    private Date date;

    @RandomDate
    private LocalDate localDateLondon;
    @RandomDate(zone = "Europe/Moscow")
    private LocalDate localDateMoscow;

    public SomeEvent() {
        this.name = "some name";
    }

    @Override
    public String toString() {
        return "SomeEvent{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", localDateLondon=" + localDateLondon +
                ", localDateMoscow=" + localDateMoscow +
                '}';
    }
}
