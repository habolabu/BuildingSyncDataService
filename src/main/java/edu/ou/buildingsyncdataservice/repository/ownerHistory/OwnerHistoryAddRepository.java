package edu.ou.buildingsyncdataservice.repository.ownerHistory;

import edu.ou.buildingsyncdataservice.data.entity.OwnerHistoryDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OwnerHistoryAddRepository extends BaseRepository<OwnerHistoryDocument, OwnerHistoryDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(OwnerHistoryDocument input) {
        // do nothing
    }

    /**
     * Save new owner history
     *
     * @param ownerHistoryDocument owner history
     * @return owner history
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected OwnerHistoryDocument doExecute(OwnerHistoryDocument ownerHistoryDocument) {
        return mongoTemplate.save(ownerHistoryDocument);
    }

    @Override
    protected void postExecute(OwnerHistoryDocument input) {
        // do nothing
    }
}
