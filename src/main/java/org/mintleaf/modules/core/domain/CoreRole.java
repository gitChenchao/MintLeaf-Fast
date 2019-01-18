package org.mintleaf.modules.core.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * core_role
 * @author 
 */
public class CoreRole implements Serializable {
    /**
     * 角色表主键
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 用户id，0为角色，有关联时则为用户的单独权限
     */
    private Integer creator;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 更新者id
     */
    private Integer updateuser;

    /**
     * 更新时间
     */
    private Date updatetime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        CoreRole other = (CoreRole) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getUpdateuser() == null ? other.getUpdateuser() == null : this.getUpdateuser().equals(other.getUpdateuser()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getUpdateuser() == null) ? 0 : getUpdateuser().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", createtime=").append(createtime);
        sb.append(", creator=").append(creator);
        sb.append(", description=").append(description);
        sb.append(", updateuser=").append(updateuser);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}