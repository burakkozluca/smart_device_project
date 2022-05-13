public class Eyleyici1 implements IAgArayüz{
    @Override
    public int sogutucuAc() throws InterruptedException {
        System.out.println("Sogutucu Açılıyor.......");
        System.out.println("Sıcaklık Düşürülüyor.......");
        Thread.sleep(1000);
        System.out.println("Sıcaklık Düşürüldü.......");
        return 1;
    }

    @Override
    public void sogutucuKapat() throws InterruptedException {
        System.out.println("Sogutucu Kapatılıyor.......");
        Thread.sleep(1000);
        System.out.println("Sogutucu Kapatıldı.......");
    }
}
