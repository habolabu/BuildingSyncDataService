package edu.ou.buildingsyncdataservice.common.mapper;

import edu.ou.buildingsyncdataservice.data.entity.OwnerHistoryDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.Map;

@Mapper
public interface OwnerHistoryDocumentMapper {
    OwnerHistoryDocumentMapper INSTANCE = Mappers.getMapper(OwnerHistoryDocumentMapper.class);

    /**
     * Map HashMap<String, String> object to OwnerHistory object
     *
     * @param map represents for OwnerHistoryAddRequest object
     * @return OwnerHistory object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "OId", source = "id", qualifiedByName = "objectToInt")
    @Mapping(target = "joinDate", source = "joinDate", qualifiedByName = "objectToDate")
    @Mapping(target = "ownerId", source = "ownerId", qualifiedByName = "objectToInt")
    @Mapping(target = "roomId", source = "roomId", qualifiedByName = "objectToInt")
    OwnerHistoryDocument fromMap(Map<String, Object> map);

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

    /**
     * Convert object to Date
     *
     * @param object object will be converted
     * @return Date value
     * @author Nguyen Trung Kien - OU
     */
    @Named("objectToDate")
    static Date objectToDate(Object object) {
        return new Date((long) object);
    }
}
