package edu.ou.buildingsyncdataservice.repository.priceTag;

import edu.ou.buildingsyncdataservice.data.entity.PriceTagDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PriceTagUpdateRepository extends BaseRepository<PriceTagDocument, Object> {
    private final IBaseRepository<Integer, PriceTagDocument> priceTagFindOneRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(PriceTagDocument input) {
        // do nothing
    }

    /**
     * Update exist price tag document
     *
     * @param priceTagDocument input of task
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected Object doExecute(PriceTagDocument priceTagDocument) {
        final PriceTagDocument existPriceTagDocument = priceTagFindOneRepository.execute(priceTagDocument.getOId());

        assert existPriceTagDocument != null;
        priceTagDocument.setId(existPriceTagDocument.getId());

        return mongoTemplate.save(priceTagDocument);
    }

    @Override
    protected void postExecute(PriceTagDocument input) {
        // do nothing
    }
}
