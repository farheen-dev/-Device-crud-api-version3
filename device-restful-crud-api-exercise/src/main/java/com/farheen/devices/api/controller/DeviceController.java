package com.farheen.devices.api.controller;

import com.farheen.devices.api.entity.Device;
import com.farheen.devices.api.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    //POST MAPPING FOR ONE DEVICE
    @PostMapping("/addDevice")
    public ResponseEntity<Object> addDevice(@RequestBody Device device)
    {
         return deviceService.saveDevice(device);
    }

    //POST MAPPING FOR MORE DEVICES
    @PostMapping("/addDevices")
    public ResponseEntity<Object> addDevices(@RequestBody List<Device> devices)
    {
        return deviceService.saveMoreDevices(devices);
    }

    //GET MAPPING FOR TO GET ONE DEVICE BY ID
    @GetMapping("/deviceById/{deviceId}")
    public ResponseEntity<Object> findDeviceById(@PathVariable int deviceId )
    {
       return deviceService.getDeviceById(deviceId);
    }

    //GET MAPPING FOR TO GET ONE DEVICE BY NAME
    @GetMapping("/deviceByName/{deviceName}")
    public ResponseEntity<Object> findDeviceByName(@PathVariable String deviceName )
    {
        return deviceService.getDeviceByName(deviceName);
    }

    //GET MAPPING FOR TO GET ALL DEVICES
    @GetMapping("/devices")
    public ResponseEntity<Object> findAllDevices()
    {
        return deviceService.getAllDevices();
    }

    //PUT MAPPING
    @PutMapping("/update/{deviceId}")
    public ResponseEntity<Object> modifyDevices(@RequestBody Device device,@PathVariable int deviceId)
    {
        return deviceService.updateDevice(device, deviceId);
    }

    //DELETE MAPPING FOR ONE DEVICE
    @DeleteMapping("/delete/{deviceId}")
    public ResponseEntity<Object> deleteDevice(@PathVariable int deviceId)
    {
        return deviceService.deleteDeviceById(deviceId);
    }

    // DELETE MAPPING FOR ALL THE DEVICES
    @DeleteMapping("/deleteAll")
    public ResponseEntity<Object> deleteAll()
    {
        return deviceService.deleteAllDevice();
    }

}
