package my.decided.tasks.level32.lesson08.bonus01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ItemInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxy, args);
    }
}
