package my.decided.tasks.level31.lesson15.big01.command;

import my.decided.tasks.level31.lesson15.big01.ConsoleHelper;

public class ExitCommand implements Command {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("До встречи!");
    }
}
