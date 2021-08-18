package sort;

import java.util.*;
import java.util.stream.Collectors;

public class StudentGrade {

    static class Student {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            students.add(new Student(name, score));
        }

        List<Student> sortedStudents = students.stream()
            .sorted(Comparator.comparing(Student::getScore).reversed())  // 성적이 높은 순으로 정렬
            .collect(Collectors.toList());

        for (Student student : sortedStudents) {
            System.out.println(student.getName());
        }

    }
}

/*
2
홍길동 95
이순신 77
* */