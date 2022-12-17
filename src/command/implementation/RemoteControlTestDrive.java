package command.implementation;

import command.implementation.commands.CeilingFanOffCommand;
import command.implementation.commands.CeilingFanHighCommand;
import command.implementation.commands.GarageDoorDownCommand;
import command.implementation.commands.GarageDoorOpenCommand;
import command.implementation.commands.LightOffCommand;
import command.implementation.commands.LightOnCommand;
import command.implementation.commands.StereoOffCommand;
import command.implementation.commands.StereoOnWithCdCommand;
import command.implementation.receivers.CeilingFan;
import command.implementation.receivers.GarageDoor;
import command.implementation.receivers.Light;
import command.implementation.receivers.Stereo;
import command.implementation.invokers.RemoteControl;

public class RemoteControlTestDrive {

  public static void main(String[] args) {
    RemoteControl remoteControl = new RemoteControl();

    Light livingRoomLight = new Light("Living Room");
    Light kitchenLight = new Light("Kitchen");
    CeilingFan ceilingFan = new CeilingFan("Living Room");
    GarageDoor garageDoor = new GarageDoor();
    Stereo stereo = new Stereo("Living Room");


    LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
    LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
    LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
    LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

    CeilingFanHighCommand ceilingFanOn = new CeilingFanHighCommand(ceilingFan);
    CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

    GarageDoorOpenCommand garageDoorUp = new GarageDoorOpenCommand(garageDoor);
    GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);

    StereoOnWithCdCommand stereoOnWithCd = new StereoOnWithCdCommand(stereo);
    StereoOffCommand stereoOff = new StereoOffCommand(stereo);

    remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
    remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
    remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff);
    remoteControl.setCommand(3, stereoOnWithCd, stereoOff);

    System.out.println(remoteControl);
    remoteControl.onButtonWasPushed(0);
    remoteControl.offButtonWasPushed(0);
    remoteControl.onButtonWasPushed(1);
    remoteControl.offButtonWasPushed(1);
    remoteControl.onButtonWasPushed(2);
    remoteControl.offButtonWasPushed(2);
    remoteControl.onButtonWasPushed(3);
    remoteControl.offButtonWasPushed(3);
  }
}
