package edu.ou.buildingsyncdataservice.repository.area;

import edu.ou.buildingsyncdataservice.data.entity.AreaDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AreaUpdateRepository extends BaseRepository<AreaDocument, Object> {
    private final IBaseRepository<Integer, AreaDocument> areaFindOneRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(AreaDocument areaDocument) {
        // do nothing
    }

    /**
     * Update exist area document
     *
     * @param areaDocument input of task
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected Object doExecute(AreaDocument areaDocument) {
        final AreaDocument existAreaDocument = areaFindOneRepository.execute(areaDocument.getOId());

        assert existAreaDocument != null;
        areaDocument.setId(existAreaDocument.getId());

        return mongoTemplate.save(areaDocument);
    }

    @Override
    protected void postExecute(AreaDocument areaDocument) {
        // do nothing
    }
}
