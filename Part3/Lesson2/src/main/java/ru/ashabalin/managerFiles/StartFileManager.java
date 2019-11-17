package ru.ashabalin;

/**
 * @author Aleksei Shabalin on 22.11.2016.
 */
public class StartFileManager {
    private FileManager fileManager;

    public StartFileManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public void init() {
        System.out.println("***Hello!!!***");
        fileManager.fillMenu();
        while (true){
            fileManager.showMenu();
        }
    }
}
