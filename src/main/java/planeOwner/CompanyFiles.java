package planeOwner;

import java.io.*;
import java.util.List;

public class CompanyFiles {

    public static  void outputBinaryFilmsIntoFile(List<Company> films, String fileName) throws IOException {
        try( ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))){
            objectOutputStream.writeObject(films);}
    }


    public static List<Company> readBinaryFilmsFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Company>) objectInput.readObject();
        }
    }
}
