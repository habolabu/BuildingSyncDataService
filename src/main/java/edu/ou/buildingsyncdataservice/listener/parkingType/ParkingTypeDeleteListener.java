package edu.ou.buildingsyncdataservice.listener.parkingType;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.building.internal.parkingType.ParkingTypeDeleteQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ParkingTypeDeleteListener implements IBaseListener<String, Object> {
    private final IBaseRepository<String, Object> parkingTypeDeleteRepository;

    /**
     * Delete exist parking type
     *
     * @param parkingTypeSlug parking type slug
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {ParkingTypeDeleteQueueI.QUEUE})
    public Object execute(String parkingTypeSlug) {
        return parkingTypeDeleteRepository.execute(parkingTypeSlug);
    }
}
