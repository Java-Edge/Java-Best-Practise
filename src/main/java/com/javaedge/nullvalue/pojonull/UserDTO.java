package com.javaedge.nullvalue.pojonull;

import lombok.Data;

import java.util.Optional;

@Data
public class UserDTO {
    private Long id;

    /**
     * 以区分用户不传数据 or 故意传null
     */
    private Optional<String> name;

    /**
     * 以区分用户不传数据 or 故意传null
     */
    private Optional<Integer> age;
}
