package bus;

import java.io.Serializable;

public class Phone implements Serializable {
    private int CityCode;
    private int CellCode;

    public int getCellCode() {
        return CellCode;
    }

    public void setCellCode(int cellCode) {
        CellCode = cellCode;
    }

    public int getCityCode() {

        return CityCode;
    }

    public void setCityCode(int cityCode) {
        CityCode = cityCode;
    }

    public Phone()
    {
        this.CityCode=0;
        this.CellCode=0;
    }
    public Phone(int CityC,int CellC)
    {
        this.CityCode=CityC;
        this.CellCode=CellC;
    }

    @Override
    public String toString() {
        return "("+this.getCityCode()+")"+this.getCellCode();
    }
}
