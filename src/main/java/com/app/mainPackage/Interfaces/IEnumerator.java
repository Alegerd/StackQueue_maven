package com.app.mainPackage.Interfaces;

/**
 * Created by alegerd on 19.02.17.
 */
public interface IEnumerator {
    boolean MoveNext(); // перемещение на одну позицию вперед в контейнере элементов
    Object getCurrent();  // текущий элемент в контейнере
    void Reset(); // перемещение в начало контейнера
}
