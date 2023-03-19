package edu.ou.buildingsyncdataservice.listener.priceTag;

import edu.ou.buildingsyncdataservice.common.mapper.PriceTagDocumentMapper;
import edu.ou.buildingsyncdataservice.data.entity.PriceTagDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.building.internal.priceTag.PriceTagUpdateQueueI;
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
public class PriceTagUpdateListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<PriceTagDocument, Object> priceTagUpdateRepository;
    private final MessageConverter messageConverter;

    /**
     * Update exist price tag
     *
     * @param input request from client
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {PriceTagUpdateQueueI.QUEUE})
    public Object execute(Object input) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) input);
        final PriceTagDocument priceTagDocument = PriceTagDocumentMapper.INSTANCE.fromMap(dataMap);

        return priceTagUpdateRepository.execute(priceTagDocument);
    }
}
