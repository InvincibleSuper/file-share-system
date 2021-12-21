package my.jwds.core.model;



public class ArrayModelProperty extends ModelProperty{

    private ModelProperty component;

    public ModelProperty getComponent() {
        return component;
    }

    public void setComponent(ModelProperty component) {
        this.component = component;
    }

    public ArrayModelProperty(String name, String type, ModelProperty component) {
        super(name, type);
        this.component = component;
    }


    public ArrayModelProperty(String name, String type) {
        super(name, type);
    }

    public ArrayModelProperty() {
    }

    public ArrayModelProperty clone(){
        if (getComponent() == null){
            return new ArrayModelProperty(getName(),getType(),null);
        }
        return new ArrayModelProperty(getName(),getType(),getComponent().clone());
    }
}
