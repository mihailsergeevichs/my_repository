package my.decided.tasks.level26.lesson15.big01.command;

import my.decided.tasks.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by Overlord on 29.06.15.
 */
interface Command {
        void execute() throws InterruptOperationException;
}
