<%-- Document : contato Created on : 24/08/2020, 10:45:16 Author : Admin --%>
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
    <link href="css/estilo.css" rel="stylesheet" />
  </head>
  <body>
    <div id="principal">
      <div id="banner" class="div_borda">
        <img id="img_banner" src="imagem/banner.jpg" alt="banner petshop..." />
      </div>
      <div class="div_borda espaco_topo" id="menu">
        <ul>
          <li>
            <a href="./logado/index.jsp">HOME</a>
          </li>
          <li>
            <a href="./logado/produto.jsp">PRODUTO</a>
          </li>
          <li>
            <a href="./logado/fornecedor.jsp">Fornecedor</a>
          </li>
        </ul>
      </div>

      <div id="artigo" class="espaco_topo div_borda">
        <h1>Contato</h1>

        <span>${sucesso}</span>

        <form id="form_email" method="post" action="testeFormulario">
          <div class="div_flex">
            <label for="email">E-mail:</label>
            <input
              id="email"
              type="email"
              name="email"
              placeholder="example@email.com"
              required
            />
          </div>

          <div class="div_flex">
            <label for="senha">Senha:</label>
            <input id="senha" type="password" name="senha" />
          </div>

          <div class="div_flex">
            <label for="cadastro">Cadastro:</label>
            <input id="cadastro" type="date" name="cadastro" />
          </div>

          <div class="div_flex">
            <label for="cb">Checkbox:</label>
            <input id="cb" type="checkbox" name="linguagens" value="php" />PHP
            <input
              id="cb"
              type="checkbox"
              name="linguagens"
              value="dotnet"
            />DotNet
            <input id="cb" type="checkbox" name="linguagens" value="java" />Java
            <input id="cb" type="checkbox" name="linguagens" value="c++" />C++
          </div>

          <div class="div_flex">
            <label>Radio:</label>
            <input type="radio" name="sexo" value="Feminino" />Feminino
            <input type="radio" name="sexo" value="Masculino" />Masculino
          </div>

          <div class="div_flex">
            <input class="botao botao_esquerda" value="Enviar" type="submit" />
            <input class="botao" type="reset" value="Limpar" />
          </div>
        </form>
      </div>
      <div id="banner_2" class="div_borda espaco_topo"></div>

      <div id="rodape" class="div_borda espaco_topo"></div>
    </div>
  </body>
</html>
