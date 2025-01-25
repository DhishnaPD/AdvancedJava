package com.dhishna.mvoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ReverseofNumber {
public static void main(String[] args) throws IOException{
BufferedReader reader = new BufferedReader(new 
InputStreamReader(System.in));
System.out.println("Enter the number : ");
long number = Long.parseLong(reader.readLine());
long digit = 0, sum = 0;
while(number > 0) {
digit = number % 10;
number = number / 10;
sum = sum * 10 + digit;
}
System.out.println("The reverse of the number is : "+sum);
}
}
