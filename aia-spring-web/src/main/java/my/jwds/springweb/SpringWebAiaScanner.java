package my.jwds.springweb;

import my.jwds.core.AbstractApiScanner;
import my.jwds.core.AiaApiScanner;
import my.jwds.core.AiaManager;
import my.jwds.core.security.SecuritySupport;
import my.jwds.springweb.parse.SpringHandlerMappingParserComposite;
import my.jwds.springweb.utils.HandlerMappingUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.HandlerMapping;

import javax.annotation.PostConstruct;
import java.util.*;

public class SpringWebAiaScanner extends AbstractApiScanner {

    private ApplicationContext ac;

    private SpringHandlerMappingParserComposite parserRegister;


    public SpringWebAiaScanner(ApplicationContext ac, SpringHandlerMappingParserComposite parserRegister,AiaManager aiaManager) {
        this.ac = ac;
        this.parserRegister = parserRegister;
        this.setAiaManager(aiaManager);
    }
    @PostConstruct
    public void startScanner(){
        super.startScanner();
    }

    @Override
    protected void scanning() {
        new Thread(()->{
            List<HandlerMapping> handlerMappings = HandlerMappingUtils.get(ac);
            for (HandlerMapping handlerMapping : handlerMappings) {
                parserRegister.parse(getAiaManager(),handlerMapping);
            }
            getAiaManager().setScan(true);
        }).start();
    }



}
