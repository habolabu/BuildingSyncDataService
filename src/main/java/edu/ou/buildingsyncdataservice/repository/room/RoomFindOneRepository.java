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
public class RoomFindOneRepository extends BaseRepository<Integer, RoomDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer input) {
        // do nothing
    }

    /**
     * Find room by id
     *
     * @param roomId room id
     * @return room
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected RoomDocument doExecute(Integer roomId) {
        return mongoTemplate.findOne(
                new Query(
                        Criteria.where("oId")
                                .is(roomId)
                ),
                RoomDocument.class
        );
    }

    @Override
    protected void postExecute(Integer input) {
        // do nothing
    }
}
