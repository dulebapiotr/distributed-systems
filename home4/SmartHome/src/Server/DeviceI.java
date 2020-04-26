package Server;

import SmartHome.Device;
import SmartHome.deviceType;
import SmartHome.status;
import com.zeroc.Ice.Current;



public class DeviceI implements Device {
    protected status status;
    protected deviceType deviceType;
    protected String name;

    public DeviceI(deviceType deviceType, String name){
        this.status= SmartHome.status.OFF;
        this.deviceType = deviceType;
        this.name = name;

    }

    @Override
    public void on(Current current) {
        this.status = SmartHome.status.ON;
    }

    @Override
    public void off(Current current) {
        this.status = SmartHome.status.OFF;
    }

    @Override
    public status getStatus(Current current) {
        return this.status;
    }

    @Override
    public String getName(Current current) {
        return this.name;
    }

    @Override
    public String getManual(Current current) {
        return null;
    }

    @Override
    public deviceType getDeviceType(Current current) {
        return this.deviceType;
    }
}
