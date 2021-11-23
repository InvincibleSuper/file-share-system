package my.jwds.springweb.parse.method;

import my.jwds.api.InvokeContentType;
import my.jwds.api.definition.resolver.DefinitionResolver;
import my.jwds.model.resolver.ModelResolver;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.RequestBody;


public class RequestBodyHandlerMethodArgumentResolver extends ParamHandlerMethodArgumentResolver {


    public RequestBodyHandlerMethodArgumentResolver(DefinitionResolver definitionResolver, ModelResolver modelResolver) {
        super(definitionResolver, modelResolver);
    }

    /**
     * 能解析吗
     *
     * @param parameter 方法参数
     * @return 结果
     */
    @Override
    public boolean canResolve(MethodParameter parameter) {
        return parameter.getParameterAnnotation(RequestBody.class) != null;
    }

    /**
     * 解析内容类型
     * @param parameter 方法参数
     * @return 参数类别
     */
    protected InvokeContentType resolveContentType(MethodParameter parameter){
        return InvokeContentType.json;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
