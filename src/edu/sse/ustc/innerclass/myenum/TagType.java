package edu.sse.ustc.innerclass.myenum;


public enum TagType
{

    WIFI(1), MOBILEPHONE(2), LAPTOP(3), PAD(4), RFID(5), STA(6);

    private Integer value = null;

    private TagType(Integer value)
    {
        this.value = value;
    }

    public static TagType findByValue(String value)
    {
        switch (value)
        {
            case "WIFI":
            case "wifi":
                return WIFI;
            case "MOBILEPHONE":
            case "mobilephone":
                return MOBILEPHONE;
            case "LAPTOP":
            case "laptop":
                return LAPTOP;
            case "PAD":
            case "pad":
                return PAD;
            case "RFID":
            case "rfid":
                return RFID;
            case "STA":
            case "sta":
                return STA;
            default:
                return null;
        }
    }

    public static TagType findByValue(int value)
    {
        switch (value)
        {
            case 1:
                return WIFI;
            case 2:
                return MOBILEPHONE;
            case 3:
                return LAPTOP;
            case 4:
                return PAD;
            case 5:
                return RFID;
            case 6:
                return STA;
            default:
                return null;
        }
    }

    public Integer getValue()
    {
        return value;
    }

    public void setValue(Integer value)
    {
        this.value = value;
    }

}
