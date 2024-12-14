package com.pos.pos_backend.authentication.RoleAndPermission;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RolePermissionConfig {
    private static final Map<String, List<String>> ROLE_PERMISSIONS = new HashMap<>();

    static {
        ROLE_PERMISSIONS.put("ADMIN", Arrays.asList(
                "admin:get",
                "admin:create",
                "admin:delete",
                "admin:update",
                "seller:get",
                "seller:create",
                "seller:delete",
                "seller:update",
                "manager:get",
                "manager:update" ,
                "manager:create" ,
                "manager:delete"
        ));
        ROLE_PERMISSIONS.put("SELLER", Arrays.asList(
                "seller:get", "seller:update" , "seller:create"
        ));

        ROLE_PERMISSIONS.put("MANAGER", Arrays.asList(
                "seller:get",
                "seller:create",
                "seller:delete",
                "seller:update",
                "manager:get",
                "manager:update" ,
                "manager:create" ,
                "manager:delete"
        ));

    }

    public static List<String> getPermissionsByRole(String role) {
        return ROLE_PERMISSIONS.getOrDefault(role, Arrays.asList());
    }
}
