package Client;
// **********************************************************************
//
// Copyright (c) 2003-2019 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************



import java.io.BufferedReader;


import SmartHome.*;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Util;
import com.zeroc.Ice.ObjectPrx;
import com.zeroc.Ice.LocalException;

public class JavaClient
{
    public static void main(String[] args)
    {
        int status = 0;
        Communicator communicator = null;

        try {
            // 1. Inicjalizacja ICE
            communicator = Util.initialize(args);

            String input = null;
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

            while(true){
                showManual();
                String[] devicesNames = loadDevicesNames(communicator);
                System.out.print(">>");
                input = br.readLine();
                ObjectPrx obj = null;

                for(String deviceName : devicesNames){
                    if(deviceName.equals(input)){
                        obj = communicator.stringToProxy("device/"+deviceName+":tcp -h localhost -p 10000");
                        break;
                    }
                }

                if(input.equals("list")){
                    loadDevicesNames(communicator);
                } else if(input.equals("help")){
                    showManual();
                } else if(obj == null){
                    System.out.println("No device "+input+" found!");
                }else{
                    control(obj, br);
                }
            }
        } catch (LocalException e) {
            e.printStackTrace();
            status = 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            status = 1;
        }
        if (communicator != null) {
            // Clean up
            //
            try {
                communicator.destroy();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                status = 1;
            }
        }
        System.exit(status);
    }

    private static void showManual(){ }
    private  static String[] loadDevicesNames(Communicator communicator){
        System.out.println("----- Devices: -----");

        ObjectPrx base = communicator.stringToProxy("devices/deviceList:tcp -h localhost -p 10000");
        DeviceListPrx object = DeviceListPrx.checkedCast(base);
        String[] names = object.getList();
        for(String name : names){
            System.out.println(name);
        }
        System.out.println("--------------------");
        return names;
    }

    private  static  void control(ObjectPrx obj, BufferedReader br) throws  Exception{
        switch (DevicePrx.checkedCast(obj).getDeviceType()){
            case FRIDGE:{
                FridgePrx fridge =  FridgePrx.checkedCast(obj);
                System.out.println(fridge.getManual());
                while(true){
                    System.out.print(">>");
                    String[] cmd = br.readLine().split("\\.");
                    if(cmd[0].equals("exit")){ break;}
                    manageFridge(fridge, cmd);
                }
                break;
            }
            case CAMERA:{
                CameraPrx camera =  CameraPrx.checkedCast(obj);
                System.out.println(camera.getManual());
                while(true){
                    System.out.print(">>");
                    String[] cmd = br.readLine().split("\\.");
                    if(cmd[0].equals("exit")) break;
                    manageCamera(camera, cmd);
                }
                break;
            }
            case SWITCH:{
                SwitchPrx mySwitch =  SwitchPrx.checkedCast(obj);
                System.out.println(mySwitch.getManual());
                while(true){
                    System.out.print(">>");
                    String[] cmd = br.readLine().split("\\.");
                    if(cmd[0].equals("exit")) break;
                    manageSwitch(mySwitch, cmd);
                }
                break;

            }
            case LIGHTBULB:{
                LightBulbPrx bulb = LightBulbPrx.checkedCast(obj);
                System.out.println(bulb.getManual());
                while(true){
                    System.out.print(">>");
                    String[] cmd = br.readLine().split("\\.");
                    if(cmd[0].equals("exit")) break;
                    manageLightBulb(bulb, cmd);
                }
                break;

            }

        }

    }

    private static void manageFridge(FridgePrx fridge, String[] cmd) throws UnreachableArgument {
        switch (Integer.valueOf(cmd[0])){
            case 1: {
                //on fridge
                fridge.on();
                break;
            }
            case 2:
                //off fridge
                fridge.off();
                break;
            case 3: {
                //get status
                System.out.println(fridge.getStatus());
                break;
            }
            case 4: {
                //set temp (value,unit)
                temperature temp  = null;
                switch (cmd[2]) {
                    case "C":
                        temp = new temperature(Float.valueOf(cmd[1]), unit.CELCIUS);
                        break;
                    case "K":
                        temp = new temperature(Float.valueOf(cmd[1]), unit.KELVIN);
                        break;
                    case "F":
                        temp = new temperature(Float.valueOf(cmd[1]), unit.FAHRENHEIT);
                        break;
                }
                try{
                    fridge.setTemp(temp);
                }catch (UnreachableArgument e){
                    e.printStackTrace();
                }

                break;

            }
            case 5:{
                temperature temp = null;
                switch (cmd[1]) {
                    case "C":
                        temp = fridge.getTemp(unit.CELCIUS);
                        break;
                    case "K":
                        temp = fridge.getTemp(unit.KELVIN);
                        break;
                    case "F":
                        temp = fridge.getTemp(unit.FAHRENHEIT);
                        break;
                }
                System.out.println(temp.value+" " + temp.unit);

                break;
            }
            case 6:{
                byte[]image = fridge.getImage(Integer.valueOf(cmd[1]));
                int N = (int) Math.sqrt(image.length);
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        System.out.print(Integer.toHexString(Math.abs(image[i*N + j]) % 16) + " ");
                    }
                    System.out.println();
                }
                break;
            }
            case 7:{
                float humidity = fridge.getHumidity();
                System.out.println("Humidity is "+humidity+ " %");
                break;
            }
        }


    }

    private static void manageCamera(CameraPrx camera, String[] cmd){
        switch (Integer.valueOf(cmd[0])){
            case 1: {
                //on fridge
                camera.on();
                break;
            }
            case 2:
                //off fridge
                camera.off();
                break;
            case 3: {
                //get status
                System.out.println(camera.getStatus());
                break;
            }
            case 4: {
                try{
                    camera.setPosition(new cameraPosition(Integer.valueOf(cmd[1]),Integer.valueOf(cmd[2])));
                }catch (UnreachableArgument e){
                    e.printStackTrace();
                }
                break;
            }
            case 5: {
                cameraPosition pos = camera.getPosition();
                System.out.println("vertical:"+pos.verticalPosition);
                System.out.println("horizontal:"+pos.horizontalPosition);
                break;
            }
            case 6:{
                try{
                    camera.setZoom(Integer.valueOf(cmd[1]));
                }catch (UnreachableArgument e){
                    e.printStackTrace();
                }
                break;
            }
            case 7:{
                int zoom = camera.getZoom();
                System.out.println("zoom: "+zoom+"%");
                break;
            }
            case 8:{
                System.out.println("Hello");
                byte[]image = camera.getImage();
                int N = (int) Math.sqrt(image.length);
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        System.out.print(Integer.toHexString(Math.abs(image[i*N + j]) % 16) + " ");
                    }
                    System.out.println();
                }
                break;
            }

        }
    }

    private static void manageSwitch(SwitchPrx mySwitch, String[] cmd){
        switch (Integer.valueOf(cmd[0])) {
            case 1: {
                //on fridge
                mySwitch.on();
                break;
            }
            case 2:
                //off fridge
                mySwitch.off();
                break;
            case 3: {
                //get status
                System.out.println(mySwitch .getStatus());
                break;
            }
            case 4:{
                status status = mySwitch.getStatus();
                if(status.equals(SmartHome.status.ON)){
                    System.out.println("Switch will turn OFF in "+cmd[1]+" sec.");}
                else {System.out.println("Switch will turn ON in "+cmd[1]+" sec.");

                mySwitch.setTimeout(Integer.valueOf(cmd[1]));
                break;
                }
            }
            case 5: {
                double load = mySwitch.getCurrentLoad();
                System.out.println("Device consumes "+load+ " Ampers.");
                break;
            }
        }

    }

    private  static void manageLightBulb(LightBulbPrx bulb, String[] cmd){
        switch (Integer.valueOf(cmd[0])) {
            case 1: {
                //on fridge
                bulb.on();
                break;
            }
            case 2:
                //off fridge
                bulb.off();
                break;
            case 3: {
                //get status
                System.out.println(bulb.getStatus());
                break;
            }
            case 4:{
                status status = bulb.getStatus();
                if(status.equals(SmartHome.status.ON)){
                    System.out.println("Bulb will turn OFF in "+cmd[1]+" sec.");}
                else {System.out.println("Bulb will turn ON in "+cmd[1]+" sec.");

                    bulb.setTimeout(Integer.valueOf(cmd[1]));
                    break;
                }
            }
            case 5: {
                double load = bulb.getCurrentLoad();
                System.out.println("Bulb consumes "+load+ " Ampers.");
                break;
            }
            case 6: {
                int r=Integer.valueOf(cmd[1]);
                int g=Integer.valueOf(cmd[2]);
                int b=Integer.valueOf(cmd[3]);
                rgbColor color = new rgbColor(r,g,b);
                try{
                    bulb.setColor(color);
                    System.out.println("Set colour to:");
                    System.out.println("r: "+color.RED);
                    System.out.println("g: "+color.GREEN);
                    System.out.println("b: "+color.BLUE);
                }catch (BadArgument e){
                    e.printStackTrace();
                }
                break;
            }
            case 7: {
                rgbColor color = bulb.getColor();
                System.out.println("LightBulb colour:");
                System.out.println("r: "+color.RED);
                System.out.println("g: "+color.GREEN);
                System.out.println("b: "+color.BLUE);
                break;
            }

            case 8:{
                int brightness = Integer.valueOf(cmd[1]);
                try{
                    bulb.setBrightness(brightness);
                    System.out.println("Set brightness to: " +brightness+" %");
                }
                catch (UnreachableArgument e){
                    e.printStackTrace();
                }
                break;
            }
            case 9: {
                int brightness = bulb.getBrightness();
                System.out.println("Brightness: " +brightness+" %");
                break;
            }
        }
    }

}
