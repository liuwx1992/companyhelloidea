package com.practice.thread;

/**
 * @Description:不可变对象
 * @Author: liuweixin
 * @Date: 2019/3/26
 * @Time: 11:27
 */
public class ImmutableObjectPerson {
    private final String name;
    private final String sex;

    public ImmutableObjectPerson(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public static void main(String[] args) {
    }

}
