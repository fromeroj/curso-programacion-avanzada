// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package mx.unam.mcc.pa.web;

import mx.unam.mcc.pa.Estado;
import mx.unam.mcc.pa.Usuario;
import mx.unam.mcc.pa.web.ApplicationConversionServiceFactoryBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    declare @type: ApplicationConversionServiceFactoryBean: @Configurable;
    
    public Converter<Estado, String> ApplicationConversionServiceFactoryBean.getEstadoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<mx.unam.mcc.pa.Estado, java.lang.String>() {
            public String convert(Estado estado) {
                return new StringBuilder().append(estado.getPais()).append(' ').append(estado.getEstado()).toString();
            }
        };
    }
    
    public Converter<Integer, Estado> ApplicationConversionServiceFactoryBean.getIdToEstadoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Integer, mx.unam.mcc.pa.Estado>() {
            public mx.unam.mcc.pa.Estado convert(java.lang.Integer id) {
                return Estado.findEstado(id);
            }
        };
    }
    
    public Converter<String, Estado> ApplicationConversionServiceFactoryBean.getStringToEstadoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, mx.unam.mcc.pa.Estado>() {
            public mx.unam.mcc.pa.Estado convert(String id) {
                return getObject().convert(getObject().convert(id, Integer.class), Estado.class);
            }
        };
    }
    
    public Converter<Usuario, String> ApplicationConversionServiceFactoryBean.getUsuarioToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<mx.unam.mcc.pa.Usuario, java.lang.String>() {
            public String convert(Usuario usuario) {
                return new StringBuilder().append(usuario.getNombre()).append(' ').append(usuario.getApellidos()).toString();
            }
        };
    }
    
    public Converter<Integer, Usuario> ApplicationConversionServiceFactoryBean.getIdToUsuarioConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Integer, mx.unam.mcc.pa.Usuario>() {
            public mx.unam.mcc.pa.Usuario convert(java.lang.Integer id) {
                return Usuario.findUsuario(id);
            }
        };
    }
    
    public Converter<String, Usuario> ApplicationConversionServiceFactoryBean.getStringToUsuarioConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, mx.unam.mcc.pa.Usuario>() {
            public mx.unam.mcc.pa.Usuario convert(String id) {
                return getObject().convert(getObject().convert(id, Integer.class), Usuario.class);
            }
        };
    }
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getEstadoToStringConverter());
        registry.addConverter(getIdToEstadoConverter());
        registry.addConverter(getStringToEstadoConverter());
        registry.addConverter(getUsuarioToStringConverter());
        registry.addConverter(getIdToUsuarioConverter());
        registry.addConverter(getStringToUsuarioConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
}
