package com.sarfraz.task.domain;

import com.sarfraz.task.config.Slab;
import com.sarfraz.task.config.SlabConfig;
import org.javatuples.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

//TODO: make slab configurable
@Component
public class DeliveryFreeUtil {



    private static final Logger log = LoggerFactory.getLogger(DeliveryFreeUtil.class);
    private static final long KM_TO_METER_MULTIPLE = 1000L;
    private static final long INR_TO_PAISA_MULTIPLE = 100L;

    @Autowired
    SlabConfig slabConfig;

    @PostConstruct
    void init() {

        log.info("Using Slab Configuration: {}", slabConfig.toString());

    }

    /**
     *
     * @param distance distance in meters
     * @return delivery free in paisas
     */
    public long getDeliveryFee(long distance) {

        List<Slab> slabs =  slabConfig.getSlabs();

        for(Slab slab: slabs) {

            long lowerLimitInMeter =  slab.getLower() * KM_TO_METER_MULTIPLE;
            long upperLimitInMeter = slab.getUpper() * KM_TO_METER_MULTIPLE;
            long deliveryFee = slab.getFee() * INR_TO_PAISA_MULTIPLE;

            // If upper-limit is 0, it means its the highest slab
            if(upperLimitInMeter == 0L) {
                if(distance >= lowerLimitInMeter) {
                    log.info("Delivery slab used is: {}", slab);
                    return deliveryFee;
                }
            }
            if(distance >= lowerLimitInMeter && distance < upperLimitInMeter) {
                log.info("Delivery slab used is: {}", slab);
                return deliveryFee;
            }
        }
        log.error("No delivery slab found");
        return Long.MAX_VALUE;




    }

//    private long kmToMeter(long km) {
//
//    }


}
