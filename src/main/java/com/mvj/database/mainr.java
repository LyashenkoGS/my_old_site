package com.mvj.database;

/**
 * Created by sokol on 12.09.2015.
 */
public class mainr {
    public static void main(String[] args) {
        TODOdbWorker todOdbWorker = new TODOdbWorker();

        //todOdbWorker.addTODO("xui", "pizda");
        todOdbWorker.deleteTODO("xui");
        //todOdbWorker.addTODO("xui75", "12pizda");
        //System.out.println(todOdbWorker.getTODO());
    }
}
