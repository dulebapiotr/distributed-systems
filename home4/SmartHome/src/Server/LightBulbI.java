package Server;

import SmartHome.*;
import com.zeroc.Ice.Current;


import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LightBulbI extends DeviceI implements LightBulb {

    protected rgbColor color;
    protected int brightness;

    public LightBulbI(String name){
        super(SmartHome.deviceType.LIGHTBULB, name);
        rgbColor tmpColor = new rgbColor(252,215,3);
        this.color = tmpColor;
        this.brightness=50;
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
        double max = 10;
        double random = new Random().nextDouble();
        double result = min + (random * (max - min));
        return result;
    }

    @Override
    public void setColor(rgbColor color, Current current) throws BadArgument {
        if(color.RED<0||color.GREEN<0||color.BLUE<0||color.RED>255||color.GREEN>255|color.BLUE>255) throw new BadArgument();
        this.color = color;
        System.out.println("Set colour to:");
        System.out.println("r: "+color.RED);
        System.out.println("g: "+color.GREEN);
        System.out.println("b: "+color.BLUE);

    }

    @Override
    public rgbColor getColor(Current current) {
        return this.color;
    }



    @Override
    public void setBrightness(int brightness, Current current) throws UnreachableArgument {
        if(brightness<0||brightness>100) throw new UnreachableArgument();
        this.brightness=brightness;
        System.out.println("Set brightness to: " +brightness+" %");
    }

    @Override
    public int getBrightness(Current current) {
        return this.brightness;
    }

    @Override
    public String getManual(Current current) {
        StringBuilder sb = new StringBuilder();
        sb.append("===== LightBulb Manual =====\n");
        sb.append("1. on\n");
        sb.append("2. off\n");
        sb.append("3. getStatus\n");
        sb.append("4. setTimeout.<seconds>\n");
        sb.append("5. getLoad\n");
        sb.append("6. setColor.<red>.<green>.<blue>\n");
        sb.append("7. getColor\n");
        sb.append("8. setBrightness.<brightness>\n");
        sb.append("9. getBrightness\n");
        sb.append("========================");
        return sb.toString();
    }
}
