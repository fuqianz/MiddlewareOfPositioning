package edu.sse.ustc.innerclass.myenum;

public enum DevStatus
{

    ONLINE(1), // online
    OFFLINE(2);// offline
    private Integer value = null;

    private DevStatus(Integer value)
    {
        this.value = value;
    }

    public static DevStatus findByValue(String value)
    {
        switch (value)
        {
            case "ONLINE":
            case "online":
                return ONLINE;
            case "OFFLINE":
            case "offline":
                return OFFLINE;
            default:
                return null;
        }
    }

    public static DevStatus findByValue(int value)
    {
        switch (value)
        {
            case 1:
                return ONLINE;
            case 2:
                return OFFLINE;
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
