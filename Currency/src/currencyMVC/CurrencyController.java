package currencyMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyController 
{
	CurrencyView view;
	CurrencyModel model;
	
	public CurrencyController(CurrencyView theView, CurrencyModel theModel)
	{
		view=theView;
		model=theModel;
		this.view.addCalculationListener(new CalculationListener());
	
	}
	
	public class CalculationListener implements ActionListener
	{
		//Something more
		@Override
		public void actionPerformed(ActionEvent e)
		{
			double amount;
			String originC;
			String destinationC;
			double result,resultTemp;
			
			amount=view.getAmount();
			if (amount<0)
			{
				amount=1;
			}
			destinationC=view.getDestinationCurrency();
			originC=view.getOriginCurrency();
			
			model.getExchangeRate();
			resultTemp=model.getSolution(amount, originC, destinationC);
			result=model.RoundTo2Decimals(resultTemp);
			view.setConversionLabel(result);
			view.appendToTextSolution(amount, originC, destinationC, result);
			
		}
		
	}

}
