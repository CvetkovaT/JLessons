package kz.tsetkova.tasya.homeWorks.filegenerator;

import java.io.*;

public class MyFileGenerator {
    private String filesPath;

    public MyFileGenerator(String filesPath) {
        this.filesPath = filesPath;
    }


    public void generateNewFiles(int n){

        for(int i = 0; i < n; i++){
            String fileNameWithPath = filesPath + "\\test_" + i + ".txt";
            File file = new File(fileNameWithPath);

            if (!file.exists()  && file.isFile()){
                try {
                    file.createNewFile();
                    System.out.println("file generated");
                } catch (IOException e) {
                    System.out.println("File is not allowed to create");
                    System.exit(8);
                }
            }
            try (var fos = new FileOutputStream(file)) {
                boolean isComma = false;

                fos.write ((char)((int)(Math.random()*26 + 66)));
                while (true){
                    int wordLen = (int)(Math.random()*4 + 4);
                    for (int j = 0; j < wordLen; j++){
                        fos.write ((char)((int)(Math.random()*26 + 97)));
                    }
                    double randValue = Math.random();
                    if(randValue < 0.3){
                        if (!isComma) {
                            fos.write(',');
                            fos.write(' ');
                            isComma = true;
                        } else {
                            if (randValue < 0.1) {
                                fos.write('?');
                                break;
                            }
                            else if (randValue < 0.2) {
                                fos.write('!');
                                break;
                            }

                            fos.write('.');
                            break;

                        }
                    } else {
                    fos.write(' ');
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
