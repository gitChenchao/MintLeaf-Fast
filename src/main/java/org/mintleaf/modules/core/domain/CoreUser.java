package org.mintleaf.modules.core.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * core_user
 * @author
 */
public class CoreUser implements Serializable {
    /**
     * 用户表主键
     */
    private Integer id;

    /**
     * 租户id，0为系统用户
     */
    private Integer tenantid;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户密码MD5加密
     */
    private String psw;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String iphone;

    /**
     * 创建人，0为初始化
     */
    private Integer creator;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 用户状态，1启用，0禁用
     */
    private Integer flag;

    /**
     * 最后登录时间
     */
    private Date logintime;

    /**
     * 更新者id
     */
    private Integer updateuser;

    /**
     * 更新时间
     */
    private Date updatetime;

    private String role;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTenantid() {
        return tenantid;
    }

    public void setTenantid(Integer tenantid) {
        this.tenantid = tenantid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public Integer getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(Integer updateuser) {
        this.updateuser = updateuser;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CoreUser other = (CoreUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getTenantid() == null ? other.getTenantid() == null : this.getTenantid().equals(other.getTenantid()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getPsw() == null ? other.getPsw() == null : this.getPsw().equals(other.getPsw()))
                && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
                && (this.getIphone() == null ? other.getIphone() == null : this.getIphone().equals(other.getIphone()))
                && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
                && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
                && (this.getFlag() == null ? other.getFlag() == null : this.getFlag().equals(other.getFlag()))
                && (this.getLogintime() == null ? other.getLogintime() == null : this.getLogintime().equals(other.getLogintime()))
                && (this.getUpdateuser() == null ? other.getUpdateuser() == null : this.getUpdateuser().equals(other.getUpdateuser()))
                && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
                && (this.getRole() == null ? other.getRole() == null : this.getRole().equals(other.getRole()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTenantid() == null) ? 0 : getTenantid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPsw() == null) ? 0 : getPsw().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getIphone() == null) ? 0 : getIphone().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getFlag() == null) ? 0 : getFlag().hashCode());
        result = prime * result + ((getLogintime() == null) ? 0 : getLogintime().hashCode());
        result = prime * result + ((getUpdateuser() == null) ? 0 : getUpdateuser().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getRole() == null) ? 0 : getRole().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tenantid=").append(tenantid);
        sb.append(", name=").append(name);
        sb.append(", psw=").append(psw);
        sb.append(", email=").append(email);
        sb.append(", iphone=").append(iphone);
        sb.append(", creator=").append(creator);
        sb.append(", createtime=").append(createtime);
        sb.append(", flag=").append(flag);
        sb.append(", logintime=").append(logintime);
        sb.append(", updateuser=").append(updateuser);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", role=").append(role);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}