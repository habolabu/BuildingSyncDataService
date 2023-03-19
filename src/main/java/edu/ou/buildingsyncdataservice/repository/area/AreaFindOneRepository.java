package edu.ou.buildingsyncdataservice.repository.area;

import edu.ou.buildingsyncdataservice.data.entity.AreaDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AreaFindOneRepository extends BaseRepository<Integer, AreaDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer areaOId) {
        // do nothing
    }

    /**
     * Find Area by id
     *
     * @param areaOId area id
     * @return area
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected AreaDocument doExecute(Integer areaOId) {
        return mongoTemplate.findOne(
                new Query(
                        Criteria.where("oId")
                                .is(areaOId)
                ),
                AreaDocument.class
        );
    }

    @Override
    protected void postExecute(Integer areaOId) {
        // do nothing
    }
}
