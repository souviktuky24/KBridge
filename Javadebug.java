//package main;
//import main.Serial;

import java.io.Serializable;
import java.io.*;
import java.util.concurrent.Callable;
import java.lang.Thread;


public class Javadebug {
    public static void main(String[] args){
        System.out.println("Hi Java Debug");
        String a = "u";
        String b = "uu";
        String test = "uu";
        Call c = new Call(); 
        Serial sr = new Serial(a, b, c);
        //Call cl = new Call(a,test);
        System.out.println(sr.getA());
        System.out.println(sr.getB());

        try {
            Call t = sr.getC();
            Thread.sleep(10000);
            String res = (String) t.call();
            StringBuilder sb = new StringBuilder();
            sb.append(res);
            sb.append("testing");
            String f = sb.toString();
            System.out.println(f);
        } 
        catch(Exception e) {

        }
    }
}

class Serial implements Serializable {

    private String a;
    private String b;
    private Call c;

    public Serial(String a, String b, Call c){
        this.a = a;
        this.b = b;
        this.c =c;
    }

    public String getA() {
        return this.a;
    }
    public void setA(String a) {
        this.a = a;
    }
    public String getB() {
        return this.b;
    }
    public void setB(String b) {
        this.b = b;
    }
    public Call getC() {
        return this.c;
    }
    public void setC(Call b) {
        this.c = b;
    }
}


class Call implements Callable {


    @Override
    public Object call() throws Exception 
    { 
     String s = "Hello call";
     return s;
      } 


}
