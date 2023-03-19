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
public class ParkingDeleteRepository extends BaseRepository<String, Object> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(String input) {
        // do nothing
    }

    /**
     * Delete exist parking
     *
     * @param parkingSlug parking slug
     * @return delete result
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected Object doExecute(String parkingSlug) {
        return mongoTemplate.remove(
                new Query(
                        Criteria.where("slug")
                                .is(parkingSlug)
                ),
                ParkingDocument.class
        );
    }

    @Override
    protected void postExecute(String input) {
        // do nothing
    }
}
