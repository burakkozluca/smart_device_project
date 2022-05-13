import java.util.Random;

public class SıcaklıkAlgılama implements ISıcaklıkAlgılama{

    @Override
    public int sicaklikOku() throws InterruptedException {
        System.out.println("Sıcaklık Okunuyor.............");
        Random rand=new Random();
        int sicaklik=rand.nextInt(75);
        Thread.sleep(1000);
        System.out.println("Sıcaklık: " + sicaklik + "°C");

        return sicaklik;
    }
}
