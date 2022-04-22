package com.example.shopjava.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "watches")
public class Watch extends Product{

    @Column(nullable = false)
    private String series;

    @Column(nullable = false)
    private String purpose;

    @Column(nullable = false)
    private String display_shape;

    @Column(nullable = false)
    private Boolean touch_screen;

    @Column(nullable = false)
    private Boolean waterproof;

    @Column(nullable = false)
    private Boolean call_support;

    @Column(nullable = false)
    private Boolean music_control;

    @Column(nullable = false)
    private Boolean pulse_measurement;

    @Column(nullable = false)
    private Boolean step_counting;

    @Column(nullable = false)
    private Boolean sleep_monitoring;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private Boolean working_hours;

    @Column(nullable = false)
    private String display_diagonal;

    public Watch(){}

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getDisplay_shape() {
        return display_shape;
    }

    public void setDisplay_shape(String display_shape) {
        this.display_shape = display_shape;
    }

    public Boolean getTouch_screen() {
        return touch_screen;
    }

    public void setTouch_screen(Boolean touch_screen) {
        this.touch_screen = touch_screen;
    }

    public Boolean getWaterproof() {
        return waterproof;
    }

    public void setWaterproof(Boolean waterproof) {
        this.waterproof = waterproof;
    }

    public Boolean getCall_support() {
        return call_support;
    }

    public void setCall_support(Boolean call_support) {
        this.call_support = call_support;
    }

    public Boolean getMusic_control() {
        return music_control;
    }

    public void setMusic_control(Boolean music_control) {
        this.music_control = music_control;
    }

    public Boolean getPulse_measurement() {
        return pulse_measurement;
    }

    public void setPulse_measurement(Boolean pulse_measurement) {
        this.pulse_measurement = pulse_measurement;
    }

    public Boolean getStep_counting() {
        return step_counting;
    }

    public void setStep_counting(Boolean step_counting) {
        this.step_counting = step_counting;
    }

    public Boolean getSleep_monitoring() {
        return sleep_monitoring;
    }

    public void setSleep_monitoring(Boolean sleep_monitoring) {
        this.sleep_monitoring = sleep_monitoring;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getWorking_hours() {
        return working_hours;
    }

    public void setWorking_hours(Boolean working_hours) {
        this.working_hours = working_hours;
    }

    public String getDisplay_diagonal() {
        return display_diagonal;
    }

    public void setDisplay_diagonal(String display_diagonal) {
        this.display_diagonal = display_diagonal;
    }
}
