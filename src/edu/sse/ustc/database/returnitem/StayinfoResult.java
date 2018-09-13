package edu.sse.ustc.database.returnitem;

public class StayinfoResult
{
    private double stayinfoave;
    private double stayinfovar;

    public double getStayinfoave()
    {
        return stayinfoave;
    }

    public void setStayinfoave(double stayinfoave)
    {
        this.stayinfoave = stayinfoave;
    }

    public double getStayinfovar()
    {
        return stayinfovar;
    }

    @Override
    public String toString()
    {
        return "StayinfoResult [stayinfoave=" + stayinfoave + ", stayinfovar=" + stayinfovar + "]";
    }

    public void setStayinfovar(double stayinfovar)
    {
        this.stayinfovar = stayinfovar;
    }

}
