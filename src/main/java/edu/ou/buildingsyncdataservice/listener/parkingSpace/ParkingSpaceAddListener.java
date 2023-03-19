package edu.ou.buildingsyncdataservice.listener.parkingSpace;

import edu.ou.buildingsyncdataservice.common.mapper.ParkingSpaceDocumentMapper;
import edu.ou.buildingsyncdataservice.data.entity.ParkingSpaceDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.building.internal.parkingSpace.ParkingSpaceAddQueueI;
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
public class ParkingSpaceAddListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<ParkingSpaceDocument, ParkingSpaceDocument> parkingSpaceAddRepository;
    private final MessageConverter messageConverter;

    /**
     * Add new parking space
     *
     * @param parkingSpace parkingSpace
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {ParkingSpaceAddQueueI.QUEUE})
    public Object execute(Object parkingSpace) {
        final Map<String, Object> dataMap = (HashMap<String, Object>)
                messageConverter.fromMessage((Message) parkingSpace);
        final ParkingSpaceDocument parkingSpaceDocument = ParkingSpaceDocumentMapper.INSTANCE.fromMap(dataMap);

        return parkingSpaceAddRepository.execute(parkingSpaceDocument);
    }

}
