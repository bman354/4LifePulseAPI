package com.LifePulse.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.LifePulse.entities.User;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/user")
@OpenAPIDefinition(info = @Info(title = "Register User Service"), servers = {
        @Server(url = "http://localhost:8080", description = "Local server.")})

public interface UserController {
	//@formatter:off

	  @Operation(
	          summary = "RegisterUser",
	          description = "Create a new User, returns the newly created user and a 201 status",
	          responses = {
	                  @ApiResponse(
	                          responseCode = "201",
	                          description = "User is created and returned successfully",
	                          content = @Content(mediaType = "application/json",
	                          schema = @Schema(implementation = User.class))),

	                  @ApiResponse(
	                          responseCode = "400",
	                          description = "The requested parameters are invalid",
	                          content = @Content(mediaType = "application/json")),

	                  @ApiResponse(
	                          responseCode = "404",
	                          description = "No User made with those criteria",
	                          content = @Content(mediaType = "application/json")),

	                  @ApiResponse(
	                          responseCode = "500",
	                          description = "An unplanned error ocurred",
	                          content = @Content(mediaType = "application/json"))
	          },
	          parameters = {
	              @Parameter(
	                      name = "create_user_fname",
	                      allowEmptyValue = false,
	                      required = true,
	                      description = "New Users First Name"),
	              @Parameter(
	                      name = "create_user_lname",
	                      allowEmptyValue = false,
	                      required = true,
	                      description = "New Users Last Name"),
	              @Parameter(
	                      name = "create_user_username",
	                      allowEmptyValue = false,
	                      required = true,
	                      description = "New users username"),
	              @Parameter(
	                      name = "create_user_password",
	                      allowEmptyValue = false,
	                      required = true,
	                      description = "New users password"),
	              @Parameter(
	                      name = "create_user_email",
	                      allowEmptyValue = false,
	                      required = true,
	                      description = "New Users email"),
	              @Parameter(
	                      name = "create_user_phone",
	                      allowEmptyValue = true,
	                      required = false,
	                      description = "New Users phone number")
	          }
	  )
	  @PostMapping(value = "/register")
	  @ResponseStatus(code = HttpStatus.CREATED)
	  HttpStatus createUser(
			  @RequestParam(required = true) String create_user_fname,
			  @RequestParam(required = true) String create_user_lname,
	 		  @RequestParam(required = true) String create_user_username,
	 		  @RequestParam(required = true) String create_user_password,
			  @RequestParam(required = true) String create_user_email,
	 		  @RequestParam(required = false) Optional<String> create_user_phone);

}
