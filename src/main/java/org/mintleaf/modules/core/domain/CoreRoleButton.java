package org.mintleaf.modules.core.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * core_role_button
 * @author 
 */
public class CoreRoleButton implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 角色id
     */
    private Integer roleid;

    /**
     * 按钮id
     */
    private Integer buttonid;

    /**
     * 1为有权限，0为没有权限（防止以后会出现角色有权限但是个人没有权限的情况）
     */
    private Integer flag;

    /**
     * 创建时间
     */
    private Date createtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getButtonid() {
        return buttonid;
    }

    public void setButtonid(Integer buttonid) {
        this.buttonid = buttonid;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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
        CoreRoleButton other = (CoreRoleButton) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRoleid() == null ? other.getRoleid() == null : this.getRoleid().equals(other.getRoleid()))
            && (this.getButtonid() == null ? other.getButtonid() == null : this.getButtonid().equals(other.getButtonid()))
            && (this.getFlag() == null ? other.getFlag() == null : this.getFlag().equals(other.getFlag()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRoleid() == null) ? 0 : getRoleid().hashCode());
        result = prime * result + ((getButtonid() == null) ? 0 : getButtonid().hashCode());
        result = prime * result + ((getFlag() == null) ? 0 : getFlag().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleid=").append(roleid);
        sb.append(", buttonid=").append(buttonid);
        sb.append(", flag=").append(flag);
        sb.append(", createtime=").append(createtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}