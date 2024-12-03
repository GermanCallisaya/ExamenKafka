package com.ger.principal.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class EarthquakeResponse {
    private String type;
    private Metadata metadata;
    private List<Feature> features;
    private List<Double> bbox;



    public static class Metadata {
        private Long generated;
        private String url;
        private String title;
        private int status;
        private String api;
        private int count;

    
    }

    public static class Feature {
        private String type;
        private Properties properties;
        private Geometry geometry;
        private String id;

  
    }

    public static class Properties {
        private double mag;
        private String place;
        private Long time;
        private Long updated;
        private String tz;
        private String url;
        private String detail;
        private String felt;
        private String cdi;
        private String mmi;
        private String alert;
        private String status;
        private int tsunami;
        private int sig;
        private String net;
        private String code;
        private String ids;
        private String sources;
        private String types;
        private int nst;
        private Double dmin;
        private Double rms;
        private int gap;
        private String magType;
        private String type;
        private String title;

 
    }

    public static class Geometry {
        private String type;
        private List<Double> coordinates;

        // Getters and setters
    }
}
