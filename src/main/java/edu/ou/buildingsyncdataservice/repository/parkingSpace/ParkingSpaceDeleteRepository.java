package edu.ou.buildingsyncdataservice.repository.parkingSpace;

import edu.ou.buildingsyncdataservice.data.entity.ParkingSpaceDocument;
import edu.ou.buildingsyncdataservice.data.entity.ParkingSpaceDocumentPK;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ParkingSpaceDeleteRepository extends BaseRepository<ParkingSpaceDocumentPK, Object> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(ParkingSpaceDocumentPK input) {
        // do nothing
    }

    /**
     * Delete exist parking space
     *
     * @param parkingSpaceId parking space id
     * @return delete result
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected Object doExecute(ParkingSpaceDocumentPK parkingSpaceId) {
        final List<Criteria> conditions = new ArrayList<>() {
            {
                add(Criteria.where("parkingId")
                        .is(parkingSpaceId.getParkingId()));
                add(Criteria.where("parkingTypeId")
                        .is(parkingSpaceId.getParkingTypeId()));
            }
        };

        return mongoTemplate.remove(
                new Query(new Criteria().andOperator(conditions.toArray(new Criteria[0]))),
                ParkingSpaceDocument.class
        );
    }

    @Override
    protected void postExecute(ParkingSpaceDocumentPK input) {
        // do nothing
    }
}
