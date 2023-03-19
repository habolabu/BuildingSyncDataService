package edu.ou.buildingsyncdataservice.listener.room;

import edu.ou.buildingsyncdataservice.common.mapper.RoomDocumentMapper;
import edu.ou.buildingsyncdataservice.data.entity.RoomDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.building.internal.room.RoomAddQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class RoomAddListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<RoomDocument, RoomDocument> roomAddRepository;
    private final MessageConverter messageConverter;

    /**
     * Add new room
     *
     * @param room room of task
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {RoomAddQueueI.QUEUE})
    public Object execute(Object room) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) room);
        final RoomDocument roomDocument = RoomDocumentMapper.INSTANCE.fromMap(dataMap);

        return roomAddRepository.execute(roomDocument);
    }
}
