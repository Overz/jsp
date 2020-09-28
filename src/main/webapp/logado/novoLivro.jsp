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
            <a href="./fornecedor.jsp">FORNECEDOR</a>
          </li>
          <li>
            <a href="./livro.jsp">LIVRO</a>
          </li>
        </ul>
      </div>
      <div id="menu_lateral" class="div_borda espaco_topo">
        <ul>
          <li>
            <a href="../logado/livro.jsp">Pesquisa</a>
          </li>
          <li>
            <a href="../logado/novoLivro.jsp">Novo</a>
          </li>
        </ul>
      </div>
      <div id="sistema" class="espaco_topo div_borda">
        <h1>Livro</h1>

        <c:if test="${msgSucesso != null}">
          <p class="mensagemSucesso">${msgSucesso}</p>
        </c:if>

        <c:if test="${msgErro != null}">
          <p class="mensagemErro">${msgErro}</p>
        </c:if>

        <form
          id="form_email"
          method="post"
          action="${pageContext.request.contextPath}/crud_livro?cmd=salvar"
        >
            <input type="hidden" name="id" value="${livro.id}" />
            <script>
              console.log(response.body)
            </script>
            <div class="div_flex">
              <label for="nome">Nome:</label>
              <input
                id="nome"
                type="text"
                name="nome"
                required
                value="${livro.nome}"
                placeholder="Ex: A Saga da Batata"
              />
            </div>
            <div class="div_flex">
              <label for="autor">Autor:</label>
              <input
                id="autor"
                type="text"
                name="autor"
                required
                value="${livro.autor}"
                placeholder="Ex: Joaozinho da Silva"
              />
            </div>
            <div class="div_flex">
              <label for="editora">Editora:</label>
              <input
                id="editora"
                type="text"
                name="editora"
                required
                value="${livro.editora}"
                placeholder="Ex: Editora Batatinha"
              />
            </div>
            <div class="div_flex">
              <label for="anoEdicao">Ano de Edicao:</label>
              <input
                id="anoEdicao"
                type="date"
                name="anoEdicao"
                required
                value="${livro.anoEdicao}"
              />
            </div>
            <div class="div_flex">
              <label for="email_textarea">Descrição:</label>
              <textarea
                id="email_textarea"
                name="descricao"
                placeholder="Descreva algo sobre o livro..."
                style="resize: vertical" >${livro.descricao}</textarea>
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
