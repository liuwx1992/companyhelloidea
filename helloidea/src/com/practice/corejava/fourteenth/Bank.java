package com.practice.corejava.fourteenth;

import java.util.Arrays;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/22
 * @Time: 11:28
 */
public class Bank {

    private static double[] accounts;

    public Bank(int n,double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
    }

    public synchronized void transfer(int from,int to,double amount) throws InterruptedException {
        while (accounts[from] < amount){
            wait();
        }
        accounts[from] -= amount;
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.println("Total Balance: X10.2fXn"+getTotalBalance());
        notifyAll();
    }

    /**
     *  Gets the sum of all account balances.
     *  return the total balance
     * */
    public synchronized double getTotalBalance(){
        double sum = 0;
        for (double d : accounts){
            sum += d;
        }
        return sum;
    }

    /**
     *  Gets the number of accounts in the bank.
     *  ©return the number of accounts
     *
     * */
    public int size(){
        return accounts.length;
    }

}
