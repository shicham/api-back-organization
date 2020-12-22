package com.crm.commun.tools;

import com.crm.commun.exceptions.ServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class StringTools {

    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * Convert Object to JsonString
     * @param obj
     * @return String
     */
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean isStringInt(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }

    public static boolean isEmpty(Long value) {
        return value == null;
    }
    public static boolean isEmpty(Date value) {
        return value == null;
    }
    public static boolean isEmpty(String value) {
        return value == null || value.trim().length() == 0;
    }
    public static boolean isNotEmpty(String value){
        return !isEmpty(value);
    }
    public static boolean isNotEmpty(Long value){
        return !isEmpty(value);
    }
    public static boolean isNotEmpty(Date value){
        return !isEmpty(value);
    }
    public static Date toDate(String strDate,String format) throws ServiceException {
        try {
            DateFormat df = new SimpleDateFormat(format);
            df.setLenient(false);
            return df.parse(strDate);
        } catch (DateTimeParseException e) {
            throw new ServiceException("invalide date : " + strDate);
        }catch (ParseException e) {
            throw new ServiceException("invalide date : " + strDate);
        }

    }

    public static String toDate(Date strDate)  {
        return new SimpleDateFormat(YYYY_MM_DD).format(strDate);
    }

    public static long getDifferenceDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
