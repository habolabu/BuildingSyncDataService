package edu.ou.buildingsyncdataservice.data.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("Apartment")
public class ApartmentDocument implements Serializable {
    @Id
    private String id;
    private int oId;
    private String name;
    private String slug;
    private int floorAmount;
    private int areaId;
}
