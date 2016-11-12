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

/**
 * This is class contains the business logic of a File Manager
 */
public interface FileManager {
    // it`s path to directory
    String pathDir;
    //it`s array contains of a menu File Manager
    String[] menu;

    /**
     * This is method fills menu of a File Manager
     */
    void fillMenu();

    /**
     * This is method shows menu of a File Manager
     */
    void showMenu();

    /**
     * This is method execute action of a User
     */
    void action();

}