package com.practice.thread;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/26
 * @Time: 20:32
 */
public class MatchCounter implements Callable<Integer> {
    private File directory;
    private String keyword;

    public MatchCounter(File directory, String keyword) {
        this.directory = directory;
        this.keyword = keyword;
    }

    @Override
    public Integer call() {
        int count = 0;
        try {
            File[] files = directory.listFiles();
            List<Future<Integer>> results = new ArrayList<>();
            for(File file : files){
                if(file.isDirectory()){
                    MatchCounter counter = new MatchCounter(file,keyword);
                    FutureTask<Integer> task = new FutureTask<>(counter);
                    results.add(task);
                    Thread t = new Thread(task);
                    t.start();
                }else {
                    if(search(file)){
                        count++;
                    }
                }
            }
            for (Future<Integer> future : results){
                count += future.get();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    /**
     * Searches a file for a given keyword.
     * @param file the file to search
     * ©return true if the keyword is contained in the file V
     */
    public boolean search(File file){
        try {
            try (Scanner in = new Scanner(file,"UTF-8")){
                Boolean found = false;
                while (!found && in.hasNextLine()){
                    String nextLine = in.nextLine();
                    if(nextLine.contains(keyword)){
                        found = true;
                    }
                }
                return found;
            }
        }catch (IOException e){
            return false;
        }
    }
}
