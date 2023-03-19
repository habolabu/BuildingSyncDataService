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

@Repository
@RequiredArgsConstructor
public class ParkingSpaceFindOneRepository extends BaseRepository<ParkingSpaceDocumentPK, ParkingSpaceDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(ParkingSpaceDocumentPK input) {
        // do nothing
    }

    /**
     * Find parking space by id
     *
     * @param parkingSpaceId parking space id
     * @return parking space
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected ParkingSpaceDocument doExecute(ParkingSpaceDocumentPK parkingSpaceId) {

        return mongoTemplate.findOne(
                new Query(
                        new Criteria().andOperator(
                                new ArrayList<Criteria>() {
                                    {
                                        add(Criteria.where("parkingId")
                                                .is(parkingSpaceId.getParkingId()));
                                        add(Criteria.where("parkingTypeId")
                                                .is(parkingSpaceId.getParkingTypeId()));
                                    }
                                }.toArray(new Criteria[0])
                        )
                ),
                ParkingSpaceDocument.class
        );
    }

    @Override
    protected void postExecute(ParkingSpaceDocumentPK input) {
        // do nothing
    }
}
