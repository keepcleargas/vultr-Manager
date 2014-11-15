package com.zaozao.vultrManager.data;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by chenqisheng on 14/11/9.
 */
public class Instance {
    @JSONField(name = "SUBID")
    private String subId;
    private String os;
    private String disk;
    private String ram;
    @JSONField(name = "vcpu_count")
    private String cpuCount;
    private String location;
    @JSONField(name = "DCID")
    private String dcid;
    @JSONField(name = "default_password")
    private String defaultPassword;
    @JSONField(name = "date_created")
    private String dateCreated;
    @JSONField(name = "pending_charges")
    private String pendingCharges;
    @JSONField(name = "power_status")
    private String powerStatus;
    @JSONField(name = "internal_ip")
    private String internalIp;
    @JSONField(name = "netmask_v4")
    private String netmaskV4;
    @JSONField(name = "gateway_v4")
    private String gatewayV4;
    @JSONField(name = "auto_backups")
    private String autoBackups;
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

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getCpuCount() {
        return cpuCount;
    }

    public void setCpuCount(String cpuCount) {
        this.cpuCount = cpuCount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDcid() {
        return dcid;
    }

    public void setDcid(String dcid) {
        this.dcid = dcid;
    }

    public String getDefaultPassword() {
        return defaultPassword;
    }

    public void setDefaultPassword(String defaultPassword) {
        this.defaultPassword = defaultPassword;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getPendingCharges() {
        return pendingCharges;
    }

    public void setPendingCharges(String pendingCharges) {
        this.pendingCharges = pendingCharges;
    }

    public String getPowerStatus() {
        return powerStatus;
    }

    public void setPowerStatus(String powerStatus) {
        this.powerStatus = powerStatus;
    }

    public String getInternalIp() {
        return internalIp;
    }

    public void setInternalIp(String internalIp) {
        this.internalIp = internalIp;
    }

    public String getNetmaskV4() {
        return netmaskV4;
    }

    public void setNetmaskV4(String netmaskV4) {
        this.netmaskV4 = netmaskV4;
    }

    public String getGatewayV4() {
        return gatewayV4;
    }

    public void setGatewayV4(String gatewayV4) {
        this.gatewayV4 = gatewayV4;
    }

    public String getAutoBackups() {
        return autoBackups;
    }

    public void setAutoBackups(String autoBackups) {
        this.autoBackups = autoBackups;
    }

    @Override
    public String toString() {
        return "Instance{" +
                "subId='" + subId + '\'' +
                ", os='" + os + '\'' +
                ", disk='" + disk + '\'' +
                ", ram='" + ram + '\'' +
                ", vCpuCount='" + cpuCount + '\'' +
                ", location='" + location + '\'' +
                ", dcid='" + dcid + '\'' +
                ", defaultPassword='" + defaultPassword + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", pendingCharges='" + pendingCharges + '\'' +
                ", powerStatus='" + powerStatus + '\'' +
                ", internalIp='" + internalIp + '\'' +
                ", netmaskV4='" + netmaskV4 + '\'' +
                ", gatewayV4='" + gatewayV4 + '\'' +
                ", autoBackups='" + autoBackups + '\'' +
                ", ip='" + ip + '\'' +
                ", status='" + status + '\'' +
                ", label='" + label + '\'' +
                ", currentBandwidth=" + currentBandwidth +
                ", allowedBandwidth='" + allowedBandwidth + '\'' +
                '}';
    }
}
