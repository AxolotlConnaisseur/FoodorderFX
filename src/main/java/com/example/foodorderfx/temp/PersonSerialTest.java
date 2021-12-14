package com.example.foodorderfx.temp;

import java.io.*;

public class PersonSerialTest implements Serializable {

    public String vorname;
    public String nachname;
    public int alter;
    public String geschlecht;

    static final long serialVersionUID = 1L;

    public PersonSerialTest(String vorname, String nachname, int alter) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.alter = alter;
    }

    public PersonSerialTest(String vorname, String nachname, int alter, String geschlecht) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.alter = alter;
        this.geschlecht = geschlecht;
    }

    public static void main(String[] args) {

        String path = "C:\\Users\\Franzi\\FoodorderFX\\src\\main\\java\\com\\example\\foodorderfx\\temp\\somefile.dat";


        PersonSerialTest originalPerson = new PersonSerialTest("Franzi", "Eingärtner", 20, "Blobb");
        PersonSerialTest originalPerson2 = new PersonSerialTest("John", "Doe", 30, "Plastik-Dummy");

        System.out.println("Original Person = " + originalPerson);
        System.out.println("Original Person = " + originalPerson2);

        serializeObject(originalPerson2, path);
        serializeObject(originalPerson, path);


        System.out.println();

        PersonSerialTest deserializedPerson = deSerializeObject(path);
        PersonSerialTest deserializedPerson2 = deSerializeObject(path);
        System.out.println("Deserialized Person = " + deserializedPerson);
        System.out.println("Deserialized Person = " + deserializedPerson2);

    }

    private static void serializeObject(PersonSerialTest person, String path) {

        FileOutputStream fos = null;
        ObjectOutputStream out = null;

        try {

            fos = new FileOutputStream(path);
            out = new ObjectOutputStream(fos);
            out.writeObject(person);
            out.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static PersonSerialTest deSerializeObject(String path) {

        PersonSerialTest person = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(path);
            in = new ObjectInputStream(fis);
            person = (PersonSerialTest) in.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return person;
    }

    @Override
    public String toString() {
        return "PersonSerialTest{" +
                "vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", alter=" + alter +
                ", geschlecht='" + geschlecht + '\'' +
                '}';
    }
}
