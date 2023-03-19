package edu.ou.buildingsyncdataservice.listener.apartment;

import edu.ou.buildingsyncdataservice.common.mapper.ApartmentDocumentMapper;
import edu.ou.buildingsyncdataservice.data.entity.ApartmentDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.building.internal.apartment.ApartmentAddQueueI;
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
public class ApartmentAddListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<ApartmentDocument, ApartmentDocument> apartmentAddRepository;
    private final MessageConverter messageConverter;

    /**
     * Add new apartment
     *
     * @param apartment apartment information
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {ApartmentAddQueueI.QUEUE})
    public Object execute(Object apartment) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) apartment);
        final ApartmentDocument apartmentDocument = ApartmentDocumentMapper.INSTANCE.fromMap(dataMap);

        return apartmentAddRepository.execute(apartmentDocument);
    }
}
