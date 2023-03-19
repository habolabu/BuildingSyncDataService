package edu.ou.buildingsyncdataservice.listener.apartment;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.building.internal.apartment.ApartmentDeleteQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApartmentDeleteListener implements IBaseListener<String, Object> {
    private final IBaseRepository<String, Object> apartmentDeleteRepository;


    /**
     * Delete exist apartment
     *
     * @param apartmentSlug apartment slug
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {ApartmentDeleteQueueI.QUEUE})
    public Object execute(String apartmentSlug) {
        return apartmentDeleteRepository.execute(apartmentSlug);
    }
}
