package edu.ou.buildingsyncdataservice.repository.room;

import edu.ou.buildingsyncdataservice.data.entity.RoomDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RoomAddRepository extends BaseRepository<RoomDocument, RoomDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(RoomDocument input) {
        // do nothing
    }

    /**
     * Add new room document
     *
     * @param roomDocument room document
     * @return room document
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected RoomDocument doExecute(RoomDocument roomDocument) {
        return mongoTemplate.save(roomDocument);
    }

    @Override
    protected void postExecute(RoomDocument input) {
        // do nothing
    }
}
