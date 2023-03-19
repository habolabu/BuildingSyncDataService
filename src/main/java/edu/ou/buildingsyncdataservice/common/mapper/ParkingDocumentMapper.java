package edu.ou.buildingsyncdataservice.common.mapper;

import edu.ou.buildingsyncdataservice.data.entity.ParkingDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface ParkingDocumentMapper {
    ParkingDocumentMapper INSTANCE = Mappers.getMapper(ParkingDocumentMapper.class);

    /**
     * Map HashMap<String, String> object to Parking object
     *
     * @param map represents for ParkingAddRequest object
     * @return Parking object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "OId", source = "id", qualifiedByName = "objectToInt")
    @Mapping(target = "name", source = "name", qualifiedByName = "objectToString")
    @Mapping(target = "slug", source = "slug", qualifiedByName = "objectToString")
    @Mapping(target = "apartmentId", source = "apartmentId", qualifiedByName = "objectToInt")
    ParkingDocument fromMap(Map<String, Object> map);

    /**
     * Convert object to String
     *
     * @param object object will be converted
     * @return String object
     * @author Nguyen Trung Kien - OU
     */
    @Named("objectToString")
    static String objectToString(Object object) {
        return (String) object;
    }

    /**
     * Convert object to int
     *
     * @param object object will be converted
     * @return int value
     * @author Nguyen Trung Kien - OU
     */
    @Named("objectToInt")
    static int objectToInt(Object object) {
        return (int) object;
    }
}
