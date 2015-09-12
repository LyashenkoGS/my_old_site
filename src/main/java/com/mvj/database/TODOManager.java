package com.mvj.database;

import java.util.Map;

public interface TODOManager {

    Map<String,String> getTODO();

    void addTODO(String todo, String name);
}
