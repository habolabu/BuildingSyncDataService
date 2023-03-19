package edu.ou.buildingsyncdataservice.repository.room;

import edu.ou.buildingsyncdataservice.data.entity.RoomDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RoomDeleteRepository extends BaseRepository<String, Object> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(String input) {
        // do nothing
    }

    /**
     * Delete exist room
     *
     * @param roomSlug room slug
     * @return delete result
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected Object doExecute(String roomSlug) {
        return mongoTemplate.remove(
                new Query(
                        Criteria.where("slug")
                                .is(roomSlug)
                ),
                RoomDocument.class
        );
    }

    @Override
    protected void postExecute(String input) {
        // do nothing
    }
}
