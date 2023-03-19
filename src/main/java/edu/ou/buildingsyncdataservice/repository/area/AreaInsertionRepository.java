package edu.ou.buildingsyncdataservice.repository.area;

import edu.ou.buildingsyncdataservice.data.entity.AreaDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AreaInsertionRepository extends BaseRepository<AreaDocument, AreaDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(AreaDocument areaDocument) {
        // do nothing
    }

    /**
     * Insert new area
     *
     * @param areaDocument area
     * @return area
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected AreaDocument doExecute(AreaDocument areaDocument) {
        return mongoTemplate.save(areaDocument);
    }

    @Override
    protected void postExecute(AreaDocument areaDocument) {
        // do nothing
    }
}
