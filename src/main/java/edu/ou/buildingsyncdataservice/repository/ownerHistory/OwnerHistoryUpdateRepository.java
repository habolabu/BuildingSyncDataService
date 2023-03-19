package edu.ou.buildingsyncdataservice.repository.ownerHistory;

import edu.ou.buildingsyncdataservice.data.entity.OwnerHistoryDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OwnerHistoryUpdateRepository extends BaseRepository<OwnerHistoryDocument, OwnerHistoryDocument> {
    private final IBaseRepository<Integer, OwnerHistoryDocument> ownerHistoryFindOneRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(OwnerHistoryDocument input) {
        // do nothing
    }

    /**
     * Update exist owner history document
     *
     * @param ownerHistoryDocument owner history
     * @return updated owner history
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected OwnerHistoryDocument doExecute(OwnerHistoryDocument ownerHistoryDocument) {
        final OwnerHistoryDocument existOwnerHistoryDocument =
                ownerHistoryFindOneRepository.execute(ownerHistoryDocument.getOId());

        assert existOwnerHistoryDocument != null;
        ownerHistoryDocument.setId(existOwnerHistoryDocument.getId());

        return mongoTemplate.save(ownerHistoryDocument);
    }

    @Override
    protected void postExecute(OwnerHistoryDocument input) {
        // do nothing
    }
}
