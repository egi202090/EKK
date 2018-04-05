package Model;

import Helper.DBconnection;
import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableObjectValue;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public abstract class BaseModel<T> {
    private Field[] fields;
    protected SimpleStringProperty id = new SimpleStringProperty();
    protected String tableName;
    protected Connection connection;
    protected Map<String, Object> managedProperties = new HashMap<String, Object>();


    public BaseModel() throws SQLException {
        this.fields = getClass().getDeclaredFields();
        this.connection = DBconnection.getInstance();
        this.tableName = getClass().getSimpleName().toLowerCase();
        this.addProperty("id", this.id);
    }

    public void addProperty(String name, Object property) {
        this.managedProperties.put(name, property);
    }

    private String replaceLastOccurence(String str) {
        int ind = str.lastIndexOf(",");
        if (ind >= 0)
            str = new StringBuilder(str).replace(ind, ind + 1, "").toString();
        return str;
    }

    public void save() throws SQLException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        String query = "INSERT INTO `" + this.tableName + "`(" + this.getColumnValues(true) + ") VALUES ( " + this.getFieldValues(true) + " );";
        Statement stmt = this.connection.createStatement();
        stmt.executeUpdate(query);
    }


    protected String getColumnValues(boolean ignoreId) {
        StringBuilder columns = new StringBuilder();
        Iterator it = this.managedProperties.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if(ignoreId && pair.getKey().equals("id")){
                continue;
            }
            columns.append("`" + pair.getKey() + "`,");
        }
        return this.replaceLastOccurence(columns.toString());
    }


    protected String getFieldValues(boolean ignoreId) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        StringBuilder values = new StringBuilder();
        Iterator it = this.managedProperties.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            Class<?> cls = Class.forName(pair.getValue().getClass().getName());
            Method meth = cls.getMethod("get");
            Object val = meth.invoke(pair.getValue(), null);
            if(pair.getKey().equals("id") && ignoreId){
                continue;
            }
            if(pair.getKey().equals("id") && !ignoreId){
                values.append(",");
            }else if(val == null){
                values.append("null,");
            }else{
                values.append("'" + val + "',");
            }
        }
        return this.replaceLastOccurence(values.toString());
    }


    public void update() {

    }


    private void saveOrUpdate(T modelToSave) throws SQLException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException, InstantiationException {
        if (this.id.get() != null) {
            this.update();
        } else {
            this.save();
        }
    }

    private boolean doesFieldKeyExist(String fieldToSearch) {
        for (Field field : fields) {
            if (field.getName().equals(fieldToSearch)) {
                return true;
            }
        }
        return false;
    }

}

// REFLECTION API
/* System.out.println(field.getType().toString().replace("class ", ""));
 *//*Class cls = Class.forName(field.getType().toString().replace("class ", ""));*//*
            SimpleStringProperty myTestObject = new SimpleStringProperty();
            Class<?> cls = Class.forName(field.getClass().getName());
            Method meth = cls.getMethod("get");
            meth.invoke(field,null);
            *//*Object myTestObject = cls.newInstance();*//*
 *//*Method myMethod = field.get(myTestObject).getClass().getDeclaredMethod("get");*//*
            String myObj = ((SimpleStringProperty) field.get(myTestObject)).get();
            Method myMethod = myObj.getClass().getDeclaredMethod("get");
            values.append("`" + myMethod.invoke(field.get(myTestObject)) + "`,");*/