package com.design.design.factory.bean;


import java.util.ArrayList;
import java.util.List;

/**
 *  BeanDefinition 结构，以便 BeansFactory 根据这个结构来创建对象
 */
public class BeanDefinition {

    private String id;
    private String className;
    private List<ConstructorArg> constructorArgs=new ArrayList<>();
    private Scope scope=Scope.SINGLETON;
    private boolean lazyInit=false;

    public boolean isSingleton(){
        return scope.equals(Scope.SINGLETON);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<ConstructorArg> getConstructorArgs() {
        return constructorArgs;
    }

    public void setConstructorArgs(List<ConstructorArg> constructorArgs) {
        this.constructorArgs = constructorArgs;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    public class ConstructorArg {

        private boolean isRef;
        private Class type;
        private Object arg;

        public boolean getIsRef() {
            return isRef;
        }

        public void setRef(boolean ref) {
            isRef = ref;
        }

        public Class getType() {
            return type;
        }

        public void setType(Class type) {
            this.type = type;
        }

        public Object getArg() {
            return arg;
        }

        public void setArg(Object arg) {
            this.arg = arg;
        }
    }
}
