package org.mintleaf.modules.core.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * core_menu
 * @author 
 */
public class CoreMenu implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 网址
     */
    private String url;

    /**
     * 显示的图标
     */
    private String icon;

    /**
     * 类型，0 菜单，1 连接网址,2 隐藏连接
     */
    private String menutype;

    /**
     * 显示排序
     */
    private Integer display;

    /**
     * 父级的id，引用本表id字段
     */
    private Integer parentid;

    /**
     * 创建者id，0为超级管理员
     */
    private Integer creator;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新者id
     */
    private Integer updateuser;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 是否启用，0 禁用，1启用
     */
    private String flag;

    /**
     * 权限代码
     */
    private String permission;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMenutype() {
        return menutype;
    }

    public void setMenutype(String menutype) {
        this.menutype = menutype;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
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
        CoreMenu other = (CoreMenu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getMenutype() == null ? other.getMenutype() == null : this.getMenutype().equals(other.getMenutype()))
            && (this.getDisplay() == null ? other.getDisplay() == null : this.getDisplay().equals(other.getDisplay()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUpdateuser() == null ? other.getUpdateuser() == null : this.getUpdateuser().equals(other.getUpdateuser()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getFlag() == null ? other.getFlag() == null : this.getFlag().equals(other.getFlag()))
            && (this.getPermission() == null ? other.getPermission() == null : this.getPermission().equals(other.getPermission()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getMenutype() == null) ? 0 : getMenutype().hashCode());
        result = prime * result + ((getDisplay() == null) ? 0 : getDisplay().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUpdateuser() == null) ? 0 : getUpdateuser().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getFlag() == null) ? 0 : getFlag().hashCode());
        result = prime * result + ((getPermission() == null) ? 0 : getPermission().hashCode());
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
        sb.append(", url=").append(url);
        sb.append(", icon=").append(icon);
        sb.append(", menutype=").append(menutype);
        sb.append(", display=").append(display);
        sb.append(", parentid=").append(parentid);
        sb.append(", creator=").append(creator);
        sb.append(", createtime=").append(createtime);
        sb.append(", updateuser=").append(updateuser);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", flag=").append(flag);
        sb.append(", permission=").append(permission);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}