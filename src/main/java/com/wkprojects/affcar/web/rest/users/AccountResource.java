/**
 * Copyright (c) 2019. CreatedBy Wassim KALBOUSSI.  All rights reserved.
 */

package com.wkprojects.affcar.web.rest.users;

import com.wkprojects.affcar.model.JwtToken;
import com.wkprojects.affcar.model.LoginModel;
import com.wkprojects.affcar.security.AuthoritiesConstants;
import com.wkprojects.affcar.security.SecurityUtils;
import com.wkprojects.affcar.service.dto.users.UserDto;
import com.wkprojects.affcar.service.interfaces.users.IUserService;
import com.wkprojects.affcar.web.rest.vm.ChangePasswordVM;
import com.wkprojects.affcar.web.rest.vm.ResetPasswordVM;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class AccountResource {

    private final IUserService userService;

    public AccountResource(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registerUser")
    public ResponseEntity registerUser(@Valid @RequestBody UserDto userDto) {
        UserDto savedUser = userService.registerUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/activateUser")
    public ResponseEntity activateUser(@RequestParam("key") String key) {
        UserDto user = userService.activateUser(key);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity authenticateUser(@Valid @RequestBody LoginModel loginModel) {
        String jwt = userService.authenticateUser(loginModel);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + jwt);
        return new ResponseEntity<>(new JwtToken(jwt), httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/getRemoteUser")
    public String getRemoteUser(HttpServletRequest request) {
        return request.getRemoteUser();
    }

    @GetMapping("/isAuthenticated")
    public ResponseEntity isAuthenticated() {
        return new ResponseEntity<>(SecurityUtils.isAuthenticated(), HttpStatus.OK);
    }

    @GetMapping("/getCurrentUserEmail")
    public ResponseEntity getCurrentUserEmail() {
        String currentUserEmail = userService.getCurrentUserEmail();
        return new ResponseEntity<>(currentUserEmail, HttpStatus.OK);
    }

    @GetMapping("/getCurrentUser")
    public ResponseEntity getCurrentUser() {
        UserDto user = userService.getCurrentUser();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/isCurrentUserInRole")
    public ResponseEntity isCurrentUserInRole(@RequestParam("role") String role) {
        return new ResponseEntity<>(SecurityUtils.isCurrentUserInRole(role), HttpStatus.OK);
    }

    @PutMapping("/deactivateUser/{email}")
    @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.SUPER_ADMIN})
    public ResponseEntity deactivateUser(@PathVariable("email") String email) {
        userService.deactivateUser(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/changePassword")
    public ResponseEntity changePassword(@Valid @RequestBody ChangePasswordVM changePasswordVM) {
        userService.changePassword(changePasswordVM.getCurrentPassword(), changePasswordVM.getNewPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/resetPassword/init/{email}")
    public ResponseEntity requestResetPassword(@PathVariable String email){
        userService.requestResetPassword(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/resetPassword/finish")
    public ResponseEntity finishResetPassword(@Valid @RequestBody ResetPasswordVM resetPasswordVM){
        userService.finishResetPassword(resetPasswordVM);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{email}")
    public ResponseEntity deleteUser(@PathVariable("email") String email){
        userService.deleteUser(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updateUser")
    @Secured({AuthoritiesConstants.ADMIN,AuthoritiesConstants.SUPER_ADMIN})
    public ResponseEntity updateUser(@Valid @RequestBody UserDto user){
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity logout(){
        userService.logout();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
