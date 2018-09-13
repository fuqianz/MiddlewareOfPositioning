package edu.sse.ustc.restful.resource.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParameterControl
{
    public static boolean intInputError(int x)
    {
        if (x < 0)
        {
            return true;
        }

        return false;
    }

    public static boolean stringInputError(String str)
    {
        if (str == null)
        {
            return true;
        }
        return false;
    }

    public static boolean timeInputError(String time)
    {
        String[] str = time.split(" ");

        if (str.length == 2)
        {
            String[] s1 = str[0].split("-");
            String[] s2 = str[1].split(":");

            if (s1.length == 3 && s2.length == 3 && !s1[1].equals(""))
            {
                int month = Integer.parseInt(s1[1]);

                if (month > 0 && month < 13 && !s1[2].equals(""))
                {
                    int day = Integer.parseInt(s1[2]);
                    if (day > 0 && day < 32 && !s2[0].equals(""))
                    {
                        int hour = Integer.parseInt(s2[0]);
                        if (hour >= 0 && hour < 24 && !s2[1].equals(""))
                        {
                            int minute = Integer.parseInt(s2[1]);
                            if (minute >= 0 && minute < 60 && !s2[2].equals(""))
                            {
                                int second = Integer.parseInt(s2[2]);
                                if (second >= 0 && second < 60)
                                {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean spaceTypeInputError(int type)
    {
        if (type == 0 || type == 1 || type == 2)
        {
            return false;
        }
        return true;
    }

    public static String getMac(String ap_Mac)
    {
        if (ap_Mac.indexOf(":") != -1 && ap_Mac.length() == 17)
        {
            return ap_Mac;
        }

        if (ap_Mac.length() != 12)
        {
            return null;
        }

        String apMac = ap_Mac.substring(0, 2);
        apMac = apMac + ":";
        apMac = apMac + ap_Mac.substring(2, 4);
        apMac = apMac + ":";
        apMac = apMac + ap_Mac.substring(4, 6);
        apMac = apMac + ":";
        apMac = apMac + ap_Mac.substring(6, 8);
        apMac = apMac + ":";
        apMac = apMac + ap_Mac.substring(8, 10);
        apMac = apMac + ":";
        apMac = apMac + ap_Mac.substring(10, 12);

        return apMac;
    }

    public static void main(String[] args)
    {
        System.out.println(timeInputError("2010-10-20+10:08:20"));
        System.out.println(timeInputError("0010-10-20+10:08:20"));
        System.out.println(timeInputError("0010-0-20+10:08:20"));
    }
}