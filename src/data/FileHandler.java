package data;

import java.io.*;
import java.util.List;

public class FileHandler<T>{
    private String filePath="src/data/myCustomers.ser";
    public void WriteToSerializeFile(List<T> list)throws IOException
    {
        FileOutputStream fos=new FileOutputStream(filePath);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
        fos.close();

    }

    public List<T> ReadFromSerializeFile() throws FileNotFoundException,IOException,ClassNotFoundException
    {
        List<T> list;
        FileInputStream fis=new FileInputStream(filePath);
        ObjectInputStream ois=new ObjectInputStream(fis);

        list=(List<T>)ois.readObject();

        return list;
    }
}
