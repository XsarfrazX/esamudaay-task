package com.sarfraz.task.domain;

import org.javatuples.Pair;
import org.springframework.stereotype.Component;

import java.util.HashMap;
//TODO: make slab configurable
@Component
public class DeliveryFreeUtil {

    private static final long DELIVERY_FREE_0_TO_10_KM = 5000;
    private static final long DELIVERY_FREE_10_TO_20_KM = 10000;
    private static final long DELIVERY_FREE_20_TO_50_KM = 50000;
    private static final long DELIVERY_FREE_50_KM = 100000;

    private  HashMap<Long, Pair<Long,Long>> deliverySlab= new HashMap<>();

    DeliveryFreeUtil() {


        deliverySlab.put(50L, new Pair<Long,Long>(0L,10000L));

    }

    /**
     *
     * @param distance distance in meters
     * @return delivery free in paisas
     */
    public long getDeliveryFee(long distance) {

        if (distance >= 0 && distance <= 10000) {
            return DELIVERY_FREE_0_TO_10_KM;
        }
        else if (distance >= 10000 && distance < 20000) {
            return DELIVERY_FREE_10_TO_20_KM;
        }
        else if(distance >= 20000 && distance < 50000) {
            return DELIVERY_FREE_20_TO_50_KM;
        }
        else {
            return DELIVERY_FREE_50_KM;
        }



    }


}
