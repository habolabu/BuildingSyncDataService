package edu.ou.buildingsyncdataservice.data.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Document("OwnerHistory")
public class OwnerHistoryDocument implements Serializable {
    @Id
    private String id;
    private int oId;
    private Timestamp joinDate;
    private Integer ownerId;
    private Integer roomId;
}
