package com.vitaliy.appstore.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "application")
public class Application implements Comparable<Application> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "app_name")
    private String name;

    @Column(name = "version")
    private String version;

    @Column(name = "content_rate")
    private int contentRate;

    public Application() {
    }

    public Application(String name, String version, int contentRate) {
        this.name = name;
        this.version = version;
        this.contentRate = contentRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getContentRate() {
        return contentRate;
    }

    public void setContentRate(int contentRate) {
        this.contentRate = contentRate;
    }

    @Override
    public int compareTo(Application o) {
        return version.compareTo(o.version);
    }
}
