package com.rhcloud.my_visualjava.dao.todo;

import com.rhcloud.my_visualjava.test.com.rhcloud.my_visualjava.todo.Todo;

import java.util.List;

public interface TodoDao {

    List<Todo> getTODO();

    void addTODO(String todo, String name);

    void deleteTODO(String key);

    void updateTODO(String id, String todo, String name);

    void isDoneTODO(String id);
}
