package action;

/**
 * Created by linlin on 2017/10/14.
 */
public class ActionManager {

    public static Action getActionClass(String className) throws Exception {

        Class clazz=null;
        Action action=null;
        clazz=Thread.currentThread().getContextClassLoader()
                .loadClass(className);
        if(clazz==null){
            clazz=Class.forName(className);
        }
        action=(Action)clazz.newInstance();
        return action;
    }
}

