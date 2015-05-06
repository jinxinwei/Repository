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

	
	//�÷������������el���ʽ����ȡĳ������ֵ����������᲻���ã�
	//��Ҫ��struts�ı�ǩ����ȡĳ������ֵ���Żᴥ���÷����ĵ���
	@Override
	public String convertToString(Map context, Object o) {
		return format.format((Date)o);		
	}
 
}
