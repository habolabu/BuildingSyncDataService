package edu.ou.buildingsyncdataservice.listener.parking;

import edu.ou.buildingsyncdataservice.common.mapper.ParkingDocumentMapper;
import edu.ou.buildingsyncdataservice.data.entity.ParkingDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.building.internal.parking.ParkingAddQueueI;
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
public class ParkingAddListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<ParkingDocument, ParkingDocument> parkingAddRepository;
    private final MessageConverter messageConverter;


    /**
     * Add new parking
     *
     * @param parking parking
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {ParkingAddQueueI.QUEUE})
    public Object execute(Object parking) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) parking);
        final ParkingDocument parkingDocument = ParkingDocumentMapper.INSTANCE
                .fromMap(dataMap);

        return parkingAddRepository.execute(parkingDocument);
    }
}
