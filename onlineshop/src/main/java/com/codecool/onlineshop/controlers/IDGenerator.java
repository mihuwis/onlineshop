package com.codecool.onlineshop.controlers;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class IDGenerator{

    private List<Integer> idPool = new ArrayList<Integer>();

    public Integer generateID() throws Exception {
        boolean generatingID = true;
        Integer randomID;
        int min = 1000;
        int max = 9999;

        while(generatingID) {
            randomID = ThreadLocalRandom.current().nextInt(min, max + 1);
            if (!idPool.contains(randomID)) {
                idPool.add(randomID);
                generatingID = false;
                return randomID;
            }
        }
        throw new Exception();
    }
}
