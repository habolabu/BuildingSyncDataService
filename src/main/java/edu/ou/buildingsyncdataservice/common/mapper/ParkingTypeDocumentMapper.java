package edu.ou.buildingsyncdataservice.common.mapper;

import edu.ou.buildingsyncdataservice.data.entity.ParkingTypeDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface ParkingTypeDocumentMapper {
    ParkingTypeDocumentMapper INSTANCE = Mappers.getMapper(ParkingTypeDocumentMapper.class);

    /**
     * Map HashMap<String, String> object to ParkingType object
     *
     * @param map represents for ParkingTypeAddRequest object
     * @return Apartment object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "OId", source = "id", qualifiedByName = "objectToInt")
    @Mapping(target = "name", source = "name", qualifiedByName = "objectToString")
    @Mapping(target = "slug", source = "slug", qualifiedByName = "objectToString")
    @Mapping(target = "priceTagId", source = "priceTagId", qualifiedByName = "objectToInt")
    ParkingTypeDocument fromMap(Map<String, Object> map);

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
