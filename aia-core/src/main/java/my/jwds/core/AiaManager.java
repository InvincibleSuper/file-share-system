package my.jwds.core;


import my.jwds.api.InvokeApi;
import my.jwds.api.mgt.AiaApiManager;
import my.jwds.definition.resolver.DefinitionResolver;
import my.jwds.model.resolver.ModelResolver;
import my.jwds.plugin.AiaPlugin;
import my.jwds.plugin.mgt.AiaPluginManager;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class AiaManager implements AiaTemplateManager, AiaPluginManager, AiaApiManager {


    private AiaTemplateManager templateManager;

    private AiaPluginManager pluginManager;

    private AiaApiManager apiManager;


    public AiaManager(AiaTemplateManager templateManager, AiaPluginManager pluginManager, AiaApiManager apiManager) {
        this.templateManager = templateManager;
        this.pluginManager = pluginManager;
        this.apiManager = apiManager;
    }

    public AiaManager() {
    }



    public AiaTemplateManager getTemplateManager() {
        return templateManager;
    }

    public void setTemplateManager(AiaTemplateManager templateManager) {
        this.templateManager = templateManager;
    }

    public AiaPluginManager getPluginManager() {
        return pluginManager;
    }

    public void setPluginManager(AiaPluginManager pluginManager) {
        this.pluginManager = pluginManager;
    }

    public AiaApiManager getApiManager() {
        return apiManager;
    }

    public void setApiManager(AiaApiManager apiManager) {
        this.apiManager = apiManager;
    }


    /**
     * 注册api
     *
     * @param api api
     */
    @Override
    public void registerApi(InvokeApi api) {

    }

    /**
     * 根据组注册api列表
     *
     * @param group 组
     * @param apis  api列表
     */
    @Override
    public void registerGroupApi(String group, List<InvokeApi> apis) {

    }

    /**
     * 注册所有api
     *
     * @param all 所有api
     */
    @Override
    public void registerAll(Map<String, List<InvokeApi>> all) {

    }

    /**
     * 获取组
     *
     * @return 组列表
     */
    @Override
    public Set<String> getGroup() {
        return null;
    }

    /**
     * 获取组
     *
     * @param group 组名
     * @return
     */
    @Override
    public List<InvokeApi> getGroupInvokeApi(String group) {
        return null;
    }

    /**
     * 全部api
     *
     * @return 组和api的键值对
     */
    @Override
    public Map<String, List<InvokeApi>> allApi() {
        return null;
    }

    /**
     * 添加模板
     *
     * @param template 模板
     */
    @Override
    public void add(AiaTemplate template) {

    }

    /**
     * 删除模板
     *
     * @param template 模板
     */
    @Override
    public void remove(AiaTemplate template) {

    }

    /**
     * 修改模板
     *
     * @param name     名称
     * @param template 模板
     */
    @Override
    public void update(String name, AiaTemplate template) {

    }

    /**
     * 全部模板
     *
     * @return 全部模板
     */
    @Override
    public Map<String, Map<String, AiaTemplate>> allTemplate() {
        return null;
    }

    /**
     * 根据组获取模板
     *
     * @param group 根据组获取模板
     * @return
     */
    @Override
    public Map<String, AiaTemplate> getGroupTemplate(String group) {
        return null;
    }

    /**
     * 注册插件
     *
     * @param plugin
     */
    @Override
    public void registerPlugin(AiaPlugin plugin) {

    }

    /**
     * 获取全部插件
     *
     * @return
     */
    @Override
    public List<AiaPlugin> allPlugin() {
        return null;
    }
}
