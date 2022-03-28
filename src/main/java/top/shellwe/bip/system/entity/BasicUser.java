package top.shellwe.bip.system.entity;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import javax.persistence.Column;
import javax.persistence.Id;

import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.shellwe.bip.common.entity.BaseEntity;

/**
 * The type User.
 * @author BenjaminThomas
 */
@Data
@ApiModel(description = "系统管理-用户基础表")
@TableName("basic_user")
public class BasicUser extends BaseEntity<BasicUser> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "UID")
    @Id
    @TableId(value="id", type= IdType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ApiModelProperty(value = "头像")
    @TableField("avatarID")
    private String avatarID;

    @ApiModelProperty(value = "全局标识")
    @TableField("GID")
    private String GID;

    @ApiModelProperty(value = "企业标识")
    @TableField("enterpriseID")
    private String enterpriseID;

    @ApiModelProperty(value = "账号名称")
    @TableField("userName")
    private String userName;

    @ApiModelProperty(value = "真实名称")
    @TableField("userRealName")
    private String userRealName;

    @ApiModelProperty(value = "登录密码")
    @TableField("userPassword")
    private String userPassword;

    @ApiModelProperty(value = "用户角色")
    @TableField("userRole")
    private String userRole;

    @ApiModelProperty(value = "token")
    @TableField("token")
    private String token;

    @ApiModelProperty(value = "创建时间")
    @TableField("created_at")
    private Date created_at;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_at")
    private Date update_at;

    @ApiModelProperty(value = "盐值")
    @TableField("salt")
    private String salt;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets avatar id.
     *
     * @return the avatar id
     */
    public String getAvatarID() {
        return avatarID;
    }

    /**
     * Sets avatar id.
     *
     * @param avatarID the avatar id
     */
    public void setAvatarID(String avatarID) {
        this.avatarID = avatarID;
    }

    /**
     * Gets gid.
     *
     * @return the gid
     */
    public String getGID() {
        return GID;
    }

    /**
     * Sets gid.
     *
     * @param GID the gid
     */
    public void setGID(String GID) {
        this.GID = GID;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets user real name.
     *
     * @return the user real name
     */
    public String getUserRealName() {
        return userRealName;
    }

    /**
     * Sets user real name.
     *
     * @param userRealName the user real name
     */
    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    /**
     * Gets user password.
     *
     * @return the user password
     * @param s
     */
    public String getUserPassword(String s) {
        return userPassword;
    }

    /**
     * Sets user password.
     *
     * @param userPassword the user password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Gets user role.
     *
     * @return the user role
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * Sets user role.
     *
     * @param userRole the user role
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * Gets enterprise id.
     *
     * @return the enterprise id
     */
    public String getEnterpriseID() {
        return enterpriseID;
    }

    /**
     * Sets enterprise id.
     *
     * @param enterpriseID the enterprise id
     */
    public void setEnterpriseID(String enterpriseID) {
        this.enterpriseID = enterpriseID;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }
}
