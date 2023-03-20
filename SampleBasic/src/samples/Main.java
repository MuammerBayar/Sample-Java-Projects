/*----------------------------------------------------------------------------------------------------------------------
    izlenecek (oop):26.video
    izlenecek (app): -
----------------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Klavyeden bir kullanıcı adı ve şifre isteyen basit bir ATM uygulamasının bir parçasını aşağıdaki
	açıklamalara göre yazınız.

	 Açıklamalar:
	 - Kullanıcı ad ve şifresi en fazla 3(üç) kez denenebilecektir.

	 - Denemeler sırasında doğru giriş yapılırsa "Giriş başarılı", başarısız denemelerde "Giriş başarısız", 3. denemede de
	 başarısız olunursa "Giriş başarısız . Artık deneme hakkınız bitti" mesajla verilecektir.

	 - Kullanıcı adı ve şifrenin doğruluğu program içerisinde belirlenen bir kullanıcı adı ve şifre ile yapılacaktır

	 - Uygulama genel düşünülerek yapılmalıdır

	 - Örnekte ATM uygulaması sürekli çalışmaktadır
----------------------------------------------------------------------------------------------------------------------*/
package samples;

public class Main {
    public static void main(String [] args)
    {

    }
}
class ATMApp {
    public static void run()
    {
        for (;;) {
            ATM atm = new ATM();
        }
    }
}
class Card {
    public String name;
    public String userName;
    public String password;

    public Card (String fullName, String uName, String pwd)
    {
        //...
        name = fullName;
        userName = uName;
        password = pwd;
    }

    //...
}
class ATM{
    public Card card;
    public java.util.Scanner kb;

    public boolean checkCard(String uname, String pwd)
    {
        return card.userName == uname && card.password == pwd;
    }
    public void doWorkForEntry(int n)
    {
        int i;
        for (i = 0; i < n; ++i) {
            System.out.print("username: ");
            String uname = kb.nextLine();
            System.out.print("password: ");
            String pwd = kb.nextLine();

            if (checkCard(uname,pwd)) {
                System.out.println("Giriş başarılı");
                break;
            }
            else
                System.out.println("Giriş başarısız");
        }

    }
    public ATM ()
    {
        kb = new java.util.Scanner(System.in);
        card = new Card(kb.nextLine(),kb.nextLine(), kb.nextLine());
        doWorkForEntry(3);

    }


}
