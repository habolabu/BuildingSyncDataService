package edu.ou.buildingsyncdataservice.data.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("ParkingSpace")
public class ParkingSpaceDocument implements Serializable {
    @Id
    private String id;
    private Integer availableSpace;
    private Integer capacity;
    private Integer parkingId;
    private Integer parkingTypeId;
}
