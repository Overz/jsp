<%-- Document : contato Created on : 24/08/2020, 10:45:16 Author : Admin --%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="utf-8" %>

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

        <c:if test="${msgAlerta != null}">
          <p class="mensagemAlerta">${msgAlerta}</p>
        </c:if>

        <c:if test="${msgSucesso != null}">
          <p class="mensagemSucesso">${msgSucesso}</p>
        </c:if>

        <c:if test="${msgErro != null}">
          <p class="mensagemErro">${msgErro}</p>
        </c:if>

        <form
          id="form_email"
          method="post"
          action="${pageContext.request.contextPath}/crud_fornecedor?cmd=pesquisarPorNome"
        >
          <div class="div_flex">
            <label for="nome">Nome:</label>
            <input id="nome" type="text" name="nome" required />
            <input
              class="botao botao_pesquisa"
              value="Pesquisar"
              type="submit"
            />
          </div>

          <!--inicio tabela-->
          <script>
            console.log(response.body)
          </script>
          <c:if test="${fornecedor != null}">
            <table class="table_pesquisa">
              <thead>
                <tr>
                  <th>Nome</th>
                  <th>Cadastro</th>
                  <th>Telefone</th>
                  <th>E-mail</th>
                  <th style="width: 110px">A��es</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${fornecedor}" var="fornecedor">
                  <tr>
                    <td>${fornecedor.nome}</td>
                    <td>
                      <f:formatDate
                        value="${fornecedor.dtCadastro}"
                        pattern="dd/MM/yyyy"
                      />
                    </td>
                    <td>${fornecedor.telefone}</td>
                    <td>${fornecedor.email}</td>
                    <td>
                      <a
                        href="${pageContext.request.contextPath}/crud_fornecedor?cmd=carregar&idTela=${fornecedor.id}"
                      >
                        <img
                          class="espaco_img"
                          src="../imagem/lapis.png"
                          title="Alterar"
                          alt="#"
                        />
                      </a>

                      <a
                        href="${pageContext.request.contextPath}/crud_fornecedor?cmd=excluir&idTela=${fornecedor.id}"
                      >
                        <img
                          src="../imagem/lixeira.png"
                          title="Excluir"
                          alt="#"
                        />
                      </a>
                    </td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </c:if>
          <!--fim tabela-->
        </form>
      </div>

      <div id="rodape" class="div_borda espaco_topo"></div>
    </div>
  </body>
</html>
