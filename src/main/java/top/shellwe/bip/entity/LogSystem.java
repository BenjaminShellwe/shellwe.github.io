package top.shellwe.bip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "logsystem")
public class LogSystem {
    @Id
    @Column(name = "model_requestID", nullable = false)
    private String model_requestID;
    private int id;
    private String date;
    private String model_serviceName;
    private String model_readWriteType;
    private String model_userName;
    private String model_accountName;
    private String model_realName;
    private String model_resourceType;
    private String model_resourceName;
    private String model_operationName;
    private String model_keyValue;

    public String getModel_requestID() {
        return model_requestID;
    }

    public void setModel_requestID(String model_requestID) {
        this.model_requestID = model_requestID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getModel_serviceName() {
        return model_serviceName;
    }

    public void setModel_serviceName(String model_serviceName) {
        this.model_serviceName = model_serviceName;
    }

    public String getModel_readWriteType() {
        return model_readWriteType;
    }

    public void setModel_readWriteType(String model_readWriteType) {
        this.model_readWriteType = model_readWriteType;
    }

    public String getModel_userName() {
        return model_userName;
    }

    public void setModel_userName(String model_userName) {
        this.model_userName = model_userName;
    }

    public String getModel_accountName() {
        return model_accountName;
    }

    public void setModel_accountName(String model_accountName) {
        this.model_accountName = model_accountName;
    }

    public String getModel_realName() {
        return model_realName;
    }

    public void setModel_realName(String model_realName) {
        this.model_realName = model_realName;
    }

    public String getModel_resourceType() {
        return model_resourceType;
    }

    public void setModel_resourceType(String model_resourceType) {
        this.model_resourceType = model_resourceType;
    }

    public String getModel_resourceName() {
        return model_resourceName;
    }

    public void setModel_resourceName(String model_resourceName) {
        this.model_resourceName = model_resourceName;
    }

    public String getModel_operationName() {
        return model_operationName;
    }

    public void setModel_operationName(String model_operationName) {
        this.model_operationName = model_operationName;
    }

    public String getModel_keyValue() {
        return model_keyValue;
    }

    public void setModel_keyValue(String model_keyValue) {
        this.model_keyValue = model_keyValue;
    }
}
