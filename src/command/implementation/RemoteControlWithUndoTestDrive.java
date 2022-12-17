package command.implementation;

import command.implementation.commands.LightOffCommand;
import command.implementation.commands.LightOnCommand;
import command.implementation.invokers.RemoteControlWithUndo;
import command.implementation.receivers.Light;

public class RemoteControlWithUndoTestDrive {

  public static void main(String[] args) {
    RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

    Light livingRoomLight = new Light("Living Room");

    LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
    LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

    remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);

    remoteControl.onButtonWasPushed(0);
    remoteControl.offButtonWasPushed(0);
    System.out.println(remoteControl);
    remoteControl.undoButtonWasPushed();
    remoteControl.offButtonWasPushed(0);
    remoteControl.onButtonWasPushed(0);
    System.out.println(remoteControl);
    remoteControl.undoButtonWasPushed();
  }
}
