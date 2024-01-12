/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expensetracker;

/**
 *
 * @author bejgum akshara
 */
public class expenseentry {
    private String date;
    private String data;
    private double amt;
    private String type;
     
    
    public expenseentry(String date,String data,double amt,String type){
        this.date=date;
        this.data=data;
        this.amt=amt;
        this.type=type;
    }
    public String getdate(){return date;
}
    public String getdata(){return data;}
    public double getamt(){return amt;}
    public String gettype(){return type;}
}
