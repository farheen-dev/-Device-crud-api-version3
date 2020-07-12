package com.farheen.devices.api.repository;

import com.farheen.devices.api.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DeviceRepository extends JpaRepository<Device, Integer> {
    List<Device> findByDeviceName(String deviceName);
}
