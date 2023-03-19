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
public class ParkingTypeDeleteRepository extends BaseRepository<String, Object> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(String input) {
        // do nothing
    }

    /**
     * Delete exist parking type
     *
     * @param parkingTypeSlug parking type slug
     * @return delete result
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected Object doExecute(String parkingTypeSlug) {
        return mongoTemplate.remove(
                new Query(
                        Criteria.where("slug")
                                .is(parkingTypeSlug)
                ),
                ParkingTypeDocument.class
        );
    }

    @Override
    protected void postExecute(String input) {
        // do nothing
    }
}
