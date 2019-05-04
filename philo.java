import java.util.Random;

public class philo {
    private int philoId;
    private Frk left,right;

    public philo(int philoId){
        this.philoId=philoId;
    }

    public void start(Frk left,Frk right) throws InterruptedException{

        this.left=left;
        this.right=right;

        while(true){
            if(new Random().nextBoolean()){
                eat();
            }else{
                think();
            }
        }
    }

    public void think() throws InterruptedException{

        System.out.println("The Philosopher: "+philoId +" is now thinking");
        Thread.sleep(new Random().nextInt(1000)+100);
        System.out.println("The Philosopher : "+philoId +" has stopped thinking.");
    }

    public void eat() throws InterruptedException{

        boolean rightPick=false;
        boolean leftPick=false;

        System.out.println(philoId +" philosoper is now humgry and want to eat.");

        System.out.println(philoId +" philosoper is now picking up the Fork: "+left.forkId);
        leftPick =left.pick(philoId);

        if(!leftPick){
            return;
        }
        System.out.println(philoId+"philosoper is now picking up the fork: "+right.forkId);
        rightPick =left.pick(philoId);

        if(!rightPick){
            left.free();
            return;
        }

        System.out.println(+philoId +"philosoper is now eating");

        Thread.sleep(new Random().nextInt(1000)+100);

        left.free();
        right.free();

        System.out.println(philoId+"philosoper hasa stopped eating and freed the Forks.");
    }

}
