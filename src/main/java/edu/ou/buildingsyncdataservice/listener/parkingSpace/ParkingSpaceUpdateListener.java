package edu.ou.buildingsyncdataservice.listener.parkingSpace;

import edu.ou.buildingsyncdataservice.common.mapper.ParkingSpaceDocumentMapper;
import edu.ou.buildingsyncdataservice.data.entity.ParkingSpaceDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.building.internal.parkingSpace.ParkingSpaceUpdateQueueI;
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
public class ParkingSpaceUpdateListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<ParkingSpaceDocument, ParkingSpaceDocument> parkingSpaceUpdateRepository;
    private final MessageConverter messageConverter;

    /**
     * Update information exist apartment
     *
     * @param parkingSpace parkingSpace of task
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {ParkingSpaceUpdateQueueI.QUEUE})
    public Object execute(Object parkingSpace) {
        final Map<String, Object> dataMap = (HashMap<String, Object>)
                messageConverter.fromMessage((Message) parkingSpace);
        final ParkingSpaceDocument parkingSpaceDocument = ParkingSpaceDocumentMapper.INSTANCE.fromMap(dataMap);

        return parkingSpaceUpdateRepository.execute(parkingSpaceDocument);
    }
}
