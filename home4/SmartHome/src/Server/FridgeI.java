package Server;

import SmartHome.*;
import com.zeroc.Ice.Current;


import java.util.Random;

public class FridgeI extends DeviceI implements Fridge {

    protected temperature temperature;

    public FridgeI(String name){
        super(SmartHome.deviceType.FRIDGE,name);
        temperature initTemperature = new temperature();
        initTemperature.unit=unit.CELCIUS;
        initTemperature.value=5;
        this.temperature = initTemperature;
    }


    @Override
    public void setTemp(temperature temp, Current current) throws UnreachableArgument {
        switch (temp.unit) {
            case KELVIN: {
                if (274 > temp.value || temp.value > 289) {
                    throw new UnreachableArgument();
                }
                break;
            }
            case CELCIUS: {
                if (1.0 > temp.value || temp.value > 15.0) {
                    throw new UnreachableArgument();
                }
                break;
            }
            case FAHRENHEIT: {
                if (33 > temp.value || temp.value > 59) {
                    throw new UnreachableArgument();
                }
                break;
            }
        }

            System.out.println("Temperature set:"+temp.value+" "+temp.unit);
             this.temperature=temp;





    }

    @Override
    public temperature getTemp(unit unit, Current current) {
        float tmpKel = 0;
        switch (this.temperature.unit){
            case FAHRENHEIT:{
                tmpKel=(this.temperature.value+ (float)460)*(float)(5.00/9.00);
                break;
            }
            case CELCIUS:{
                tmpKel = (this.temperature.value+273);
                break;
            }
            case KELVIN:{
                tmpKel = this.temperature.value;
            }
        }

        switch (unit){
            case CELCIUS:{
                return new temperature((tmpKel-273), SmartHome.unit.CELCIUS);
            }
            case FAHRENHEIT:{
                return new temperature(((float)(9/5)*(tmpKel)-460), SmartHome.unit.FAHRENHEIT);
            }
        }
        System.out.println("Request for frighe temp");
        return new temperature(tmpKel, SmartHome.unit.KELVIN);

    }

    @Override
    public float getHumidity(Current current) {
        Random r = new Random();
        float random = 0 + r.nextFloat() * (0 - 100);
        System.out.println("Request for frighe humidity");
        return -1*random;
    }

    @Override
    public byte[] getImage(int shelf, Current current) throws UnreachableArgument {
        if(shelf<0||shelf>6) throw new UnreachableArgument();
        byte[] b = new byte[256];
        new Random().nextBytes(b);
        System.out.println("Request for frighe image");
        return b;

    }



    @Override
    public String getManual(Current current) {
        StringBuilder sb = new StringBuilder();
        sb.append("===== Fridge Manual =====\n");
        sb.append("1. on\n");
        sb.append("2. off\n");
        sb.append("3. getStatus\n");
        sb.append("4. setTemperature.<value>.<unit>\n");
        sb.append("5. getTemperature.<unit>\n");
        sb.append("6. getImage.<shelf>\n");
        sb.append("7. getHumidity\n");
        sb.append("========================");
        return sb.toString();
    }

}
