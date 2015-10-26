package my.decided.tasks.level26.lesson15.big01;


import my.decided.tasks.level26.lesson15.big01.command.CommandExecutor;
import my.decided.tasks.level26.lesson15.big01.exception.InterruptOperationException;


import java.io.IOException;
import java.util.Locale;

/**
 * Created by Overlord on 29.06.15.
 */
public class CashMachine
{
    public static void main(String[] args) throws IOException, InterruptOperationException {
        Locale.setDefault(Locale.ENGLISH);
        Operation operation;
        do
        {
            operation = ConsoleHelper.askOperation();
            CommandExecutor.execute(operation);
        }
        while (!operation.equals(Operation.EXIT));
    }
}