package array;

import java.util.*;

class Student implements Comparable<Student> {

    private String name = "";
    private int score = 0;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }
    public int getScore() {
        return this.score;
    }
    // 점수가 낮은 순서로 정렬
    @Override
    public int compareTo(Student student) {
        if (this.score < student.score) return -1; // student.getScore안쓰고 어떻게 접근이 될까?
        return 1;
    }
}

public class AscendingScore6_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        
        int n = sc.nextInt();
        sc.nextLine(); // 버퍼비우기
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            int score = sc.nextInt();

            students.add(new Student(name, score));
            sc.nextLine(); // 버퍼비우기
        }

        Collections.sort(students);

        for (int i = 0; i < n; i++) {
            System.out.printf("%s ", students.get(i).getName());
        }
    }
}

