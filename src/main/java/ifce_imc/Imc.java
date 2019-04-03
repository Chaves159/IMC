package ifce_imc;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Imc extends TelegramLongPollingBot{

	public void onUpdateReceived(Update update) {
		double imc;
		if (update.hasMessage()){
			
			Message mes = update.getMessage();
			String texto = mes.getText();
			String[] altura_peso = texto.split(" ");
			SendMessage sm = new SendMessage();
			int altura = Integer.parseInt(altura_peso[0]);
			double peso = Double.parseDouble( altura_peso[1]);
			imc = (peso / (altura*altura))*10000;
			
			sm.setChatId(update.getMessage().getChatId());
			sm.setText("Seu IMC E: " + imc);
			
			try {
				execute(sm);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
	}


	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "ifce_imc_bot";
	}

	@Override
	public String getBotToken() {
		
		return "849823257:AAFjHarvOqyG_49HFrPEvr-8429z20z55Gg";
	}

}
