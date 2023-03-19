package edu.ou.buildingsyncdataservice.repository.parkingType;

import edu.ou.buildingsyncdataservice.data.entity.ParkingTypeDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ParkingTypeAddRepository extends BaseRepository<ParkingTypeDocument, ParkingTypeDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(ParkingTypeDocument input) {
        // do nothing
    }

    /**
     * Save new parking type
     *
     * @param parkingTypeDocument parking type
     * @return parking type
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected ParkingTypeDocument doExecute(ParkingTypeDocument parkingTypeDocument) {
        return mongoTemplate.save(parkingTypeDocument);
    }

    @Override
    protected void postExecute(ParkingTypeDocument input) {

    }
}
