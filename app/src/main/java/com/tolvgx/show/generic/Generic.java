package com.tolvgx.show.generic;

public class Generic<T> {
    //泛型
    public static void main(String[] args){
        Generic<String> generic = new Generic<>();
        generic.setKey("xxx");

        System.out.println(generic.getKey());

        generic.genericMethod("23");
    }

    private T key;

    private T getKey(){
        return key;
    }

    private void setKey(T t){
        this.key = t;
    }

    //泛型方法
    private <E> void genericMethod(E e){

        System.out.println(e);
    }
}
