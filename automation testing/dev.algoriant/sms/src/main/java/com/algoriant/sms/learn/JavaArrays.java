package com.algoriant.sms.learn;

public class JavaArrays {
        public static void main(String args[]){

            int a[]=new int[5];//declaration and instantiation
            String[] myString=new String[3];
            myString[0]="hi";
            myString[1]="hello";
            myString[2]="hi";
            a[0]=10;//initialization
            a[1]=20;
            a[2]=70;
            a[3]=40;
            a[4]=50;

//printing array
            for(int i=0;i<a.length;i++)//length is the property of array
                 {
                System.out.println(a[i]);
        }
        for(String n:myString)
        {
            System.out.println(n);
        }
    }

}
