package edu.ou.buildingsyncdataservice.listener.ownerHistory;

import edu.ou.buildingsyncdataservice.common.mapper.OwnerHistoryDocumentMapper;
import edu.ou.buildingsyncdataservice.data.entity.OwnerHistoryDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.building.internal.ownerHistory.OwnerHistoryAddQueueI;
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
public class OwnerHistoryAddListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<OwnerHistoryDocument, OwnerHistoryDocument> ownerHistoryAddRepository;
    private final MessageConverter messageConverter;


    /**
     * Add new owner history
     *
     * @param ownerHistory owner history
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {OwnerHistoryAddQueueI.QUEUE})
    public Object execute(Object ownerHistory) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) ownerHistory);
        final OwnerHistoryDocument ownerHistoryDocument = OwnerHistoryDocumentMapper.INSTANCE
                .fromMap(dataMap);

        return ownerHistoryAddRepository.execute(ownerHistoryDocument);
    }
}
