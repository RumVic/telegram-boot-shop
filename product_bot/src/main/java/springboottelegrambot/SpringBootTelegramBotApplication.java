package springboottelegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import springboottelegrambot.storage.entity.StihiyaShopSlash;

@SpringBootApplication
public class SpringBootTelegramBotApplication {

	private final static String massage = "Hey my dear, this is first msg ever";
	private final static Long vicRumId = 530618365L;
	private final static Long dimonId = 425925545L;

	public static void main(String[] args) throws TelegramApiException {

		SpringApplication.run(SpringBootTelegramBotApplication.class, args);
		TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
		StihiyaShopSlash sss = new StihiyaShopSlash();
		botsApi.registerBot(sss);
		//sss.sendText(vicRumId,massage);
	}
}
