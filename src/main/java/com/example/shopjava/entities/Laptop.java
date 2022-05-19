package com.example.shopjava.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "laptops")
public class Laptop extends Product {

    @Column(nullable = false)
    private String device_type;

    @Column(nullable = false)
    private String sc_diagonal;

    @Column(nullable = false)
    private String processor_manufacturer;

    @Column(nullable = false)
    private Integer cores;

    @Column(nullable = false)
    private String processor_series;

    @Column(nullable = false)
    private Integer RAM;

    @Column(nullable = false)
    private String drive_type;

    private String discrete_graphics;

    @Column(nullable = false)
    private String series;

    @Column(nullable = false)
    private String inst_os;

    @Column(nullable = false)
    private Integer storage;

    @Column(nullable = false)
    private Integer screen_refresh;

    private String matrix_type;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private Integer video_size;

    private String optical_drive;

    private String sc_resolution;

    @Column(nullable = false)
    private Float weight;

    private Boolean touch_screen;

    public Laptop() {
    }

    public Laptop(String image, String name, Float price, String brand, String payment, Float rating, Integer discount,
                  String gifts, Boolean isAvailable, Integer warranty, Date addedAt, Integer sold, Category category,
                  String device_type, String sc_diagonal, String processor_manufacturer, Integer cores, String processor_series,
                  Integer RAM, String drive_type, String discrete_graphics, String series, String inst_os, Integer storage,
                  Integer screen_refresh, String matrix_type, String color, Integer video_size, String optical_drive,
                  String sc_resolution, Float weight, Boolean touch_screen) {
        super(image, name, price, brand, payment, rating, discount, gifts, isAvailable, warranty, addedAt, sold, category);
        this.device_type = device_type;
        this.sc_diagonal = sc_diagonal;
        this.processor_manufacturer = processor_manufacturer;
        this.cores = cores;
        this.processor_series = processor_series;
        this.RAM = RAM;
        this.drive_type = drive_type;
        this.discrete_graphics = discrete_graphics;
        this.series = series;
        this.inst_os = inst_os;
        this.storage = storage;
        this.screen_refresh = screen_refresh;
        this.matrix_type = matrix_type;
        this.color = color;
        this.video_size = video_size;
        this.optical_drive = optical_drive;
        this.sc_resolution = sc_resolution;
        this.weight = weight;
        this.touch_screen = touch_screen;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getSc_diagonal() {
        return sc_diagonal;
    }

    public void setSc_diagonal(String sc_diagonal) {
        this.sc_diagonal = sc_diagonal;
    }

    public String getProcessor_manufacturer() {
        return processor_manufacturer;
    }

    public void setProcessor_manufacturer(String processor_manufacturer) {
        this.processor_manufacturer = processor_manufacturer;
    }

    public Integer getCores() {
        return cores;
    }

    public void setCores(Integer cores) {
        this.cores = cores;
    }

    public String getProcessor_series() {
        return processor_series;
    }

    public void setProcessor_series(String processor_series) {
        this.processor_series = processor_series;
    }

    public Integer getRAM() {
        return RAM;
    }

    public void setRAM(Integer RAM) {
        this.RAM = RAM;
    }

    public String getDrive_type() {
        return drive_type;
    }

    public void setDrive_type(String drive_type) {
        this.drive_type = drive_type;
    }

    public String getDiscrete_graphics() {
        return discrete_graphics;
    }

    public void setDiscrete_graphics(String discrete_graphics) {
        this.discrete_graphics = discrete_graphics;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getInst_os() {
        return inst_os;
    }

    public void setInst_os(String inst_os) {
        this.inst_os = inst_os;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public Integer getScreen_refresh() {
        return screen_refresh;
    }

    public void setScreen_refresh(Integer screen_refresh) {
        this.screen_refresh = screen_refresh;
    }

    public String getMatrix_type() {
        return matrix_type;
    }

    public void setMatrix_type(String matrix_type) {
        this.matrix_type = matrix_type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getVideo_size() {
        return video_size;
    }

    public void setVideo_size(Integer video_size) {
        this.video_size = video_size;
    }

    public String getOptical_drive() {
        return optical_drive;
    }

    public void setOptical_drive(String optical_drive) {
        this.optical_drive = optical_drive;
    }

    public String getSc_resolution() {
        return sc_resolution;
    }

    public void setSc_resolution(String sc_resolution) {
        this.sc_resolution = sc_resolution;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Boolean getTouch_screen() {
        return touch_screen;
    }

    public void setTouch_screen(Boolean touch_screen) {
        this.touch_screen = touch_screen;
    }
}
