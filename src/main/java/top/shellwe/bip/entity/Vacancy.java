package top.shellwe.bip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "vacancy")
public class Vacancy {

    @Id
    @Column(name = "affairID", nullable = false)
    private String affairID;
    private String position;
    private String status;
    private String department;
    private String director;
    private String phoneD;
    private String manager;
    private String phoneM;
    private String departmentStatus;
    private String description;
    private String createdTime;

    public String getAffairID() {
        return affairID;
    }

    public void setAffairID(String affairID) {
        this.affairID = affairID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPhoneD() {
        return phoneD;
    }

    public void setPhoneD(String phoneD) {
        this.phoneD = phoneD;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getPhoneM() {
        return phoneM;
    }

    public void setPhoneM(String phoneM) {
        this.phoneM = phoneM;
    }

    public String getDepartmentStatus() {
        return departmentStatus;
    }

    public void setDepartmentStatus(String departmentStatus) {
        this.departmentStatus = departmentStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
