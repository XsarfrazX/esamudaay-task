package com.sarfraz.task.config;


import org.springframework.boot.context.properties.ConfigurationProperties;


import java.util.List;


@ConfigurationProperties(prefix = "slab-config")
public class SlabConfig {


    List<Slab> slabs;

    public List<Slab> getSlabs() {
        return slabs;
    }

    public void setSlabs(List<Slab> slabs) {
        this.slabs = slabs;
    }

    @Override
    public String toString() {
        return "SlabConfig{" +
                "slabs=" + slabs +
                '}';
    }
}


