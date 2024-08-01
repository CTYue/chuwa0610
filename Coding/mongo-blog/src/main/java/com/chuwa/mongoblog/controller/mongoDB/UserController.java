//package com.chuwa.mongoblog.controller;
//
////import com.chuwa.mongoblog.dto.PostDto;
//import com.chuwa.mongoblog.dto.UserDto;
////import com.chuwa.mongoblog.entity.User;
////import com.chuwa.mongoblog.servicevice.PostService;
//import com.chuwa.mongoblog.service.UserService;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
///**
// * @Create 07/2024
// * @Author xiao
// * @Description
// */
//
//
//@RestController
//@RequestMapping("api/v1/users")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    MongoTemplate mongoTemplate;
//
//	@PostMapping(value = "create")
//	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
//	    UserDto response = userService.createUser(userDto);
//	    return new ResponseEntity<>(response, HttpStatus.CREATED);
//	}
//
//
//	/**
//	* @PathVariable
//	* 用于获取URL路径中的动态部分。示例URL：/posts/123
//	* @param id
//	* @return
//	*/
//
////	@GetMapping(value = "/{id}")
////	public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") String id) {
////		Optional<UserDto> userOptional = userService.getUserById(id);
////		if (userOptional.isPresent()) {
////			UserDto user = userOptional.get();
////			UserDto userDto = new UserDto();
////			userDto.setName(user.getName());
////			userDto.setAddress(user.getAddress());
////			return ResponseEntity.ok(userDto);
////		} else {
////			return ResponseEntity.notFound().build();
////		}
////	}
//
//	@GetMapping
//	public ResponseEntity<UserDto> getUserById(@RequestParam(name = "id") String id) {
//		Optional<UserDto> userOptional = userService.getUserById(id);
//		if (userOptional.isPresent()) {
//			UserDto user = userOptional.get();
//			UserDto userDto = new UserDto();
//			userDto.setName(user.getName());
//			userDto.setAddress(user.getAddress());
//			return ResponseEntity.ok(userDto);
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}
//
// /**
//  * @RequestParam
//  * 用于获取URL查询字符串中的参数。示例URL：/posts?category=tech
//  */
//}
