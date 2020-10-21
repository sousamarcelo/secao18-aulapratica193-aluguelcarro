package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.service.BrazilTaxService;
import model.service.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		System.out.println("Enter retal data: ");		
		System.out.print("Car model: ");
		String model = sc.nextLine();
		System.out.print("Pickup (dd/MM/yyyy HH:mm): ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Return (dd/MM/yyyy HH:mm): ");
		Date finish = sdf.parse(sc.nextLine());
		CarRental carRental = new CarRental(start, finish, new Vehicle(model));
		
		System.out.print("Enter price per hour: ");
		Double pricePerHour = sc.nextDouble();
		System.out.print("Enter price per day: ");
		Double pricePerDay = sc.nextDouble();
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		rentalService.processinvoice(carRental);
		
		System.out.println("INVOICE:");
		System.out.println("Basic payment:" + String.format("%.2f", carRental.getInvoice().getBaseciPayment()) );
		System.out.println("Tax: " + String.format("%.2f", carRental.getInvoice().getTax()) );
		System.out.println("Total payment: " + String.format("%.2f", carRental.getInvoice().totalPayment()) );
		
		sc.close();
	}

}
