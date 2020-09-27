<%-- Created by IntelliJ IDEA. User: cris Date: 26/09/2020 Time: 17:02 To change
this template use File | Settings | File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>:.PetShop Senac.:</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta
      name="description"
      content="Meta Tags - O que s�o e como utiliz�-las"
    />
    <meta name="keywords" content="promo��o ra��o, ra��o, desenvolvimento" />
    <link href="../css/estilo.css" rel="stylesheet" />
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
      <div class="div_borda espaco_topo" id="menu">
        <ul>
          <li>
            <a href="./index.jsp">HOME</a>
          </li>
          <li>
            <a href="./produto.jsp">PRODUTO</a>
          </li>
          <li>
            <a href="./fornecedor.jsp">Fornecedor</a>
          </li>
        </ul>
      </div>
      <div id="menu_lateral" class="div_borda espaco_topo">
        <ul>
          <li>
            <a href="../logado/produto.jsp">Pesquisa</a>
          </li>
          <li>
            <a href="../logado/novoProduto.jsp">Novo</a>
          </li>
        </ul>
      </div>
      <div id="sistema" class="espaco_topo div_borda">
        <h1>Produto</h1>

        <c:if test="${msgSucesso != null}">
          <p class="mensagemSucesso">${msgSucesso}</p>
        </c:if>

        <c:if test="${msgErro != null}">
          <p class="mensagemErro">${msgErro}</p>
        </c:if>

        <form
          id="form_email"
          method="post"
          action="${pageContext.request.contextPath}/crud_teste?cmd=salvar"
        >
<%--          <input type="hidden" name="id" value="${produto.id}" />--%>
<%--          <div class="div_flex">--%>
<%--            <label for="nome">Nome:</label>--%>
<%--            <input--%>
<%--              id="nome"--%>
<%--              type="text"--%>
<%--              name="nome"--%>
<%--              required--%>
<%--              value="${produto.nome}"--%>
<%--            />--%>
<%--          </div>--%>
<%--          <div class="div_flex">--%>
<%--            <label for="preco">Preco:</label>--%>
<%--            <input--%>
<%--              id="preco"--%>
<%--              type="number"--%>
<%--              name="preco"--%>
<%--              required--%>
<%--              value="${produto.preco}"--%>
<%--            />--%>
<%--          </div>--%>
<%--          <div class="div_flex">--%>
<%--            <label for="estoque">Estoque:</label>--%>
<%--            <input--%>
<%--              id="estoque"--%>
<%--              type="number"--%>
<%--              name="estoque"--%>
<%--              required--%>
<%--              value="${produto.estoque}"--%>
<%--            />--%>
<%--          </div>--%>
<%--          <div class="div_flex">--%>
<%--            <label for="email_textarea">Descrição:</label>--%>
<%--            <textarea--%>
<%--              id="email_textarea"--%>
<%--              name="descricao"--%>
<%--              style="resize: vertical"--%>
<%--            >${produto.descricao}</textarea>--%>
<%--          </div>--%>
          <div class="div_flex">
            <input class="botao botao_esquerda" value="Enviar" type="submit" />
            <input class="botao" type="reset" value="Limpar" />
          </div>
        </form>
      </div>
      <div id="rodape" class="div_borda espaco_topo"></div>
    </div>
  </body>
</html>
