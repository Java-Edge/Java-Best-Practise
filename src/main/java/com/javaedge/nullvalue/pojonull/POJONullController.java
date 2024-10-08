package com.javaedge.nullvalue.pojonull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("pojonull")
@RestController
public class POJONullController {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public void test() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jdk8Module());
        UserDTO result = objectMapper.readValue("{\"id\":\"1\", \"age\":30, \"name\":null}", UserDTO.class);
        log.info("field name with null value dto:{} name:{}", result, result.getName().orElse("N/A"));
        // field name with null value dto:UserDTO(id=1, name=Optional.empty, age=Optional[30]) name:N/A
        log.info("missing field name dto:{}", objectMapper.readValue("{\"id\":\"1\", \"age\":30}", UserDTO.class));
        // missing field name dto:UserDTO(id=1, name=null, age=Optional[30])
    }

    @PostMapping("bad")
    public User wrong(@RequestBody User user) {
        user.setNickname(String.format("guest%s", user.getName()));
        return userRepository.save(user);
    }

    @PostMapping("right")
    public UserEntity right(@RequestBody UserDTO user) {
        if (user == null || user.getId() == null)
            throw new IllegalArgumentException("用户Id不能为空");

        UserEntity userEntity = userEntityRepository.findById(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("用户不存在"));

        if (user.getName() != null) {
            userEntity.setName(user.getName().orElse(""));
        }
        userEntity.setNickname("guest" + userEntity.getName());
        if (user.getAge() != null) {
            userEntity.setAge(user.getAge().orElseThrow(() -> new IllegalArgumentException("年龄不能为空")));
        }
        return userEntityRepository.save(userEntity);
    }
}