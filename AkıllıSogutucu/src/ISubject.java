public interface ISubject {
    void attach(IObserver obs);
    void detach(IObserver obs);

    void notify(String mesaj) throws InterruptedException;
}
