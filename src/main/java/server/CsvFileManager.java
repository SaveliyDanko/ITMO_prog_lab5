package server;

import database.CollectionDataBase;
import database.models.*;
import server.validators.FlatValidator;

import java.io.*;
import java.util.LinkedHashMap;

public class CsvFileManager {
    public static void saveFlatToFile(LinkedHashMap<Long, Flat> collection, String filePath) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for(Flat flat: collection.values()){
                String sb = flat.getId() + "," +
                        flat.getName() + "," +
                        flat.getCoordinates().getX() + "," +
                        flat.getCoordinates().getY() + "," +
                        flat.getCreationDate() + "," +
                        flat.getArea() + "," +
                        flat.getNumberOfRooms() + "," +
                        flat.getPrice() + "," +
                        (flat.getView() != null ? flat.getView().toString() : "") + "," +
                        flat.getTransport().toString() + "," +
                        flat.getHouse().getName() + "," +
                        flat.getHouse().getYear() + "," +
                        flat.getHouse().getNumberOfFloors() + "," +
                        flat.getHouse().getNumberOfFlatsOnFloor() + "," +
                        flat.getHouse().getNumberOfLifts() + "\n";

                bw.write(sb);
            }
        } catch (IOException e) {
            OutputManager.logError("Invalid Csv File Path, try again.");
            System.exit(0);
        }
    }

    public static void collectionFiller(String filePath){
        CollectionDataBase dataBase = CollectionDataBase.getDataBaseInstance();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            String csvSplitBy = ","; // Разделитель в CSV файле
            while ((line = br.readLine()) != null){
                if (FlatValidator.validator(line)){
                    String[] s = line.split(csvSplitBy);

                    long id = Long.parseLong(s[0]);
                    String flatName = s[1];
                    float x = Float.parseFloat(s[2]);
                    Long y = Long.parseLong(s[3]);
                    Coordinates coordinates = new Coordinates(x, y);
                    String data = s[4];
                    float area = Float.parseFloat(s[5]);
                    long flatNumberOfRooms = Long.parseLong(s[6]);
                    Float price = Float.parseFloat(s[7]);
                    View view = View.valueOf(s[8]);
                    Transport transport = Transport.valueOf(s[9]);
                    String houseName = s[10];
                    Long houseYear = Long.parseLong(s[11]);
                    Long houseNumberOfFloors = Long.parseLong(s[12]);
                    int houseNumberOfFlatsOnFloor = Integer.parseInt(s[13]);
                    int houseNumberOfLifts = Integer.parseInt(s[14]);

                    House house = new House(houseName, houseYear, houseNumberOfFloors, houseNumberOfFlatsOnFloor, houseNumberOfLifts);
                    Flat flat = new Flat(flatName, coordinates, area, flatNumberOfRooms, price, view, transport, house);
                    flat.setId(id);
                    flat.setCreationDate(data);

                    dataBase.getDataBase().put(flat.getId(), flat);
                }
                else {
                    OutputManager.logError("Incorrect file data, please correct file and try to restart the program");
                    System.exit(0);
                }


            }
        }catch (IOException e){
            OutputManager.logError(e.getMessage());
        }
    }

}
