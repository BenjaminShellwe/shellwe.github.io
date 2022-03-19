package top.shellwe.bip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "avatar")
public class Avatar {

    @Id
    @Column(name = "id", nullable = false)
    private int id;
    private String caption;
    private String description;
    private int userID;
    private long image;
    private String name;
    private String data;
    private String headers;
    private String url;


    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public long getImage() {
        return image;
    }

    public void setImage(long image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String toString() {
        return "avatarModel{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", caption='" + caption + '\'' +
                ", description='" + description + '\'' +
                ", userID='" + userID + '\'' +
                ", name='" + name + '\'' +
                ", data='" + data + '\'' +
                ", headers='" + headers + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
