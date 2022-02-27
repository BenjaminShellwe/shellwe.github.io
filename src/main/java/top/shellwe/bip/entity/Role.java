package top.shellwe.bip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "role")
public class Role {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    private int userID;
    private String realName;
    private String role;
    private String advancedPermission;
    private String basicPermission;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAdvancedPermission() {
        return advancedPermission;
    }

    public void setAdvancedPermission(String advancedPermission) {
        this.advancedPermission = advancedPermission;
    }

    public String getBasicPermission() {
        return basicPermission;
    }

    public void setBasicPermission(String basicPermission) {
        this.basicPermission = basicPermission;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}