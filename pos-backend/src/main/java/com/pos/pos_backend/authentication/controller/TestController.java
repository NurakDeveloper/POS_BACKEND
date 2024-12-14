package com.pos.pos_backend.authentication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("admin")
    @PreAuthorize("hasAuthority('admin:get')")
    public String getAdminEndpoint(){
        return "ADMIN:GET";
    }
    @PostMapping("admin/create")
    @PreAuthorize("hasAuthority('admin:create')")
    public String createAdminEndpoint(){
        return "ADMIN:CREATE";
    }
    @DeleteMapping("admin/remove")
    @PreAuthorize("hasAuthority('admin:delete')")
    public String removeAdminEndPoint(){
        return "ADMIN:DELETE";
    }
    @PutMapping("admin/update")
    @PreAuthorize("hasAuthority('admin:update')")
    public String updateEndPoint(){
        return "ADMIN:UPDATE";
    }
    @PostMapping("seller/create")
    @PreAuthorize("hasAuthority('seller:create')")
    public String sellerCreateEndPoint(){
        return "SELLER:CREATE";
    }
    @GetMapping("seller")
    @PreAuthorize("hasAuthority('seller:get')")
    public String userGetEndPoint(){
        return "SELLER:GET";
    }
    @DeleteMapping("seller/delete")
    @PreAuthorize("hasAuthority('seller:delete')")
    public String sellerDeleteEndpoint(){
        return "SELLER:DELETE";
    }
    @PutMapping("seller/update")
    @PreAuthorize("hasAuthority('seller:get')")
    public String userUpdateEndPoint(){
        return "SELLER:UPDATE";
    }

}
