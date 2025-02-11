package day06.gennericEx.ex4;

public class Applicant<T>{
    public T kind;

    public Applicant(T kind) {
        this.kind = kind;
    }
}
