package edu.sse.ustc.innerclass.myenum;

public enum CoordinateType
{

    RCTANGULAR(1), SPACE_RCTANGULAR(2);

    private Integer value;

    private CoordinateType(Integer value)
    {
        this.value = value;
    }

    public static CoordinateType findByValue(String value)
    {
        switch (value)
        {
            case "RCTANGULAR":
            case "rctangular":
                return RCTANGULAR;
            case "SPACE_RCTANGULAR":
            case "space_rctangular":
                return SPACE_RCTANGULAR;
            default:
                return null;
        }
    }

    public static CoordinateType findByValue(int value)
    {
        switch (value)
        {
            case 1:
                return RCTANGULAR;
            case 2:
                return SPACE_RCTANGULAR;
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
