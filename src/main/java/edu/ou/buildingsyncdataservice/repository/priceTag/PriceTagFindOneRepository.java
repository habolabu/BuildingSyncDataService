package edu.ou.buildingsyncdataservice.repository.priceTag;

import edu.ou.buildingsyncdataservice.data.entity.PriceTagDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PriceTagFindOneRepository extends BaseRepository<Integer, PriceTagDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer input) {
        // do nothing
    }

    /**
     * Find price tag by id
     *
     * @param priceTagOId price tag id
     * @return price tag
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected PriceTagDocument doExecute(Integer priceTagOId) {
        return mongoTemplate.findOne(
                new Query(
                        Criteria.where("oId")
                                .is(priceTagOId)
                ),
                PriceTagDocument.class
        );
    }

    @Override
    protected void postExecute(Integer input) {
        // do nothing
    }
}
