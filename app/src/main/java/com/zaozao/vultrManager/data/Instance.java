package com.zaozao.vultrManager.data;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by chenqisheng on 14/11/9.
 */
public class Instance {
    @JSONField(name = "SUBID")
    private String subId;
    @JSONField(name = "main_ip")
    private String ip;
    private String status;
    private String label;
    @JSONField(name = "current_bandwidth_gb")
    private float currentBandwidth;
    @JSONField(name = "allowed_bandwidth_gb")
    private String allowedBandwidth;

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public float getCurrentBandwidth() {
        return currentBandwidth;
    }

    public void setCurrentBandwidth(float currentBandwidth) {
        this.currentBandwidth = currentBandwidth;
    }

    public String getAllowedBandwidth() {
        return allowedBandwidth;
    }

    public void setAllowedBandwidth(String allowedBandwidth) {
        this.allowedBandwidth = allowedBandwidth;
    }

    @Override
    public String toString() {
        return "Instance{" +
                "subId='" + subId + '\'' +
                ", ip='" + ip + '\'' +
                ", status='" + status + '\'' +
                ", label='" + label + '\'' +
                ", currentBandwidth=" + currentBandwidth +
                ", allowedBandwidth='" + allowedBandwidth + '\'' +
                '}';
    }
}
