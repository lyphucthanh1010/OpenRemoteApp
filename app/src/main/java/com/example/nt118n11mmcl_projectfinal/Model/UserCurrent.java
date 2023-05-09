package com.example.nt118n11mmcl_projectfinal.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserCurrent implements Serializable {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }

    public UserCurrent(String version, String name, String id, String type) {
        this.version = version;
        this.name = name;
        this.id = id;
        this.type =type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String type;
    public String version;

    public String id;
    public Object attributes;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String name;
}
