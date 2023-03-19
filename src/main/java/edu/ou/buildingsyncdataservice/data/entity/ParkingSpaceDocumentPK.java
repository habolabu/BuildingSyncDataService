package edu.ou.buildingsyncdataservice.data.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ParkingSpaceDocumentPK implements Serializable {
    private int parkingId;
    private int parkingTypeId;
}
