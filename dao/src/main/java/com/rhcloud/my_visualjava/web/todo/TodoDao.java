package com.rhcloud.my_visualjava.web.todo;

import com.rhcloud.my_visualjava.test.com.rhcloud.my_visualjava.todo.Todo;

import java.util.List;

public interface TodoDao {

    List<Todo> getAllTodo();

    List<Todo> getAllActiveTodo();
    List<Todo> getAllDoneTodo();
    void addTODO(String todo, String name);

    void deleteTODO(String key);

    void updateTODO(String id, String todo, String name);

    void isDoneTODO(String id);

    void changeDefaultJdbcConfiguration();
}
