package my.decided.tasks.level26.lesson15.big01.command;

import my.decided.tasks.level26.lesson15.big01.Operation;
import my.decided.tasks.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Overlord on 29.06.15.
 */
public class CommandExecutor
{
    private static Map<Operation, Command> map = new HashMap<>();
    static
    {
        map.put(Operation.INFO, new InfoCommand());
        map.put(Operation.DEPOSIT, new DepositCommand());
        map.put(Operation.WITHDRAW, new WithdrawCommand());
        map.put(Operation.EXIT, new ExitCommand());
    }

    public static final void execute(Operation operation) throws InterruptOperationException
    {
        map.get(operation).execute();
    }

    public CommandExecutor()
    {
    }

}