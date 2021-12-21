package z_labWork;

public class Lab_2_Inheritance{

    public static void main(String[] args) {

        FootBallPlayer footBallPlayer = new FootBallPlayer("AAA",18,"Football");
        CricketPlayer cricketPlayer = new CricketPlayer("BBB",19,"Cricket");
        HockeyPlayer hockeyPlayer = new HockeyPlayer("CCC",20,"Hockey");

//        footBallPlayer.show();
//        cricketPlayer.show();
//        hockeyPlayer.show();

        Player footBall = new FootBallPlayer("",0,"");
        footBall.fun();

    }

    static class FootBallPlayer extends Player{

        String gameType;

        public FootBallPlayer(String name, int age, String gameType) {
            super(name, age);
            this.gameType = gameType;
        }

        public void fun2(){
            System.out.println("Football fun2");
        }

        public void fun1(){
            System.out.println("Football fun1");
        }

        public void show(){
            System.out.println("Player name: "+this.name);
            System.out.println("Player age : "+this.age);
            System.out.println("Game type :"+this.gameType);
            System.out.println();
        }

    }

    static class CricketPlayer extends Player{

        String gameType;

        public CricketPlayer(String name, int age, String gameType) {
            super(name, age);
            this.gameType = gameType;
        }

        public void show(){
            System.out.println("Player name: "+this.name);
            System.out.println("Player age : "+this.age);
            System.out.println("Game type :"+this.gameType);
            System.out.println();
        }

    }

    static class HockeyPlayer extends Player{

        String gameType;

        public HockeyPlayer(String name, int age, String gameType) {
            super(name, age);
            this.gameType = gameType;
        }

        public void show(){
            System.out.println("Player name: "+this.name);
            System.out.println("Player age : "+this.age);
            System.out.println("Game type :"+this.gameType);
            System.out.println();
        }

    }

    protected static class Player{
        public String name;
        public int age ;

        public Player(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void fun(){
            System.out.println("Player fun");
        }
    }

}
