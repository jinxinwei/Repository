package com.mybos.web.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter {

	private SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {

        Date date = null;  
        String dateString = null;  
        if (values != null && values.length > 0) {  
            dateString = values[0];  
            if (dateString != null) {  
                try {  
                    date = format.parse(dateString);  
                } catch (ParseException e) {  
                    date = null;  
                }  
            }
        }  
        
        return date;  		
		
	}

	
	//该方法，如果是用el表达式来获取某个日期值，这个方法会不调用，
	//需要用struts的标签来获取某个日期值，才会触发该方法的调用
	@Override
	public String convertToString(Map context, Object o) {
		return format.format((Date)o);		
	}
 
}
