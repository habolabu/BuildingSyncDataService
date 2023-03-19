package edu.ou.buildingsyncdataservice.repository.apartment;

import edu.ou.buildingsyncdataservice.data.entity.ApartmentDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ApartmentAddRepository extends BaseRepository<ApartmentDocument, ApartmentDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(ApartmentDocument input) {
        // do nothing
    }

    /**
     * Save new apartment
     *
     * @param apartmentDocument apartment
     * @return apartment
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected ApartmentDocument doExecute(ApartmentDocument apartmentDocument) {
        return mongoTemplate.save(apartmentDocument);
    }

    @Override
    protected void postExecute(ApartmentDocument input) {
        // do nothing
    }
}
