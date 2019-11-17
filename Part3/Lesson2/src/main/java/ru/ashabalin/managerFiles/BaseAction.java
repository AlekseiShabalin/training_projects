package ru.ashabalin;

/**
 * @author Aleksei Shabalin on 22.11.2016.
 */
public abstract class BaseAction {
    private String name;

    public abstract int key();

    public BaseAction(String name) {
        this.name = name;
    }

    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }
}
