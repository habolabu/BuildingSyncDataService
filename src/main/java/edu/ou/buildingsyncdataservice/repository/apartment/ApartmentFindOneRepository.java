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
public class ApartmentFindOneRepository extends BaseRepository<Integer, ApartmentDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer input) {
        // do nothing
    }

    /**
     * Find apartment by id
     *
     * @param apartmentId apartment id
     * @return apartment
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected ApartmentDocument doExecute(Integer apartmentId) {
        return mongoTemplate.findOne(
                new Query(
                        Criteria.where("oId")
                                .is(apartmentId)
                ),
                ApartmentDocument.class
        );
    }

    @Override
    protected void postExecute(Integer input) {
        // do nothing
    }
}
