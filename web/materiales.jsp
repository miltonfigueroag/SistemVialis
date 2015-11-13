<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenedor de Materiales</title>
        <%@include file="header.txt"%>
    </head>
    <body>
     hola 
        <div id="wrapper">
            <%@include file="menu.jspf" %>
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                Mantenedor de Materiales
                            </h1>                          
                            <table class="table table-bordered">
                                <thead>
                                <th>Codigo</th>
                                <th>Articulo</th>
                                <th>Unidad Medida</th>
                                <th>Marca</th>
                                <th>Acciones</th>
                                </thead>
                                <tbody>
                                    <s:iterator value="records" var="dato" status="estado">
                                        <tr>
                  <!-- los nombre de valores de las propiedades deben ser los mismos que en la clase del modelo-->
                                            <td><s:property value="codigo" /></td>
                                            <td><s:property value="articulo" /></td>                                          
                                            <td><s:property value="u_medida" /></td>
                                             <td><s:property value="marca" /></td>
                                            <td>
                                                <s:a action="editar">
                                                    <s:param name="codigo" value="codigo" />
                                                    <i class="glyphicon glyphicon-pencil"></i>
                                                </s:a>
                                                <s:a action="eliminarMaterialAccion">
                                                    <s:param name="codigo" value="codigo" />
                                                    <i class="glyphicon glyphicon-trash"></i>
                                                </s:a>    
                                            </td>
                                        </tr>
                                    </s:iterator>
                                </tbody>
                            </table>

                        </div>

                    </div><!-- /.row -->  
                </div> <!-- /.container-fluid -->
            </div> <!-- /#page-wrapper -->
        </div>  <!-- /#wrapper -->
        <%@include file="footer.txt" %>
    </body>
</html>
