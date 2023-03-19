package edu.ou.buildingsyncdataservice.common.mapper;

import edu.ou.buildingsyncdataservice.data.entity.ApartmentDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface ApartmentDocumentMapper {
    ApartmentDocumentMapper INSTANCE = Mappers.getMapper(ApartmentDocumentMapper.class);

    /**
     * Map HashMap<String, String> object to Apartment object
     *
     * @param map represents for ApartmentAddRequest object
     * @return Apartment object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "OId", source = "id", qualifiedByName = "objectToInt")
    @Mapping(target = "name", source = "name", qualifiedByName = "objectToString")
    @Mapping(target = "slug", source = "slug", qualifiedByName = "objectToString")
    @Mapping(target = "floorAmount", source = "floorAmount", qualifiedByName = "objectToInt")
    @Mapping(target = "areaId", source = "areaId", qualifiedByName = "objectToInt")
    ApartmentDocument fromMap(Map<String, Object> map);

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
     * Convert object to in
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
