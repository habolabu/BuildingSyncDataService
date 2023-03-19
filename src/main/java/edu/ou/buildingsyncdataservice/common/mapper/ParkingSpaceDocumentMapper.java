package edu.ou.buildingsyncdataservice.common.mapper;

import edu.ou.buildingsyncdataservice.data.entity.ParkingSpaceDocument;
import edu.ou.buildingsyncdataservice.data.entity.ParkingSpaceDocumentPK;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface ParkingSpaceDocumentMapper {
    ParkingSpaceDocumentMapper INSTANCE = Mappers.getMapper(ParkingSpaceDocumentMapper.class);

    /**
     * Map Map<String, String> object to ParkingSpace object
     *
     * @param map represents for ParkingSpaceAddRequest object
     * @return ParkingSpace object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "parkingId", source = "parkingId", qualifiedByName = "objectToInt")
    @Mapping(target = "parkingTypeId", source = "parkingTypeId", qualifiedByName = "objectToInt")
    @Mapping(target = "capacity", source = "capacity", qualifiedByName = "objectToInt")
    @Mapping(target = "availableSpace", source = "availableSpace", qualifiedByName = "objectToInt")
    ParkingSpaceDocument fromMap(Map<String, Object> map);

    /**
     * Map Map<String, Object> object to ParkingSpaceDocumentPK object
     *
     * @param map represents for ParkingSpaceDocumentPK object
     * @return ParkingSpaceDocumentPK object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "parkingId", source = "parkingId", qualifiedByName = "objectToInt")
    @Mapping(target = "parkingTypeId", source = "parkingTypeId", qualifiedByName = "objectToInt")
    ParkingSpaceDocumentPK fromMapPK(Map<String, Object> map);

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
