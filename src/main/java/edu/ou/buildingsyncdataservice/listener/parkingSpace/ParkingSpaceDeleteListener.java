package edu.ou.buildingsyncdataservice.listener.parkingSpace;

import edu.ou.buildingsyncdataservice.common.mapper.ParkingSpaceDocumentMapper;
import edu.ou.buildingsyncdataservice.data.entity.ParkingSpaceDocumentPK;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.building.internal.parkingSpace.ParkingSpaceDeleteQueueI;
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
public class ParkingSpaceDeleteListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<ParkingSpaceDocumentPK, Object> parkingSpaceDeleteRepository;
    private final MessageConverter messageConverter;


    /**
     * Delete exist parking space
     *
     * @param parkingSpaceId parking space id
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {ParkingSpaceDeleteQueueI.QUEUE})
    public Object execute(Object parkingSpaceId) {
        final Map<String, Object> dataMap = (HashMap<String, Object>)
                messageConverter.fromMessage((Message) parkingSpaceId);
        final ParkingSpaceDocumentPK parkingSpaceDocument = ParkingSpaceDocumentMapper.INSTANCE.fromMapPK(dataMap);

        return parkingSpaceDeleteRepository.execute(parkingSpaceDocument);
    }
}
