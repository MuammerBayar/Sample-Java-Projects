/*----------------------------------------------------------------------------------------------------------------------
    DateApp sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package byr.samples.application.dateapp;

import byr.util.datetime.Date;

public class DateApp {
	private DateApp()
	{
	}
	private static void displayDateTR(Date date)
	{
		System.out.println(date.toLongDateStringTR());
		System.out.println(date.isWeekend() ? "Bugün kurs var tekrar yaptınız mı?" : "Kurs günü yaklaşıyor. Tekrar yapmayı unutmayınız");
	}
	private static void displayDateEN(Date date)
	{
		System.out.println(date.toLongDateStringEN());
		System.out.println(date.isWeekend() ? "That is the course day. Did you review?" :
				"Course day is coming. Do not forget to review");
	}
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);

		for (;;) {
			System.out.print("Gün:");
			int day = Integer.parseInt(kb.nextLine());

			if (day == 0)
				break;

			System.out.print("Ay:");
			int month = Integer.parseInt(kb.nextLine());

			System.out.print("Yıl:");
			int year = Integer.parseInt(kb.nextLine());

			Date date = new Date(day, month, year); // Geçersiz tarih işlemleri ileride..

			displayDateTR(date);
			displayDateEN(date);
		}

		System.out.println("Tekrar yapıyor musun?");
	}
}