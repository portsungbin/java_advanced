package day04.innerClass.ex6.builderpattern.Quiz1;

public class Student {
    //필수 멤버
    private String id;
    private String name;
    private String major;
    //선택 멤버
    private String grade;
    private String phoneNumber;
    private String address;

    private Student(StudentBuild studentBuild) {
        this.id = studentBuild.id;
        this.name = studentBuild.name;
        this.major = studentBuild.major;
        this.grade = studentBuild.grade;
        this.phoneNumber = studentBuild.phoneNumber;
        this.address = studentBuild.address;

    }

    public static class StudentBuild {
        //필수 멤버
        private String id;
        private String name;
        private String major;
        //선택 멤버
        private String grade;
        private String phoneNumber;
        private String address;

        public StudentBuild(String id, String name, String major) {
            this.id = id;
            this.name = name;
            this.major = major;
        }


        public StudentBuild addgrade() {
            this.grade = "freshman";
            return this;
        }
        public StudentBuild addphoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        public StudentBuild addaddress(String address) {
            this.address = address;
            return this;
        }

        public Student Build() {
            return new Student(this);
        }


    }
    @Override
    public String toString() {
        return "StudentBuild{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", grade='" + grade + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
