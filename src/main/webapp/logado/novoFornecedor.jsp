<%-- Document : contato Created on : 24/08/2020, 10:45:16 Author : Admin --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <title>:.PetShop Senac.:</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta
            name="description"
            content="Meta Tags - O que s�o e como utiliz�-las"
    />
    <meta name="keywords" content="promo��o ra��o, ra��o, desenvolvimento"/>
    <link href="../css/estilo.css" rel="stylesheet"/>
</head>
<body>
<div id="principal">
    <div id="banner" class="div_borda">
        <img
                id="img_banner"
                src="../imagem/banner.jpg"
                alt="banner petshop..."
        />
    </div>

    <%@include file="menu.html" %>

    <div id="menu_lateral" class="div_borda espaco_topo">
        <ul>
            <li>
                <a href="../logado/fornecedor.jsp">Pesquisa</a>
            </li>
            <li>
                <a href="../logado/novoFornecedor.jsp">Novo</a>
            </li>
        </ul>
    </div>

    <div id="sistema" class="espaco_topo div_borda">
        <h1>Fornecedor</h1>

        <c:if test="${msgSucesso != null}">
            <p class="mensagemSucesso">${msgSucesso}</p>
        </c:if>

        <c:if test="${msgErro != null}">
            <p class="mensagemErro">${msgErro}</p>
        </c:if>

        <form
                id="form_email"
                method="post"
                action="/SitePetshop/crud_fornecedor?cmd=salvar"
        >
            <input type="hidden" name="id" value="${fornecedor.id}"/>
            <div class="div_flex">
                <label>Nome:</label>
                <input
                        type="text"
                        name="nome"
                        required
                        value="${fornecedor.nome}"
                />
            </div>
            <div class="div_flex">
                <label>E-mail:</label>
                <input
                        type="text"
                        name="email"
                        required
                        value="${fornecedor.email}"
                />
            </div>
            <div class="div_flex">
                <label>telefone:</label>
                <input
                        type="text"
                        name="telefone"
                        required
                        value="${fornecedor.telefone}"
                />
            </div>
            <div class="div_flex">
                <label>Descri��o:</label>
                <textarea id="email_textarea" name="descricao">
                    ${fornecedor.descricao}</textarea>
            </div>
            <div class="div_flex">
                <input class="botao botao_esquerda" value="Enviar" type="submit"/>
                <input class="botao" type="reset" value="Limpar"/>
            </div>
        </form>
    </div>

    <div id="rodape" class="div_borda espaco_topo"></div>
</div>
</body>
</html>
