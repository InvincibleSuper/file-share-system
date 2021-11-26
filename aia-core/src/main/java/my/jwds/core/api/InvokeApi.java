package my.jwds.core.api;



import java.util.List;
import java.util.Map;

/**
 * 执行api，把url param header 结合到此类
 */
public class InvokeApi extends InvokeDefinition{

    private InvokeUrl url;


    private List<InvokeParam> params;


    private Map<String,String> headers;


    private String group;


    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getGroup() {
        return group;
    }

    public InvokeApi setGroup(String group) {
        this.group = group;
        return this;
    }

    public InvokeUrl getUrl() {
        return url;
    }

    public InvokeApi setUrl(InvokeUrl url) {
        this.url = url;
        return this;
    }

    public List<InvokeParam> getParams() {
        return params;
    }

    public void setParams(List<InvokeParam> params) {
        this.params = params;
    }

    public InvokeApi(String definition, InvokeUrl url, List<InvokeParam> params, Map<String, String> headers, String group) {
        super(definition);
        this.url = url;
        this.params = params;
        this.headers = headers;
        this.group = group;
    }

    public InvokeApi() {

    }
}