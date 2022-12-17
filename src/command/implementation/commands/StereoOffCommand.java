package command.implementation.commands;

import command.implementation.receivers.Stereo;

public class StereoOffCommand implements Command {
  Stereo stereo;

  public StereoOffCommand(Stereo stereo) {
    this.stereo = stereo;
  }

  @Override
  public void execute() {
    stereo.off();
  }

  @Override
  public void undo() {
    stereo.on();
    stereo.setCd();
    stereo.setVolume(11);
  }
}
