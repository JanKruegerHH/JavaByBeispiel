package org.sample.java.streams.service;

import lombok.extern.slf4j.Slf4j;
import org.sample.java.streams.domain.NamePhone;
import org.sample.java.streams.domain.NamePhoneEmail;

import java.util.stream.Stream;

@Slf4j
public class MapStreamService {

    public void logoutStreamNamePhoneEmail(Stream<NamePhoneEmail> stream) {
        stream.forEach((a) -> {
            log.info(a.getName() + " " + a.getPhonenum() + " " + a.getEmail());
        });
    }

    public void logoutStreamNamePhone(Stream<NamePhone> stream) {
        stream.forEach((a) -> {
            log.info(a.getName() + " " + a.getPhonenum());
        });
    }

    public Stream<NamePhone> map(Stream<NamePhoneEmail> stream) {
        return stream.map((a) -> new NamePhone(a.getName(), a.getPhonenum()));
    }

    public Stream<NamePhone> mapAndFilter(Stream<NamePhoneEmail> stream) {
        return stream
                .filter((a) -> a.getName().equals("Mary"))
                .map((a) -> new NamePhone(a.getName(), a.getPhonenum()));
    }
}
