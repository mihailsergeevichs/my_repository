package my.decided.tasks.level26.lesson15.big01.command;

import my.decided.tasks.level26.lesson15.big01.ConsoleHelper;
import my.decided.tasks.level26.lesson15.big01.CurrencyManipulator;
import my.decided.tasks.level26.lesson15.big01.CurrencyManipulatorFactory;
import my.decided.tasks.level26.lesson15.big01.exception.InterruptOperationException;


/**
 * Created by Overlord on 29.06.15.
 */
class DepositCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException {
        String code =  ConsoleHelper.askCurrencyCode();
        CurrencyManipulator cur = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        String[] arg = ConsoleHelper.getValidTwoDigits(code);
        int k = Integer.parseInt(arg[0]);
        int l = Integer.parseInt(arg[1]);
        cur.addAmount(k,l);
    }
}