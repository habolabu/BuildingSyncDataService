package edu.ou.buildingsyncdataservice.repository.priceTag;

import edu.ou.buildingsyncdataservice.data.entity.PriceTagDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PriceTagAddRepository extends BaseRepository<PriceTagDocument, PriceTagDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(PriceTagDocument input) {
        // do nothing
    }

    /**
     * Insert new price tag
     *
     * @param priceTagDocument price tag
     * @return price tag
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected PriceTagDocument doExecute(PriceTagDocument priceTagDocument) {
        return mongoTemplate.save(priceTagDocument);
    }

    @Override
    protected void postExecute(PriceTagDocument input) {
        // do nothing
    }
}
