<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Editing Variable</title>
            <link rel="stylesheet" type="text/css" href="/angularMYSQL/faces/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Editing Variable</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="PkVariable:"/>
                    <h:outputText value="#{variable.variable.pkVariable}" title="PkVariable" />
                    <h:outputText value="Codigo:"/>
                    <h:inputText id="codigo" value="#{variable.variable.codigo}" title="Codigo" />
                    <h:outputText value="Descripcion:"/>
                    <h:inputText id="descripcion" value="#{variable.variable.descripcion}" title="Descripcion" />
                    <h:outputText value="Estado:"/>
                    <h:inputText id="estado" value="#{variable.variable.estado}" title="Estado" />
                    <h:outputText value="Nombre:"/>
                    <h:inputText id="nombre" value="#{variable.variable.nombre}" title="Nombre" />
                    <h:outputText value="Valor:"/>
                    <h:inputText id="valor" value="#{variable.variable.valor}" title="Valor" />

                </h:panelGrid>
                <br />
                <h:commandLink action="#{variable.edit}" value="Save">
                    <f:param name="jsfcrud.currentVariable" value="#{jsfcrud_class['net.codejava.spring.model.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][variable.variable][variable.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{variable.detailSetup}" value="Show" immediate="true">
                    <f:param name="jsfcrud.currentVariable" value="#{jsfcrud_class['net.codejava.spring.model.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][variable.variable][variable.converter].jsfcrud_invoke}"/>
                </h:commandLink>
                <br />
                <h:commandLink action="#{variable.listSetup}" value="Show All Variable Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>