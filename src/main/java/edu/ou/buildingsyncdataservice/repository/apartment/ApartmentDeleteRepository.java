package edu.ou.buildingsyncdataservice.repository.apartment;

import edu.ou.buildingsyncdataservice.data.entity.ApartmentDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ApartmentDeleteRepository extends BaseRepository<String, Object> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(String input) {
        // do nothing
    }

    /**
     * Delete exist apartment
     *
     * @param apartmentSlug apartment slug
     * @return delete result
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected Object doExecute(String apartmentSlug) {
        return mongoTemplate.remove(
                new Query(
                        Criteria.where("slug")
                                .is(apartmentSlug)
                ),
                ApartmentDocument.class
        );
    }

    @Override
    protected void postExecute(String input) {
        // do nothing
    }
}
