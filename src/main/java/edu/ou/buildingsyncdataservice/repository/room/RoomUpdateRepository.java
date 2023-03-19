package edu.ou.buildingsyncdataservice.repository.room;

import edu.ou.buildingsyncdataservice.data.entity.RoomDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RoomUpdateRepository extends BaseRepository<RoomDocument, RoomDocument> {
    private final IBaseRepository<Integer, RoomDocument> roomFindOneRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(RoomDocument input) {
        // do nothing
    }

    /**
     * Update exist room
     *
     * @param roomDocument room
     * @return room
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected RoomDocument doExecute(RoomDocument roomDocument) {
        final RoomDocument existRoomDocument = roomFindOneRepository.execute(roomDocument.getOId());

        assert existRoomDocument != null;
        roomDocument.setId(existRoomDocument.getId());

        return mongoTemplate.save(roomDocument);
    }

    @Override
    protected void postExecute(RoomDocument input) {
        // do nothing
    }
}
