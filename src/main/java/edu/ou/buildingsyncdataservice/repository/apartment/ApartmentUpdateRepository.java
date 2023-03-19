package edu.ou.buildingsyncdataservice.repository.apartment;

import edu.ou.buildingsyncdataservice.data.entity.ApartmentDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ApartmentUpdateRepository extends BaseRepository<ApartmentDocument, ApartmentDocument> {
    private final IBaseRepository<Integer, ApartmentDocument> apartmentFindOneRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(ApartmentDocument input) {
        // do nothing
    }

    /**
     * Update exist apartment document
     *
     * @param apartmentDocument apartment
     * @return updated apartment
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected ApartmentDocument doExecute(ApartmentDocument apartmentDocument) {
        final ApartmentDocument existApartmentDocument =
                apartmentFindOneRepository.execute(apartmentDocument.getOId());

        assert existApartmentDocument != null;
        apartmentDocument.setId(existApartmentDocument.getId());

        return mongoTemplate.save(apartmentDocument);
    }

    @Override
    protected void postExecute(ApartmentDocument input) {
        // do nothing
    }
}
