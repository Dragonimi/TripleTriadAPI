package com.revature.ttapi.user;

import com.revature.ttapi.common.exceptions.AccountExistsException;
import com.revature.ttapi.user.dtos.requests.UserRequest;
import com.revature.ttapi.user.dtos.responses.UserResponse;
import com.revature.ttapi.user.models.AppUser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {



    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public void checkUsernameAvailability(@PathVariable String username) {
        if (userService.usernameExists(username)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse registerAccount(@Valid UserRequest userRequest, HttpServletRequest servletRequest) {
        try {
            AppUser registeredUser = userService.registerNewUserAccount(userRequest);
            return new UserResponse(registeredUser);
        } catch (AccountExistsException e) {
            return null;
        }
    }
}
