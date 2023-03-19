package edu.ou.buildingsyncdataservice.listener.priceTag;

import edu.ou.buildingsyncdataservice.common.mapper.PriceTagDocumentMapper;
import edu.ou.buildingsyncdataservice.data.entity.PriceTagDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.building.internal.priceTag.PriceTagAddQueueI;
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
public class PriceTagAddListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<PriceTagDocument, PriceTagDocument> priceTagAddRepository;
    private final MessageConverter messageConverter;


    /**
     * Insert new price tag
     *
     * @param priceTag request from client
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {PriceTagAddQueueI.QUEUE})
    public Object execute(Object priceTag) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) priceTag);
        final PriceTagDocument priceTagDocument = PriceTagDocumentMapper.INSTANCE.fromMap(dataMap);

        return priceTagAddRepository.execute(priceTagDocument);

    }
}
