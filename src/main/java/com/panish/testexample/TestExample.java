package com.panish.testexample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestExample {

    private static final List<String> formats;

    static {
        // TODO Auto-generated constructor stub
        formats = new ArrayList<String>();

        // this is the format Collaborus saves its dates
        formats.add("yyyy-MM-dd HH:mm:ssZ");
        formats.add("yyyy-MM-dd HH:mm:ss");
        formats.add("yyyy-MM-dd hh:mm:ss a");
        formats.add("yyyy-MM-dd");
        formats.add("dd/MM/yy");
        formats.add("dd/MM/yyyy");
        formats.add("d/MM/yy");
        formats.add("d/MM/yyyy");
        formats.add("dd/M/yy");
        formats.add("dd/M/yyyy");
        formats.add("d/M/yy");
        formats.add("d/M/yyyy");
        formats.add("ddMMyy");
        formats.add("ddMMyyyy");
        formats.add("MM/dd/yyyy");

    }

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date);
        ///System.out.println(date.getTimezoneOffset());
        //System.out.println(date.toString());

        Date converted = convertTimezone();
        System.out.println("---------- Converted ----------");
        System.out.println(converted);
    }

    public static Date convertTimezone() {

        String fromTimeZone = "SG";
        String toTimezone = "AU";
        Date date = new Date();
        String pattern = "yyyy-MM-dd HH:mm:ss";

        String fromZoneId = null, toZoneId = null;
        if (fromTimeZone.equalsIgnoreCase(toTimezone)) {
            return date;
        } else {
                fromZoneId = "Asia/Singapore"; //timeZoneProps.getProperty(fromTimeZone);
                toZoneId = "Australia/Sydney"; //timeZoneProps.getProperty(toTimezone);
                if(fromZoneId != null && (toTimezone != null)) {
                    final ZoneId id = ZoneId.systemDefault();
                    ZonedDateTime zonedDT = ZonedDateTime.ofInstant(date.toInstant(), id);
                    ZonedDateTime zonedDT2 = zonedDT.withZoneSameLocal(ZoneId.of(fromZoneId));
                    ZonedDateTime Au = zonedDT2.withZoneSameInstant(ZoneId.of(toZoneId));
                    String ds = DateTimeFormatter.ofPattern(pattern).format(Au);
                    Date convertedDate = convertToDate(ds);
                    return convertedDate;
                }else{
                    return null;
                }

        }
    }

    public static Date convertToDate(String value) {
        Date validDate = null;
        Boolean isValid = false;

        if (value == null || value.isEmpty()) {
            return null;
        }


        for (String fs : formats) {
            SimpleDateFormat f = null;
//            if(CountryCode.Thailand.equals(country)) {
//                f = new SimpleDateFormat(fs, new Locale("th", "TH"));
//            } else {
            f = new SimpleDateFormat(fs);
//            }
            try {
                f.setLenient(false);
                validDate = f.parse(value);

                if (f.toPattern().endsWith("Z") && validDate != null) {
                    // Z will expand to timezone data so this will never succeed with strict length
                    // checking
                    isValid = true;
                } else {
                    // take care of strict pattern by checking length
                    if (value.trim().length() == f.toPattern().length()) {
                        isValid = true;
                    } else if(value.trim().contains("AM") || value.trim().contains("PM") ) {
                        isValid = true;
                    }else{
                        isValid = false;
                    }
                }

            }
            catch (ParseException e) {
                isValid = false;
            }
            if (isValid) {
                return validDate;
            }
        }

        if (!isValid) {
        }

        return null;
    }
}
