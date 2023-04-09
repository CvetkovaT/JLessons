package kz.tsetkova.tasya.homeWorks.filegenerator;

public class Main {
    public static void main(String[] args) {
        MyFileGenerator testGen = new MyFileGenerator("D:\\programming\\myFileTester");
        testGen.generateNewFiles(5);
        StrangeDictionary dic = new StrangeDictionary();
        dic.dictionaryGenerate();
    }
}
