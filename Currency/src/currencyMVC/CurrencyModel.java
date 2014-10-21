package currencyMVC;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CurrencyModel
{
	private double euroToDolar;
	private double euroToPound;
	private double euroToZloty;
	private double dolarToEuro;
	private double poundToEuro;
	private double zlotyToEuro;
	private double dolarToZloty;
	private double dolarToPound;
	private double poundToDollar;
	private double poundToZloty;
	private double zlotyToPound;
	private double zlotyToDolar;
	
	private String link="http://www.ecb.europa.eu/stats/exchange/eurofxref/html/index.en.html";
	
	public void getExchangeRate()
	{
		
		
		try {
			Document doc = Jsoup.connect(link).get();
			//System.out.println(doc);
			Elements content=doc.getElementsByClass("rate");
			System.out.println(content);
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			euroToDolar=Double.parseDouble(content.get(0).text());
			dolarToEuro=1/euroToDolar;
						
			System.out.println("Rate euro to dolar:\t" + euroToDolar);
			System.out.println("Rate dolar to euro:\t" + dolarToEuro);
			
			
			euroToPound=Double.parseDouble(content.get(5).text());
			poundToEuro=1/euroToPound;
			System.out.println("Rate euro to pound:\t" + euroToPound);
			System.out.println("Rate pound to euro:\t" + poundToEuro);
			
			euroToZloty=Double.parseDouble(content.get(8).text());
			zlotyToEuro=1/euroToZloty;
			System.out.println("Rate euro to Zloty:\t" + euroToZloty);
			System.out.println("Rate Zloty to euro:\t" + zlotyToEuro);
			
			dolarToEuro=1/euroToDolar;
			dolarToZloty=dolarToEuro/zlotyToEuro;
			System.err.println("dolarToEuro" + dolarToEuro + " zlotyToEuro"
					+ zlotyToEuro);
			
			System.out.println("Rate dolar to zloty:\t" + dolarToZloty);
			
			
			dolarToPound=dolarToEuro/poundToEuro;
			poundToDollar=1/dolarToPound;
			System.out.println("Rate dolar to pound:\t" + dolarToPound);
			System.out.println("Rate pound to dolar:\t" + poundToDollar);
			
			poundToZloty=poundToEuro/zlotyToEuro;
			zlotyToPound=1/poundToZloty;
			zlotyToDolar=1/dolarToZloty;
			System.out.println("Rate pound to zloty:\t" + poundToZloty);
			System.out.println("Rate zloty to pound:\t" + zlotyToPound);
			System.out.println("Rate zloty to dollar:\t" + zlotyToDolar);
			
			
			
		} catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, "Impossible to connect to internet, try a bit later");
			System.exit(0);
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 
	 * @param args
	 */
	
	public double getSolution(double amount,String originCurrency,String dstinyCurrency)
	{
		double solution = 0;
		
		switch(originCurrency)
		{
		case "Pound":
			switch(dstinyCurrency)
			{
				case "Dollar":
					System.out.println("Inside double switch");
					System.out.println("The amount= "+amount +" exchange rate "+poundToDollar+" "+originCurrency+ " to  "+dstinyCurrency);
					return solution=amount*poundToDollar;
					
				
				case"Zloty":
					return solution=amount*poundToZloty;
					
				case"Euro":	
					return solution=amount*poundToEuro;
					
				case"Pound":	
					return solution=amount;
					
					
			}
			break;
			
		case "Euro":
			
			switch(dstinyCurrency)
			{
				case "Dollar":
					return solution=amount*euroToDolar;
					
				
				case"Zloty":
					return solution=amount*euroToZloty;
					
				case"Pound":	
					return solution=amount*euroToPound;
					
					
				case"Euro":	
					return solution=amount;
					
					
			}
			break;
			
		case "Zloty":
			
			switch(dstinyCurrency)
			{
				case "Dollar":
					return solution=amount*zlotyToDolar;
					
				
				case"Euro":
					return solution=amount*zlotyToEuro;
					
				case"Pound":	
					return solution=amount*zlotyToPound;
					
					
				case"Zloty":	
					return solution=amount;
					
			}
			break;	
		
		case "Dollar":
			
			switch(dstinyCurrency)
			{
				case "Euro":
					return solution=amount*dolarToEuro;
					
			
				case"Zloty":
					return solution=amount*dolarToZloty;
					
				case"Pound":	
					return solution=amount*dolarToPound;
					
				case"Dollar":	
					return solution=amount;
					
			}
		break;
		}
		return solution;
			
		
		//return solution;
		
	}
	
	
	public double RoundTo2Decimals(double val) {
        DecimalFormat df2 = new DecimalFormat("###.##");
    return Double.valueOf(df2.format(val));
}
	
	/*public static void main(String[] args) {
		CurrencyModel cu = new CurrencyModel();
		cu.getExchangeRate();
	}*/
}
