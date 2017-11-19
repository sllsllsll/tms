package cn.happy.l_converter;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import org.apache.struts2.util.StrutsTypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by linlin on 2017/10/12.
 */
public class DateConverter2 extends StrutsTypeConverter{

   private static List<SimpleDateFormat> list=new ArrayList<SimpleDateFormat>();
   static {
       list.add(new SimpleDateFormat("yyyy/MM/dd"));
       list.add(new SimpleDateFormat("yyyy-MM-dd"));
       list.add(new SimpleDateFormat("yyyyMMdd"));
   }

    public Object convertFromString(Map context, String[] values, Class toClass) {
       String date=values[0];
       for(SimpleDateFormat item:list)
           try {
               return item.parse(date);
           } catch (ParseException e) {
           continue;
           }
throw  new TypeConversionException();
    }

    public String convertToString(Map map, Object o) {
       Date date=(Date) o;
        return new SimpleDateFormat("全局yyyy年MM月dd日 hh:mm:ss").format(o);
    }
}
