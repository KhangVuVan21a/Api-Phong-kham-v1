package com.example.demo.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.LoginDto;
import com.example.demo.Dto.RegisterDto;
import com.example.demo.Dto.UserJwtDto;
import com.example.demo.Service.impl.UserServiceImpl;
import com.example.demo.Utils.Constants;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:3000")
public class AuthController extends BaseControll{
	private final static String MESSAGE_ERROR_LOG = "AuthController error !";

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterDto input, Errors errors) {
        try{
            if (errors.hasErrors())
                return this.error(this.errorResponse(errors));

            if (this.userService.isCheckUserName(input.getUserName())) {
                return this.error(this.errorResponse("Username is already taken !"));
            }
            if (this.userService.isCheckEmail(input.getEmail())) {
                return this.error(this.errorResponse("Email is already in use !"));
            }

            // Create new user's account
            UserJwtDto output =  this.userService.userRegister1(input);

            return this.success(this.successResponse(Constants.REGISTER_SUCCESS, output));
        }catch (Exception ex){
            log.error(MESSAGE_ERROR_LOG, ex);
            return this.serverError();
        }
    }

    @PostMapping("/login")
  //  @Parameter(name = "Login api")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDto input, Errors errors)
    {
        try{
            if (errors.hasErrors())
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(this.errorResponse(errors));

            UserJwtDto output = this.userService.userLogin1(input);
            return ResponseEntity.ok(this.successResponse(Constants.LOGIN_SUCCESS, output));

        }catch (AuthenticationException ex)
        {
            return this.error(this.errorResponse(Constants.LOGIN_ERROR));
        }catch (Exception ex){
            log.error(MESSAGE_ERROR_LOG, ex);
            return this.serverError();
        }
    }
}
