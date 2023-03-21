package LF8.application;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rivescript.Config;
import com.rivescript.RiveScript;

@SpringBootApplication
public class Lf8Application {

	public static void main(String[] args) {
		SpringApplication.run(Lf8Application.class, args);
	}

	@Bean
	public TimedAspect timedAspect(MeterRegistry registry) {
		return new TimedAspect(registry);
	}

	@Bean
    public RiveScript riveScript() {
        RiveScript bot = new RiveScript(Config.utf8());
		bot.loadFile(Lf8Application.class.getClassLoader().getResource("replies.rive").getFile());
        return bot;
    }
}
