package edu.ou.buildingsyncdataservice.listener.parkingType;

import edu.ou.buildingsyncdataservice.common.mapper.ParkingTypeDocumentMapper;
import edu.ou.buildingsyncdataservice.data.entity.ParkingTypeDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.building.internal.parkingType.ParkingTypeUpdateQueueI;
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
public class ParkingTypeUpdateListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<ParkingTypeDocument, ParkingTypeDocument> parkingTypeUpdateRepository;
    private final MessageConverter messageConverter;

    /**
     * Update information exist parking type
     *
     * @param parkingType parkingType of task
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {ParkingTypeUpdateQueueI.QUEUE})
    public Object execute(Object parkingType) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) parkingType);
        final ParkingTypeDocument parkingTypeDocument = ParkingTypeDocumentMapper.INSTANCE.fromMap(dataMap);

        return parkingTypeUpdateRepository.execute(parkingTypeDocument);
    }
}
