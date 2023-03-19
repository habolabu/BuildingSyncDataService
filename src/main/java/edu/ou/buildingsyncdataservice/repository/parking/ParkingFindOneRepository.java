package edu.ou.buildingsyncdataservice.repository.parking;

import edu.ou.buildingsyncdataservice.data.entity.ParkingDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ParkingFindOneRepository extends BaseRepository<Integer, ParkingDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer input) {
        // do nothing
    }

    /**
     * Find parking by id
     *
     * @param parkingId parking id
     * @return parking
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected ParkingDocument doExecute(Integer parkingId) {
        return mongoTemplate.findOne(
                new Query(
                        Criteria.where("oId")
                                .is(parkingId)
                ),
                ParkingDocument.class
        );
    }

    @Override
    protected void postExecute(Integer input) {
        // do nothing
    }
}
