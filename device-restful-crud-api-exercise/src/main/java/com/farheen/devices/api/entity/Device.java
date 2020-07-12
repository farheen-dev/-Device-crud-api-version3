package com.farheen.devices.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue
    private int deviceId;

    @Column(name = "device_name")
    private String deviceName;

    @Column(name = "device_status")
    private String deviceStatus;

    @Column(name = "device_model")
    private String deviceModel;

    @Column(name = "enrolled_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date enrolledTime;

    public Device() {
    }

    public Device(String deviceName, String deviceStatus, String deviceModel, Date enrolledTime) {
        this.deviceName = deviceName;
        this.deviceStatus = deviceStatus;
        this.deviceModel = deviceModel;
        this.enrolledTime = enrolledTime;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public Date getEnrolledTime() {
        return enrolledTime;
    }

    public void setEnrolledTime(Date enrolledTime) {
        this.enrolledTime = enrolledTime;
    }
}
