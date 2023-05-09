/*package com.example.sampleproject.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Asset {
    @SerializedName("id")
    public String id;
    @SerializedName("version")
    public Integer version;
    @SerializedName("createdOn")
    public String createdOn;
    @SerializedName("name")
    public String name;
    @SerializedName("accessPublicRead")
    public Boolean accessPublicRead;
    @SerializedName("parentId")
    public String parentId;
    @SerializedName("realm")
    public String realm;
    @SerializedName("type")
    public String type;
    @SerializedName("path")
    public String[] path;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAccessPublicRead() {
        return accessPublicRead;
    }

    public void setAccessPublicRead(Boolean accessPublicRead) {
        this.accessPublicRead = accessPublicRead;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getPath() {
        return path;
    }

    public void setPath(String[] path) {
        this.path = path;
    }
    public String toString() {
        return "Asset{" +
                "id='" + id + '\'' +
                ", version=" + version +
                ", createdOn=" + createdOn +
                ", name='" + name + '\'' +
                ", accessPublicRead=" + accessPublicRead +
                ", parentId='" + parentId + '\'' +
                ", realm='" + realm + '\'' +
                ", type='" + type + '\'' +
                ", path=" + path +
                '}';
    }
}*/
package com.example.nt118n11mmcl_projectfinal.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Asset {
    @SerializedName("id")
    @Expose
    public String id;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @SerializedName("name")
    @Expose
    public String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @SerializedName("createdOn")
    @Expose
    public Long createdOn;
    public Long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }
    @SerializedName("accessPublicRead")
    @Expose
    public Boolean accessPublicRead;
    public Boolean getAccessPublicRead() {
        return accessPublicRead;
    }
    @SerializedName("version")
    @Expose
    public Integer version;
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setAccessPublicRead(Boolean accessPublicRead) {
        this.accessPublicRead = accessPublicRead;
    }
    @SerializedName("realm")
    @Expose
    public String realm;
    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }
    @SerializedName("type")
    @Expose
    public String type;
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @SerializedName("parentId")
    @Expose
    private String parentId;
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        attributes = attributes;
    }

    @SerializedName("attributes")
    @Expose
    public Object attributes;
    @Override
    public String toString()
    {
        return "" + attributes;
    }

}




