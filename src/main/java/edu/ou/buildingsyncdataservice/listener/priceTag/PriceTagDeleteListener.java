package edu.ou.buildingsyncdataservice.listener.priceTag;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.building.internal.priceTag.PriceTagDeleteQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PriceTagDeleteListener implements IBaseListener<String, Object> {
    private final IBaseRepository<String, Object> priceTagDeleteRepository;

    /**
     * Delete exist priceTag
     *
     * @param priceTagSlug request from client
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {PriceTagDeleteQueueI.QUEUE})
    public Object execute(String priceTagSlug) {
        return priceTagDeleteRepository.execute(priceTagSlug);
    }
}
