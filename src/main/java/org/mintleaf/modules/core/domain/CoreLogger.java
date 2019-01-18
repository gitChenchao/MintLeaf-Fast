package org.mintleaf.modules.core.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * core_logger
 * @author 
 */
public class CoreLogger implements Serializable {
    private Integer id;

    /**
     * 客户端请求IP地址
     */
    private String client_ip;

    /**
     * 日志请求地址
     */
    private String uri;

    /**
     * 终端请求方式,普通请求,ajax请求
     */
    private String type;

    /**
     * 请求方式method,post,get等
     */
    private String method;

    /**
     * 请求接口唯一session标识
     */
    private String session_id;

    /**
     * 请求时间
     */
    private Date time;

    /**
     * 接口返回时间
     */
    private String returm_time;

    /**
     * 请求时httpStatusCode代码，如：200,400,404等
     */
    private String http_status_code;

    /**
     * 请求耗时（毫秒单位）
     */
    private Integer time_consuming;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getReturm_time() {
        return returm_time;
    }

    public void setReturm_time(String returm_time) {
        this.returm_time = returm_time;
    }

    public String getHttp_status_code() {
        return http_status_code;
    }

    public void setHttp_status_code(String http_status_code) {
        this.http_status_code = http_status_code;
    }

    public Integer getTime_consuming() {
        return time_consuming;
    }

    public void setTime_consuming(Integer time_consuming) {
        this.time_consuming = time_consuming;
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
        CoreLogger other = (CoreLogger) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClient_ip() == null ? other.getClient_ip() == null : this.getClient_ip().equals(other.getClient_ip()))
            && (this.getUri() == null ? other.getUri() == null : this.getUri().equals(other.getUri()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getMethod() == null ? other.getMethod() == null : this.getMethod().equals(other.getMethod()))
            && (this.getSession_id() == null ? other.getSession_id() == null : this.getSession_id().equals(other.getSession_id()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getReturm_time() == null ? other.getReturm_time() == null : this.getReturm_time().equals(other.getReturm_time()))
            && (this.getHttp_status_code() == null ? other.getHttp_status_code() == null : this.getHttp_status_code().equals(other.getHttp_status_code()))
            && (this.getTime_consuming() == null ? other.getTime_consuming() == null : this.getTime_consuming().equals(other.getTime_consuming()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getClient_ip() == null) ? 0 : getClient_ip().hashCode());
        result = prime * result + ((getUri() == null) ? 0 : getUri().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getMethod() == null) ? 0 : getMethod().hashCode());
        result = prime * result + ((getSession_id() == null) ? 0 : getSession_id().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getReturm_time() == null) ? 0 : getReturm_time().hashCode());
        result = prime * result + ((getHttp_status_code() == null) ? 0 : getHttp_status_code().hashCode());
        result = prime * result + ((getTime_consuming() == null) ? 0 : getTime_consuming().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", client_ip=").append(client_ip);
        sb.append(", uri=").append(uri);
        sb.append(", type=").append(type);
        sb.append(", method=").append(method);
        sb.append(", session_id=").append(session_id);
        sb.append(", time=").append(time);
        sb.append(", returm_time=").append(returm_time);
        sb.append(", http_status_code=").append(http_status_code);
        sb.append(", time_consuming=").append(time_consuming);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}