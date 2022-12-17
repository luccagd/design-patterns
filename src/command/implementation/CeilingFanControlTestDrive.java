package command.implementation;

import command.implementation.commands.CeilingFanHighCommand;
import command.implementation.commands.CeilingFanMediumCommand;
import command.implementation.commands.CeilingFanOffCommand;
import command.implementation.commands.GarageDoorDownCommand;
import command.implementation.commands.GarageDoorOpenCommand;
import command.implementation.commands.LightOffCommand;
import command.implementation.commands.LightOnCommand;
import command.implementation.commands.StereoOffCommand;
import command.implementation.commands.StereoOnWithCdCommand;
import command.implementation.invokers.RemoteControl;
import command.implementation.invokers.RemoteControlWithUndo;
import command.implementation.receivers.CeilingFan;
import command.implementation.receivers.GarageDoor;
import command.implementation.receivers.Light;
import command.implementation.receivers.Stereo;

public class CeilingFanControlTestDrive {

  public static void main(String[] args) {
    RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

    CeilingFan ceilingFan = new CeilingFan("Living Room");

    CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
    CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
    CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

    remoteControl.setCommand(0, ceilingFanMedium, ceilingFanOff);
    remoteControl.setCommand(1, ceilingFanHigh, ceilingFanOff);

    remoteControl.onButtonWasPushed(0);
    remoteControl.offButtonWasPushed(0);
    System.out.println(remoteControl);
    remoteControl.undoButtonWasPushed();

    remoteControl.onButtonWasPushed(1);
    System.out.println(remoteControl);
    remoteControl.undoButtonWasPushed();
  }
}
