package com.mofei.pojo;

import java.io.Serializable;

/**
 * @author mofei
 * @create 2021-02-17:59
 */
public class Flower implements Serializable {
    private Integer id;
    private String name;
    private Float price;
    private String production;
    private String filename;
    private String filetype;

    public Flower() {
    }

    public Flower(Integer id, String name, Float price, String production, String filename, String filetype) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.production = production;
        this.filename = filename;
        this.filetype = filetype;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }
}
