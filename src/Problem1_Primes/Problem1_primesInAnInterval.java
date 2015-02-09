package Problem1_Primes;

import java.lang.System;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1_primesInAnInterval {

    public static boolean isPrime(int num){
        for (int i=2;i<Math.sqrt(num)+1;i++) {
            if(num%i==0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner scanNumbers = new Scanner(System.in);

        boundaryNumbers boundary = new boundaryNumbers();

        System.out.println("Input an integer for bottom limit for your range:");
        for(int i = 0;i<1;i++){
            try{
                boundary.setStartNumber(Integer.parseInt(scanNumbers.nextLine()));
            }catch (NumberFormatException nfe){
                System.out.println("Invalid value for bottom limit. Please enter an integer number greater than 0. Try again:");
                i--;
            }
        }

        System.out.println("Input an integer for top limit for your range:");
        for (int i=0;i<1;i++) {
            try {
                boundary.setEndNumber(Integer.parseInt(scanNumbers.nextLine()));
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid value for top limit. Please enter an integer number greater than 0. Try again:");
                i--;
            }
        }

        if(boundary.areBoundariesCorrect()) {
            List<Integer> primes = new ArrayList<Integer>();
            System.out.println("The prime numbers in the range ["+boundary.getStartNumber()+".."+boundary.getEndNumber()+"]");
            for (int i = boundary.getStartNumber(); i < boundary.getEndNumber() + 1; i++) {
                if (i == 2) {
                    primes.add(i);
                } else if (isPrime(i)) {
                    primes.add(i);
                }
            }
            System.out.println(primes.toString());
        }
    }
}
