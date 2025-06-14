/* CellularPlane
 * Description:
 * version: v1.0
 * Author: Dan Morozov, Idan Hamias
 * Status: Not finished
*/

package pack;
import java.lang.classfile.MethodBuilder;
import java.util.*;

public class CellularPlane {
    private int _NamePack;
    private int _Min;
    private int _MB;
    private float _Price;
    private int _OverMin;
    private int _OverMB;



    public String toString() {
        return "CellularPlane{" +
                "_NamePack=" + _NamePack +
                ", _Min=" + _Min +
                ", _MB=" + _MB +
                ", _Price=" + _Price +
                '}';
    }


    public CellularPlane(int NamePack, int Min, int MB, float Price){
        _NamePack = NamePack;
        _Min = Min <= 0 ? 0 : Min;
        _MB = MB <= 0 ? 0 : MB;
        _Price = Price <= 0 ? 0 : Price;
    }

    public String PriceForMonth(int UsedMin, int UsedMB) {
        _OverMin = UsedMB > _Min ? 0 : UsedMin - _Min;
        _OverMB = UsedMB > _MB ? 0 : UsedMB - _MB;
        double PriceForMonth = _Price + (_OverMin * 0.3) + (_OverMB * 0.05);
        return "Price for the month: " + PriceForMonth;
    }

    public String PriceForMonth(int UsedMB, int UsedMin, int UsedDay) {
        float NeedbeUsed = 28 / UsedDay;
        float priceFUsedDay = NeedbeUsed * _Price;
        _OverMin = UsedMB > _Min ? 0 : UsedMin - _Min;
        _OverMB = UsedMB > _MB ? 0 : UsedMB - _MB;
        double PriceForMonth = priceFUsedDay + (_OverMin * 0.3) + (_OverMB * 0.05);
        return "Price for the month: " + PriceForMonth;
    }
    public void Same(CellularPlane other) {
        if(_MB == other.getMB())
        {System.out.println("The MB are the same");}
        if(_Min == other.getMin())
        {System.out.println("The Min are the same");}
        if(_Price == other.getPrice())
        {System.out.println("The Price are the same");}
    }

    public String ExpensiveByPrice(CellularPlane other) {
        if(_Price > other.getPrice()) {
            return _NamePack + "is more expensive than " + other.getNamePack();
        } else if (_Price < other.getPrice()) { 
            return other.getNamePack() + "is more expensive than " + _NamePack;
        } else {
            return "Both plans have the same price";
        }
    }

    public String ExpensiveByMinandMB(CellularPlane other) {
        if(_Min > other.getMin() && _MB > other.getMB()) {
            return _NamePack + " is more expensive than " + other.getNamePack();
        } else if (_Min < other.getMin() && _MB < other.getMB()) {
            return other.getNamePack() + " is more expensive than " + _NamePack;
        } else {
            return "Both plans have the same price";
        }
    }

    public float getPrice(){
        return _Price;
    }
    public int getMin(){
        return _Min;
    }
    public int getMB(){
        return _MB;
    }
    public int getNamePack(){
        return _NamePack;
    }
}
