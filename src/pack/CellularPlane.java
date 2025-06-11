/* CellularPlane
 * Description:
 * version: v1.0
 * Author: Dan Morozov, Idan Hamias
 * Status: Not finished
*/

package pack;
import java.util.*;

public class CellularPlane {
    private String _namePack;
    private double _price;
    private int _numFmin;//Number of browsing and Num of MB
    private int _numFMB;
    private double _overFmin;//Over of minutes
    private double _overFmb;//Over of MB


    private double _priceFminOver;
    private double _priceFmbOver;

    // the constructor of the CellularPlane class
    public CellularPlane(String namePack)
    {   
        _namePack = namePack;
        Checker(namePack);
       }
    
    public void Checker(String namePack) {
        if(namePack.toLowerCase().equals("basic")){
            _numFMB = 2000;
            _numFmin = 200;
            _price = 19.90;
        }
        else if(namePack.toLowerCase().equals("premium")){
            _numFMB = 5000;
            _numFmin = 500;
            _price = 29.90;
        }
        else if(namePack.toLowerCase().equals("unlimited")){
            _numFMB = 10000;
            _numFmin = 1000;
            _price = 49.90;
        }else{
            _numFMB = 2000;
            _numFmin = 200;
            _price = 19.90;

        }
    }

    public String PriceperMonth(int numFmin, int numFMB){

        return "";
    }
    public String PriceperMonth(int numFmin, int numFMB , int UsedDays) {
        int UsedMIN = numFmin;
        int UsedMB = numFMB;

        double DaysFMounth = 28.0 / UsedDays;
        double PricePerDay = _price * DaysFMounth;

        double Tempmin = _numFmin * DaysFMounth;// number of minutes needed be used
        double TempMB = _numFMB * DaysFMounth; // number of MB needed be used

        if(UsedMIN > Tempmin){
            _overFmin = UsedMIN - Tempmin;
            _priceFminOver = _overFmin * 0.3;
        } else {
            _overFmin = 0;
            _priceFminOver = 0;
        }

        if(UsedMB > TempMB){
            _overFmb = UsedMB - TempMB;
            _priceFmbOver = _overFmb * 0.05;
        } else {
            _overFmb = 0;
            _priceFmbOver = 0;
        }
        _price = PricePerDay + _priceFminOver + _priceFmbOver;

        return "The price for the month is: "+ _price + "$";
    }

    public String toString(){
        return "Price:"+_price+"$" +"\n"+
        "Number of minutes:"+_numFmin+" min" +"\n"+
        "Number of MB:"+_numFMB+" MB"+'\n'+
        "Price per minute of call beyound the limit:"+_priceFminOver+"$" +'\n'+
        "Price per MB beyound the limit:"+_priceFmbOver+"$";

    }
    public String getNamePack() {
        return _namePack;
    }
    public double getPrice() {
        return _price;
    }
    public int getNumFmin() {
        return _numFmin;
    }
    public int getNumFMB() {
        return _numFMB;
    }
    
    public void setNamePack(String namePack) {
        _namePack = namePack;
        Checker(namePack);
    }
}
