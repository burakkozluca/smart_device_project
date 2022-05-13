import java.util.ArrayList;
import java.util.List;

public class Publisher implements ISubject{
    private  List<IObserver> subscribers = new ArrayList<>();

    @Override
    public void attach(IObserver subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void detach(IObserver subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notify(String mesaj) throws InterruptedException {
        SıcaklıkAlgılama sıcaklıkAlgılama=new SıcaklıkAlgılama();
        int sicaklik=sıcaklıkAlgılama.sicaklikOku();
        if (sicaklik<15||sicaklik>40){
            for (IObserver observer:subscribers) {
                observer.update();
            }
        }
    }
}
