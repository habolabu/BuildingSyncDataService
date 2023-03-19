package edu.ou.buildingsyncdataservice.listener.area;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.building.internal.area.AreaDeleteQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AreaDeleteListener implements IBaseListener<String, Object> {
    private final IBaseRepository<String, Object> areaDeleteRepository;

    /**
     * Delete exist area
     *
     * @param areaSlug request from client
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {AreaDeleteQueueI.QUEUE})
    public Object execute(String areaSlug) {
        return areaDeleteRepository.execute(areaSlug);

    }
}
