package org.example;

import java.util.HashMap;
import java.util.Map;

public class abc {

    public static void main(String[] args) {
        System.out.println("Dipak Jagtap");
        HashMap<Integer,String> en=new HashMap<Integer,String>();
        en.put(1,"dipak");
        en.put(2,"jagtap");
        en.put(3,"kanadi");
       // System.out.println(en);
        for(Map.Entry<Integer,String> en1: en.entrySet()){
            if(en1.getValue().contains("dipak")){
                System.out.println(en1.getValue()+"  "+en1.getKey());
            }

        }

    }
}
