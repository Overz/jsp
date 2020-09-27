<%-- Document : contato Created on : 24/08/2020, 10:45:16 Author : Admin --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
          action="${pageContext.request.contextPath}/crud_fornecedor?cmd=salvar"
        >
          <input type="hidden" name="id" value="${fornecedor.id}" />
          <div class="div_flex">
            <label for="nome">Nome:</label>
            <input
              id="nome"
              type="text"
              name="nome"
              required
              value="${fornecedor.nome}"
            />
          </div>
          <div class="div_flex">
            <label for="email">E-mail:</label>
            <input
              id="email"
              type="text"
              name="email"
              required
              value="${fornecedor.email}"
            />
          </div>
          <div class="div_flex">
            <label for="telefone">telefone:</label>
            <input
              id="telefone"
              type="text"
              name="telefone"
              required
              value="${fornecedor.telefone}"
            />
          </div>
          <div class="div_flex">
            <label for="email_textarea">Descrição:</label>
            <textarea id="email_textarea" name="descricao" placeholder="" >${fornecedor.descricao}</textarea>
          </div>
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
