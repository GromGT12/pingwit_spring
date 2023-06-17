package pl.pingwit.springbootfirst;

import java.util.List;

public class UserService{
private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void printUser(){
        List<UserRecord> userRecordList = userRepository.findAllUsers();
        userRecordList.forEach(System.out::println);

    }
}
