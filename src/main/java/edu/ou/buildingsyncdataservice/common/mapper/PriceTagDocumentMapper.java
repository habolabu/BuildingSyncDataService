package edu.ou.buildingsyncdataservice.common.mapper;

import edu.ou.buildingsyncdataservice.data.entity.PriceTagDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface PriceTagDocumentMapper {

    PriceTagDocumentMapper INSTANCE = Mappers.getMapper(PriceTagDocumentMapper.class);

    /**
     * Map HashMap<String, String> object to PriceTagDocument object
     *
     * @param map represents for PriceTagAddRequest object
     * @return PriceTagDocument object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "OId", source = "id", qualifiedByName = "objectToInt")
    @Mapping(target = "name", source = "name", qualifiedByName = "objectToString")
    @Mapping(target = "slug", source = "slug", qualifiedByName = "objectToString")
    @Mapping(target = "pricePerDay", source = "pricePerDay", qualifiedByName = "objectToInt")
    PriceTagDocument fromMap(Map<String, Object> map);

    /**
     * Convert object to String
     *
     * @param object object to String
     * @return String value
     * @author Nguyen Trung Kien - OU
     */
    @Named("objectToString")
    static String objectToString(Object object) {
        return (String) object;
    }

    /**
     * Convert object to int
     *
     * @param object object to int
     * @return int value
     * @author Nguyen Trung Kien - OU
     */
    @Named("objectToInt")
    static int objectToInt(Object object) {
        return (int) object;
    }
}