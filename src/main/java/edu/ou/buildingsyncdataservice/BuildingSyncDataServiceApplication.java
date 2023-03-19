package edu.ou.buildingsyncdataservice;

import edu.ou.coreservice.annotation.BaseSyncDataAnnotation;
import org.springframework.boot.SpringApplication;

@BaseSyncDataAnnotation
public class BuildingSyncDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuildingSyncDataServiceApplication.class, args);
    }

}
