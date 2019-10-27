package com.soo.test2.mapper;

import java.util.Random;

public class test {

  public static void main(String[] args) {
//    String key = new TempKey();
//    getKey(50, false);
    String key = new TempKey().getKey(50, false);
    System.out.println();
  }
  
  public class TempKey {
    
    private boolean lowerCheck;
    private int size;
    
    public String getKey(int size, boolean lowerCheck) {
        this.size = size;
        this.lowerCheck = lowerCheck;
        return init();
    }
    
    private String init() {
        Random ran = new Random();
        StringBuffer sb = new StringBuffer();
        int num = 0;
        do {
            num = ran.nextInt(75)+48;
            if((num>=48 && num<=57) || (num>=65 && num<=90) || (num>=97 && num<=122)) {
                sb.append((char)num);
            }else {
                continue;
            }
        } while (sb.length() < size);
        if(lowerCheck) {
            return sb.toString().toLowerCase();
        }
        return sb.toString();
    }
    
}
}
