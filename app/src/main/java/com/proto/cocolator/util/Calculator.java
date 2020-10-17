package com.proto.cocolator.util;

import android.annotation.SuppressLint;

public class Calculator {
    String ribbon1;
    String ribbon2;
    String ribbon3;
    String ribbon4;
    String ribbon5;
    String ribbon6;

    public Calculator(String ribbon1, String ribbon2, String ribbon3, String ribbon4) {
        this.ribbon1 = ribbon1;
        this.ribbon2 = ribbon2;
        this.ribbon3 = ribbon3;
        this.ribbon4 = ribbon4;
    }

    public Calculator(String ribbon1, String ribbon2, String ribbon3, String ribbon4, String ribbon5, String ribbon6) {
        this.ribbon1 = ribbon1;
        this.ribbon2 = ribbon2;
        this.ribbon3 = ribbon3;
        this.ribbon4 = ribbon4;
        this.ribbon5 = ribbon5;
        this.ribbon6 = ribbon6;
    }

    public Calculator(String ribbon1, String ribbon2, String ribbon3, String ribbon4, String ribbon5) {
        this.ribbon1 = ribbon1;
        this.ribbon2 = ribbon2;
        this.ribbon3 = ribbon3;
        this.ribbon4 = ribbon4;
        this.ribbon5 = ribbon5;
    }

    public String getResult4() {
        String val = ribbon1 + ribbon2;
        int multiplier = Integer.parseInt(ribbon3);
        return getResistance(Long.parseLong(String.valueOf(Integer.parseInt(val) * (int) Math.pow(10, multiplier)))) + " " + getTolerance(ribbon4);
    }


    public String getResult5() {
        String val = ribbon1 + ribbon2 + ribbon3;
        int multiplier = Integer.parseInt(ribbon4);
        return getResistance(Long.parseLong(String.valueOf(Integer.parseInt(val) * (int) Math.pow(10, multiplier)))) + " " + getTolerance(ribbon5);
    }

    public String getResult6() {
        String val = ribbon1 + ribbon2 + ribbon3;
        int multiplier = Integer.parseInt(ribbon4);
        return getResistance(Long.parseLong(String.valueOf(Integer.parseInt(val) * (int) Math.pow(10, multiplier)))) + " " + getTolerance(ribbon5) + " " + getCoefficient(ribbon6);
    }

    @SuppressLint("DefaultLocale")
    public String getResistance(long res) {
        if (res < 1000) {
            return res + " Ohm";
        } else if (res >= 1000 && res < 1000000) {
            return String.format("%.1f", res / 1000.0) + " kOhm";
        } else if (res >= 1000000 && res < 1000000000) {
            return String.format("%.1f", res / 1000000.0) + " MOhm";
        } else if (res >= 1000000000) {
            return String.format("%.1f", res / 1000000000.0) + " GOhm";
        }
        return "Invalid";
    }

    private String getTolerance(String tolerance_code) {
        String tolerance = " ";
        switch (tolerance_code) {
            case "1": //brown
                tolerance = "1%";
                break;
            case "2": //red
                tolerance = "2%";
                break;
            case "3": //orange
                tolerance = "3%";
                break;
            case "4": //yellow
                tolerance = "4%";
                break;
            case "5": //green
                tolerance = "0.5%";
                break;
            case "6": //blue
                tolerance = "0.25%";
                break;
            case "7": //purple
                tolerance = "0.1%";
                break;
            case "8": //gray
                tolerance = "0.05%";
                break;
            case "11": //gold
                tolerance = "5%";
                break;
            case "10": //silver
                tolerance = "10%";
                break;
            default:
                return " ";

        }
        return tolerance;
    }

    private String getCoefficient(String sixth_band) {
        String coefficient = " ";
        switch (sixth_band) {
            case "1": // black
                coefficient = "100";
                break;
            case "2": // red
                coefficient = "50";
                break;
            case "3": // orange
                coefficient = "15";
                break;
            case "4": // yellow
                coefficient = "25";
                break;
            case "6": // blue
                coefficient = "10";
                break;
            case "7": //purple
                coefficient = "5";
                break;
            default:
                return " ";
        }
        return coefficient + " ppm/deg C";
    }
}
