package action;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linlin on 2017/10/14.
 */
public class ActionMapping {
    private String name;
    private String className;
    private Map<String,String> map=new HashMap<String, String>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getValue(String key) {
        return map.get(key);
    }

    public void addMap(String key,String vlaue) {
       map.put(key,vlaue);
    }
}
