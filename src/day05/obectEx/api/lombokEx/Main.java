package day05.obectEx.api.lombokEx;

public class Main {
    public static void main(String[] args) {
        Member member = new Member();
        Member member1 = new Member("shin", "sss", 24);
        System.out.println(member1.getId());
        member1.setId("sssss");
        System.out.println(member1.toString());
    }
}
