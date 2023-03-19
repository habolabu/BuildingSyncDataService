package edu.ou.buildingsyncdataservice.repository.ownerHistory;

import edu.ou.buildingsyncdataservice.data.entity.OwnerHistoryDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OwnerHistoryFindOneRepository extends BaseRepository<Integer, OwnerHistoryDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer input) {
        // do nothing
    }

    /**
     * Find owner history by id
     *
     * @param ownerHistoryId owner history id
     * @return owner history
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected OwnerHistoryDocument doExecute(Integer ownerHistoryId) {
        return mongoTemplate.findOne(
                new Query(
                        Criteria.where("oId")
                                .is(ownerHistoryId)
                ),
                OwnerHistoryDocument.class
        );
    }

    @Override
    protected void postExecute(Integer input) {
        // do nothing
    }
}
