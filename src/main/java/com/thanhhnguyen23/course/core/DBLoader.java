package com.thanhhnguyen23.course.core;

import com.thanhhnguyen23.course.Course;
import com.thanhhnguyen23.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DBLoader implements ApplicationRunner {
    private final CourseRepository courses;

    @Autowired
    public DBLoader(CourseRepository courses) {
        this.courses = courses;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Course course1 = new Course("Java Basics", "https://docs.oracle.com/javase/tutorial/java/nutsandbolts/index.html");
        Course course2 = new Course("Effective Java", "https://github.com/jbloch/effective-java-3e-source-code");
        courses.save(course1);
        courses.save(course2);
    }
}
