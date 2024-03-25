package server.validators;

/**
 * A class for implementing the flat validator
 *
 * @since 1.0
 * @author savadanko
 */
public class FlatValidator {

    public static boolean validator(String line){
        String csvValidator = ",";
        String[] flatData = line.split(csvValidator);

        if (flatData.length != 15){
            return false;
        }
        else{
            return IdValidator.validator(flatData[0]) && NameValidator.validate(flatData[1]) && XCoordinateValidator.validator(flatData[2])
                    && YCoordinateValidator.validator(flatData[3]) && DataValidator.validator(flatData[4]) && AreaValidator.validator(flatData[5])
                    && FlatNumberOfRoomsValidator.validator(flatData[6]) && FlatPriceValidator.validator(flatData[7])
                    && ViewValidator.validator(flatData[8]) && TransportValidator.validate(flatData[9])
                    && NameValidator.validate(flatData[10]) && HouseYearValidator.validator(flatData[11])
                    && HouseNumberOfFloorsValidator.validator(flatData[12])
                    && HouseNumberOfFlatsOnFloorValidator.validator(flatData[13])
                    && HouseNumberOfLiftsValidator.validator(flatData[14]);
        }
    }
}
