package edu.ou.buildingsyncdataservice.listener.room;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.building.internal.room.RoomDeleteQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomDeleteListener implements IBaseListener<String, Object> {
    private final IBaseRepository<String, Object> roomDeleteRepository;

    /**
     * Delete exist room
     *
     * @param roomSlug room slug
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {RoomDeleteQueueI.QUEUE})
    public Object execute(String roomSlug) {
        return roomDeleteRepository.execute(roomSlug);
    }
}
