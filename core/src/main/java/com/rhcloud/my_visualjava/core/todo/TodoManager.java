package com.rhcloud.my_visualjava.core.todo;


import java.util.List;

public interface TodoManager {
    List<Todo> getTODO();

    void addTODO(String todo, String name);

    void deleteTODO(String key);

    void updateTODO(String id, String todo, String name);

    void isDoneTODO(String id);
}
