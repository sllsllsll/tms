package action;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by linlin on 2017/10/14.
 */
public class ActionMappingManager {
    private Map<String, ActionMapping> maps = new HashMap<String, ActionMapping>();

    public ActionMapping getValue(String key) {
        return maps.get(key);
    }

    public void addMaps(String key, ActionMapping value) {
        maps.put(key, value);
    }

    public ActionMappingManager(String[] files) throws Exception {

for(String path:files){
    init(path);
}
    }
    public void init(String path) throws Exception {
        InputStream is = this.getClass().getResourceAsStream("/" + path);
        Document doc = new SAXReader().read(is);
        Element root = doc.getRootElement();
        Element actions = (Element) root.elements("actions").iterator().next();
        for (Iterator<Element> action = actions.elementIterator("action"); action.hasNext(); ) {
            Element actionnext = action.next();
            ActionMapping am = new ActionMapping();
            am.setName(actionnext.attributeValue("name"));
            am.setClassName(actionnext.attributeValue("class"));
            for (Iterator<Element> result = actionnext.elementIterator("result"); result.hasNext(); ) {
                Element resultnext = result.next();
                String name = resultnext.attributeValue("name");
                String value = resultnext.getText();
                if (name == null || "".equals(name)) {
                    name = "success";

                }
                am.addMap(name, value);

            }

        }

    }
}
