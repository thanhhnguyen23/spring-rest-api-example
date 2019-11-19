package com.thanhhnguyen23.course.core;

import com.thanhhnguyen23.course.Course;
import com.thanhhnguyen23.course.CourseRepository;
import com.thanhhnguyen23.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DBLoader implements ApplicationRunner {
    private final CourseRepository courses;

    @Autowired
    public DBLoader(CourseRepository courses) {
        this.courses = courses;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Course course = new Course("Effective Java", "https://github.com/jbloch/effective-java-3e-source-code");
        course.addReview(new Review(3, "this course is awesome!"));
        courses.save(course);

        String[] templates = {
                "Up and Running with %s",
                "%s Basics",
                "%s for Beginners",
                "Under the hood: %s"
        };
        String[] buzzwords = {
                "Spring REST Data",
                "Java 8",
                "Scala",
                "Groovy",
                "Hibernate"
        };
        List<Course> bunchOfCourses = new ArrayList<>();
        IntStream.range(0,100)
                .forEach(i -> {
                    String template = templates[i % templates.length];
                    String buzzword = buzzwords[i % buzzwords.length];

                    String title = String.format(template, buzzword);
                    Course c = new Course(title, "http://www.example.com");
                    c.addReview(new Review(i % 5, String.format("More %s please!!!", buzzword)));
                    bunchOfCourses.add(c);
                });
        /**
         * saveAll() supports iterable Collection interfaces such as List
         * where save() is used for single objects (Course)
         */
        courses.saveAll(bunchOfCourses);
    }
}
