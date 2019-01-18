package org.mintleaf.modules.core.domain;

import java.io.Serializable;

/**
 * core_logger
 * @author 
 */
public class CoreLoggerWithBLOBs extends CoreLogger implements Serializable {
    /**
     * 请求参数内容,json
     */
    private String param_data;

    /**
     * 接口返回数据json
     */
    private String return_data;

    private static final long serialVersionUID = 1L;

    public String getParam_data() {
        return param_data;
    }

    public void setParam_data(String param_data) {
        this.param_data = param_data;
    }

    public String getReturn_data() {
        return return_data;
    }

    public void setReturn_data(String return_data) {
        this.return_data = return_data;
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
        CoreLoggerWithBLOBs other = (CoreLoggerWithBLOBs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClient_ip() == null ? other.getClient_ip() == null : this.getClient_ip().equals(other.getClient_ip()))
            && (this.getUri() == null ? other.getUri() == null : this.getUri().equals(other.getUri()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getMethod() == null ? other.getMethod() == null : this.getMethod().equals(other.getMethod()))
            && (this.getSession_id() == null ? other.getSession_id() == null : this.getSession_id().equals(other.getSession_id()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getReturm_time() == null ? other.getReturm_time() == null : this.getReturm_time().equals(other.getReturm_time()))
            && (this.getHttp_status_code() == null ? other.getHttp_status_code() == null : this.getHttp_status_code().equals(other.getHttp_status_code()))
            && (this.getTime_consuming() == null ? other.getTime_consuming() == null : this.getTime_consuming().equals(other.getTime_consuming()))
            && (this.getParam_data() == null ? other.getParam_data() == null : this.getParam_data().equals(other.getParam_data()))
            && (this.getReturn_data() == null ? other.getReturn_data() == null : this.getReturn_data().equals(other.getReturn_data()));
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
        result = prime * result + ((getParam_data() == null) ? 0 : getParam_data().hashCode());
        result = prime * result + ((getReturn_data() == null) ? 0 : getReturn_data().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", param_data=").append(param_data);
        sb.append(", return_data=").append(return_data);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}