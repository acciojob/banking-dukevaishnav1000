package com.driver;

import java.util.Arrays;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
    this.balance=balance;
    this.name=name;
    this.minBalance=minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception {
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if (sum >= 0 && digits > 0)
        {  String temp="";
            int arr[]=new int[digits];
            if (sum <= 9) {
                arr[arr.length-1]=sum;
                return Arrays.toString(arr);
            }
         else {
                int sumNow=9;
                arr[digits-1]=9;
                int count=digits-2;
                int diff=sum;
                while(sumNow<sum && arr[0]!=9)
                {       diff=sum-sumNow;
                    if(diff>9)
                    {
                        arr[count]=9;
                        count--;
                        sumNow+=9;
                    }
                    else
                    {
                        arr[count]=diff;
                        sumNow+=diff;
                        break;
                    }
                }
                if(sum>sumNow)
                    throw new Exception("Account Number can not be generated");
                else
                    return Arrays.toString(arr);
        }
    }
    else
        throw new Exception("Account Number can not be generated");

    }

    public void deposit(double amount) {
        //add amount to balance
        balance+=amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(amount<=balance-minBalance)
            this.balance-=amount;
        else
                throw new Exception("Insufficient Balance");

    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

}