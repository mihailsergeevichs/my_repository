package my.decided.tasks.level26.lesson15.big01.command;

import my.decided.tasks.level26.lesson15.big01.ConsoleHelper;
import my.decided.tasks.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by Overlord on 29.06.15.
 */
class ExitCommand implements Command {

        @Override
        public void execute() throws InterruptOperationException {
            ConsoleHelper.writeMessage("Really want to exit?");

            if (ConsoleHelper.readString().equalsIgnoreCase("yes"))
                ConsoleHelper.writeMessage("Thank you. Good Bye.");
        }

}
