package edu.ou.buildingsyncdataservice.listener.parking;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.building.internal.parking.ParkingDeleteQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ParkingDeleteListener implements IBaseListener<String, Object> {
    private final IBaseRepository<String, Object> parkingDeleteRepository;


    /**
     * Delete exist parking
     *
     * @param parkingSlug parking slug
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {ParkingDeleteQueueI.QUEUE})
    public Object execute(String parkingSlug) {
        return parkingDeleteRepository.execute(parkingSlug);
    }

}
