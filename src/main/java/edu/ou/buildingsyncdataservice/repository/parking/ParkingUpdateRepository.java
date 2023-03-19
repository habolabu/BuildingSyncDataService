package edu.ou.buildingsyncdataservice.repository.parking;

import edu.ou.buildingsyncdataservice.data.entity.ParkingDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ParkingUpdateRepository extends BaseRepository<ParkingDocument, ParkingDocument> {
    private final IBaseRepository<Integer, ParkingDocument> parkingFindOneRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(ParkingDocument input) {
        // do nothing
    }

    /**
     * Update exist parking document
     *
     * @param parkingDocument parking
     * @return updated parking
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected ParkingDocument doExecute(ParkingDocument parkingDocument) {
        final ParkingDocument existParkingDocument = parkingFindOneRepository.execute(parkingDocument.getOId());

        assert existParkingDocument != null;
        parkingDocument.setId(existParkingDocument.getId());

        return mongoTemplate.save(parkingDocument);
    }

    @Override
    protected void postExecute(ParkingDocument input) {
        // do nothing
    }
}
