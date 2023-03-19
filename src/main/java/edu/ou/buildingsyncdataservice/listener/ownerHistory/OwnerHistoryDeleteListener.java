package edu.ou.buildingsyncdataservice.listener.ownerHistory;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.building.internal.ownerHistory.OwnerHistoryDeleteQueueI;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OwnerHistoryDeleteListener implements IBaseListener<Integer, Object> {
    private final BaseRepository<Integer, Object> ownerHistoryDeleteRepository;

    /**
     * Delete exist owner history
     *
     * @param ownerHistoryId owner history id
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {OwnerHistoryDeleteQueueI.QUEUE})
    public Object execute(Integer ownerHistoryId) {
        return ownerHistoryDeleteRepository.execute(ownerHistoryId);
    }
}
