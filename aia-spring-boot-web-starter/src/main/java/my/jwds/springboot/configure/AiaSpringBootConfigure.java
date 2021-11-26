package my.jwds.springboot.configure;

import my.jwds.core.api.definition.resolver.DefinitionResolver;
import my.jwds.core.api.definition.resolver.JavadocDefinitionResolver;
import my.jwds.core.api.definition.resolver.PriorityDefinitionResolver;
import my.jwds.core.api.mgt.AiaApiManager;
import my.jwds.cache.CacheManager;
import my.jwds.config.AiaConfig;
import my.jwds.core.AiaApiScanner;
import my.jwds.core.AiaManager;
import my.jwds.core.AiaTemplateManager;
import my.jwds.core.model.resolver.ModelResolver;
import my.jwds.core.plugin.mgt.AiaPluginManager;
import my.jwds.springweb.AiaSpringWebConfigure;
import my.jwds.springweb.SpringWebAiaScanner;
import my.jwds.springweb.data.AiaController;
import my.jwds.springweb.parse.RequestMappingHandlerMappingParser;
import my.jwds.springweb.parse.SpringHandlerMappingParserComposite;
import my.jwds.springweb.parse.method.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AiaSpringBootConfigure extends AiaSpringWebConfigure {


    @Bean
    @ConditionalOnMissingBean
    public AiaConfig aiaConfig(){
        return super.aiaConfig();
    }

    @Bean
    @ConditionalOnMissingBean
    public CacheManager cacheManager(){
        return super.cacheManager();
    }

    @Bean
    @ConditionalOnMissingBean
    public AiaTemplateManager aiaTemplateManager(CacheManager cacheManager){
        return super.aiaTemplateManager(cacheManager);
    }
    @Bean
    @ConditionalOnMissingBean
    public AiaPluginManager aiaPluginManager(CacheManager cacheManager){
        return super.aiaPluginManager(cacheManager);
    }
    @Bean
    @ConditionalOnMissingBean
    public AiaApiManager aiaApiManager(CacheManager cacheManager){
        return super.aiaApiManager(cacheManager);
    }


    @Bean
    @ConditionalOnMissingBean
    public AiaManager aiaManager(AiaTemplateManager templateManager,AiaPluginManager pluginManager,AiaApiManager apiManager){
        return super.aiaManager(templateManager,pluginManager,apiManager);
    }

    @Bean
    public DefinitionResolver javadocDefinitionResolver(AiaConfig aiaConfig){
        return new JavadocDefinitionResolver(aiaConfig.getSrcPath());
    }

    @Bean
    @ConditionalOnMissingBean
    public PriorityDefinitionResolver priorityDefinitionResolver(List<DefinitionResolver> definitionResolvers){
        return super.priorityDefinitionResolver(definitionResolvers);
    }

    @Bean
    @ConditionalOnMissingBean
    public ModelResolver defaultModelResolver(PriorityDefinitionResolver priorityDefinitionResolver){
        return super.defaultModelResolver(priorityDefinitionResolver);
    }

    @Bean
    public HandlerMethodArgumentResolver ignoreHandlerMethodArgumentResolver(){
        return new IgnoreHandlerMethodArgumentResolver();
    }

    @Bean
    public HandlerMethodArgumentResolver multipartFileHandlerMethodArgumentResolver(PriorityDefinitionResolver definitionResolver, ModelResolver modelResolver){
        return new MultipartFileHandlerMethodArgumentResolver(definitionResolver,modelResolver);
    }


    @Bean
    public HandlerMethodArgumentResolver paramHandlerMethodArgumentResolver(PriorityDefinitionResolver definitionResolver, ModelResolver modelResolver){
        return new ParamHandlerMethodArgumentResolver(definitionResolver,modelResolver);
    }


    @Bean
    public HandlerMethodArgumentResolver requestBodyHandlerMethodArgumentResolver(PriorityDefinitionResolver definitionResolver, ModelResolver modelResolver){
        return new RequestBodyHandlerMethodArgumentResolver(definitionResolver,modelResolver);
    }

    @Bean
    public HandlerMethodArgumentResolver requestParamHandlerMethodArgumentResolver(PriorityDefinitionResolver definitionResolver, ModelResolver modelResolver){
        return new RequestParamHandlerMethodArgumentResolver(definitionResolver,modelResolver);
    }


    @Bean
    @ConditionalOnMissingBean
    public HandlerMethodArgumentResolverRegister handlerMethodArgumentResolverRegister(List<HandlerMethodArgumentResolver> argumentResolvers){
        HandlerMethodArgumentResolverRegister argumentResolverRegister = new DefaultHandlerMethodArgumentResolverRegister();
        argumentResolverRegister.registerResolvers(argumentResolvers);
        return argumentResolverRegister;
    }



    @Bean
    @ConditionalOnMissingBean
    public SpringHandlerMappingParserComposite parserComposite(PriorityDefinitionResolver definitionResolver, HandlerMethodArgumentResolverRegister argumentResolverRegister){
        SpringHandlerMappingParserComposite parserComposite = new SpringHandlerMappingParserComposite();
        parserComposite.addParser(new RequestMappingHandlerMappingParser(definitionResolver,argumentResolverRegister));
        return parserComposite;
    }


    @Bean
    @ConditionalOnMissingBean
    public AiaApiScanner aiaApiScanner(ApplicationContext applicationContext,SpringHandlerMappingParserComposite parserComposite,AiaManager aiaManager){
        return  new SpringWebAiaScanner(applicationContext,parserComposite,aiaManager);
    }

    @Bean
    @ConditionalOnMissingBean
    public AiaController aiaController(AiaManager aiaManager){
        AiaController aiaController = new AiaController();
        aiaController.setAiaManager(aiaManager);
        return aiaController;
    }
}
