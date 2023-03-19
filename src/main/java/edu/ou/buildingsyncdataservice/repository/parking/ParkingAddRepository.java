package edu.ou.buildingsyncdataservice.repository.parking;

import edu.ou.buildingsyncdataservice.data.entity.ParkingDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ParkingAddRepository extends BaseRepository<ParkingDocument, ParkingDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(ParkingDocument input) {
        // do nothing
    }

    /**
     * Save new parking
     *
     * @param parkingDocument parking
     * @return parking
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected ParkingDocument doExecute(ParkingDocument parkingDocument) {
        return mongoTemplate.save(parkingDocument);
    }

    @Override
    protected void postExecute(ParkingDocument input) {
        // do nothing
    }
}
