package com.praynow.praynow.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Data
class DaySchedule {
    @Schema(example = "2026-03-22")
    private String date;
    @Schema(example = "Sunday")
    private String day;
    @Schema(example = "06:00")
    private String fajr;
    @Schema(example = "01:30")
    private String dhuhr;
    @Schema(example = "06:45")
    private String asr;
    @Schema(example = "07:30")
    private String maghrib;
    @Schema(example = "09:00")
    private String isha;
}

@Data
class Location  {
    @Schema(example = "47.6675")
    private double lat;
    @Schema(example = "-122.0983")
    private double lng;
    @Schema(example = "18080 NE 68th St, Redmond, WA 98052")
    private String address;
}

@Data
@Document(collection = "masjids")
public class Masjid {
    @Id
    @Schema(example = "MongoDB Id")
    private String id;
    @Schema(example = "icor")
    private String masjidId;
    @Schema(example = "Islamic Center of Redmond")
    private String masjidName;
    @Schema(example = "Redmond")
    private String city;
    @Schema(example = "WA")
    private String state;
    @Schema(example = "2026")
    private int year;
    private Location location;
    @Schema(example = "3")
    private int month;
    private List<DaySchedule> days;
}
