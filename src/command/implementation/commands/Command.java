package command.implementation.commands;

public interface Command {
  void execute();

  void undo();
}
