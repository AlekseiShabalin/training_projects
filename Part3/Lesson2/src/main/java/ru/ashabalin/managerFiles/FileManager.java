package ru.ashabalin;

/**
 * @author Aleksei Shabalin.
 */

/*
Перед реализацией в коде. Составить каркас приложения на интерфейсах.
С описанием.
1. Разработать клиент серверное приложение на сокетах.
2. Серверная часть должна реализовывать следующее апи
    - получить список корневого каталога. Корневой каталог задается при запуске
сервера.
    - перейти в подкаталог.
    - спуститься в родительский каталог
    - скачать файл
    - загрузить файл.
3. Клиент должен это апи уметь вызывать.
 */

import java.io.File;

/**
 * This is class contains the business logic of a File Manager
 */
public class FileManager {
    // it`s path to directory
    private String pathDir = "Part3\\Lesson2\\src\\main\\resources\\";
//    File file = new File(pathDir);
    //it`s array contains of a menu File Manager
    private String[] menu = new String[5];
    private int position = 0;
    //it`s array files and directories in folder
    private File[] allFile;

    public File[] getAllFile() {
        return allFile;
    }

    /**
     * This is method fills menu of a File Manager
     */
    public void fillMenu() {
        this.menu[position++] = String.format("%s. %s", position, "Show list of root folder");
        this.menu[position++] = String.format("%s. %s", position, "Go to folder");
        this.menu[position++] = String.format("%s. %s", position, "To return the parent folder");
        this.menu[position++] = String.format("%s. %s", position, "Download file");
        this.menu[position++] = String.format("%s. %s", position, "Download the file in");

    }

    /**
     * This is method shows menu of a File Manager
     */
    public void showMenu() {
        System.out.println("***Menu programme***");
        for (String menuItem : this.menu) {
            if (menuItem != null) {
                System.out.println(menuItem);
            }
        }
    }

    /**
     * This is method execute action of a User
     */
    public void action() {

    }

    /**
     * Returns names the files and directories
     */
    public void showAllFile(String path) {
        File file = new File(path);
        allFile = file.listFiles();

        for (String subFile : file.list()) {
            System.out.println(subFile);
//            if (subFile.isDirectory()) {
//                System.out.println(subFile.getName());
//                showAllFile(subFile.getPath());
//            }else {
//                System.out.println(subFile.getName());
//            }
        }

//        for (File subFile : allFile) {
//            if (subFile.isDirectory() && subFile != null) {
//                System.out.println(subFile.getName());
//                showAllFile(subFile.getPath());
//            }else {
//                System.out.println(subFile.getName());
//            }
//        }

    }



}