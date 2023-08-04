package TicketAutomat;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutomatTicket {
	
	private static final DecimalFormat round1 = new DecimalFormat("0.00");
	private static final DecimalFormat round2 = new DecimalFormat("0");
	
	@SuppressWarnings("null")
	public static void main(String[] args) throws InterruptedException {
		
		Scanner scan = new Scanner(System.in);
		
		//Varibalen
		String usedZone = null;
		String card = null;
		double age;
		double price = 0;
		double endprice = 0;
		double number = 0;
		double pay = 0;
		byte While = 1;
		byte temp = 1;
		
		//Zonenauswahl
		
		List<String> zone = new ArrayList<>();
		zone.add("a");
		zone.add("b");
		zone.add("c");
		
		//Abfrage
		
		List<String> query = new ArrayList<>();
		query.add("ja");
		query.add("nein");
		
		//Zahlungsmöglichkeit
		
		List<Double> payment = new ArrayList<>();
		payment.add(0.01);
		payment.add(0.02);
		payment.add(0.05);
		payment.add(0.10);
		payment.add(0.20);
		payment.add(0.50);
		payment.add(1.00);
		
		do {
			try {
				While++;
				
				price = 0;
				endprice = 0;
				number = 0;
				pay = 0;
				
				System.out.println("Guten Tag! \nBitte geben sie die folgenden Daten an:");
				System.out.println("Welche Zone möchten sie Auswählen? \nZone A: 2,50€ \nZone B: 3,70€ \nZone C: 5,20€");
				usedZone = scan.next();
				
				if(zone.contains(usedZone)) {
					
					System.out.println("Besitzen sie eine Bahnkarte?");
					card = scan.next().toLowerCase();
					
					if(query.contains(card)) {
						
						System.out.println("Wie alt sind sie?");
						age = scan.nextDouble();
						
						System.out.println("Wie viele Karten möchten sie kaufen?");
						number = scan.nextDouble();
						round2.format(number);
						
						switch(usedZone) {
						
						case "a":
							price = 2.50;
							if(number > 0) {
							if(card.equals("ja")) {
								if(age < 0) {
									While = 1;
									endprice = (Double) null;
								} else if(age >= 18) {
									endprice = (price * 0.8) * number;
								} else if (age < 18) {
									endprice = ((price * 0.8) / 2) * number;
								}
							} else if(card.equals("nein")) {
								if(age < 0) {
									While = 1;
									endprice = (Double) null;
									endprice = (price / 2) * number;
								} else if(age >= 18) {
									endprice = price * number;
								} else if(age < 18) {
									endprice = ((price * 0.8) / 2) * number;
								}
							}
							} else {
								While = 1;
								endprice = (Double) null;
							} break;
								
						case "b":
							price = 3.70;
							if(number > 0) {
								if(card.equals("ja")) {
									if(age < 0) {
										While = 1;
										endprice = (Double) null;
									} else if(age >= 18) {
										endprice = (price * 0.8) * number;
									} else if (age < 18) {
										endprice = ((price * 0.8) / 2) * number;
									}
								} else if(card.equals("nein")) {
									if(age < 0) {
										While = 1;
										endprice = (Double) null;
										endprice = (price / 2) * number;
									} else if(age >= 18) {
										endprice = price * number;
									} else if(age < 18) {
										endprice = ((price * 0.8) / 2) * number;
									}
								}
								} else {
									While = 1;
									endprice = (Double) null;
								} break;
							
						case "c":
							price = 5.20;
							if(number > 0) {
								if(card.equals("ja")) {
									if(age < 0) {
										While = 1;
										endprice = (Double) null;
									} else if(age >= 18) {
										endprice = (price * 0.8) * number;
									} else if (age < 18) {
										endprice = ((price * 0.8) / 2) * number;
									}
								} else if(card.equals("nein")) {
									if(age < 0) {
										While = 1;
										endprice = (Double) null;
										endprice = (price / 2) * number;
									} else if(age >= 18) {
										endprice = price * number;
									} else if(age < 18) {
										endprice = ((price * 0.8) / 2) * number;
									}
								}
								} else {
									While = 1;
									endprice = (Double) null;
								} break;
						
						}
						
					} else {
					While = 1;
					endprice = (Double) null;
					}
					
					while(endprice > 0.00) {
						
						endprice = Math.round(endprice * 100);
						endprice = endprice / 100.00;
						
						System.out.println("Sie müssen einen Betrag von " + endprice + "€ bezahlen!");
						System.out.println("Bitte Zahlen sie Münzen (bis 1€) ein, bis der Betrag komplett abgezahlt wurde.");
						pay = scan.nextDouble();
						
						if(payment.contains(pay)) {
							endprice = endprice - pay;
						} else {
							System.out.println("Du kannst diese Art von Zahlungsmöglichkeit nicht verwenden! \nBitte versuche es erneut.");
							Thread.sleep(2000);
							System.out.println("\n\n\n\n\n\n\n\n");
						}
						
					}
					if(endprice == 0.00) {
						System.out.println("Ihr Betrag wurde komplett abgezahlt! \nViel spaß bei ihrem Aufenthalt.");
						Thread.sleep(4000);
						System.out.println("\n\n\n\n\n\n\n\n");
						While = 1;
						temp = 0;
					} else if(endprice < 0.00) {
						endprice = endprice * -1;
						System.out.println("Ihr Betrag wurde komplett abgezahlt und ihr Restgeld im Wert von " + round1.format(endprice) + "€ bekommen sie als ein Gutschein gutgeschrieben \nViel spaß bei ihrem Aufenthalt.");
						Thread.sleep(4000);
						System.out.println("\n\n\n\n\n\n\n\n");
						While = 1;
						temp = 0;
					}
					
				} else {
					System.out.println("Systemfehler... \nStarte neu");
					Thread.sleep(4000);
					System.out.println("\n\n\n\n\n\n\n\n");
					While = 1;
				}
				
			} catch(Exception e) {
				
				System.out.println("Systemfehler..\nStarte neu");
				Thread.sleep(4000);
				System.out.println("\n\n\n\n\n\n\n\n");
				
			}
		} while(While == 1);
		scan.close();
	}
}