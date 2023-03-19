package edu.ou.buildingsyncdataservice.repository.parkingType;

import edu.ou.buildingsyncdataservice.data.entity.ParkingTypeDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ParkingTypeUpdateRepository extends BaseRepository<ParkingTypeDocument, ParkingTypeDocument> {
    private final IBaseRepository<Integer, ParkingTypeDocument> parkingTypeFindOneRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(ParkingTypeDocument input) {
        // do nothing
    }

    /**
     * Update exist parking type document
     *
     * @param parkingTypeDocument parking type
     * @return updated parking type
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected ParkingTypeDocument doExecute(ParkingTypeDocument parkingTypeDocument) {
        final ParkingTypeDocument existParkingTypeDocument =
                parkingTypeFindOneRepository.execute(parkingTypeDocument.getOId());

        assert existParkingTypeDocument != null;
        parkingTypeDocument.setId(existParkingTypeDocument.getId());

        return mongoTemplate.save(parkingTypeDocument);
    }

    @Override
    protected void postExecute(ParkingTypeDocument input) {
        // do nothing
    }
}
