package my.decided.tasks.level22.lesson05.home01;

public class TooShortStringSecondThreadException extends RuntimeException {
    public TooShortStringSecondThreadException(Exception e) {
        super.initCause(e);
    }
}