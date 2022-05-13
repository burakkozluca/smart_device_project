import java.util.Scanner;
public class Arayüz {

    public static void main(String args[]) throws InterruptedException {
        Scanner alınan=new Scanner(System.in);
        VeritabaniIslemi giris= new VeritabaniIslemi();
        SıcaklıkAlgılama sıcaklıkAlgılama=new SıcaklıkAlgılama();
        ISubject publisher=new Publisher();
        IObserver observer=new IObserver() {
            @Override
            public void update() throws InterruptedException {
                System.out.println("Lütfen Sıcakığı Kontrol Ediniz...........");
            }
        };
        publisher.attach(observer);
        publisher.notify("Sıcaklık");
        String ad, sifre;
        int durum = 0; // Cihaz kapalı olarak başlar
        System.out.println("Kullanıcı Adını giriniz:");
        ad=alınan.nextLine();
        if (giris.ad(ad)){
            System.out.println("Şifre giriniz:");
            sifre=alınan.nextLine();
            if (giris.sifre(sifre)){
                System.out.println("**Cihazı açmak için 1'e basınız**");
                durum=alınan.nextInt();
                if(durum==1) {
                    System.out.println("**Sıcaklığı okumak için 2'e basınız**");
                    durum=alınan.nextInt();
                    if (durum==2){
                        sıcaklıkAlgılama.sicaklikOku();
                        System.out.println("Soğutucuyu açmak için 3'e basınız................");
                        System.out.println("Soğutucuyu kapatmak için 4'e basınız.............");
                        durum= alınan.nextInt();;
                        Eyleyici1 eyleyici1=new Eyleyici1();
                        if (durum==3){
                            eyleyici1.sogutucuAc();
                        }
                        if(durum==4){
                            eyleyici1.sogutucuKapat();
                        }
                    }
                }
            }
        }
    }
}
