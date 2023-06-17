package dev.toktab.model;

import java.util.HashMap;

public class Global {

    private static final HashMap<Integer,String> roleName = new HashMap<Integer,String>(){{
        put(1, "Worker");
        put(2, "Manager");
        put(3, "Head-Manager");
        put(4, "Admin");
        put(5, "Head-Admin");
    }};;

    public static String getRoleName(int id){
        return roleName.get(id);
    }
}
