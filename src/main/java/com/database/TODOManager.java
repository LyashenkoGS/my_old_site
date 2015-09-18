package com.database;

import java.util.List;

public interface TODOManager {

    List<TodoClass> getTODO();

    void addTODO(String todo, String name);

    void deleteTODO(String key);

    void updateTODO(String id, String todo, String name);
}
