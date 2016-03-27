package com.goit.ee.module1.api;

/**
 * Created by Администратор on 26.03.2016.
 */
public interface Provider<T> {
    T get(int size);
}
