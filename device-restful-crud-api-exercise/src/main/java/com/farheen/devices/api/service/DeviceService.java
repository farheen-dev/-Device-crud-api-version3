package com.farheen.devices.api.service;

import com.farheen.devices.api.entity.Device;
import com.farheen.devices.api.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    /*****POST METHODS******/

    //To create/save one devices
    public ResponseEntity<Object> saveDevice(Device device)
    {
        deviceRepository.save(device);
        return new ResponseEntity<>("Device is successfully created with id " + device.getDeviceId(), HttpStatus.CREATED);
    }

    //To create/save list of devices
    public ResponseEntity<Object> saveMoreDevices(List<Device> device)
    {
        deviceRepository.saveAll(device);
        return new ResponseEntity<>("Devices are successfully created " , HttpStatus.CREATED);

    }

    /*****GET METHODS******/

    //To get one device by id
    public ResponseEntity<Object> getDeviceById(int deviceId)
    {
        Device existingDevice = this.deviceRepository.findById(deviceId).orElse(null);
        if(existingDevice == null ){
            return new ResponseEntity<>("Device not found with that id " + deviceId, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(existingDevice, HttpStatus.OK);

    }


    //To get one device by name
    public ResponseEntity<Object> getDeviceByName(String deviceName)
    {
        List<Device> existingDevice = this.deviceRepository.findByDeviceName(deviceName);
        if(existingDevice == null ){
            return new ResponseEntity<>("Device not found with that Name " + deviceName, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(existingDevice, HttpStatus.OK);
    }

    //To get all the list of devices
    public  ResponseEntity<Object> getAllDevices()
    {
        List<Device> existingDevice = this.deviceRepository.findAll();
        if(existingDevice == null ){
            return new ResponseEntity<>("Device are no devices in the database " , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(existingDevice, HttpStatus.OK);

    }

    /*****PUT METHODS******/
    public ResponseEntity<Object> updateDevice(Device device, int deviceId)
    {
        Device existingDevice = this.deviceRepository.findById(deviceId).orElse(null);
        if(existingDevice == null ){
            return new ResponseEntity<>("Device are no device with that id " + deviceId + " to modify" , HttpStatus.NOT_FOUND);
        }
        existingDevice.setDeviceName(device.getDeviceName());
        existingDevice.setDeviceStatus(device.getDeviceStatus());
        existingDevice.setDeviceModel(device.getDeviceModel());
        existingDevice.setEnrolledTime(device.getEnrolledTime());
        this.deviceRepository.save(existingDevice);
        return new ResponseEntity<>(existingDevice, HttpStatus.OK);

    }

    /*****DELETE METHODS******/

    //To delete one device
    public ResponseEntity<Object> deleteDeviceById(int deviceId)
    {
        Device existingDevice = this.deviceRepository.findById(deviceId).orElse(null);
        if(existingDevice == null ){
            return new ResponseEntity<>("Device are no device with that id " + deviceId + " to delete" , HttpStatus.NOT_FOUND);
        }
        this.deviceRepository.deleteById(deviceId);
        return new ResponseEntity<>("The device with id " + deviceId + " successfully deleted", HttpStatus.OK);
    }

    //To delete all the devices
    public ResponseEntity<Object> deleteAllDevice()
    {
        this.deviceRepository.deleteAll();
        return  new ResponseEntity<>("All the devices enrolled are successfully deleted", HttpStatus.OK);
    }
}
