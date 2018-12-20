package work.usepdf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import work.usepdf.repository.parser.MurphyUnitsText;

import java.util.Map;

@SpringBootApplication
public class UsepdfApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsepdfApplication.class, args);
    }

    @Bean(name = "UnitsList")
    public Map<Integer, String> units(){
        return new MurphyUnitsText().getMurphyLesson();
    }

    @Primary
    @Bean
    public FreeMarkerConfigurationFactoryBean factoryBean(){
        FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
        bean.setTemplateLoaderPath("classpath:/templates");
        return bean;
    }
}
