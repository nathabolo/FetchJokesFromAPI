package model;

import java.io.Serializable;
import java.util.Arrays;

public class ApiResponse implements Serializable {

    private String category[];
    private String dateCreated;
    private String iconUrl;
    private String id;
    private String dateUpdated;
    private String url;
    private String value;

    public String[] getCategory() {
        return category;
    }

    public void setCategory(String[] category) {
        this.category = category;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "category=" + Arrays.toString(category) +
                ", dateCreated='" + dateCreated + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", id='" + id + '\'' +
                ", dateUpdated='" + dateUpdated + '\'' +
                ", url='" + url + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
