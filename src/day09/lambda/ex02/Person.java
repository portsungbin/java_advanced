package day09.lambda.ex02;
//Person 클래스는 Workable을 매개변수로 갖는 action 메소드와 speakable을 매개변수로 갖는 action2() 갖고 있다

public class Person {
    private String name;
    private String job;
    private String contents;
    private String songtitle;

    public Person(String name, String job, String contents, String songtitle) {
        this.name = name;
        this.job = job;
        this.contents = contents;
        this.songtitle = songtitle;
    }

    public void action(Workable workable) {
        workable.work(name, job);
    }

    public void action2(Speakable speakable) {
        speakable.speak(contents);
    }

    public void action3(song song) {
        song.sing(songtitle);
    }


}
