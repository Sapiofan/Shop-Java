package com.example.shopjava.entities;

import javax.persistence.*;

@Entity
@Table(name = "phones")
public class Phone extends Product{

    @Column(nullable = false)
    private String series;

    @Column(nullable = false)
    private String built_in_memory;

    @Column(nullable = false)
    private Boolean RAM_slot;

    @Column(nullable = false)
    private Integer CPU;

    @Column(nullable = false)
    private String os;

    @Column(nullable = false)
    private Boolean NFC;

    @Column(nullable = false)
    private String sc_diagonal;

    private Boolean biometric_security;

    @Column(nullable = false)
    private String main_camera;

    @Column(nullable = false)
    private String front_camera;

    @Column(nullable = false)
    private String battery;

    private Boolean wireless_charger;

    @Column(nullable = false)
    private Integer cores;

    private Integer screen_refresh;

    public Phone(){}

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getBuilt_in_memory() {
        return built_in_memory;
    }

    public void setBuilt_in_memory(String built_in_memory) {
        this.built_in_memory = built_in_memory;
    }

    public Boolean getRAM_slot() {
        return RAM_slot;
    }

    public void setRAM_slot(Boolean RAM_slot) {
        this.RAM_slot = RAM_slot;
    }

    public Integer getCPU() {
        return CPU;
    }

    public void setCPU(Integer CPU) {
        this.CPU = CPU;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Boolean getNFC() {
        return NFC;
    }

    public void setNFC(Boolean NFC) {
        this.NFC = NFC;
    }

    public String getSc_diagonal() {
        return sc_diagonal;
    }

    public void setSc_diagonal(String sc_diagonal) {
        this.sc_diagonal = sc_diagonal;
    }

    public Boolean getBiometric_security() {
        return biometric_security;
    }

    public void setBiometric_security(Boolean biometric_security) {
        this.biometric_security = biometric_security;
    }

    public String getMain_camera() {
        return main_camera;
    }

    public void setMain_camera(String main_camera) {
        this.main_camera = main_camera;
    }

    public String getFront_camera() {
        return front_camera;
    }

    public void setFront_camera(String front_camera) {
        this.front_camera = front_camera;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public Boolean getWireless_charger() {
        return wireless_charger;
    }

    public void setWireless_charger(Boolean wireless_charger) {
        this.wireless_charger = wireless_charger;
    }

    public Integer getCores() {
        return cores;
    }

    public void setCores(Integer cores) {
        this.cores = cores;
    }

    public Integer getScreen_refresh() {
        return screen_refresh;
    }

    public void setScreen_refresh(Integer screen_refresh) {
        this.screen_refresh = screen_refresh;
    }
}
