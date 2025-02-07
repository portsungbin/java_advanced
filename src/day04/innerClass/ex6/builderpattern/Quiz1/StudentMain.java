package day04.innerClass.ex6.builderpattern.Quiz1;

public class StudentMain {
    public static void main(String[] args) {
        Student 성빈 = new Student.StudentBuild("내 아이디", "임성빈", "학생")
                .addgrade()
                .addphoneNumber("010-1234-5678")
                .addaddress("2@2")
                .Build();
        System.out.println(성빈);

        Student 창선 = new Student.StudentBuild("형 아이디", "강창선", "3@3")
                .addgrade()
                .addphoneNumber("010-8765-4321")
                .Build();
        System.out.println(창선);
    }
}
