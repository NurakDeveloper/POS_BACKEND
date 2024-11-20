package com.pos.pos_backend.service.implement;

import com.pos.pos_backend.model.Employee;
import com.pos.pos_backend.model.user.User;
import com.pos.pos_backend.model.user.UserRequest;
import com.pos.pos_backend.model.user.UserRespone;
import com.pos.pos_backend.repository.EmployeeRepository;
import com.pos.pos_backend.repository.UserRepository;
import com.pos.pos_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserImpl implements UserService {
    private UserRepository userRepository;
    private EmployeeRepository employeeRepository;
    @Override
    public UserRespone userLogin(UserRequest userRequest) {
        User users = userRepository.findByUserName(userRequest.getUserName());
        if(users != null){
            if(userRequest.getPassword().equals(users.getPassword())){

                try {
                    Employee employee = employeeRepository.findById(users.getUserId()).orElseThrow();
                    return new UserRespone("ok" , "success" ,users.getUserId() ,users.getRole(), employee);
                }catch (Exception e){
                    return new UserRespone("ok" , "success" ,users.getUserId() ,users.getRole(), null);
                }

            }
        }
        return new UserRespone("error" , "fail" , null ,null,null);
    }
}
