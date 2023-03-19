package edu.ou.buildingsyncdataservice.repository.parkingType;

import edu.ou.buildingsyncdataservice.data.entity.ParkingTypeDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ParkingTypeFindOneRepository extends BaseRepository<Integer, ParkingTypeDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer input) {
        // do nothing
    }

    /**
     * Find parking type by id
     *
     * @param parkingTypeId parking type id
     * @return parking type
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected ParkingTypeDocument doExecute(Integer parkingTypeId) {
        return mongoTemplate.findOne(
                new Query(
                        Criteria.where("oId")
                                .is(parkingTypeId)
                ),
                ParkingTypeDocument.class
        );
    }

    @Override
    protected void postExecute(Integer input) {
        // do nothing
    }
}
