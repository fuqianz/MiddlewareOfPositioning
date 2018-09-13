package edu.sse.ustc.innerclass.myenum;

public enum MapType
{

    NORMAL(1), // normal map
    CASCADE(2);// cascade map

    private Integer value = null;

    private MapType(Integer value)
    {
        this.value = value;
    }

    public static MapType findByValue(String value)
    {
        switch (value)
        {
            case "NORMAL":
            case "normal":
                return NORMAL;
            case "CASCADE":
            case "cascade":
                return CASCADE;
            default:
                return null;
        }
    }

    public static MapType findByValue(int value)
    {
        switch (value)
        {
            case 1:
                return NORMAL;
            case 2:
                return CASCADE;
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
