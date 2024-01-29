package org.sample.java.streams.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NamePhoneEmail {
    private String name;
    private String phonenum;
    private String email;
}
