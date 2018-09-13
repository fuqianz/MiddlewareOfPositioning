package edu.sse.ustc.innerclass.myenum;

public enum APType
{

    NORMAL(1), ANCHOR(2), RFID(3);
    private Integer value;

    private APType(Integer value)
    {

        this.value = value;
    }

    public static APType findByValue(String value)
    {
        switch (value)
        {
            case "NORMAL":
            case "normal":
                return NORMAL;
            case "ANCHOR":
            case "anchor":
                return ANCHOR;
            case "RFID":
            case "rfid":    
                return RFID;
            default:
                return null;
        }
    }

    public static APType findByValue(int value)
    {
        switch (value)
        {
            case 1:
                return NORMAL;
            case 2:
                return ANCHOR;
            case 3:
                return RFID;
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
