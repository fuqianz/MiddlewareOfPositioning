package edu.sse.ustc.innerclass.myenum;

public enum MapFormat
{

    JPEG(1), BMP(2), GIF(3), PNG(4), PSD(5);

    private Integer value = null;

    private MapFormat(Integer value)
    {
        this.value = value;
    }

    public static MapFormat findByValue(String value)
    {
        switch (value)
        {
            case "jpeg":
            case "JPEG":
                return JPEG;
            case "BMP":
            case "bmp":
                return BMP;
            case "GIF":
            case "gif":
                return GIF;
            case "PNG":
            case "png":
                return PNG;
            case "PSD":
            case "psd":
                return PSD;
            default:
                return null;
        }
    }

    public static MapFormat findByValue(int value)
    {
        switch (value)
        {
            case 1:
                return JPEG;
            case 2:
                return BMP;
            case 3:
                return GIF;
            case 4:
                return PNG;
            case 5:
                return PSD;
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
