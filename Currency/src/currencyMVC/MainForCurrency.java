package currencyMVC;

public class MainForCurrency {

	public static void main(String[] args) {
		
		CurrencyModel model = new CurrencyModel();
		CurrencyView view = new CurrencyView();
			
		CurrencyController controller = new CurrencyController(view,model);
	}
}
