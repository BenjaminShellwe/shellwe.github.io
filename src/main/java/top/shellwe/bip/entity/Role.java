package top.shellwe.bip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "role")
public class Role {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    private String role;
    private String enterprisePermission;
    private String enterpriseAdd;
    private String enterpriseAlter;
    private String enterpriseQuery;
    private String enterpriseDelete;
    private String basicPermission;
    private String basicAdd;
    private String basicAlter;
    private String basicQuery;
    private String basicDelete;
    private String personalPermission;
    private String personalAdd;
    private String personalAlter;
    private String personalQuery;
    private String personalDelete;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEnterprisePermission() {
        return enterprisePermission;
    }

    public void setEnterprisePermission(String enterprisePermission) {
        this.enterprisePermission = enterprisePermission;
    }

    public String getEnterpriseAdd() {
        return enterpriseAdd;
    }

    public void setEnterpriseAdd(String enterpriseAdd) {
        this.enterpriseAdd = enterpriseAdd;
    }

    public String getEnterpriseAlter() {
        return enterpriseAlter;
    }

    public void setEnterpriseAlter(String enterpriseAlter) {
        this.enterpriseAlter = enterpriseAlter;
    }

    public String getEnterpriseQuery() {
        return enterpriseQuery;
    }

    public void setEnterpriseQuery(String enterpriseQuery) {
        this.enterpriseQuery = enterpriseQuery;
    }

    public String getEnterpriseDelete() {
        return enterpriseDelete;
    }

    public void setEnterpriseDelete(String enterpriseDelete) {
        this.enterpriseDelete = enterpriseDelete;
    }

    public String getBasicPermission() {
        return basicPermission;
    }

    public void setBasicPermission(String basicPermission) {
        this.basicPermission = basicPermission;
    }

    public String getBasicAdd() {
        return basicAdd;
    }

    public void setBasicAdd(String basicAdd) {
        this.basicAdd = basicAdd;
    }

    public String getBasicAlter() {
        return basicAlter;
    }

    public void setBasicAlter(String basicAlter) {
        this.basicAlter = basicAlter;
    }

    public String getBasicQuery() {
        return basicQuery;
    }

    public void setBasicQuery(String basicQuery) {
        this.basicQuery = basicQuery;
    }

    public String getBasicDelete() {
        return basicDelete;
    }

    public void setBasicDelete(String basicDelete) {
        this.basicDelete = basicDelete;
    }

    public String getPersonalPermission() {
        return personalPermission;
    }

    public void setPersonalPermission(String personalPermission) {
        this.personalPermission = personalPermission;
    }

    public String getPersonalAdd() {
        return personalAdd;
    }

    public void setPersonalAdd(String personalAdd) {
        this.personalAdd = personalAdd;
    }

    public String getPersonalAlter() {
        return personalAlter;
    }

    public void setPersonalAlter(String personalAlter) {
        this.personalAlter = personalAlter;
    }

    public String getPersonalQuery() {
        return personalQuery;
    }

    public void setPersonalQuery(String personalQuery) {
        this.personalQuery = personalQuery;
    }

    public String getPersonalDelete() {
        return personalDelete;
    }

    public void setPersonalDelete(String personalDelete) {
        this.personalDelete = personalDelete;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}