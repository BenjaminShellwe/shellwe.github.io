package top.shellwe.bip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "dictionary")
public class Dictionary {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    private String prefix;
    private String uniqueID;
    private String typeCode;
    private String typeName;
    private int valueID;
    private String valueName;
    private String valueStatus;
    private String description;
    private String editable;
    private String type;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getValueID() {
        return valueID;
    }

    public void setValueID(int valueID) {
        this.valueID = valueID;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public String getValueStatus() {
        return valueStatus;
    }

    public void setValueStatus(String valueStatus) {
        this.valueStatus = valueStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEditable() {
        return editable;
    }

    public void setEditable(String editable) {
        this.editable = editable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" + "prefix = " + prefix + ", id = " + id +
                     ", uniqueID = " + uniqueID + ", typeCode = " + typeCode +
                     ", typeName=" + typeName + ", valueID = " + valueID +
                     ", valueName = " + valueName + ", valueStatus = " + valueStatus +
                     ", description = " + description + ", editable = " + editable +
                     ", type = " + type +
                '}';
    }
}
