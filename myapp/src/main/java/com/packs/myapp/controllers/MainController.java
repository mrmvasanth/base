package com.packs.myapp.controllers;

import com.packs.myapp.models.entity.Users;
import com.packs.myapp.models.response.ApiResponse;
import com.packs.myapp.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    UsersService usersService;

    @PostMapping("/auser")
    public ApiResponse addUser(@RequestBody Users user){
        return usersService.addUser(user);
    }

    @GetMapping("/guser/{userid}")
    public ApiResponse getAllUsers(@PathVariable Long userid){
        return usersService.getUser(userid);
    }

    @DeleteMapping("duser/{userid}")
    public ApiResponse deleteUser(@PathVariable Long userid){
        return usersService.deleteUser(userid);
    }

}
