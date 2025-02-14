package day06.gennericEx.ex4;

public class Course {

    //person(사람) 이면 수강등록 기능
    public static void registerCourse1(Applicant<?> applicant) {
        System.out.println(applicant.kind.getClass().getSimpleName() + "이 Course1을 등록함");
    }

    //학생만 등록 가능 기능
    public static void registerCourse2(Applicant<? extends Student> applicant) {
        System.out.println(applicant.kind.getClass().getSimpleName() + "이 Course2을 등록함");
    }

    //직장인 및 일반인만 등록 가능 기능
    public static void registerCourse3(Applicant<? super Worker> applicant) {
        System.out.println(applicant.kind.getClass().getSimpleName() + "이 Course3을 등록함");
    }
}
