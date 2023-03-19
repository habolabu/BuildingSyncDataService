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
public class AreaDeleteRepository extends BaseRepository<String, Object> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(String areaSlug) {
        // do nothing
    }

    /**
     * Delete exist area
     *
     * @param areaSlug area slug
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected Object doExecute(String areaSlug) {
        return mongoTemplate.remove(
                new Query(
                        Criteria.where("slug")
                                .is(areaSlug)
                ),
                AreaDocument.class
        );
    }

    @Override
    protected void postExecute(String areaSlug) {
        // do nothing
    }
}
