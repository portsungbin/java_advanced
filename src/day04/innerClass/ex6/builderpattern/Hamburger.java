package day04.innerClass.ex6.builderpattern;

//빌더패턴은 복잡한 객체를 단계적으로 생성 할 수 있도록 도와주는 디자인 패턴이다.
//옵션이나 매개변수를 가진 객체를 만들 때 유용함

import lombok.Data;

public class Hamburger {
    //필수 멤버
    private String bun;
    private String patty;
    private String drink;

    //선택 멤버
    private boolean cheese;
    private boolean lettuce;
    private boolean tomato;
    private boolean bacon;

private Hamburger(BurgerBuilder builder) {
        this.bun = builder.bun;
        this.patty = builder.patty;
        this.drink = builder.drink;
        this.cheese = builder.cheese;
        this.lettuce = builder.lettuce;
        this.tomato = builder.tomato;
        this.bacon = builder.bacon;
    }

    public static class  BurgerBuilder {
        private String bun;
        private String patty;
        private String drink;

        private boolean cheese = false; //선택할것인지 안할것인지를 하려고 boolean
        private boolean lettuce = false;
        private boolean tomato = false;
        private boolean bacon = false;
        //선택적 요소를 단계적으로 추가할 수 있도록 메서드를 설계

        public BurgerBuilder(String bun, String patty, String drink) {
            this.bun = bun;
            this.patty = patty;
            this.drink = drink;
        }

        public BurgerBuilder addCheese(){
            this.cheese = true;
            return this;
        }

        public BurgerBuilder addlettuce(){
            this.lettuce = true;
            return this;
        }

        public BurgerBuilder addtomato(){
            this.tomato = true;
            return this;
        }

        public BurgerBuilder addbacon(){
            this.bacon = true;
            return this;
        }

        //핵심 최종적으로 BurgerBuilder 객체를 반환하는 메서드를 생성
        public Hamburger build() {
            return new Hamburger(this);
        }



    }//end of inner class

    @Override
    public String toString() {
        return "Hamburger{" +
                "bun='" + bun + '\'' +
                ", patty='" + patty + '\'' +
                ", drink='" + drink + '\'' +
                ", cheese=" + cheese +
                ", lettuce=" + lettuce +
                ", tomato=" + tomato +
                ", bacon=" + bacon +
                '}';
    }
}
