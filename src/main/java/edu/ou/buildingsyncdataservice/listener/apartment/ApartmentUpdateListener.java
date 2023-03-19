package edu.ou.buildingsyncdataservice.listener.apartment;

import edu.ou.buildingsyncdataservice.common.mapper.ApartmentDocumentMapper;
import edu.ou.buildingsyncdataservice.data.entity.ApartmentDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.building.internal.apartment.ApartmentUpdateQueueI;
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
public class ApartmentUpdateListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<ApartmentDocument, ApartmentDocument> apartmentUpdateRepository;
    private final MessageConverter messageConverter;

    /**
     * Update information exist apartment
     *
     * @param apartment apartment
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {ApartmentUpdateQueueI.QUEUE})
    public Object execute(Object apartment) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) apartment);
        final ApartmentDocument apartmentDocument = ApartmentDocumentMapper.INSTANCE
                .fromMap(dataMap);

        return apartmentUpdateRepository.execute(apartmentDocument);
    }
}
