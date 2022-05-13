import java.sql.*;

public class VeritabaniIslemi implements IVeritabani{
    private Connection baglan() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/nesne",
                    "postgres", "12345");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public boolean ad(String ad) {
        try {
            boolean girisDurumu;

            Connection conn = this.baglan(); // Veritabanı bağlantısı yapılır

            // Konsoldan girilen bilgilere uygun kişiyi veritabanından seçmek için gerekli SQL sorgusu yazılır
            String sql = "SELECT *  FROM \"User\" WHERE \"userName\"='" + ad + "'";

            // Sorgu çalıştırılır
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Veritabanı bağlantısı sonlandırılır
            conn.close();

            Thread.sleep(500);
            if (!rs.next()) { // Veritabanından dönen ResultSet boş ise böyle bir kullanıcı yoktur
                System.out.println("Böyle bir kullanıcı bulunamadı...");
                girisDurumu = false;
            } else { // ResultSet boş değilse giriş başarılıdır
                System.out.println("Kişi Bulundu....");

                girisDurumu = true;
            }

            /***** Kaynakları serbest bırak *****/
            rs.close();
            stmt.close();
            return girisDurumu;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean sifre(String sifre) {
        try {
            boolean girisDurumu;

            Connection conn = this.baglan(); // Veritabanı bağlantısı yapılır

            // Konsoldan girilen bilgilere uygun kişiyi veritabanından seçmek için gerekli SQL sorgusu yazılır
            String sql = "SELECT *  FROM \"User\" WHERE \"password\"='" + sifre +"'";

            // Sorgu çalıştırılır
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Veritabanı bağlantısı sonlandırılır
            conn.close();

            Thread.sleep(500);
            if (!rs.next()) { // Veritabanından dönen ResultSet boş ise böyle bir kullanıcı yoktur
                System.out.println("Böyle bir kullanıcı bulunamadı...");
                girisDurumu = false;
            } else { // ResultSet boş değilse giriş başarılıdır
                System.out.println("Giriş başarılı...");

                girisDurumu = true;
            }

            /***** Kaynakları serbest bırak *****/
            rs.close();
            stmt.close();
            return girisDurumu;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
