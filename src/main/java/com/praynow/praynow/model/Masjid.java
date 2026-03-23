package com.praynow.praynow.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
    class DaySchedule {
        private String date;
        private String day;
        private String fajr;
        private String dhuhr;
        private String asr;
        private String maghrib;
        private String isha;
    }

@Data
@Document(collection = "masjids")
public class Masjid {
    @Id
    private String id;
    private String masjidId;
    private String masjidName;
    private String city;
    private String state;
    private int year;
    private int month;
    private List<DaySchedule> days;
}
