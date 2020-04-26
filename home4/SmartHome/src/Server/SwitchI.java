package Server;

import SmartHome.Switch;
import com.zeroc.Ice.Current;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SwitchI extends DeviceI implements Switch {

    public SwitchI(String name){
        super(SmartHome.deviceType.SWITCH, name);
    }


    @Override
    public void setTimeout(int seconds, Current current) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(this.status== SmartHome.status.ON){
            this.status= SmartHome.status.OFF;
        }else{
            this.status = SmartHome.status.ON;
        }
    }

    @Override
    public double getCurrentLoad(Current current) {
        double min = 0;
        double max = 20;
        double random = new Random().nextDouble();
        double result = min + (random * (max - min));
        return result;
    }

    @Override
    public String getManual(Current current) {
        StringBuilder sb = new StringBuilder();
        sb.append("===== Switch Manual =====\n");
        sb.append("1. on\n");
        sb.append("2. off\n");
        sb.append("3. getStatus\n");
        sb.append("4. setTimeout.<seconds>\n");
        sb.append("5. getLoad\n");
        sb.append("========================");
        return sb.toString();
    }

    }
