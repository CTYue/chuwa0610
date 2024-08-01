//package com.chuwa.mongoblog.service.Impl;
//
//import com.chuwa.mongoblog.dto.UserDto;
//import com.chuwa.mongoblog.entity.User;
//import com.chuwa.mongoblog.repository.UserRepository;
//import com.chuwa.mongoblog.service.UserService;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
///**
// * @Create 07/2024
// * @Author xiao
// * @Description
// */
//
//@Service
//public class UserServiceImpl implements UserService {
//
//	@Autowired
//	private UserRepository userRepository;
//
//	public UserServiceImpl() {
//	}
//
//	public UserServiceImpl(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
//
//	@Override
//	 public UserDto createUser(UserDto userDto) {
//		 User user = new User();
////		 user.setId(userDto.getId());
//		 user.setName(userDto.getName());
//		 user.setAddress(userDto.getAddress());
//
//		 User savedUser = userRepository.save(user);
//		 UserDto response = new UserDto();
////		 response.setId(savedUser.getId());
//		 response.setName(savedUser.getName());
//		 response.setAddress(savedUser.getAddress());
//
//		 return response;
//	 }
//
//
//
//	@Override
//	public Optional<UserDto> getUserById(String userId) {
////		ObjectId objectId = null;
////		try {
////			objectId = new ObjectId(userId);
////			// 调用UserService获取数据
////			// 返回相应的 ResponseEntity
////		} catch (IllegalArgumentException e) {
////			// 处理ObjectId格式不正确的情况，返回合适的响应或记录日志
////			e.printStackTrace();
////		}
//
//		Optional<User> userOptional = userRepository.findById(userId);
//		if (!userOptional.isPresent()) {
//			return Optional.empty();
//		}
//		UserDto response = new UserDto();
////		response.setId(user.getId());
//		response.setName(userOptional.get().getName());
//		response.setAddress(userOptional.get().getAddress());
//		return Optional.of(response);
//	}
//}
