package edu.ou.buildingsyncdataservice.repository.parkingSpace;

import edu.ou.buildingsyncdataservice.data.entity.ParkingSpaceDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ParkingSpaceAddRepository extends BaseRepository<ParkingSpaceDocument, ParkingSpaceDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(ParkingSpaceDocument input) {
        // do nothing
    }

    /**
     * Save new parking space
     *
     * @param parkingSpaceDocument parking space
     * @return parking space
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected ParkingSpaceDocument doExecute(ParkingSpaceDocument parkingSpaceDocument) {
        return mongoTemplate.save(parkingSpaceDocument);
    }

    @Override
    protected void postExecute(ParkingSpaceDocument input) {

    }
}
