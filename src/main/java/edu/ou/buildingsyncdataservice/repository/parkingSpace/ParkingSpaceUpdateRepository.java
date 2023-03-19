package edu.ou.buildingsyncdataservice.repository.parkingSpace;

import edu.ou.buildingsyncdataservice.data.entity.ParkingSpaceDocument;
import edu.ou.buildingsyncdataservice.data.entity.ParkingSpaceDocumentPK;
import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ParkingSpaceUpdateRepository extends BaseRepository<ParkingSpaceDocument, ParkingSpaceDocument> {
    private final IBaseRepository<ParkingSpaceDocumentPK, ParkingSpaceDocument> parkingSpaceFindOneRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(ParkingSpaceDocument input) {
        // do nothing
    }

    /**
     * Update exist apartment document
     *
     * @param parkingSpaceDocument apartment
     * @return updated apartment
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected ParkingSpaceDocument doExecute(ParkingSpaceDocument parkingSpaceDocument) {
        final ParkingSpaceDocument existParkingSpaceDocument =
                parkingSpaceFindOneRepository.execute(
                        new ParkingSpaceDocumentPK()
                                .setParkingId(parkingSpaceDocument.getParkingId())
                                .setParkingTypeId(parkingSpaceDocument.getParkingTypeId())
                );

        assert existParkingSpaceDocument != null;
        parkingSpaceDocument.setId(existParkingSpaceDocument.getId());

        return mongoTemplate.save(parkingSpaceDocument);
    }

    @Override
    protected void postExecute(ParkingSpaceDocument input) {
        // do nothing
    }
}
