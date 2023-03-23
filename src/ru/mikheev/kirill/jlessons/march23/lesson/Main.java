package ru.mikheev.kirill.jlessons.march23.lesson;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        File testFile = new File("test.out");

        initSimpleFile(testFile);

        try(InputStream fis = new ByteArrayInputStream(new byte[] {1,2,3,4})) {
            printAllBytesFromStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //printlnWordsFromFile(testFile);

    }


    public static void initSimpleFile(File file) {
        if(!file.exists() && file.isFile()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("File is not allowed to create");
                System.exit(228);
            }
        }

        try (var fos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {

            fos.writeUTF("Hello\n");
            fos.writeUTF("World\n");
            fos.writeUTF("!\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printlnWordsFromFile(File file) {


        try (var fis = new DataInputStream(new FileInputStream(file))) {
            StringBuilder singleWord = new StringBuilder("");

            while(  fis.available() > 0 ) {
                System.out.println(fis.readUTF());

//                char ch = (char)fis.read();
//                if(ch == ' ') {
//                    System.out.println(singleWord);
//                    singleWord.delete(0, singleWord.length());
//                }else{
//                    singleWord.append(ch);
//                }
            }
            System.out.println(singleWord);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void printAllBytesFromStream(InputStream is) throws IOException {
        int tmp;
        while((tmp = is.read()) != -1)  {
            System.out.println(tmp);
        }
    }
}
