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
public class PriceTagDeleteRepository extends BaseRepository<String, Object> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(String input) {
        // do nothing
    }

    /**
     * Delete exist price tag
     *
     * @param priceTagSlug price tag slug
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected Object doExecute(String priceTagSlug) {
        return mongoTemplate.remove(
                new Query(
                        Criteria.where("slug")
                                .is(priceTagSlug)
                ),
                PriceTagDocument.class
        );
    }

    @Override
    protected void postExecute(String input) {
        // do nothing
    }
}
