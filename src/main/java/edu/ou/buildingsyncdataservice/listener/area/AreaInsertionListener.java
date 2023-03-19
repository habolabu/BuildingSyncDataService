package edu.ou.buildingsyncdataservice.listener.area;

import edu.ou.buildingsyncdataservice.common.mapper.AreaDocumentMapper;
import edu.ou.buildingsyncdataservice.data.entity.AreaDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.building.internal.area.AreaAddQueueI;
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
public class AreaInsertionListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<AreaDocument, AreaDocument> areaInsertionRepository;
    private final MessageConverter messageConverter;


    /**
     * Insert new area
     *
     * @param area area
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {AreaAddQueueI.QUEUE})
    public Object execute(Object area) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) area);
        final AreaDocument areaDocument = AreaDocumentMapper.INSTANCE.fromMap(dataMap);

        return areaInsertionRepository.execute(areaDocument);
    }
}
